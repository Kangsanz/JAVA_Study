package com.varxyz.jv251.domain;

import com.varxyz.jv251.exception.InsufficientBalanceException;
import com.varxyz.jv251.exception.OverdraftException;

public class CheckingAccount extends Account {
	protected double overdraftAmount; // 마이너스 대출 한도액

	public CheckingAccount() {

	}

	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public void withdraw(double amount) throws InsufficientBalanceException { // 출금 메소드
		if (balance < amount) {
			double overdraftNeeded = amount - balance;
			if (overdraftAmount < overdraftNeeded) {
				throw new OverdraftException("에러 ㅣ 대월금 초과", balance, overdraftNeeded);
			} else {
				balance = 0.0;
				overdraftAmount = overdraftAmount - overdraftNeeded;
			}
		} else {
			balance = balance - amount;
		}
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
}
