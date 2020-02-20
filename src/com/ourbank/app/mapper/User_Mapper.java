package com.ourbank.app.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ourbank.app.bean.UserBoard_Bean;

@Repository
public interface User_Mapper {
	final String INSERT="insert into tlb_user_board (id, passwd, user_name,"
			+ " user_birth, user_phone,  user_address, user_email, admin)"
			+ " values ( #{id}, #{passwd},#{user_name},#{user_birth}, "
			+ " #{user_phone}, #{user_address}, #{user_email},0 )";
	
	@Insert(INSERT)
	void insert(UserBoard_Bean boardbean);
	
	//같은 아이디인 사람 있는가? 0이 아님 있음!
	final String SELECT_CHECK_ID="select count(*) from tlb_user_board where id=#{id}";
	
	@Select(SELECT_CHECK_ID)
	int selectCheckID(@Param("id") String id);
	
	//아이디-비밀번호 맞는 지 확인
	final String  SELECT_CHECK_ID_PASSWD="select count(*) from tlb_user_board where  id=#{id} and passwd=#{passwd}";
	
	@Select(SELECT_CHECK_ID_PASSWD)
	int selectCheckIdPasswd(@Param("id") String id, @Param("passwd") String passwd) ;
	
	// 이름, 전화번호, 생일이 맞는 아이디 찾아옴
	final String SELECT_CHECK_FIND_ID="select id from tlb_user_board "
			+ "where user_name=#{user_name} and user_birth=#{user_birth} and user_phone=#{user_phone}";
	
	@Select(SELECT_CHECK_FIND_ID)
	String selectCheckFindId(@Param("user_name") String user_name,
			@Param("user_birth") String user_birth,
			@Param("user_phone") String user_phone);
	
	// 해당 정보에 해당하는 사용자가 존재하는가?
	final String SELECT_CHECK_FIND_PASSWD="select count(*) from tlb_user_board "  
			+" where id=#{id} and user_name=#{user_name} "
			+ "and user_birth=#{user_birth} and user_phone=#{user_phone}";
	
	@Select(SELECT_CHECK_FIND_PASSWD)
	int selectCheckFindPasswd(
			@Param("id") String id,
			@Param("user_name") String user_name,
			@Param("user_birth") String user_birth,
			@Param("user_phone") String user_phone);
	
	final String UPDATE_PASSWD="update tlb_user_board set passwd=#{passwd} where id=#{id}";
	
	@Update(UPDATE_PASSWD)
	void updatePasswd(@Param("passwd") String passwd, 
					  @Param("id") String id);
	
	
}
