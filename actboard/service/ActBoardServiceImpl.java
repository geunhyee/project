package com.carina.cbs.board.actboard.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carina.cbs.board.actboard.dao.IActBoardDAO;
import com.carina.cbs.board.actboard.vo.ActBoardVO;
import com.carina.cbs.board.freeboard.vo.FreeBoardVO;
import com.carina.cbs.board.freeboard.vo.SearchVO;

/**
 * Class Name  : ActBoardServiceImpl
 * Author      : ParkGeunHye
 * Created Date: 2023. 12. 13.
 * Version: 1.0
 * Purpose:   실천일지 service구현체
 * Description: 
 */
@Service
public class ActBoardServiceImpl implements ActBoardService {
	@Autowired
	IActBoardDAO dao;
	
	@Override
	public List<ActBoardVO> getactboardList(){
		return dao.getactboardList();
		
	}
	
	public void actboardwrite(ActBoardVO actboard) throws Exception{
		int result = dao.actboardwrite(actboard);
		if(result ==0) {
			throw new Exception();
		}
	}
	
	public ActBoardVO getActBoard(int boardNo) throws Exception{
		ActBoardVO result = dao.getActBoard(boardNo);
		if(result == null) {
			throw new Exception();
		}
		return result;
	}
	//조회수
	public void actHit(int boardNo) throws Exception{
		int result = dao.actHit(boardNo);
		if(result ==0) {
			throw new Exception();
		}
		
	}

	
	//수정
	public void updateactBoard(ActBoardVO actboard) throws Exception{
		int result = dao.updateactBoard(actboard);
		if(result == 0) {
			throw new Exception();
		}
	}
	
	//삭제

	public void deleteactBoard(int boardNo) throws Exception {
	    try {
	        // 게시글 삭제
	        int result = dao.deleteactBoard(boardNo);
	        if (result == 0) {
	            // 게시글이 삭제되지 않았을 경우 예외를 던집니다.
	            throw new Exception("게시글 삭제 실패");
	        }
	    } catch (Exception e) {
	        // 예외를 적절하게 처리합니다.
	        e.printStackTrace(); // 또는 로깅 등을 활용하여 예외 처리
	        throw e; // 다시 예외를 던지거나, 다른 예외로 변환하여 처리할 수 있습니다.
	    }
	}

	
	//검색부분
	public List<ActBoardVO> searchBoardList(SearchVO search){
		int totalRowCount = dao.getTotalRowCount(search);
		  System.out.println(totalRowCount); 
		  search.setTotalRowCount(totalRowCount);
		  search.pageSetting(); 
		List<ActBoardVO> result = dao.searchBoardList(search);
		return result;
	}
	
	
//좋아요
		public void actGood(int boardNo) throws Exception{
			dao.actGood(boardNo);
		}
	

	

	
	//실천일지 사진업로드부분
	public String uploadProfile(ActBoardVO actBoardVO, String uploadDir, String webPath, MultipartFile file) throws Exception {
        try {
            String originFilename = file.getOriginalFilename();
            // 서버에 저장되는 파일명(중복을 방지하기 위해 유니크한 이름 생성)
            String storedFilename = UUID.randomUUID().toString() + "_" + originFilename;
            String dbFilePath = webPath + storedFilename;
            Path filePath = Paths.get(uploadDir, storedFilename);

            Files.copy(file.getInputStream(), filePath);

            // 여기서 DAO를 이용하여 ActBoardVO를 DB에 저장하는 로직을 수행합니다.
            
     
            int result = dao.uploadImage(actBoardVO);

            if (result == 0) {
                throw new Exception("Failed to save the file information to the database.");
            }

            return dbFilePath;
        } catch (Exception e) {
            throw new Exception("Failed to upload profile image.", e);
        }
	
	}
	
}
