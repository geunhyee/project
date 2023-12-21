package com.carina.cbs.board.freeboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.carina.cbs.board.freeboard.vo.FreeBoardVO;
import com.carina.cbs.board.freeboard.vo.ReplyVO;
import com.carina.cbs.board.freeboard.vo.SearchVO;

/**
 * Class Name  : IFreeBoardDAO
 * Author      : ParkGeunHye
 * Created Date: 2023. 11. 21.
 * Version: 1.0
 * Purpose:   샘플용
 * Description: 테스트를 위한 샘플입니다.
 */
@Mapper
public interface IFreeBoardDAO {
	//게시글 목록
	public List<FreeBoardVO>getfreeboardList();
	
//	public List<FreeBoardVO>getfreeboardList(SearchVO searvhVO); 
	//검색했을때 게시글 목록 
	public List<FreeBoardVO> searchBoardList(SearchVO searchVO);
	
	 public int getTotalRowCount(SearchVO searchVO);
	// 글쓸때
	 public int freeboardwrite(FreeBoardVO freeboard);
	//게시글 상세화면 볼때
	 public FreeBoardVO getFreeBoard(int boardNo);
	//게시글 수정할때
	 public int updateBoard(FreeBoardVO freeboard);
	//게시글 삭제할때
	 public int deleteBoard(int boardNo);
	 //조회수
	 public int boardHit(int boardNo);
	//댓글 불러올때
	 public ReplyVO getReply(String replyNo);
	//댓글 쓸때
	 public int writeReply(ReplyVO reply);
	//댓글목록 볼때
	 public List<ReplyVO> getReplyList(int boardNo);	
	 //댓글 삭제할때
	public int delReply(String replyNo);
	 
}
