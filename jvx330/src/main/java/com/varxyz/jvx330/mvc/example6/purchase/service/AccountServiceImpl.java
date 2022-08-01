package com.varxyz.jvx330.mvc.example6.purchase.service;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.varxyz.banking.jdbc.Account;
import com.varxyz.banking.jdbc.DataSourceConfig;

public class AccountServiceImpl implements AccountService {

	@Autowired
	private PurchaseDao dao;

	public AccountServiceImpl(DataSource datasource) {
		dao = new PurchaseDao(datasource);
	}

	@Override
	public void addAccount(PurchaseDao dao, Long customerId, String accountNum, String accountPasswd, String accType,
			Double balance, Double interestRate) {
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

	@Override
	public List<Account> getAccountsAll(PurchaseDao dao) {
		System.out.println("-getAccountsAll-");
		return dao.getAccountsAll();
	}

	@Override
	public List<Account> getAccounts(PurchaseDao dao, String userId) {
		System.out.println("-getAccounts-");
		return dao.getAccountsByUserId(userId);
	}

	@Override
	public boolean getAccountsByAccountNum(PurchaseDao dao, String accountNum) {
		System.out.println("-getAccounts-");
		boolean result = false;
		try {
			dao.getAccountsByAccountNum(accountNum);
		} catch (EmptyResultDataAccessException e) {
			result = true;
		}
		return result;
	}

	@Override
	public Account getBalance(PurchaseDao dao, String accountNum) {
		System.out.println("-getBalance-");
		return dao.getAccountsByAccountNum(accountNum);
	}

	@Override
	public void saveInterest(PurchaseDao dao, String accountNum, Double balance) {
		Account c = new Account();
		c.setAccountNum(accountNum);
		c.setBalance(balance);
		System.out.println(c.getAccountNum() + " / " + c.getBalance());

		dao.setBalanceByAccountNum(c);
		System.out.println("-saveInterest-");
	}

	@Override
	public void transfer(PurchaseDao dao, Double balance, String accountNum) {
		Account c = new Account();
		c.setAccountNum(accountNum);
		c.setBalance(balance);

		dao.setBalanceByAccountNum(c);
		System.out.println("-transfer-");
	}

	// 계좌번호 생성
	@Override
	public String geneAccountNum() {
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
	@Override
	public String checkAccountNum() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		PurchaseDao dao = context.getBean("accountDao", PurchaseDao.class);
		String result = null;

		String accountNum = geneAccountNum();
		boolean checkResult = getAccountsByAccountNum(dao, accountNum);
		if (checkResult) {
			result = accountNum;
			System.out.println("중복 계좌 없음");
		} else {
			while (true) {
				accountNum = geneAccountNum();
				checkResult = getAccountsByAccountNum(dao, accountNum);
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
