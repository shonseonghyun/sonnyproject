package webprj.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import webprj.dto.member.MemberDTO;
import webprj.service.member.MemberService;

@RequestMapping("/football/")
@Controller
public class LoginController {

	@Autowired
	MemberService memberService;
	
	//로그인 화면
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String getloginpage() {
		return "project/member/login";
	}
	
	//로그인하기
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute MemberDTO member) {
		System.out.println(memberService.doLogin(member));
		return "redirect:/football/main";
	}
	
	
	
	//회원가입 화면
	@RequestMapping(value= "signup" , method = RequestMethod.GET)
	public String getSignupPage() {
		return "project/member/signup";
	}
	
}
