package com.exchange.pp.bank.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exchange.pp.bank.vo.BankVO;
import com.exchange.pp.board.vo.BoardVO;


@Mapper
public interface IBankDAO {
	public List<BankVO> getBankList();
	public int writeBank(BankVO bank);
	
}
