package com.ourbank.app.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.ourbank.app.bean.MeetBoard_Bean;
import com.ourbank.app.service.MeetBoard_Service;

@Controller
public class MeetBoard_Controller {
	@Autowired
	private MeetBoard_Service boardService;
	
	private static final Logger logger=LoggerFactory.getLogger(MeetBoard_Controller.class);
	
	//글쓰기폼
	@RequestMapping(value="/meet_show_write_form.do", method=RequestMethod.GET)
	public String showWriteForm(Model model) {
		logger.info("show_write_form called!!");
		
		int id=0;
		
		model.addAttribute("id", id);
		model.addAttribute("boardBean", new MeetBoard_Bean());
		return "board_community/meet/meetWriteForm";
		
	}
	//글쓰기
	@RequestMapping(value="/meet_write_form.do", method=RequestMethod.POST)
	public String DomeetWriteBoard(@ModelAttribute("boardBean") @Valid MeetBoard_Bean boardBean,
			BindingResult bindingResult,
			Model model) {
		System.out.println(boardBean.toString());
		MultipartFile file=boardBean.getFile();
		
		//유효성 검사
		if(bindingResult.hasErrors()) {
			List<ObjectError> list=bindingResult.getAllErrors();
			for(ObjectError e:list) {
				logger.error("ObjectError"+e+"\n");
			}
			model.addAttribute("boardBean",boardBean);
			return "board_community/meet/meetWriteForm";
		}
		
		//파일 처리
		if(file!=null) {
			String fileName=file.getOriginalFilename();
			long fileSize=file.getSize();
			boardBean.setFilename(fileName);
			boardBean.setFilesize(fileSize);
			logger.info(boardBean.getFilename());
			logger.info(boardBean.getFilesize()+"");
			
			try {
				byte[] fileData=file.getBytes();
				FileOutputStream output=new FileOutputStream("C:\\eclipse_ourBank\\OurBank\\src\\main\\resources\\files\\"+fileName);
				output.write(fileData);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		String id="admin";
		boardBean.setId(id);
		logger.info(boardBean.getCategory()+" "+
					boardBean.getId()+" "+
					boardBean.getContent()+" "+
					boardBean.getSubject());
		boardService.insertBoard(boardBean);
		
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", 1);
		model.addAttribute("boardList", boardService.getList(1, 10));
		return "redirect:meetList.do";
	}
	
	//리스트 뿌리기
	@RequestMapping(value="/meetList.do", method=RequestMethod.GET)
	public String meetList(
			@RequestParam("current_page") String pageForView, Model model
			) {
		logger.info("meetList called !!");
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));//전체 글수
		model.addAttribute("current_page",pageForView);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(pageForView), 10)); //리스트뿌릴 ArrayList 받아와서 저장
		return "board_community/meet/meetListSpecificPage";
	}
	//회원가입 리스트 뿌리기
	@RequestMapping(value="/meetSignUpList.do", method=RequestMethod.GET)
	public String meetSignUpList(
			@RequestParam("current_page") String pageForView, Model model
			) {
		logger.info("meet signup List called !!");
		model.addAttribute("totalCnt", new Integer(boardService.getSignUpCnt()));//회원가입 글수
		model.addAttribute("current_page",pageForView);
		model.addAttribute("boardList", boardService.getSignUpList(Integer.parseInt(pageForView), 10)); //리스트뿌릴 ArrayList 받아와서 저장
		return "board_community/meet/meetListSpecificPage";
	}
	//예적금 리스트 뿌리기
	@RequestMapping(value="/meetSavingsList.do", method=RequestMethod.GET)
	public String meetSavingList(
			@RequestParam("current_page") String pageForView, Model model
			) {
		logger.info("meet saving List called !!");
		model.addAttribute("totalCnt", new Integer(boardService.getSavingsCnt()));//회원가입 글수
		model.addAttribute("current_page",pageForView);
		model.addAttribute("boardList", boardService.getSavingsList(Integer.parseInt(pageForView), 10)); //리스트뿌릴 ArrayList 받아와서 저장
		return "board_community/meet/meetListSpecificPage";
	}
	//기타 리스트 뿌리기
	@RequestMapping(value="/meetEtcList.do", method=RequestMethod.GET)
	public String meetEtcList(
			@RequestParam("current_page") String pageForView, Model model
			) {
		logger.info("meet etc List called !!");
		model.addAttribute("totalCnt", new Integer(boardService.getEtcCnt()));//회원가입 글수
		model.addAttribute("current_page",pageForView);
		model.addAttribute("boardList", boardService.getEtcList(Integer.parseInt(pageForView), 10)); //리스트뿌릴 ArrayList 받아와서 저장
		return "board_community/meet/meetListSpecificPage";
	}

	//글보기
	@RequestMapping(value="/meetView.do", method=RequestMethod.GET)
	public String viewWork(@RequestParam("idx") int idx,
						   @RequestParam("current_page") String current_page,
						   @RequestParam("searchStr") String searchStr,
						   Model model) {
		logger.info("viewWork called");
		logger.info("idx=["+idx+"] current_page=["+current_page+"] "
				+ "searchStr=["+searchStr+"]");
		MeetBoard_Bean boardData=boardService.getSpecificRow(idx);
		logger.info(boardData.getContent());
		boardService.updateHits(boardData.getHits(), boardData.getIdx());
		model.addAttribute("hits", boardData.getHits());
		logger.info(boardData.getCategory());
		
		model.addAttribute("idx", idx);
		model.addAttribute("current_page", current_page);
		model.addAttribute("searchStr", searchStr);
		model.addAttribute("boardData", boardService.getSpecificRow(idx));
		model.addAttribute("filename", boardData.getFilename());
		return "board_community/meet/meetViewMemo";
	}
	
	//다운로드
	@RequestMapping(value = "/meet_download.do", 
	         method=RequestMethod.GET)
	   @ResponseBody
	   public byte[] downProcess(HttpServletResponse response, @RequestParam String filename) throws IOException{
	      File file = new File("C:\\eclipse_ourBank\\OurBank\\src\\main\\resources\\files\\" + filename);
	      byte[] bytes = FileCopyUtils.copyToByteArray(file);
	      String fn = new String(file.getName().getBytes(),"iso_8859_1");
	      
	      response.setHeader("Content-Disposition",
	                "attachment;filename=\"" + fn + "\"");
	        response.setContentLength(bytes.length);
	        return bytes;
	   }
	//글수정폼
	@RequestMapping(value="meet_show_update_form.do",method=RequestMethod.GET)
	public String showUpdateForm(
			@RequestParam("idx") int idx,
			@RequestParam("current_page") String current_page,
			Model model
			) {
		
		logger.info("update form!!");
		logger.info(idx+"");
		model.addAttribute("idx", idx);
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardData", boardService.getSpecificRow(idx));
		
		return "board_community/meet/meetViewMemoForUpdate";
	}
	//글수정
	@RequestMapping(value="/meet_update.do", method=RequestMethod.POST)
	public String meetUpdate(
			@ModelAttribute("boardBean") @Valid MeetBoard_Bean boardBean,
			BindingResult bindingResult,
			@RequestParam("idx") int idx,
			@RequestParam("current_page") String current_page,
			Model model) {
		System.out.println(boardBean.toString());
		MultipartFile file=boardBean.getFile();
		
		//유효성 검사
		if(bindingResult.hasErrors()) {
			List<ObjectError> list=bindingResult.getAllErrors();
			for(ObjectError e:list) {
				logger.error("ObjectError"+e+"\n");
			}
			model.addAttribute("boardBean",boardBean);
			return "board_community/meet/meetWriteForm";
		}
		
		//파일 처리
		if(file!=null) {
			String fileName=file.getOriginalFilename();
			long fileSize=file.getSize();
			boardBean.setFilename(fileName);
			boardBean.setFilesize(fileSize);
			logger.info(boardBean.getFilename());
			logger.info(boardBean.getFilesize()+"");
			
			try {
				byte[] fileData=file.getBytes();
				FileOutputStream output=new FileOutputStream("C:\\eclipse_ourBank\\OurBank\\src\\main\\resources\\files\\"+fileName);
				output.write(fileData);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//세션에서 얻어와야함
		String id="admin";
		boardBean.setId(id);
		logger.info(boardBean.getCategory()+" "+
					boardBean.getId()+" "+
					boardBean.getContent()+" "+
					boardBean.getSubject());
		
		boardBean.setIdx(idx);
		
		boardService.updateBoard(boardBean);
		boardBean=boardService.getSpecificRow(idx);
		
		model.addAttribute("idx", idx);
		model.addAttribute("current_page", current_page);
		model.addAttribute("searchStr", "None");
		model.addAttribute("boardData", boardService.getSpecificRow(idx));
		model.addAttribute("filename", boardBean.getFilename());
		
		return "board_community/meet/meetViewMemo";
	}
	
	//글 삭제
	@RequestMapping(value="/meetDeleteSpecificRow.do", method=RequestMethod.GET)
	public String deleteSpecificRow(@RequestParam("idx") int idx,
									@RequestParam("current_page") int current_page,
									Model model) {
		logger.info("DeleteSpecificRow called!!");
		logger.info("memo_id=["+idx+"]  current_page=["+current_page+"]");
		boardService.deleteRow(idx);
		//다시 페이지를 조회한다.
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardList",boardService.getList(current_page, 10));
		
		return "redirect:meetList.do";
	}
	
	//글검색
	@RequestMapping(value="/meetSearch.do", method=RequestMethod.POST)
	public String searchWithSubject (@RequestParam("searchStr") String searchStr, 
									Model model) {
		
		
		return searchedList(1, searchStr,model);
	}

	//검색한 페이지로 이동
	@RequestMapping(value="/meetSearchedList.do",method = RequestMethod.GET)
	public String searchedList(
			@RequestParam("pageForView") int pageForView,
			@RequestParam("searchStr") String searchStr,
			Model model
			) {
		logger.info("listSearchedSpecificPageWork called");
		logger.info("pageForView=["+pageForView+"]");
		logger.info("searchStr=["+searchStr+"]");
		
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCntBySubject(searchStr)));
		model.addAttribute("searchedList", boardService.getSearchedList(pageForView, 10, searchStr));
		model.addAttribute("pageForView", pageForView);
		model.addAttribute("searchStr", searchStr);

		return "board_community/meet/meetListSearchedPage";
	}

}
