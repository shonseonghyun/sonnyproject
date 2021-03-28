package webprj.controller.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("football/cart")
public class CartController {
	
	//장바구니
	@RequestMapping(value="",method = RequestMethod.GET)
	public ModelAndView getCartpage(ModelAndView mav,HttpServletRequest request) {
		HttpSession session = request.getSession();
		mav.setViewName("project/goods/cart");
		return mav;
	}

}
