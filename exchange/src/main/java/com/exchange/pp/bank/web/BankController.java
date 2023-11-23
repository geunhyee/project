package com.exchange.pp.bank.web;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exchange.pp.bank.service.BankService;
import com.exchange.pp.bank.vo.BankVO;


@Controller
public class BankController {
	
	
	
	@Autowired
	BankService bankService;
	
	@ExceptionHandler(Exception.class)
	public String errorView(Exception e) {
		e.printStackTrace();
		return "errorView";
	}
	
	@RequestMapping("/bankView")
	public String bankView(Model model, HttpSession session) {
		List<BankVO> bankList = bankService.getBankList();
		model.addAttribute("bankList", bankList);
		
		return "bank/bankView";
	}
	
	
}
