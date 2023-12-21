package com.carina.cbs.board.freeboard.service;

import java.util.List;

import com.carina.cbs.board.freeboard.vo.FreeBoardVO;
import com.carina.cbs.board.freeboard.vo.ReplyVO;
import com.carina.cbs.board.freeboard.vo.SearchVO;


/**
 * Class Name  : FreeBoardService
 * Author      : ParkGeunHye
 * Created Date: 2023. 11. 29.
 * Version: 1.0
 * Purpose:   자유게시판
 * Description:  자유게시판 service
 */
public interface FreeBoardService {
	
	List<FreeBoardVO>getfreeboardList();
	void freeboardwrite(FreeBoardVO freeboard) throws Exception;
	FreeBoardVO getFreeBoard(int boardNo) throws Exception;
	 void updateBoard(FreeBoardVO freeboard) throws Exception;
	 void deleteBoard(int boardNo) throws Exception;
	 //조회수
	 void boardHit(int boardNo) throws Exception;
	 
	 //검색부분
	 List<FreeBoardVO> searchBoardList(SearchVO search);
//	 List<FreeBoardVO> getfreeboardList(SearchVO searchVO);
	 
	 //댓글부분
	 ReplyVO getReply(String replyNo) throws Exception;
	 int writeReply(ReplyVO reply) throws Exception;
	 List<ReplyVO> getReplyList(int boardNo);
	 void delReply(String replyNo) throws Exception;
	 
	 

}
