 package com.exchange.pp.code.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exchange.pp.code.vo.CodeVO;




@Mapper
public interface ICodeDAO {

	public List<CodeVO> getCodeListByParent(String parentCode);
	public List<CodeVO> getList();

}
