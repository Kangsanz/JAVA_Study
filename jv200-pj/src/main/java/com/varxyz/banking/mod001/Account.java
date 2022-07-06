package com.varxyz.banking.mod001;

	/*
	계좌정보를 캡슐화
	@author Administrator
	*/

public class Account {
	double balance;
	
	public Account(double initBalance) {
		balance = initBalance;
	}
	
	public double getBalance() {
		return balance;
	}
	

	
	public void deposite(double amt) {
		
	}
	
	/*
	전달된 amt를 현재잔고에 적립한다. 
	@param amt 입금액
	 */
	
	public void withdraw(double amt) {
		// 잔고가 부족할 때
		if(balance - amt < 0) {
			
		}
	}
}
