package com.ourbank.app.controller;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ourbank.app.bean.UserBoard_Bean;

import com.ourbank.app.service.User_Service;

@Controller
public class User_Controller {
	@Autowired
	private User_Service boardService;
	private static final Logger logger = LoggerFactory.getLogger(User_Controller.class);
	
	// 회원가입창 보여줌
	@RequestMapping(value = "/signUp.do", method = RequestMethod.GET)
	public String showSignUpForm(Model model) {

		model.addAttribute("boardBean", new UserBoard_Bean());
		return "/user/signUpForm";
	}

	// 아이디 체크
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.GET)
	public String idCheck(@RequestParam("id") String id, Model model) {
		// 동일한 아이디가 있는지 확인
		Boolean check = boardService.selectCheckID(id);
		// true : 사용 가능 , false: 사용불가
		model.addAttribute("check", check);
		model.addAttribute("id", id);
		return "/user/IdCheck";
	}

	// 주소찾기 - zipcode 사용 x api사용함
	@RequestMapping(value = "/zipCode.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String zipCode(Model model) {

		return "/user/zipCode";
	}

	// 회원가입 ing
	@RequestMapping(value = "/doSignUp.do", method = RequestMethod.POST)
	public String doSignUp(UserBoard_Bean boardBean, Model model) {

		boardService.insert(boardBean);

		return "redirect:loginForm.do";
	}

	// 로그인창 보여줌
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm(Model model) {
		logger.info("login called");
		model.addAttribute("boardBean", new UserBoard_Bean());
		model.addAttribute("noinfo", false);
		return "/user/loginForm";
	}

	//로그인 처리
	@RequestMapping(value="/loginPro.do", method = RequestMethod.POST)
	public String loginPro(
			HttpServletRequest request,
			@RequestParam("id") String id,
			@RequestParam("passwd") String passwd,
			Model model) {
		logger.info("loginPro called");
		logger.info(id+" "+passwd);
		//첫번째 if id가 있는지 찾은 있으면 true 없으면 false 창 반환
		logger.info("loginPro1 called");
		boolean checkid= boardService.selectCheckID(id);
		logger.info(checkid+"");
		if(checkid==true) {//유저가 없는 경우
			model.addAttribute("check", checkid);
			model.addAttribute("noinfo", true);
			return "/user/loginForm";
		}
		
		//두번째 if 찾은 id에 password 맞는지 확인 맞으면 home창 , 없으면 false 창 반환
		logger.info("loginPro2 called");
		boolean checkpasswd=boardService.CheckIDandPassword(id, passwd);
		if(checkpasswd==false) {
			model.addAttribute("check", checkpasswd);
			model.addAttribute("noinfo", true);
			return "redirect:loginForm.do";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("uid", id);
		return "writeboard";
	}
	
	//로그아웃
	@RequestMapping(value="/logOut.do", method=RequestMethod.GET)
	public String logOut(HttpServletRequest request,
			Model model) {
		HttpSession session=request.getSession();
		session.invalidate();
		
		return "writeboard";
	}
	
	//아이디 찾는 창으로
	@RequestMapping(value="/findId.do" , method=RequestMethod.GET)
	public String findId(Model model) {
		
		model.addAttribute("user_id", null);
		model.addAttribute("ck", false);
		return "user/findId";
	}
	
	@RequestMapping(value="/findIdCheck.do",method = RequestMethod.POST)
	public String findIdCheck(@RequestParam("user_name") String user_name,
			@RequestParam("user_birth") String user_birth,
			@RequestParam("user_phone") String user_phone,
			Model model) {
		
		String user_id = boardService.checkFindId(user_name, user_birth, user_phone);
		logger.info(user_id);
		model.addAttribute("ck", true);
		model.addAttribute("user_id", user_id);
		return "user/findId";
	}
	@RequestMapping(value="/findPasswd.do", method=RequestMethod.GET)
	public String findPassword(Model model) {
		model.addAttribute("ck", 0);
		return "user/findPasswd";
	}
	
	@RequestMapping(value="/findPasswdCheck.do", method=RequestMethod.POST)
	public String findPasswordCheck(
			@RequestParam("id") String id,
			@RequestParam("user_name") String user_name,
			@RequestParam("user_birth") String user_birth,
			@RequestParam("user_phone") String user_phone,
			Model model) {
		int ck=boardService.checkFindPasswd(id, user_name, user_birth, user_phone);
		if(ck==0) {
			model.addAttribute("ck", 1);
			return "user/findPasswd";
		}
		model.addAttribute("ck", 2);
		model.addAttribute("id", id);
		return "user/findPasswd";
	}
	
	//비밀번호 변경
	@RequestMapping(value="/changePasswdCheck.do" , method = RequestMethod.POST)
	public String changePasswdCheck(@Param("passwd") String passwd,
			@Param("id") String id,
			Model model) {
		
		return "user/passwdChanged";
	}
	
	
	
}
