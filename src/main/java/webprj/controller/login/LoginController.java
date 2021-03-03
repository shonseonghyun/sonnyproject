package webprj.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/football/")
@Controller
public class LoginController {

	@RequestMapping("login")
	public String getloginpage() {
		return "project/member/login";
	}
	
	@RequestMapping("signup")
	public String getSignupPage() {
		return "project/member/signup";
	}
	
}
