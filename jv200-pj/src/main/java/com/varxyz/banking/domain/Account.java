package com.varxyz.banking.domain;

public class Account { // (4 !) + ((3 !) * 2) + (25 * 2) + 4 받고 싶습니다...
	protected String accountNum; // 계좌번호
	protected double balance; // 계좌 잔액
	protected Customer customer;

	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
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

	public void deposite(double amount) { // 예금 메소드
		this.balance += amount; // 현재 잔액에 해당 값 만큼 추가2
	}

	public static void main(String[] args) {
//		SavingsAccount account1 = new SavingsAccount; // SavingsAccount 객체 생성
//		CheckingAccount account2 = new CheckingAccount; // CheckingAccount 객체 생성
//		account1.balance = 5000; // SavingsAccount 초기 입금액
//		account1.interestRate = 1.05; // SavingsAccount 이자율
//		account1.withdraw(6000); // SavingsAccount 출금액
//
//		account2.balance = 5000; // CheckingAccount 초기 입금액
//		account2.overdraftAmount = 6000; // CheckingAccount 마이너스 대출 한도액
//		account2.withdraw(6000); // CheckingAccount 출금액

	}
}
