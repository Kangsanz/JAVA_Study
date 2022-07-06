package com.varxyz.jv250.banking;

import java.util.Date;

public class Account { // (4 !) + ((3 !) * 2) + (25 * 2) + 4 받고 싶습니다...
	protected long aid;
	protected String accountNum; // 계좌번호
	protected double balance; // 계좌 잔액
	protected Customer customer;
	protected Date regDate;
	protected char accountType;

	public Account() {

	}

	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Date setRegDate(Date regDate) {
		return this.regDate = regDate;
	}

	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

//	@Override
//	public String toString() {
//		return "[" + cid + ", " + name
//	}

//	@Override
//	public String toString() {
//		return "Account [aid=" + aid + ", accountNum=" + accountNum + ", balance=" + balance + ", customer=" + customer
//				+ ", regDate=" + regDate + ", accountType=" + accountType + "]";
//	}

//------------------------------------------------------------------------------

	public void deposite(double amount) { // 예금 메소드
		this.balance += amount; // 현재 잔액에 해당 값 만큼 추가2
	}

}
