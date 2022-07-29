package com.varxyz.banking.jdbc.example1;

import java.util.List;

import com.varxyz.banking.jdbc.Account;

public interface AccountService {
	// 계좌 생성
	public void addAccount(AccountDao dao, Long customerId, String accountNum, String accountPasswd, String accType,
			Double balance, Double interestRate);

	// 모든 계좌 조회
	public List<Account> getAccountsAll(AccountDao dao);

	// userId로 계좌 조회
	public List<Account> getAccounts(AccountDao dao, String userId);

	// 계좌 번호로 유무 확인
	public boolean getAccountsByAccountNum(AccountDao dao, String accountNum);

	// 계좌 번호로 계좌 조회
	public Account getBalance(AccountDao dao, String accountNum);

	// 잔액에 이자 추가
	public void saveInterest(AccountDao dao, String accountNum, Double balance);

	// 계좌 이체
	public void transfer(AccountDao dao, Double balance, String accountNum);

	// 계좌번호 생성
	public String geneAccountNum();

	// 계좌번호 중복 확인
	public String checkAccountNum();
}
