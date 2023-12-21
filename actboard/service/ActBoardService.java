package com.carina.cbs.board.actboard.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.carina.cbs.board.actboard.vo.ActBoardVO;
import com.carina.cbs.board.freeboard.vo.SearchVO;

/**
 * Class Name  : ActBoardService
 * Author      : ParkGeunHye
 * Created Date: 2023. 12. 13.
 * Version: 1.0
 * Purpose:   실천일지 인터페이스 service부분
 * Description: 
 */
public interface ActBoardService {

	List<ActBoardVO>getactboardList();
	String uploadProfile(ActBoardVO actboardVO, String uploadDir, String webPath, MultipartFile file) throws Exception;
//	String uploadProfile(ActBoardVO actBoardVO, String uploadDir, String webPath, MultipartFile file) throws Exception;
	void actboardwrite(ActBoardVO actboard) throws Exception;
	ActBoardVO getActBoard(int boardNo) throws Exception;
//	ActBoardVO getActBoard(int actBoardNo) throws Exception;
	void updateactBoard(ActBoardVO actboard) throws Exception;
	void deleteactBoard(int boardNo) throws Exception;
	
//	void deleteactBoard(int boardNo, String imgPath) throws Exception;
	//조회수
	void actHit(int boardNo) throws Exception;
	//검색
	List<ActBoardVO> searchBoardList(SearchVO search);
	//좋아요
	 void actGood(int boardNo) throws Exception;
	
	
}
