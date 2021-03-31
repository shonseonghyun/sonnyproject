package webprj.controller.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import webprj.dto.cart.CartDTO;
import webprj.service.goods.GoodsService;

@Controller
@RequestMapping("football/cart")
public class CartController {
	
	@Autowired
	GoodsService gdsservice;
	
	//장바구니
	@RequestMapping(value="",method = RequestMethod.GET)
	public ModelAndView getCartpage(ModelAndView mav,HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<CartDTO> OrderList = gdsservice.getOrderList((String)session.getAttribute("id"));
		mav.addObject("OrderList",OrderList);
		mav.setViewName("project/goods/cart");
		return mav;
	}
	
	//삭제
	@RequestMapping(value="/delete" , method = RequestMethod.GET)
	public String deleteOrder(@RequestParam("cart_id") int[] cart_id) {
		gdsservice.deleteOrderList(cart_id);
		return "redirect:/football/cart";
	}
	
	@RequestMapping(value="/modify" , method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String modifyQty(@RequestParam String cart_id,@RequestParam int qty) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cart_id",cart_id);
		map.put("qty",qty);
		gdsservice.modifyQty(map);
		return "수정 성공";
	}

}
