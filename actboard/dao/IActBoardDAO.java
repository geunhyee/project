package com.carina.cbs.board.actboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.carina.cbs.board.actboard.vo.ActBoardVO;
import com.carina.cbs.board.freeboard.vo.FreeBoardVO;
import com.carina.cbs.board.freeboard.vo.SearchVO;


@Mapper
public interface IActBoardDAO {
	
	public List<ActBoardVO> getactboardList();
	public int uploadImage(ActBoardVO actBoardVO);
	public int actboardwrite(ActBoardVO actboard);
	public ActBoardVO getActBoard(int actBoardNo); 
	//수정
	public int updateactBoard(ActBoardVO actboard);
	//삭제
	public int deleteactBoard(int boardNo);
	//조회수
	public int actHit(int boardNo);
	//검색
	public List<ActBoardVO> searchBoardList(SearchVO searchVO);
	public int getTotalRowCount(SearchVO searchVO);
	//좋아요actGood
	public int actGood(int boardNo);
}
