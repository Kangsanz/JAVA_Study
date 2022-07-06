package com.varxyz.jv250.banking;

import java.util.Date;

public class AccountDaoTest {
	public static void main(String[] args) {
		AccountDao dao = new AccountDao();
		SavingsAccount sa = new SavingsAccount();

		// Add Account
		sa.setAccountNum("123-45-6789");
		sa.setBalance(45000.0);
		sa.setCustomer(new Customer(1004));
		sa.setInterestRate(0.04);
		sa.setRegDate(new Date());
		sa.setAccountType('S');
		dao.addAccounts(sa);

		// find Account
		for (Account account : dao.findAccountBySsn("970115-1234567")) {
			System.out.println(account.getCustomer().getName());
			System.out.println(account.getBalance());
		}

		System.out.println("------------------------------------------");

		// findAllAccounts() Test
		for (Account account : dao.findAllAccounts()) {
			System.out.println(account.getCustomer().getName());
		}
	}
}
