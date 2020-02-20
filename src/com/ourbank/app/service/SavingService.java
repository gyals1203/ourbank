package com.ourbank.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ourbank.app.bean.DepositBoard_Bean;
import com.ourbank.app.bean.SavinBoard_Bean;
import com.ourbank.app.mapper.DepositProduct_Mapper;
import com.ourbank.app.mapper.SavingProduct_Mapper;

@Component
public class SavingService {
@Autowired
private SavingProduct_Mapper boardMapper;

public int nSavingProduct() {
	return boardMapper.nSavingProduct();
}
public ArrayList<SavinBoard_Bean> selectSavingList(int page, int rowPerPage){
	
	return this.boardMapper.selectSaving(page,rowPerPage);
}

public ArrayList<SavinBoard_Bean> selectAllBank(){
	return this.boardMapper.all_bank();
}

}
