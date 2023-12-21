package com.carina.cbs.board.freeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carina.cbs.board.freeboard.dao.IFreeBoardDAO;

import com.carina.cbs.board.freeboard.vo.FreeBoardVO;
import com.carina.cbs.board.freeboard.vo.ReplyVO;
import com.carina.cbs.board.freeboard.vo.SearchVO;


/**
 * Class Name  : FreeBoardServiceImpl
 * Author      : ParkGeunHye
 * Created Date: 2023. 11. 29.
 * Version: 1.0
 * Purpose:   자유게시판 service
 * Description: 자유게시판 service 구현체
 */
@Service("freeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService {
	@Autowired
	IFreeBoardDAO dao;
	
	
	@Override
	//게시글 목록 부분
	public List<FreeBoardVO>getfreeboardList(){
		return dao.getfreeboardList();
	}
	
	public void freeboardwrite(FreeBoardVO freeboard) throws Exception{
		int result = dao.freeboardwrite(freeboard);
		if(result ==0) {
			throw new Exception();
		}
	}
	public FreeBoardVO getFreeBoard(int boardNo) throws Exception{
		FreeBoardVO result = dao.getFreeBoard(boardNo);
		if(result ==null ) {
			throw new Exception();
		}
		return result;
	}
	public void updateBoard(FreeBoardVO freeboard) throws Exception {
		int result = dao.updateBoard(freeboard);
		if(result ==0) {
			throw new Exception();
		}
	}
	
	public void deleteBoard(int boardNo) throws Exception {
		int result = dao.deleteBoard(boardNo);
		if(result ==0) {
			throw new Exception();
		}
	}
	//조회수
	public void boardHit(int boardNo) throws Exception{
		int result = dao.boardHit(boardNo);
		if(result ==0) {
			throw new Exception();
		}
		
	}

	
//검색부분
	public List<FreeBoardVO> searchBoardList(SearchVO search){
		int totalRowCount = dao.getTotalRowCount(search);
		  System.out.println(totalRowCount); 
		  search.setTotalRowCount(totalRowCount);
		  search.pageSetting(); 
		List<FreeBoardVO> result = dao.searchBoardList(search);
		return result;
	}
	
	//댓글부분
	public ReplyVO getReply(String replyNo) throws Exception {
		ReplyVO result = dao.getReply(replyNo);
		if(result == null) {
			throw new Exception();
			
		}
		return result;
	}
	public int writeReply(ReplyVO reply) throws Exception{
		int result = dao.writeReply(reply);
		if(result ==0) {
			throw new Exception();
		}
		return result;
	}
	
	public List<ReplyVO> getReplyList(int boardNo){
		List<ReplyVO> result = dao.getReplyList(boardNo);
		return result;
	}
	public void delReply(String replyNo) throws Exception {
		int result = dao.delReply(replyNo);
		if(result ==0) {
			throw new Exception();
		}
	}
	
	
	


	 
}