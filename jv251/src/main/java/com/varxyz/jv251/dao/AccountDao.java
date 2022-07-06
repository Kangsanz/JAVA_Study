package com.varxyz.jv251.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingsAccount;

public class AccountDao { // DB 관련 내용을 상수로 설정

	public AccountDao() {

	}

	public void addAccounts(Account account) { // Account 추가
		String sql = "INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				if (account instanceof SavingsAccount) {
					SavingsAccount sa = (SavingsAccount) account;
					pstmt.setDouble(3, sa.getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf('S'));
				} else {
					CheckingAccount ca = (CheckingAccount) account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ca.getOverdraftAmount());
					pstmt.setString(5, String.valueOf('C'));
				}
				pstmt.setLong(6, account.getCustomer().getCid());
				pstmt.executeUpdate();
			} finally {
				DataSourceManager.close(pstmt, con);
			}
			System.out.println("NEW ACCOUNT INSERTED....\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	전달된 주민번호를 가진 특정 고객의 계좌 목록 조회
	public List<Account> findAccountBySsn(String ssn) {
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
				+ " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = ?";
		List<Account> accountList = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				Account account = null;

				while (rs.next()) {
					if (rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingsAccount();
						((SavingsAccount) account).setInterestRate(rs.getDouble("interestRate"));
					} else {
						account = new CheckingAccount();
						((CheckingAccount) account).setOverdraftAmount(rs.getDouble("overdraft"));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"), rs.getString("ssn"), rs.getString("phone")));
					account.setRegDate(rs.getTimestamp("regDate"));
					account.setAccountType(rs.getString("accountType").charAt(0));
					accountList.add(account);
				}
			} finally {
				DataSourceManager.close(pstmt, con);
			}
			System.out.println("NEW ACCOUNT INSERTED....\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountList;
	}

	public List<Account> findAllAccounts() { // 전체 계좌 검색
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
				+ " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid";
		List<Account> AccountList = new ArrayList<>(); // List 배열로 데이터를 받기 위해 배열 생성
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Account account = null;

			try {
				con = DataSourceManager.getConnection(); // DB와 연결
				pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
				rs = pstmt.executeQuery(); // 데이터베이스에서 데이터를 가져와서(pstmt 입력) 결과 집합을 반환

				while (rs.next()) {
					if (rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingsAccount();
						((SavingsAccount) account).setInterestRate(rs.getDouble("interestRate"));
					} else {
						account = new CheckingAccount();
						((CheckingAccount) account).setOverdraftAmount(rs.getDouble("overdraft"));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"), rs.getString("ssn"), rs.getString("phone")));
					account.setRegDate(rs.getTimestamp("regDate"));
					account.setAccountType(rs.getString("accountType").charAt(0));
					AccountList.add(account);
				}
			} finally {
				DataSourceManager.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AccountList; // List 에 결과값을 받음
	}

	public Account findAccountNum(String accountNum) {
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
				+ " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE a.accountNum = ?";
		Account account = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, accountNum);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					if (rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingsAccount();
						((SavingsAccount) account).setInterestRate(rs.getDouble("interestRate"));
					} else {
						account = new CheckingAccount();
						((CheckingAccount) account).setOverdraftAmount(rs.getDouble("overdraft"));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"), rs.getString("ssn"), rs.getString("phone")));
					account.setRegDate(rs.getTimestamp("regDate"));
					account.setAccountType(rs.getString("accountType").charAt(0));

				}
			} finally {
				DataSourceManager.close(pstmt, con);
			}
			System.out.println("NEW ACCOUNT INSERTED....\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
}
