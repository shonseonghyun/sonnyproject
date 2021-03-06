package webprj.controller.login;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String getloginpage() {
		return "project/member/login";
	}
	
	//로그인하기
	@RequestMapping(value="login", method = RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute MemberDTO member,ModelAndView mav) {
		
		MemberDTO dto=memberService.doLogin(member);
		boolean matchPwd;
		try { //만약 아이디가 DB에 존재하지 않는다면
			matchPwd=pwdEncoder.matches(member.getPwd(), dto.getPwd());
		}catch(Exception e) {
			mav.addObject("exist", "N");
			mav.setViewName("project/member/login");
			return mav;
		}
		if(dto != null && matchPwd == true) { // 아이디가 존재하면서 패스워드가 같다면!
			//새로고림 방지 (새로운 페이지를 보여준다)
			mav.setViewName("redirect:/football/main");
			return mav;
		}
		else { //아이디가 존재하지 않거나 패스워드가 다르다면?
			mav.addObject("exist", "N");
			mav.setViewName("project/member/login");
			return mav;
		}
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
		//회원가입 진행
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
}
