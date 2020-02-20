package com.ourbank.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ourbank.app.bean.FAQBoard_Bean;
import com.ourbank.app.bean.QNABoard_Bean;
import com.ourbank.app.mapper.QNABoard_Mapper;

@Component
public class QNABoard_Service {
	@Autowired
	private QNABoard_Mapper boardMapper;
	
	//글입력 처리
	public void insertBoard(QNABoard_Bean boardBean) {
		boardMapper.insertBoard(boardBean);	
		};

	// 가장 최근글 가져오기
	public int getRecent() {
		return boardMapper.getRecent();
	}
	//본글-답변 그룹 지정
	public void updateReply( int idx) {
		this.boardMapper.updateReply(idx);
	}
	
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
	public ArrayList<QNABoard_Bean> getList(int nStartPage, int list_num){
		return this.boardMapper.getList(nStartPage, list_num);
	}
	//회원가입 글수
	public int getSignUpCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getSignUpCnt();
		return nCnt;
	}
	//회원가입 arraylist
	public ArrayList<QNABoard_Bean> getSignUpList(int nStartPage, int list_num){
		return this.boardMapper.getSignUpList(nStartPage, list_num);
	}
	//예적금
	public int getSavingsCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getSavingsCnt();
		return nCnt;
	}
	//예적금 arraylist
	public ArrayList<QNABoard_Bean> getSavingsList(int nStartPage, int list_num){
		return this.boardMapper.getSavingsList(nStartPage, list_num);
	}
	//기타
	public int getEtcCnt() {
		int nCnt=0;
		nCnt=this.boardMapper.getEtcCnt();
		return nCnt;
	}
	//기타 arraylist
	public ArrayList<QNABoard_Bean> getEtcList(int nStartPage, int list_num){
		return this.boardMapper.getEtcList(nStartPage, list_num);
	}
	
	//글보기에 뿌릴 bean
	public QNABoard_Bean getSpecificRow(int idx) {
		return this.boardMapper.getSpecificRow(idx);//-getSpecificRow(@Param("id") String id): return id, subject, name, created_date, mail, memo, hits
	}
	
	//글 수정하기
	public void updateBoard(QNABoard_Bean boardBean) {
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
	public ArrayList<QNABoard_Bean> getSearchedList(int nStartPage, int list_num, String strSearchThis){
		return this.boardMapper.getSearchedList(nStartPage, list_num, strSearchThis);
	}

}
