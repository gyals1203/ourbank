package com.ourbank.app.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ourbank.app.bean.DepositBoard_Bean;
import com.ourbank.app.bean.UserBoard_Bean;

@Repository
public interface MyPage_Mapper {

	final String SELECT_MY_INFO="select * from tlb_user_board where id=#{id}";
	
	@Select(SELECT_MY_INFO)
	@Results(value= {
			@Result(property="id",column="id"),
			@Result(property="passwd",column="passwd"),
			@Result(property = "user_name", column = "user_name"),
			@Result(property = "user_birth",column = "user_birth"),
			@Result(property = "user_phone",column = "user_phone"),
			@Result(property = "user_address",column = "user_address"),
			@Result(property = "user_email",column = "user_email")
		})
		UserBoard_Bean selectMyInfo(@Param("id") String id);
	
	final String UPDATE_MY_INFO="update tlb_user_board set passwd=#{passwd},"
			+ " user_name=#{user_name}, user_birth=#{user_birth}, user_phone=#{user_phone},"
			+ " user_address=#{user_address}, user_email=#{user_email} where id=#{id}";
	
	@Update(UPDATE_MY_INFO)
	void updateMyInfo(@Param("passwd") String passwd, @Param("user_name") String user_name,
			@Param("user_birth") String user_birth, @Param("user_phone") String user_phone,
			@Param("user_address") String user_address, @Param("user_email") String user_email,
			@Param("id") String id);
	
	//유저 삭제
	final String DELETE_ID="delete from tlb_user_board where id=#{id}";
	
	@Delete(DELETE_ID)
	void deleteId(@Param("id") String id);
	
	

}