package com.exchange.pp.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exchange.pp.bank.dao.IBankDAO;
import com.exchange.pp.bank.vo.BankVO;




@Service
public class BankService {
	@Autowired
	IBankDAO dao;
	
	public List<BankVO> getBankList(){
		List<BankVO> result = dao.getBankList();
		return result;
		
	}
	public void writebank(BankVO bank) throws Exception {
		int result = dao.writeBank(bank);
		if(result ==0) {
			throw new Exception();
		}
	}
	
}
