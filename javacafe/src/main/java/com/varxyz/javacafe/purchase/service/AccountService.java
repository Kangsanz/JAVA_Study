package com.varxyz.javacafe.purchase.service;
//package com.varxyz.jvx330.mvc.example6.purchase.service;
//
//import java.util.List;
//
//import com.varxyz.banking.jdbc.Account;
//
//public interface AccountService {
//	// 계좌 생성
//	public void addAccount(PurchaseDao dao, Long customerId, String accountNum, String accountPasswd, String accType,
//			Double balance, Double interestRate);
//
//	// 모든 계좌 조회
//	public List<Account> getAccountsAll(PurchaseDao dao);
//
//	// userId로 계좌 조회
//	public List<Account> getAccounts(PurchaseDao dao, String userId);
//
//	// 계좌 번호로 유무 확인
//	public boolean getAccountsByAccountNum(PurchaseDao dao, String accountNum);
//
//	// 계좌 번호로 계좌 조회
//	public Account getBalance(PurchaseDao dao, String accountNum);
//
//	// 잔액에 이자 추가
//	public void saveInterest(PurchaseDao dao, String accountNum, Double balance);
//
//	// 계좌 이체
//	public void transfer(PurchaseDao dao, Double balance, String accountNum);
//
//	// 계좌번호 생성
//	public String geneAccountNum();
//
//	// 계좌번호 중복 확인
//	public String checkAccountNum();
//}
