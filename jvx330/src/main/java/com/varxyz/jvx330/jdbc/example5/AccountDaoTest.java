package com.varxyz.jvx330.jdbc.example5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Account;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AccountDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AccountDao dao = context.getBean("accountDao", AccountDao.class);

		addAccount(dao);
		System.out.println("---------------------------");
		findAllAccount(dao);
		System.out.println("---------------------------");
		findAccountBySsn(dao, "106611-4564567");
		System.out.println("---------------------------");
		findAccountByCustomerId(dao, 1001L);
		System.out.println("---------------------------");

		context.close();
	}

	public static void addAccount(AccountDao dao) {
		Account c = new Account();
		c.setCustomerId(1001);
		c.setAccountNum("111-11-1111");
		c.setAccType('S');
		c.setBalance(10000.0);
		c.setInterestRate(2.0);
		c.setOverAmount(500.0);

		dao.addAccount(c);
		System.out.println("-Inserted-");
	}

	public static void findAllAccount(AccountDao dao) {
		System.out.println("-FindAllAccount-");
		dao.findAllAccount().forEach(c -> System.out.println(c));
	}

	public static void findAccountBySsn(AccountDao dao, String ssn) {
		System.out.println("-FindAccountBySsn-");
		dao.findAccountBySsn(ssn).forEach(c -> System.out.println(c));
	}

	public static void findAccountByCustomerId(AccountDao dao, Long customerId) {
		System.out.println("-FindAccountByCustomerId-");
		dao.findAccountByCustomerId(customerId).forEach(c -> System.out.println(c));
	}
}
