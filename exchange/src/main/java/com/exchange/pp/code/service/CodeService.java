package com.exchange.pp.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exchange.pp.code.dao.ICodeDAO;
import com.exchange.pp.code.vo.CodeVO;


@Service
public class CodeService {

	@Autowired
	ICodeDAO codeDao;
	
	public List<CodeVO> getCodeListByParent(String parentCode){
		List<CodeVO> codeList=codeDao.getCodeListByParent(parentCode);
		return codeList;
		
	}
	public List<CodeVO> getList(){
		List<CodeVO> codeList=codeDao.getList();
		return codeList;
		
	}


}
