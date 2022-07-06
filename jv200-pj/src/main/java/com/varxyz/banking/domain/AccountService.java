package com.varxyz.banking.domain;

public interface AccountService {
	void addAccount(Account account, String ssn);

	Account createSavingAccount(String accountNum, double balance, double interestRate);

	Account createCheckingAccount(String accountNum, double balance, double overdraftAmount);

	Account getAccountByAccountNum(String accountNum);
}
