package com.ourbank.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
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

import com.ourbank.app.bean.DepositBoard_Bean;
import com.ourbank.app.bean.SavinBoard_Bean;
import com.ourbank.app.service.AdminPage_Service;
import com.ourbank.app.service.MyPage_Service;
import com.ourbank.app.service.User_Service;

@Controller
public class AdminPage_Controller {

	@Autowired
	private AdminPage_Service adminService;

	@RequestMapping(value = "/manageDeposit.do", method = RequestMethod.GET)
	public String manageDeposit(Model model) {
		return "/board_Adminpage/manageDeposit";
	}
	@RequestMapping(value = "/manageSaving.do", method = RequestMethod.GET)
	public String manageSaving(Model model) {
		return "/board_Adminpage/manageSaving";
	}

	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}

	@RequestMapping(value = "/depositProduct.do", method = RequestMethod.GET)
	public String depositProduct(Model model) {
		try {

			int total = 0;

			// parsing할 url 지정(API 키 포함해서)
			String url = "http://finlife.fss.or.kr/finlifeapi/depositProductsSearch.xml?auth=b39a4b83238cf557b9afec85628cbb19&topFinGrpNo=020000&pageNo=1";

			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(url);

			ArrayList<DepositBoard_Bean> all_list = new ArrayList();

			// root tag
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			// 파싱할 tag-baseinfo
			NodeList BasenList = doc.getElementsByTagName("baseinfo");
			// 파싱할 tag-option
			NodeList OptionList = doc.getElementsByTagName("option");

			for (int temp = 0; temp < BasenList.getLength(); temp++) {// baseinfo 부분
				Node nNode1 = BasenList.item(temp);
				Node nNode2 = OptionList.item(temp);
				DepositBoard_Bean depositBean = new DepositBoard_Bean();
				total += 1;

				if (nNode1.getNodeType() == Node.ELEMENT_NODE) {// base info
					// arraylist(bean(데이터))로 만들어서 DB에 넣기
					Element eElement = (Element) nNode1;
					/////////////// 출력해봄
					/*
					 * System.out.println("##########BaseInfo############"); //
					 * System.out.println(eElement.getTextContent());
					 * System.out.println("공시 제출월 [yyyymm] : " + getTagValue("dcls_month",
					 * eElement)); System.out.println("금융회사 코드 : " + getTagValue("fin_co_no",
					 * eElement)); System.out.println("금융회사  : " + getTagValue("kor_co_nm",
					 * eElement)); System.out.println("금융 상품 코드  : " + getTagValue("fin_prdt_cd",
					 * eElement)); System.out.println("금융 상품명 : " + getTagValue("fin_prdt_nm",
					 * eElement)); System.out.println("가입 방법 : " + getTagValue("join_way",
					 * eElement)); System.out.println("만기후 이자율  : " + getTagValue("mtrt_int",
					 * eElement)); System.out.println("우대 조건 : " + getTagValue("spcl_cnd",
					 * eElement)); System.out.println("가입 제한 : " + getTagValue("join_deny",
					 * eElement)); System.out.println("가입 대상 : " + getTagValue("join_member",
					 * eElement)); System.out.println("기타 유의사항 : " + getTagValue("etc_note",
					 * eElement)); System.out.println("최고 한도 : " + getTagValue("max_limit",
					 * eElement)); System.out.println("공시 시작일 : " + getTagValue("dcls_strt_day",
					 * eElement)); System.out.println("공시 종료일 : " + getTagValue("dcls_end_day",
					 * eElement)); System.out.println("금융 회사 제출일[yyyymmddhh24mi] : " +
					 * getTagValue("fin_co_subm_day", eElement));
					 */

					//////////// 빈에 넣음
					depositBean.setDcls_month(getTagValue("dcls_month", eElement).toString());
					depositBean.setFin_co_no(getTagValue("fin_co_no", eElement).toString());
					depositBean.setKor_co_nm(getTagValue("kor_co_nm", eElement).toString());
					depositBean.setFin_prdt_cd(getTagValue("fin_prdt_cd", eElement).toString());
					depositBean.setFin_prdt_nm(getTagValue("fin_prdt_nm", eElement).toString());
					depositBean.setJoin_way(getTagValue("join_way", eElement).toString());
					depositBean.setMtrt_int(getTagValue("mtrt_int", eElement).toString());
					depositBean.setSpcl_cnd(getTagValue("spcl_cnd", eElement).toString());
					depositBean.setJoin_deny(getTagValue("join_deny", eElement).toString());
					depositBean.setJoin_member(getTagValue("join_member", eElement).toString());
					depositBean.setEtc_note(getTagValue("etc_note", eElement).toString());
					depositBean.setMax_limit(getTagValue("max_limit", eElement));
					depositBean.setDcls_strt_day(getTagValue("dcls_strt_day", eElement).toString());
					depositBean.setDcls_end_day(getTagValue("dcls_end_day", eElement));
					depositBean.setFin_co_subm_day(getTagValue("fin_co_subm_day", eElement).toString());

				} // if end

				if (nNode2.getNodeType() == Node.ELEMENT_NODE) {// option info
					// arraylist(bean(데이터))로 만들어서 DB에 넣기
					Element eElement = (Element) nNode2;
					/*
					 * System.out.println("--------Option-------"); //
					 * System.out.println(eElement.getTextContent());
					 * System.out.println("저축 금리 유형  : " + getTagValue("intr_rate_type", eElement));
					 * System.out.println("저축 금리 유형명  : " + getTagValue("intr_rate_type_nm",
					 * eElement)); System.out.println("저축 기간 [단위: 개월] : " + getTagValue("save_trm",
					 * eElement)); System.out.println("저축 금리 [소수점 2자리] : " +
					 * getTagValue("intr_rate", eElement));
					 * System.out.println("최고 우대금리 [소수점 2자리] : " + getTagValue("intr_rate2",
					 * eElement));
					 */

					//////////// 빈에 넣음
					depositBean.setIntr_rate_type(getTagValue("intr_rate_type", eElement).toString());
					depositBean.setIntr_rate_type_nm(getTagValue("intr_rate_type_nm", eElement).toString());
					depositBean.setSave_trm(getTagValue("save_trm", eElement).toString());
					depositBean.setIntr_rate(getTagValue("intr_rate", eElement).toString());
					depositBean.setIntr_rate2(getTagValue("intr_rate2", eElement).toString());

					all_list.add(depositBean);
					System.out.println("total " + total);
				} // if end

			} // for end
			//있던 데이터는 삭제
			adminService.deleteDeposit();
			//데이터 넣기
			adminService.insertDeposit(all_list);
		} catch (Exception e) {
			e.printStackTrace();
		} // try~catch end
		
		return "redirect:bankInfo.do?ds=0";
	}
	
	@RequestMapping(value = "/savingProduct.do", method = RequestMethod.GET)
	public String savingProduct(Model model) {
		//있던 데이터는 삭제
		adminService.deleteSaving();
		int page=1;
		while(true) {
		try {

			int total = 0;

			// parsing할 url 지정(API 키 포함해서)
			String url = "http://finlife.fss.or.kr/finlifeapi/savingProductsSearch.xml?auth=b39a4b83238cf557b9afec85628cbb19&topFinGrpNo=020000&pageNo="+page;

			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(url);

			ArrayList<SavinBoard_Bean> all_list = new ArrayList();

			// root tag
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			// 파싱할 tag-baseinfo
			NodeList BasenList = doc.getElementsByTagName("baseinfo");
			// 파싱할 tag-option
			NodeList OptionList = doc.getElementsByTagName("option");

			for (int temp = 0; temp < BasenList.getLength(); temp++) {// baseinfo 부분
				Node nNode1 = BasenList.item(temp);
				Node nNode2 = OptionList.item(temp);
				SavinBoard_Bean savingBean = new SavinBoard_Bean();
				total += 1;

				if (nNode1.getNodeType() == Node.ELEMENT_NODE) {// base info
					// arraylist(bean(데이터))로 만들어서 DB에 넣기
					Element eElement = (Element) nNode1;
					/////////////// 출력해봄
					/*
					 * System.out.println("##########BaseInfo############"); //
					 * System.out.println(eElement.getTextContent());
					 * System.out.println("공시 제출월 [yyyymm] : " + getTagValue("dcls_month",
					 * eElement)); System.out.println("금융회사 코드 : " + getTagValue("fin_co_no",
					 * eElement)); System.out.println("금융회사  : " + getTagValue("kor_co_nm",
					 * eElement)); System.out.println("금융 상품 코드  : " + getTagValue("fin_prdt_cd",
					 * eElement)); System.out.println("금융 상품명 : " + getTagValue("fin_prdt_nm",
					 * eElement)); System.out.println("가입 방법 : " + getTagValue("join_way",
					 * eElement)); System.out.println("만기후 이자율  : " + getTagValue("mtrt_int",
					 * eElement)); System.out.println("우대 조건 : " + getTagValue("spcl_cnd",
					 * eElement)); System.out.println("가입 제한 : " + getTagValue("join_deny",
					 * eElement)); System.out.println("가입 대상 : " + getTagValue("join_member",
					 * eElement)); System.out.println("기타 유의사항 : " + getTagValue("etc_note",
					 * eElement)); System.out.println("최고 한도 : " + getTagValue("max_limit",
					 * eElement)); System.out.println("공시 시작일 : " + getTagValue("dcls_strt_day",
					 * eElement)); System.out.println("공시 종료일 : " + getTagValue("dcls_end_day",
					 * eElement)); System.out.println("금융 회사 제출일[yyyymmddhh24mi] : " +
					 * getTagValue("fin_co_subm_day", eElement));
					 */

					//////////// 빈에 넣음
					savingBean.setDcls_month(getTagValue("dcls_month", eElement).toString());
					savingBean.setFin_co_no(getTagValue("fin_co_no", eElement).toString());
					savingBean.setKor_co_nm(getTagValue("kor_co_nm", eElement).toString());
					savingBean.setFin_prdt_cd(getTagValue("fin_prdt_cd", eElement).toString());
					savingBean.setFin_prdt_nm(getTagValue("fin_prdt_nm", eElement).toString());
					savingBean.setJoin_way(getTagValue("join_way", eElement).toString());
					savingBean.setMtrt_int(getTagValue("mtrt_int", eElement).toString());
					savingBean.setSpcl_cnd(getTagValue("spcl_cnd", eElement).toString());
					savingBean.setJoin_deny(getTagValue("join_deny", eElement).toString());
					savingBean.setJoin_member(getTagValue("join_member", eElement).toString());
					savingBean.setEtc_note(getTagValue("etc_note", eElement).toString());
					savingBean.setMax_limit(getTagValue("max_limit", eElement));
					savingBean.setDcls_strt_day(getTagValue("dcls_strt_day", eElement).toString());
					savingBean.setDcls_end_day(getTagValue("dcls_end_day", eElement));
					savingBean.setFin_co_subm_day(getTagValue("fin_co_subm_day", eElement).toString());

				} // if end

				if (nNode2.getNodeType() == Node.ELEMENT_NODE) {// option info
					// arraylist(bean(데이터))로 만들어서 DB에 넣기
					Element eElement = (Element) nNode2;
					/*
					 * System.out.println("--------Option-------"); //
					 * System.out.println(eElement.getTextContent());
					 * System.out.println("저축 금리 유형  : " + getTagValue("intr_rate_type", eElement));
					 * System.out.println("저축 금리 유형명  : " + getTagValue("intr_rate_type_nm",
					 * eElement)); System.out.println("저축 기간 [단위: 개월] : " + getTagValue("save_trm",
					 * eElement)); System.out.println("저축 금리 [소수점 2자리] : " +
					 * getTagValue("intr_rate", eElement));
					 * System.out.println("최고 우대금리 [소수점 2자리] : " + getTagValue("intr_rate2",
					 * eElement));
					 */

					//////////// 빈에 넣음
					savingBean.setIntr_rate_type(getTagValue("intr_rate_type", eElement).toString());
					savingBean.setIntr_rate_type_nm(getTagValue("intr_rate_type_nm", eElement).toString());
					savingBean.setRsrv_type(getTagValue("rsrv_type", eElement).toString());
					savingBean.setRsrv_type_nm(getTagValue("rsrv_type_nm", eElement).toString());
					savingBean.setSave_trm(getTagValue("save_trm", eElement).toString());
					savingBean.setIntr_rate(getTagValue("intr_rate", eElement).toString());
					savingBean.setIntr_rate2(getTagValue("intr_rate2", eElement).toString());
					all_list.add(savingBean);
					
					System.out.println("total " + total);
				} // if end

			} // for end
			
			//데이터 넣기
			adminService.insertSaving(all_list);
			page+=1;
			if(page>12) break;
		} catch (Exception e) {
			e.printStackTrace();
		} // try~catch end
		}
		return "redirect:bankInfo.do?ds=1";
	}
	
	@RequestMapping(value ="/bankInfo.do", method = RequestMethod.GET)
	public String bankInfo(
			HttpServletResponse response,
			@RequestParam("ds") int ds , Model model) {
		//금융회사 정보 삭제
		adminService.deleteBank();
		int page=1;
		while(true) {
		try {

			int total = 0;

			// parsing할 url 지정(API 키 포함해서)
			String url = "http://finlife.fss.or.kr/finlifeapi/companySearch.xml?auth=b39a4b83238cf557b9afec85628cbb19&topFinGrpNo=020000&pageNo="+page;

			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(url);

			ArrayList<SavinBoard_Bean> all_list = new ArrayList();

			// root tag
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			// 파싱할 tag-baseinfo
			NodeList BasenList = doc.getElementsByTagName("baseinfo");

			for (int temp = 0; temp < BasenList.getLength(); temp++) {// baseinfo 부분
				Node nNode1 = BasenList.item(temp);
				
				SavinBoard_Bean savingBean = new SavinBoard_Bean();
				total += 1;

				if (nNode1.getNodeType() == Node.ELEMENT_NODE) {// base info
					// arraylist(bean(데이터))로 만들어서 DB에 넣기
					Element eElement = (Element) nNode1;
					System.out.println(getTagValue("fin_co_no", eElement));
					System.out.println(getTagValue("kor_co_nm", eElement));
					System.out.println(getTagValue("homp_url", eElement));
					//////////// 빈에 넣음
					savingBean.setFin_co_no(getTagValue("fin_co_no", eElement).toString());
					savingBean.setKor_co_nm(getTagValue("kor_co_nm", eElement).toString());
					savingBean.setHomp_url(getTagValue("homp_url", eElement).toString());
					all_list.add(savingBean);
				} // if end

			} // for end
			
			//데이터 넣기
			adminService.insertBank(all_list);;
			page+=1;
			if(page>6) break;
		} catch (Exception e) {
			e.printStackTrace();
		} // try~catch end
		}
		System.out.println(ds);
		if(ds==0) {//예금 데이터 페이지로
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('예금 데이터 입력이 완료되었습니다.');</script>"); 
		        out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "board_Adminpage/manageDeposit";
		}
		//적금 데이터 페이지로
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script>alert('적금 데이터 입력이 완료되었습니다.');</script>"); 
	        out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "board_Adminpage/manageSaving";
	}
}
