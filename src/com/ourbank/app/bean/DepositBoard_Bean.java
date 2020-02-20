package com.ourbank.app.bean;

import org.springframework.stereotype.Repository;

@Repository
public class DepositBoard_Bean {
	String dcls_month; //공시제출월
	String fin_co_no; //금융회사코드
	String kor_co_nm; //금융회사명
	String fin_prdt_cd; //금융상품 코드
	String fin_prdt_nm;//금융 상품명
	String join_way;//가입 방법 
	String mtrt_int; //만기 후 이자율
	String spcl_cnd; //우대조건
	String join_deny; //가입제한
	String join_member; //가입대상
	String etc_note; //기타 유의사항
	String max_limit; //최고한도
	String dcls_strt_day; //공시 시작일
	String dcls_end_day; //공시 종료일
	String fin_co_subm_day;//금융회사 제출일
	String intr_rate_type;//저축 금리 유형
	String intr_rate_type_nm; //저축 금리 유형명
	String save_trm; //저축 기간 [개월]
	String intr_rate; //저축 금리
	String intr_rate2; //최고 우대금리
	String homp_url; //홈페이지 주소
	
	public String getHomp_url() {
		return homp_url;
	}
	public void setHomp_url(String homp_url) {
		this.homp_url = homp_url;
	}
	public String getDcls_month() {
		return dcls_month;
	}
	public void setDcls_month(String dcls_month) {
		this.dcls_month = dcls_month;
	}
	public String getFin_co_no() {
		return fin_co_no;
	}
	public void setFin_co_no(String fin_co_no) {
		this.fin_co_no = fin_co_no;
	}
	public String getKor_co_nm() {
		return kor_co_nm;
	}
	public void setKor_co_nm(String kor_co_nm) {
		this.kor_co_nm = kor_co_nm;
	}
	public String getFin_prdt_cd() {
		return fin_prdt_cd;
	}
	public void setFin_prdt_cd(String fin_prdt_cd) {
		this.fin_prdt_cd = fin_prdt_cd;
	}
	public String getFin_prdt_nm() {
		return fin_prdt_nm;
	}
	public void setFin_prdt_nm(String fin_prdt_nm) {
		this.fin_prdt_nm = fin_prdt_nm;
	}
	public String getJoin_way() {
		return join_way;
	}
	public void setJoin_way(String join_way) {
		this.join_way = join_way;
	}
	public String getMtrt_int() {
		return mtrt_int;
	}
	public void setMtrt_int(String mtrt_int) {
		this.mtrt_int = mtrt_int;
	}
	public String getSpcl_cnd() {
		return spcl_cnd;
	}
	public void setSpcl_cnd(String spcl_cnd) {
		this.spcl_cnd = spcl_cnd;
	}
	public String getJoin_deny() {
		return join_deny;
	}
	public void setJoin_deny(String join_deny) {
		this.join_deny = join_deny;
	}
	public String getJoin_member() {
		return join_member;
	}
	public void setJoin_member(String join_member) {
		this.join_member = join_member;
	}
	public String getEtc_note() {
		return etc_note;
	}
	public void setEtc_note(String etc_note) {
		this.etc_note = etc_note;
	}
	public String getMax_limit() {
		return max_limit;
	}
	public void setMax_limit(String max_limit) {
		this.max_limit = max_limit;
	}
	public String getDcls_strt_day() {
		return dcls_strt_day;
	}
	public void setDcls_strt_day(String dcls_strt_day) {
		this.dcls_strt_day = dcls_strt_day;
	}
	public String getDcls_end_day() {
		return dcls_end_day;
	}
	public void setDcls_end_day(String dcls_end_day) {
		this.dcls_end_day = dcls_end_day;
	}
	public String getFin_co_subm_day() {
		return fin_co_subm_day;
	}
	public void setFin_co_subm_day(String fin_co_subm_day) {
		this.fin_co_subm_day = fin_co_subm_day;
	}
	public String getIntr_rate_type() {
		return intr_rate_type;
	}
	public void setIntr_rate_type(String intr_rate_type) {
		this.intr_rate_type = intr_rate_type;
	}
	public String getIntr_rate_type_nm() {
		return intr_rate_type_nm;
	}
	public void setIntr_rate_type_nm(String intr_rate_type_nm) {
		this.intr_rate_type_nm = intr_rate_type_nm;
	}
	public String getSave_trm() {
		return save_trm;
	}
	public void setSave_trm(String save_trm) {
		this.save_trm = save_trm;
	}
	public String getIntr_rate() {
		return intr_rate;
	}
	public void setIntr_rate(String intr_rate) {
		this.intr_rate = intr_rate;
	}
	public String getIntr_rate2() {
		return intr_rate2;
	}
	public void setIntr_rate2(String intr_rate2) {
		this.intr_rate2 = intr_rate2;
	}
	
	
	
}
