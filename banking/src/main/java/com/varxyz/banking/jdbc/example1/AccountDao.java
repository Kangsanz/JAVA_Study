package com.varxyz.banking.jdbc.example1;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.banking.jdbc.Account;

public class AccountDao {
	private JdbcTemplate jdbcTemplate;

	public AccountDao(DataSource dataSource) { // dataSource 를 직접 만드는 방식
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addAccount(Account account) { // 실전에서 쓰는 방법, 위의 방법과 값은 같음
		String sql = "INSERT INTO Account (customerId, accountNum, accountPasswd, accType, balance, interestRate) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, account.getCustomerId(), account.getAccountNum(), account.getAccountPasswd(),
				account.getAccType(), account.getBalance(), account.getInterestRate());
	}

	public List<Account> getAccountsAll() {
		String sql = "SELECT * FROM Account";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
	}

	public List<Account> getAccounts(String userId) {
		String sql = "SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.userId = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class), userId);
	}

	public Account getAccountsByAccountNum(String accountNum) {
		String sql = "SELECT * FROM Account WHERE accountNum = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), accountNum);
	}

	public Account getBalance(String accountNum) {
		String sql = "SELECT * FROM Account WHERE accountNum = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), accountNum);
	}

	public void saveInterest(Account account) { // 실전에서 쓰는 방법, 위의 방법과 값은 같음
		String sql = "UPDATE Account SET balance = ? WHERE accountNum = ?";
		jdbcTemplate.update(sql, account.getBalance(), account.getAccountNum());
	}

	public Account transfer(Double balance, String accountNum) { // 실전에서 쓰는 방법, 위의 방법과 값은 같음
		String sql = "UPDATE Account SET balance = ? WHERE accountNum = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), balance, accountNum);
	}
}
