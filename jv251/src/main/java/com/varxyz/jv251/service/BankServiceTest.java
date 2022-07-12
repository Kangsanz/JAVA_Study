package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingsAccount;
import com.varxyz.jv251.exception.CustomerNotFoundException;

public class BankServiceTest {
	public static void main(String[] args) {
		BankService service = BankService.getInstance();
		String name = "동동";
		String ssn = "950116-1246456";
		String phone = "010-0231-3232";
		String userId = "movemove1234";
		String passwd = "asdf1525";
		String accountNum = null;

//		// 1. 신규 고객 등록
//		service.addCustomer(name, ssn, phone, userId, passwd);
//		try {
//			// 2. SavingAccount 생성
//			service.addSavingsAccount(7000.0, 0.4, ssn);
//		} catch (CustomerNotFoundException e) {
//			e.printStackTrace();
//		}

//		try {
//			// 2.5 CheckingAccount 생성
//			service.addCheckingAccount(7000.0, 0.4, ssn);
//		} catch (CustomerNotFoundException e) {
//			e.printStackTrace();
//		}

		// 3. 고객 등록 확인
		Customer customer = service.getCustomerBySsn(ssn);
		System.out.println(customer);

		// 4. 고객 계좌 목록 확인
		List<Account> myList = service.getAccountsBySsn(ssn);
		for (Account account : myList) {
			System.out.println(account);
			accountNum = account.getAccountNum();
		}
		
		Account account = service.getAccountNum(accountNum);
		
		System.out.println(account);
	}

}
