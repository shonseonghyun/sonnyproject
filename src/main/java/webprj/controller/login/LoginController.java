package webprj.controller.login;

import java.io.IOException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webprj.dto.member.MemberDTO;
import webprj.service.member.MemberService;

@RequestMapping("/football/")
@Controller
public class LoginController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	JavaMailSender mailSender;
	
	//로그인 화면
	@RequestMapping(value="login", method = RequestMethod.GET)
	public ModelAndView getloginpage(ModelAndView mav,HttpServletRequest request) {
//		Map<String,?> map = RequestContextUtils.getInputFlashMap(request);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("name") != null) { //이미 로그인한 경우
			mav.setViewName("redirect:/football/main");
			return mav;
		}
		else {  //로그인을 이제 시작하는 경우
			mav.setViewName("project/member/login");
			return mav;
		}
	}
	
	
	//로그인하기
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute MemberDTO member,HttpServletRequest request, 
			HttpServletResponse response,RedirectAttributes rttr) throws IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto=memberService.doLogin(member); //인코딩된 pwd 가진 MemberDTO객체 반화
		if(dto != null) { //아이다가 존재할 경우
			if(pwdEncoder.matches(member.getPwd(), dto.getPwd())) { // 비밀번호가 일치할 경우
				//session저장
				session.setAttribute("name", dto.getName());
				session.setAttribute("id", member.getId());
				String uri =(String) session.getAttribute("uri");
				return "redirect:" + (uri != null ? uri : "/football/main");
				
			}else { //비밀번호가 일치하지 않는 경우
				rttr.addFlashAttribute("exist", "N");
				return "redirect:/football/login";  //로그인 페이지 이동
			}
		}
		else { //아이디가 존재하지 않을 경우
			rttr.addFlashAttribute("exist", "N");
			return "redirect:/football/login";  //로그인 페이지 이동
		}
	}
	
	//로그아웃
	@RequestMapping(value= "logout" , method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/football/main";
	}
	
	//회원가입 화면
	@RequestMapping(value= "signup" , method = RequestMethod.GET)
	public String getSignupPage() {
		return "project/member/signup";
	}
	
	//회원가입(이미 아이디 중복확인 진행 완료된 후)
	@RequestMapping(value= "signup" , method = RequestMethod.POST)
	public ModelAndView doSignup(@ModelAttribute @Valid MemberDTO member,BindingResult result,ModelAndView mav) {
		//에러가 존재한다면
		if(result.hasErrors()) {
//			List<ObjectError> l = result.getAllErrors();
//			for (ObjectError objectError : l) {
//				System.out.println(objectError);
//			}
			mav.setViewName("project/member/signup");
			return mav;
		}
		
		//에러가 존재하지 않는다면 암호화 진행
		String inputPwd= member.getPwd();
		String pwd=pwdEncoder.encode(inputPwd);
		member.setPwd(pwd);
		//회원가입 쿼리 실행
		memberService.signup(member);
		mav.setViewName("redirect:/football/main");
		return mav;
	}

	
	//아이디 중복확인(ajax)
	@ResponseBody
	@RequestMapping(value="idcheck",method = RequestMethod.POST)
	public int idcheck(String id) {
		return memberService.idcheck(id);
	}
	
	//이메일 인증
	@ResponseBody
	@RequestMapping(value= "mailcheck", method = RequestMethod.GET)
	public String email(@RequestParam String email) {
		
		//인증번호 난수 생성
		Random random =  new Random();
		int checkNum = random.nextInt(88888)+11111;
		
		String setFrom = "thstjd11@gmail.com";
		String tomail = email;
		String title = "회원가입 인증메일입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다."+
				"<br><br>"+
				"인증번호는 " + checkNum +"입니다." + 
				"<br>" + 
				"해당 인증번호를 인증번호 확인란에 입력해 주세요";
		
		try { 
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true , "utf-8");
			helper.setFrom(setFrom); 
			helper.setTo(tomail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message); 
		} catch(MessagingException e) { // TODO Auto-generated catch block
			e.printStackTrace(); }
		
		return Integer.toString(checkNum);
	}

	
	//아이디 찾기
	@RequestMapping(value="/find_id", method = RequestMethod.GET)
	public String getfindidjsp() {
		return "project/member/find_id";
	}
	
	@RequestMapping(value="/find_id", method = RequestMethod.POST)
	public ModelAndView find_id(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam(defaultValue = "") String temp,
			HttpServletResponse response,RedirectAttributes rttr,ModelAndView mav) {
		MemberDTO member = memberService.findId(name, email,temp);
		if(member == null) {
			rttr.addFlashAttribute("check", true);
			mav.setViewName("redirect:/football/find_id");
			return mav;
		}else {
			mav.addObject("member", member);
			mav.setViewName("project/member/find_id_result");
			return mav;
		}
		
	}
	
	//비밀번호 찾기
	@RequestMapping(value="/find_pw", method = RequestMethod.GET)
	public String getfindpwdjsp() {
		return "project/member/find_pw";
	}
	
	//비밀번호찾기
	@RequestMapping(value="/find_pw", method = RequestMethod.POST)
	public ModelAndView find_pwd(@ModelAttribute MemberDTO member,
			HttpServletResponse response,RedirectAttributes rttr,ModelAndView mav) {
		MemberDTO findMember =memberService.findId(member.getName(), member.getEmail(), member.getId());
		if(findMember == null) {
			rttr.addFlashAttribute("check", true);
			rttr.addFlashAttribute("id", member.getId());
			mav.setViewName("redirect:/football/find_pw");
			return mav;
		}else {
			
			mav.addObject("member", member);
			mav.setViewName("project/member/find_pw_result");
			return mav;
		}
	}
	
	//임시비밀번호 전송 클릭 시
	@RequestMapping(value="/send_pw",method = RequestMethod.POST)
	public ResponseEntity<MemberDTO> sendPw(@ModelAttribute MemberDTO member) {
		//임시 비밀번호 생성
		String temp_pw=getTempPw();
		String encode_temp_pw = pwdEncoder.encode(temp_pw);
		
		String setFrom = "thstjd11@gmail.com";
		String tomail = member.getEmail();
		String title = "임시비밀번호 메일입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다."+
				"<br><br>"+
				"임시 비밀번호는 "+  temp_pw +"입니다." ;
		try { 
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true , "utf-8");
			helper.setFrom(setFrom); 
			helper.setTo(tomail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
			memberService.changePw(member.getId(), encode_temp_pw);
		} catch(MessagingException e) { // TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return new ResponseEntity<>(member,HttpStatus.OK);
	}
	
	//임시 비밀번호 생성
	private String getTempPw() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 
				'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		int idx= 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 8; i++) { 
			idx = (int) (charSet.length * Math.random());
			sb.append(charSet[idx]); 
		}
		return sb.toString();
	}
	
	@RequestMapping(value= "/find_pw_result", method = RequestMethod.POST)
	public String find_pw_result(@ModelAttribute MemberDTO member) {
		return "project/member/send_temppw";
	}

}
