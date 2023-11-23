package com.exchange.pp.code.vo;

public class CodeVO {
	private String exchageNm;
	private String exchangePrice;
	private String exchangeDate;
	private String exchangeCode;
	
	
	
	public CodeVO() {
		
	}



	public CodeVO(String exchageNm, String exchangePrice, String exchangeDate, String exchangeCode) {
		
		this.exchageNm = exchageNm;
		this.exchangePrice = exchangePrice;
		this.exchangeDate = exchangeDate;
		this.exchangeCode = exchangeCode;
	}



	public String getExchageNm() {
		return exchageNm;
	}



	public void setExchangeNm(String exchageNm) {
		this.exchageNm = exchageNm;
	}



	public String getExchangePrice() {
		return exchangePrice;
	}



	public void setExchangePrice(String exchangePrice) {
		this.exchangePrice = exchangePrice;
	}



	public String getExchangeDate() {
		return exchangeDate;
	}



	public void setExchangeDate(String exchangeDate) {
		this.exchangeDate = exchangeDate;
	}



	public String getExchangeCode() {
		return exchangeCode;
	}



	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}



	@Override
	public String toString() {
		return "CodeVO [exchageNm=" + exchageNm + ", exchangePrice=" + exchangePrice + ", exchangeDate="
				+ exchangeDate + ", exchangeCode=" + exchangeCode + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
