package com.ourbank.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ourbank.app.bean.DepositBoard_Bean;
import com.ourbank.app.bean.UserBoard_Bean;
import com.ourbank.app.mapper.MyPage_Mapper;

@Component
public class MyPage_Service {
@Autowired
private MyPage_Mapper boardMapper;

public UserBoard_Bean getUserInfo(String id) {
	return boardMapper.selectMyInfo(id);
}

//내정보 수정
public void updateUserInfo(UserBoard_Bean userBean) {
	this.boardMapper.updateMyInfo(userBean.getPasswd(), userBean.getUser_name(), userBean.getUser_birth(),
			userBean.getUser_phone(), userBean.getUser_address(), userBean.getUser_email(),userBean.getId());
}
//삭제
public void deleteId(String id) {
	this.boardMapper.deleteId(id);
}



}