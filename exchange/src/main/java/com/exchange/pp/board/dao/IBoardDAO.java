package com.exchange.pp.board.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exchange.pp.board.vo.BoardVO;
import com.exchange.pp.board.vo.ReplyVO;
import com.exchange.pp.board.SearchVO;

@Mapper
public interface IBoardDAO {
	public List<BoardVO> getBoardList();
	public List<BoardVO> searchBoardList(SearchVO search);
	public int writeBoard(BoardVO board);
	public BoardVO getBoard(int boardNo);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int boardNo);
	
	public ReplyVO getReply(String replyNo);
	public int writeReply(ReplyVO reply);
	public List<ReplyVO> getReplyList(int boardNo);
	
	public int delReply(String replyNo);
	
}
