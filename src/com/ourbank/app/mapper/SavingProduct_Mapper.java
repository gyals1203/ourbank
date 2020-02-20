package com.ourbank.app.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ourbank.app.bean.DepositBoard_Bean;
import com.ourbank.app.bean.SavinBoard_Bean;

@Repository
public interface SavingProduct_Mapper {
	final String SELECT_SAVING_LIST="select * from(" + 
			" select s.fin_prdt_nm, s.kor_co_nm, s.intr_rate_type_nm, " + 
			" s.save_trm, s.intr_rate, s.intr_rate2, b.homp_url,ceil(rownum/#{rowPerPage}) "+
			" as page from tlb_saving_board s, TLB_BANK_BOARD b" + 
			" where s.fin_co_no=b.fin_co_no) where page=#{page}";
	
	@Select(SELECT_SAVING_LIST)
	@Results(value = {
			@Result(property = "fin_prtd_nm", column = "fin_prtd_nm"),
			@Result(property = "kor_co_nm",column = "kor_co_nm"),
			@Result(property = "intr_rate_type_nm",column = "intr_rate_type_nm"),
			@Result(property = "save_trm", column = "save_trm"),
			@Result(property = "intr_rate",column = "intr_rate"),
			@Result(property = "intr_rate2", column = "intr_rate2")
	})
	ArrayList<SavinBoard_Bean> selectSaving(@Param("page") int Page,
												@Param("rowPerPage") int rowPerPage);
	
	
	final String SELECT_SAVING_ALL="select count(*) from tlb_saving_board";
	
	@Select(SELECT_SAVING_ALL)
	int nSavingProduct();
	
	
	final String SELECT_DEPOSIT_BANK="select distinct kor_co_nm from tlb_saving_board";
	
	@Select(SELECT_DEPOSIT_BANK)
	ArrayList<SavinBoard_Bean> all_bank();
}
