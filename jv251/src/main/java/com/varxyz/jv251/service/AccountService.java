package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.domain.Account;

public class AccountService {
	private AccountDao accountDao;

	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void addAccount(Account account) {
		accountDao.addAccounts(account);
	}

	public List<Account> getAccountsBySsn(String ssn) {
		return accountDao.findAccountBySsn(ssn);
	}

	public static void main(String[] args) {
		AccountService serivce = new AccountService(null);
		System.out.println(serivce.generateAccountNum());
	}

//	XXX-XX-XXXX 형식의 계좌번호 생성
	public String generateAccountNum() {
		String numStr = String.valueOf((int) (Math.random() * 1000000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0, 3));
		sb.append("-");
		sb.append(numStr.subSequence(3, 5));
		sb.append("-");
		sb.append(numStr.substring(5));
		return sb.toString();
	}

	public Account getAccountNum(String accountNum) {
		return accountDao.findAccountNum(accountNum);
	}

}
