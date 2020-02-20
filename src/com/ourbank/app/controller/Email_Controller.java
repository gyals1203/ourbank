package com.ourbank.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ourbank.app.bean.FAQBoard_Bean;
import com.ourbank.app.service.Emil_Service;



@Controller
public class Email_Controller {
@Autowired
private Emil_Service boardService;

private static final Logger logger=
LoggerFactory.getLogger(Email_Controller.class);

@RequestMapping(value="/email.do", method = RequestMethod.GET) 
public String showWriteForm(Model model) {
	logger.info("mail_form called!!");
	
	return "board_customer/email/emailView";
	
}
}
