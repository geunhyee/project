package com.exchange.pp.bank.vo;

public class BankVO {
	private String bankDate;
	private String kindMoney;
	private int bankMmoumoney;
	private int krwMoney;
	
	public BankVO() {
		super();
	}

	public BankVO(String bankDate, String kindMoney, int bankMmoumoney, int krwMoney) {
		super();
		this.bankDate = bankDate;
		this.kindMoney = kindMoney;
		this.bankMmoumoney = bankMmoumoney;
		this.krwMoney = krwMoney;
	}

	public String getBankDate() {
		return bankDate;
	}

	public void setBankDate(String bankDate) {
		this.bankDate = bankDate;
	}

	public String getKindMoney() {
		return kindMoney;
	}

	public void setKindMoney(String kindMoney) {
		this.kindMoney = kindMoney;
	}

	public int getBankMmoumoney() {
		return bankMmoumoney;
	}

	public void setBankMmoumoney(int bankMmoumoney) {
		this.bankMmoumoney = bankMmoumoney;
	}

	public int getKrwMoney() {
		return krwMoney;
	}

	public void setKrwMoney(int krwMoney) {
		this.krwMoney = krwMoney;
	}

	@Override
	public String toString() {
		return "BankVO [bankDate=" + bankDate + ", kindMoney=" + kindMoney + ", bankMmoumoney=" + bankMmoumoney
				+ ", krwMoney=" + krwMoney + "]";
	}
	
	
	
	
	
	
	
}
