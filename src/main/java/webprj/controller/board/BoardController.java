package webprj.controller.board;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import webprj.dto.board.BoardDTO;
import webprj.dto.board.BoardReplyDTO;
import webprj.dto.board.PageMaker;
import webprj.service.board.BoardService;
import webprj.service.board.reply.BoardReplyService;

@Controller
@RequestMapping("/football/board")
public class BoardController {

	@Autowired
	BoardService boardservice;
	
	@Autowired
	BoardReplyService replyservice;

	//전체 게시글 
	@RequestMapping("")
	public ModelAndView projectboard(ModelAndView mav,
			@RequestParam(defaultValue = "1")int page,
			@RequestParam(defaultValue = "title") String f,
			@RequestParam(defaultValue = "") String q
			){
		
		int count=boardservice.countboard(f,q);
		PageMaker pagemaker=new PageMaker(count,page);
		mav.addObject("p",pagemaker);
		
		List<BoardDTO> list=boardservice.getAllboard(page,f,q);
		mav.addObject("list", list);
		mav.addObject("top3", boardservice.gethittop3());
		mav.setViewName("project/board/board");
		return mav;
	}
	
	//게시글 작성 페이지 
	@RequestMapping(value= "/write",method = RequestMethod.GET)
	public String projectboardwrite() {
		return "project/board/board_write";
	}
	
	
	//저장경로
//	private String uploadpath="C:\\Users\\comon\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\webprj\\WEB-INF\\resources\\images\\project";
	
	//게시글 작성
	@RequestMapping(value= "/write",method = RequestMethod.POST)
	public String projectboardwritep(@ModelAttribute BoardDTO dto,HttpSession session) throws Exception {
		
		//file의 고유이름 가져오기
		//String savedfilename=file.getOriginalFilename();
		//uploadFile을 구현하기
		//savedfilename=uploadFile(savedfilename,file.getBytes());
		//BoardDTO dto에 넣기
		//dto.setFiles(savedfilename);
		//이 부분은 여기서 다루진 않지만 세션의 value값을 가져온 후 
		String id=(String) session.getAttribute("id");
		//BoardDTO dto에 넣기
		dto.setWriter_id(id);
		//WrtieBoard method 호출
		boardservice.WriteBoard(dto);
		return "redirect:/football/board";
	}
	
	
	//특정 게시글 조회
	@RequestMapping("/detail")
	public ModelAndView detail(@RequestParam int id,ModelAndView mav) {
		mav.addObject("detail", boardservice.getboard(id));
		mav.addObject("reply", replyservice.readReply(id));
		
		mav.setViewName("project/board/board_detail");
		return mav;
	}
	
	
//	private String uploadFile(String filename,byte[] fileData) throws Exception {
//		UUID uid=UUID.randomUUID();
//		String savedname=uid.toString()+"_"+filename;
//		File savedDir=new File(uploadpath);
//		if(!savedDir.exists()) savedDir.mkdirs();
//		File target=new File(uploadpath,savedname);
//		FileCopyUtils.copy(fileData, target);
//		return savedname;
//	}
	
	
	//게시판 글 삭제
	@RequestMapping("/delete")
	public String deleteboard(@RequestParam int id) {
		boardservice.deleteboard(id);
		return "redirect:/football/board";
	}
	
	//게시판 글 수정
	@RequestMapping(value="/modify",method = RequestMethod.GET)
	public ModelAndView getModifyform(@RequestParam int id,ModelAndView mav) {
		mav.addObject("detail", boardservice.getboard(id));
		mav.setViewName("project/board/modify");
		return mav;
	}
	
	//게시판 글 수정
	@RequestMapping(value="/modify",method = RequestMethod.POST)
	public ResponseEntity<String> postModify(@RequestBody BoardDTO board){
		ResponseEntity<String> res=null;
		try {
			boardservice.modifyboard(board);
			res=new ResponseEntity("t",HttpStatus.CREATED);
	
		}catch (Exception e) {
			String message="f";
			res=new ResponseEntity("f",HttpStatus.BAD_REQUEST);
		}
		return res;
	}
	
	/* 댓글 부분 */
	
	//댓글 작성
	@RequestMapping(value="/replywrite",method = RequestMethod.POST)
	public String writeReply(@ModelAttribute BoardReplyDTO reply ,HttpSession session) {
		replyservice.writerReply(reply);
		return "redirect:/project/board/detail?id="+reply.getId();
	}
	
	//삭제
	@RequestMapping(value="/replydel",method = RequestMethod.GET)
	public String delReply(@RequestParam int no,@RequestParam int id) {
		replyservice.delReply(no);
		return "redirect:/football/board/detail?id="+id;
	}
	
}
