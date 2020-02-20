create table tlb_deposit_board(
	dcls_month varchar2(10),
 	fin_co_no  varchar2(10) not null,
 	kor_co_nm varchar2(100) not null,
 	fin_prdt_cd varchar2(100) not null,
 	fin_prdt_nm varchar2(100) not null,
 	join_way varchar2(100) not null,
 	mtrt_int varchar2(1000) ,
	spcl_cnd varchar2(1000) ,
	join_deny varchar2(10) ,
	join_member varchar2(1000) ,
	etc_note varchar2(1000) ,
	max_limit varchar2(200) default null,
	dcls_strt_day varchar2(100) default null,
	dcls_end_day varchar2(200) default null,
	fin_co_subm_day varchar2(100) ,
	intr_rate_type varchar2(10) ,
	intr_rate_type_nm varchar2(10) ,
	save_trm varchar2(10) ,
	intr_rate varchar2(10) ,
	intr_rate2 varchar2(10) ,
	primary key(fin_prdt_cd) enable
);
drop table tlb_deposit_board;
select * from tlb_saving_board;
select * from TLB_DEPOSIT_BOARD;

-----------------------saving

create table tlb_saving_board(
	dcls_month varchar2(10),
 	fin_co_no  varchar2(10) not null,
 	kor_co_nm varchar2(100) not null,
 	fin_prdt_cd varchar2(100) not null,
 	fin_prdt_nm varchar2(100) not null,
 	join_way varchar2(100) not null,
 	mtrt_int varchar2(1000) ,
	spcl_cnd varchar2(1000) ,
	join_deny varchar2(10) ,
	join_member varchar2(1000) ,
	etc_note varchar2(1000) ,
	max_limit varchar2(200) default null,
	dcls_strt_day varchar2(100) default null,
	dcls_end_day varchar2(200) default null,
	fin_co_subm_day varchar2(100) ,
	intr_rate_type varchar2(10) ,
	intr_rate_type_nm varchar2(10) ,
	rsrv_type varchar2(30),
	rsrv_type_nm varchar2(30),
	save_trm varchar2(10) ,
	intr_rate varchar2(10) ,
	intr_rate2 varchar2(10) ,
	primary key(fin_prdt_cd) enable
);
drop table tlb_saving_board;

create table tlb_bank_board(
 	fin_co_no  varchar2(10) not null,
 	kor_co_nm varchar2(100) not null,
 	homp_url varchar2(100) ,
 	primary key(fin_co_no) enable
 )
 select * from tlb_bank_board;
 drop table tlb_bank_board;
 
 
 select * from (select d.fin_prdt_nm, d.kor_co_nm, d.intr_rate_type_nm,
 d.save_trm, d.intr_rate, d.intr_rate2, b.homp_url, ceil(d.rownum / 10) as page 
 from tlb_deposit_board d, tlb_bank_board b 
 where d.fin_co_no=b.fin_co_no)
 where page=1
 select * from(
 select d.fin_prdt_nm, d.kor_co_nm, d.intr_rate_type_nm,
 d.save_trm, d.intr_rate, d.intr_rate2, b.homp_url,ceil(rownum/10) as page from TLB_DEPOSIT_BOARD d, TLB_BANK_BOARD b
 where d.fin_co_no=b.fin_co_no) where page=1;
 