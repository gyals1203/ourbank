package com.ourbank.app.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.ourbank.app.bean.DepositBoard_Bean;
import com.ourbank.app.bean.SavinBoard_Bean;

@Repository
public interface AdminPage_Mapper {
	
		final String DELETE_DEPOSIT_DATA="delete from tlb_deposit_board";
		
		@Delete(DELETE_DEPOSIT_DATA)
		public void delete_deposit();
	
	
	//admin 예금 넣기
		final String INSERT_DEPOSIT="insert into tlb_deposit_board "
				+ " values(#{dcls_month}, #{fin_co_no},#{kor_co_nm},#{fin_prdt_cd},#{fin_prdt_nm},"
				+ " #{join_way},#{mtrt_int}, #{spcl_cnd}, #{join_deny},#{join_member},#{etc_note},"
				+ " #{max_limit,jdbcType=VARCHAR},#{dcls_strt_day},#{dcls_end_day,jdbcType=VARCHAR},#{fin_co_subm_day},#{intr_rate_type},"
				+ " #{intr_rate_type_nm}, #{save_trm},#{intr_rate},#{intr_rate2})";
		
		@Insert(INSERT_DEPOSIT)
		public void insert_deposit(DepositBoard_Bean depositBean);
		
	final String DELETE_SAVING_DATA = "delete from tlb_saving_board";

	@Delete(DELETE_SAVING_DATA)
	public void delete_saving();

	// admin 예금 넣기
	final String INSERT_SAVING = "insert into tlb_saving_board "
			+ " values(#{dcls_month}, #{fin_co_no},#{kor_co_nm},#{fin_prdt_cd},#{fin_prdt_nm},"
			+ " #{join_way},#{mtrt_int}, #{spcl_cnd}, #{join_deny},#{join_member},#{etc_note},"
			+ " #{max_limit,jdbcType=VARCHAR},#{dcls_strt_day},#{dcls_end_day,jdbcType=VARCHAR},#{fin_co_subm_day},#{intr_rate_type},"
			+ " #{intr_rate_type_nm},#{rsrv_type},#{rsrv_type_nm}, #{save_trm},#{intr_rate},#{intr_rate2})";

	@Insert(INSERT_SAVING)
	public void insert_saving(SavinBoard_Bean savingBean);
	
	final String INSERT_BANK="insert into tlb_bank_board"
			+ " values(#{fin_co_no}, #{kor_co_nm}, #{homp_url})";
	
	@Insert(INSERT_BANK)
	public void insert_bank(SavinBoard_Bean savingBean);
	
	
	final String DELETE_BANK="delete from tlb_bank_board";
	
	@Delete(DELETE_BANK)
	public void delete_bank();
}
