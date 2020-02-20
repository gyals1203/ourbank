package com.ourbank.app.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ourbank.app.bean.DepositBoard_Bean;

@Repository
public interface DepositProduct_Mapper {
	final String SELECT_DEPOSIT_LIST="select * from(" + 
			" select d.fin_prdt_nm, d.kor_co_nm, d.intr_rate_type_nm, " + 
			" d.save_trm, d.intr_rate, d.intr_rate2, b.homp_url,ceil(rownum/#{rowPerPage}) "+
			" as page from TLB_DEPOSIT_BOARD d, TLB_BANK_BOARD b" + 
			" where d.fin_co_no=b.fin_co_no) where page=#{page}";
	
	@Select(SELECT_DEPOSIT_LIST)
	@Results(value = {
			@Result(property = "fin_prtd_nm", column = "fin_prtd_nm"),
			@Result(property = "kor_co_nm",column = "kor_co_nm"),
			@Result(property = "intr_rate_type_nm",column = "intr_rate_type_nm"),
			@Result(property = "save_trm", column = "save_trm"),
			@Result(property = "intr_rate",column = "intr_rate"),
			@Result(property = "intr_rate2", column = "intr_rate2")
	})
	ArrayList<DepositBoard_Bean> selectDeposit(@Param("page") int Page,
												@Param("rowPerPage") int rowPerPage);
	
	
	final String SELECT_DEPOSIT_ALL="select count(*) from tlb_deposit_board";
	
	@Select(SELECT_DEPOSIT_ALL)
	int nDepositProduct();
	
	final String SELECT_DEPOSIT_BANK="select distinct kor_co_nm from tlb_deposit_board";
	
	@Select(SELECT_DEPOSIT_BANK)
	ArrayList<DepositBoard_Bean> all_bank();
}
