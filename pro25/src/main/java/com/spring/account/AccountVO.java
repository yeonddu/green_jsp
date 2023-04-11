package com.spring.account;

public class AccountVO {

	private String accoutNO;
	private String custName;
	private int balance;
	
	public AccountVO() {
	}
	
	public AccountVO(String accountNO, String custName, int balance) {
		this.accoutNO = accountNO;
		this.custName = custName;
		this.balance = balance;
	}

	public String getAccoutNO() {
		return accoutNO;
	}

	public void setAccoutNO(String accoutNO) {
		this.accoutNO = accoutNO;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
