package com.ourbank.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ourbank.app.bean.UserBoard_Bean;
import com.ourbank.app.mapper.User_Mapper;

@Component
public class User_Service {
	
	@Autowired
	private User_Mapper boardmapper;
	
	public void insert(UserBoard_Bean boardBean) {
		this.boardmapper.insert(boardBean);
	}
	
	public boolean selectCheckID(String id) {
		int nID= boardmapper.selectCheckID(id);
		if(nID!=0) {
			return false;//아이디가 존재할 경우
		}
		return true;//아이디가 존재하지 않을 경우
	}
	
	public boolean CheckIDandPassword(String id, String passwd) {
		int passwdOK=boardmapper.selectCheckIdPasswd(id, passwd);
		if(passwdOK==0) {//일치하는 패스워드가 존재하지 않는 경우
			return false;
		}
		return true; // 일치하는 아이디가 존재하는 경우
	}
	//아이디 찾기
	public String checkFindId(String user_name, String user_birth, String user_phone) {
		String user_id=boardmapper.selectCheckFindId(user_name, user_birth, user_phone);
	
		return user_id;	
	}
	//비밀번호찾기
	public int checkFindPasswd(String id, String user_name, String user_birth, String user_phone) {
		return boardmapper.selectCheckFindPasswd(id, user_name, user_birth, user_phone);
	}
	
	public void changePasswd(String passwd, String id) {
		this.boardmapper.updatePasswd(passwd, id);
	}
	

}
