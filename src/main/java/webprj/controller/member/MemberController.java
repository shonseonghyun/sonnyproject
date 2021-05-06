package webprj.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import webprj.dto.member.MemberDTO;
import webprj.service.member.MemberService;


@RequestMapping("football/mypage")
@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
	
	//my페이지 메인화면
	@RequestMapping(value="",method = RequestMethod.GET)
	public ModelAndView mypage(HttpServletRequest req,ModelAndView mav) {
		HttpSession session= req.getSession();
		MemberDTO member = memberService.getMyInformation((String)session.getAttribute("id"));
		mav.addObject("member", member);
		mav.setViewName("project/member/mypage/mypage_main");
		return mav;
	}
	
	@RequestMapping(value="/change",method = RequestMethod.POST)
	@ResponseBody
	public boolean changePwOrId(@RequestParam("id") String id,
			@RequestParam("original_pwd") String original_pwd,
			@RequestParam("new_pwd") String new_pwd) {
		String encodeNewPwd=pwdEncoder.encode(new_pwd);
		boolean samePwd = pwdEncoder.matches(original_pwd, memberService.changePwdWithId(id));
		if(samePwd) {
			memberService.changePw(id, encodeNewPwd);
			return true;
		}else{
			return false;
		}
		
	}

	
}
