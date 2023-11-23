package com.exchange.pp.member.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exchange.pp.member.dao.EXIMemberDAO;
import com.exchange.pp.member.vo.exMemberVO;


@Service
public class exMemberService {

	@Autowired
	EXIMemberDAO dao;
	
	public void registMember(exMemberVO member) throws Exception {
		int result = dao.registMember(member);
		if(result == 0) {
			throw new Exception();
		}
	}
	public exMemberVO loginMember(exMemberVO member) {
		exMemberVO result = dao.loginMember(member);
		if(result == null) {
			return null;
		}
		return result;
	}
	public String uploadProfile(exMemberVO member, String uploadDir, String webPath
			, MultipartFile file) throws Exception {
		String originFilename = file.getOriginalFilename();
		//서버에 저장되는 파일명(중복을 방지하기 위해 유니크한 이름생성)
		String storedFilename = UUID.randomUUID().toString() + "_"+originFilename;
		String dbFilePath = webPath + storedFilename;
		Path filePath = Paths.get(uploadDir, storedFilename);
		try {
		Files.copy(file.getInputStream(), filePath);
		
		}catch (IOException e) {
			throw new Exception("file to save the file", e);
		}
		member.setProfileImg(dbFilePath);
		int result = dao.profileUpload(member);
		if(result ==0) {
			throw new Exception();
		}
		return dbFilePath;
		
		
	}
	
}
