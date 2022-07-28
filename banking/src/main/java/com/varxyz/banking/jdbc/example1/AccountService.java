package com.varxyz.banking.jdbc.example1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.varxyz.banking.jdbc.Account;
import com.varxyz.banking.jdbc.DataSourceConfig;

public class AccountService {
	public static void addAccount(AccountDao dao, Long customerId, String accountNum, String accountPasswd,
			String accType, Double balance, Double interestRate) {
		Account c = new Account();
		c.setCustomerId(customerId);
		c.setAccountNum(accountNum);
		c.setAccountPasswd(accountPasswd);
		c.setAccType(accType);
		c.setBalance(balance);
		c.setInterestRate(interestRate);

		dao.addAccount(c);
		System.out.println("-Account Inserted-");
	}

	public static List<Account> getAccountsAll(AccountDao dao) {
		System.out.println("-getAccountsAll-");
		return dao.getAccountsAll();
	}

	public static List<Account> getAccounts(AccountDao dao, String userId) {
		System.out.println("-getAccounts-");
		return dao.getAccounts(userId);
	}

	public static boolean getAccountsByAccountNum(AccountDao dao, String accountNum) {
		System.out.println("-getAccounts-");
		boolean result = false;
		try {
			dao.getAccountsByAccountNum(accountNum);
		} catch (EmptyResultDataAccessException e) {
			result = true;
		}
		return result;
	}

	public static Account getBalance(AccountDao dao, String accountNum) {
		System.out.println("-getBalance-");
		return dao.getBalance(accountNum);
	}

	public static void saveInterest(AccountDao dao, String accountNum, Double balance) {
		Account c = new Account();
		c.setAccountNum(accountNum);
		c.setBalance(balance);
		System.out.println(c.getAccountNum() + " / " + c.getBalance());

		dao.saveInterest(c);
		System.out.println("-saveInterest-");
	}

	public static void transfer(AccountDao dao, Double balance, String accountNum) {
		System.out.println("-transfer-");
		dao.transfer(balance, accountNum);
	}

	// 계좌번호 생성
	public static String geneAccountNum() {
		String AccountNum = "";

		for (int i = 0; i < 3; i++) {
			AccountNum += (int) (Math.random() * 10);
		}
		AccountNum += "-";
		for (int i = 0; i < 2; i++) {
			AccountNum += (int) (Math.random() * 10);
		}
		AccountNum += "-";
		for (int i = 0; i < 4; i++) {
			AccountNum += (int) (Math.random() * 10);
		}

		return AccountNum;
	}

	// 계좌번호 중복 확인
	public static String checkAccountNum() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		String result = null;

		String accountNum = AccountService.geneAccountNum();
		boolean checkResult = AccountService.getAccountsByAccountNum(dao, accountNum);
		if (checkResult) {
			result = accountNum;
			System.out.println("중복 계좌 없음");
		} else {
			while (true) {
				accountNum = AccountService.geneAccountNum();
				checkResult = AccountService.getAccountsByAccountNum(dao, accountNum);
				if (checkResult) {
					result = accountNum;
					break;
				} else {
					System.out.println("중복 계좌 발견");
					continue;
				}
			}
		}
		return result;
	}
}
