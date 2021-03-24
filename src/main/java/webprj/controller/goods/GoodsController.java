package webprj.controller.goods;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import webprj.dto.goods.GoodsDTO;
import webprj.service.goods.GoodsService;

@Controller
@RequestMapping("football/goods")
public class GoodsController {

	@Autowired
	GoodsService gdsservice;
	
	//상품페이지
	@RequestMapping(value= "", method = RequestMethod.GET)
	public ModelAndView getgds(ModelAndView mav) {
		mav.addObject("list", gdsservice.getAllList());
		mav.setViewName("project/goods/gds");
		return mav;
	}
	
	//특정 상품 페이지
	@RequestMapping(value="/detail",method = RequestMethod.GET)
	public ModelAndView getgd(@RequestParam int id, ModelAndView mav) {
		mav.addObject("item", gdsservice.getList(id));
		mav.setViewName("project/goods/gds-detail");
		return mav;
	}
	
	//상품 등록 페이지
	@RequestMapping(value= "/register", method = RequestMethod.GET)
	public String getgdsregister() {
		return "project/goods/gdsregister";
	}
	
	private String uploadpath="C:\\Users\\comon\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\webprj\\resource\\project\\images";
	
	//상품 등록
	@RequestMapping(value= "/register", method = RequestMethod.POST)
	public String postgdsregister(@ModelAttribute GoodsDTO goods, 
			HttpSession session,
			@RequestParam MultipartFile file) throws Exception {
		//file의 고유이름 가져오기
		String savedfilename=file.getOriginalFilename();
		//uploadFile을 구현하기 (바뀐 이름을 저장)
		savedfilename=uploadFile(savedfilename,file.getBytes());
		goods.setGds_writer_id( (String)session.getAttribute("id"));
		goods.setPicture_url(savedfilename);
		gdsservice.registerGoods(goods);
		return "redirect:/football/goods";
	}
	
	private String uploadFile(String filename,byte[] fileData) throws Exception {
		UUID uid=UUID.randomUUID(); //랜덤한 문자열을 생성해주는 객체
		String savedname=uid.toString()+"_"+filename;
        //저장경로를 가리킨다
		File savedDir=new File(uploadpath);
        //저장경로가 존재하지 않을 경우 그 폴더생성
		if(!savedDir.exists()) savedDir.mkdirs();
        //저장경로 안에 파일 객체에 savedname이라는 파일에 대한 File 객체를 생성
		File target=new File(uploadpath,savedname);
        //파일을 복사
		FileCopyUtils.copy(fileData, target);
		return savedname;
	}
}
