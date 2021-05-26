package webprj.controller.member;

import java.util.logging.Logger;

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

import webprj.dto.include.PageDTO;
import webprj.dto.member.MemberDTO;
import webprj.service.board.BoardService;
import webprj.service.goods.GoodsService;
import webprj.service.member.MemberService;


@RequestMapping("football/mypage")
@Controller
public class MemberController {
	
	
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
	static Logger log = Logger.getLogger(MemberController.class.getName());
	
	//my페이지 메인화면
	@RequestMapping(value="",method = RequestMethod.GET)
	public ModelAndView mypage(HttpServletRequest req,ModelAndView mav) {
		HttpSession session= req.getSession();
		MemberDTO member = memberService.getMyInformation((String)session.getAttribute("id"));
		mav.addObject("member", member);
		mav.setViewName("project/member/mypage/mypage_main");
		return mav;
	}
	
	//비밀번호 변경
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
	
									//my페이지 중 게시판
	@RequestMapping(value="/board",method = RequestMethod.GET)
	public ModelAndView boardOfMypage(ModelAndView mav ,
			HttpServletRequest req,@RequestParam(value="page",defaultValue = "1") int page) {
		HttpSession session = req.getSession();
		String id= (String)session.getAttribute("id");
		
		int total = boardService.countMyBoard(id);
		//몇 개씩 보여주고
		int quantity= 3;
		// <1 2 3 4 > 같이 그룹
		int group = 4;
		PageDTO PageMaker =new PageDTO(total, page, quantity, group);
		mav.addObject("PageMaker", PageMaker);
		mav.addObject("boards", boardService.getMyBoard(id,page,quantity));
		mav.setViewName("project/member/mypage/mypage_board");
		return mav;
	}
	
	
	//my페이지 중 게시글 삭제
	//ajax
	@RequestMapping(value="/board/del",method = RequestMethod.POST)
	public ResponseEntity<String> boarddel(@RequestParam("board_id") int board_id){
		boardService.deleteboard(board_id);
		return new ResponseEntity<String>("board",HttpStatus.OK);
	}
	
	//my페이지 중 상품
	@RequestMapping(value="/goods",method = RequestMethod.GET)
	public ModelAndView goodsOfMyPage(ModelAndView mav,
			HttpServletRequest req,@RequestParam(value="page",defaultValue = "1") int page) {
		HttpSession session = req.getSession();
		String id= (String)session.getAttribute("id");
		
		int total=memberService.getGoodsCount(id);
		
		//몇 개씩 보여주고
		int quantity= 3;
		
		// <1 2 3 4 > 같이 그룹
		int group = 4;
		
		PageDTO PageMaker = new PageDTO(total,page,quantity,group);
		mav.addObject("goodsList", memberService.getMyGoods(id, page, quantity));
		mav.addObject("PageMaker", PageMaker);
		mav.setViewName("project/member/mypage/mypage_goods");
		return mav;
	}
	
	//my페이지 중 상품 삭제
	//ajax
	@RequestMapping(value="/goods/del",method = RequestMethod.POST)
	public ResponseEntity<String> goodsddel(@RequestParam("gds_id") int gds_id){
		goodsService.deleteGoods(gds_id);
		return new ResponseEntity<String>("goods",HttpStatus.OK);
	}
	
}
