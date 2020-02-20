package com.ourbank.app.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.ourbank.app.bean.FAQBoard_Bean;
import com.ourbank.app.mapper.FAQBoard_Mapper;

@Component
public class FAQBoard_Service {
	@Autowired
	private FAQBoard_Mapper boardMapper;
	
	//글입력 처리
		public void insertBoard(FAQBoard_Bean boardBean) {
			boardMapper.insertBoard(boardBean);	
			};

		// 조회수 올리기
		public void updateHits(int hits, int idx) {
			System.out.println("조회수 올라감");
			this.boardMapper.updateHits(hits, idx);
		}

		//전체글수
		public int getTotalCnt() {
			int nCnt=0;
			nCnt=this.boardMapper.getTotalCnt();
			return nCnt;
		}

		//인덱스, 제목, 작성자, 날짜, 내용, 조회수  arraylist 얻어옴
		public ArrayList<FAQBoard_Bean> getList(int nStartPage, int list_num){
			return this.boardMapper.getList(nStartPage, list_num);
		}
		//회원가입 글수
		public int getSignUpCnt() {
			int nCnt=0;
			nCnt=this.boardMapper.getSignUpCnt();
			return nCnt;
		}
		//회원가입 arraylist
		public ArrayList<FAQBoard_Bean> getSignUpList(int nStartPage, int list_num){
			return this.boardMapper.getSignUpList(nStartPage, list_num);
		}
		//예적금
		public int getSavingsCnt() {
			int nCnt=0;
			nCnt=this.boardMapper.getSavingsCnt();
			return nCnt;
		}
		//예적금 arraylist
		public ArrayList<FAQBoard_Bean> getSavingsList(int nStartPage, int list_num){
			return this.boardMapper.getSavingsList(nStartPage, list_num);
		}
		//기타
		public int getEtcCnt() {
			int nCnt=0;
			nCnt=this.boardMapper.getEtcCnt();
			return nCnt;
		}
		//기타 arraylist
		public ArrayList<FAQBoard_Bean> getEtcList(int nStartPage, int list_num){
			return this.boardMapper.getEtcList(nStartPage, list_num);
		}
		
		//글보기에 뿌릴 bean
		public FAQBoard_Bean getSpecificRow(int idx) {
			return this.boardMapper.getSpecificRow(idx);//-getSpecificRow(@Param("id") String id): return id, subject, name, created_date, mail, memo, hits
		}
		
		//글 수정하기
		public void updateBoard(FAQBoard_Bean boardBean) {
			boardMapper.updateBoard(boardBean.getIdx(), boardBean.getSubject(), 
					boardBean.getCategory(), boardBean.getContent());
		}
		//글삭제하기
		public void deleteRow(int idx) {
			this.boardMapper.deleteSpecificRow(idx);
		}
		//검색한 글 수
		public int getTotalCntBySubject(String search) {
			int nCnt=0;
			nCnt=this.boardMapper.getTotalCntBySubject(search);
			return nCnt;
		}
		//검색하기 => ArrayList 로 목록 
				public ArrayList<FAQBoard_Bean> getSearchedList(int nStartPage, int list_num, String strSearchThis){
					return this.boardMapper.getSearchedList(nStartPage, list_num, strSearchThis);
				}

}
