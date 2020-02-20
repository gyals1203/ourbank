package com.ourbank.app.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ourbank.app.bean.DepositBoard_Bean;
import com.ourbank.app.bean.SavinBoard_Bean;
import com.ourbank.app.mapper.AdminPage_Mapper;

@Component
public class AdminPage_Service {
@Autowired
AdminPage_Mapper adminMapper;
public void insertDeposit(ArrayList<DepositBoard_Bean> all_list) {
	Iterator<DepositBoard_Bean> iterator=all_list.iterator();
	
	while(iterator.hasNext()) {
	DepositBoard_Bean depositBean=(DepositBoard_Bean) iterator.next();
	System.out.println(depositBean.getFin_prdt_nm());
	adminMapper.insert_deposit(depositBean);
	}
}

public void deleteDeposit() {
	adminMapper.delete_deposit();
}

public void insertSaving(ArrayList<SavinBoard_Bean> all_list) {
	Iterator<SavinBoard_Bean> iterator=all_list.iterator();
	
	while(iterator.hasNext()) {
	SavinBoard_Bean savingBean=(SavinBoard_Bean) iterator.next();
	System.out.println(savingBean.getFin_prdt_nm());
	adminMapper.insert_saving(savingBean);
	}
}


public void deleteSaving() {
	adminMapper.delete_saving();
}

public void insertBank(ArrayList<SavinBoard_Bean> all_list) {
	Iterator<SavinBoard_Bean> iterator=all_list.iterator();
	while(iterator.hasNext()) {
	SavinBoard_Bean savingBean=(SavinBoard_Bean) iterator.next();
	System.out.println(savingBean.getHomp_url());
	adminMapper.insert_bank(savingBean);
	}
}
public void deleteBank() {
	adminMapper.delete_bank();
}

}
