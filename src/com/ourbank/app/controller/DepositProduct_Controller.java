package com.ourbank.app.controller;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ourbank.app.PageNumberingManager;
import com.ourbank.app.bean.DepositBoard_Bean;
import com.ourbank.app.service.DepositProduct_Service;


@Controller
public class DepositProduct_Controller {
@Autowired
private DepositProduct_Service boardService;

	@RequestMapping(value = "/depositList.do", method =RequestMethod.GET)
	public String depositList(@RequestParam("current_page") String currentPage,
			Model model) {
		int total_cnt=new Integer(boardService.nDepositProduct());
		
		int total_page=PageNumberingManager.getInstance().getTotalPage(total_cnt, 3);
		int first_block=PageNumberingManager.getInstance()
				.getFirstPageInBlock(Integer.parseInt(currentPage),10);
		int last_block=PageNumberingManager.getInstance()
				.getLastPageInBlock(Integer.parseInt(currentPage),10);
		
		model.addAttribute("total_page", total_page);
		model.addAttribute("totalCnt", total_cnt);//전체 글수
		model.addAttribute("current_page",currentPage);
		model.addAttribute("boardList", boardService.selectDepositList(Integer.parseInt(currentPage), 3));
		model.addAttribute("last_page", Integer.parseInt(currentPage)+9);
		model.addAttribute("all_bank", boardService.selectAllBank());
		return "/board_product/deposit/depositList";
	}

}
