package com.exchange.pp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exchange.pp.code.service.CodeService;
import com.exchange.pp.code.vo.CodeVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	CodeService codeServices;
	
	@ModelAttribute("EUR") //comList로 board쪽에서는 모두 사용가능
	public List<CodeVO> getEURCodeList(){
		List<CodeVO> comList = codeServices.getCodeListByParent("EUR/KRW");
		return comList;
	}
	@ModelAttribute("USD") //comList로 board쪽에서는 모두 사용가능
	public List<CodeVO> getUSDCodeList(){
		List<CodeVO> comList = codeServices.getCodeListByParent("USD/KRW");
		return comList;
	}
	@ModelAttribute("JPY") //comList로 board쪽에서는 모두 사용가능
	public List<CodeVO> getJPYCodeList(){
		List<CodeVO> comList = codeServices.getCodeListByParent("JPY/KRW");
		return comList;
	}
	@ModelAttribute("CNY") //comList로 board쪽에서는 모두 사용가능
	public List<CodeVO> getCNYCodeList(){
		List<CodeVO> comList = codeServices.getCodeListByParent("CNY/KRW");
		return comList;
	}
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		List<CodeVO> comList= codeServices.getList();
		model.addAttribute("exchange", comList );
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
