package com.varxyz.javacafe.purchase.repository;
//package com.varxyz.jvx330.mvc.example6.purchase.repository;
//
//import java.util.List;
//
//import org.apache.tomcat.jdbc.pool.DataSource;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//public class PurchaseDao {
//	private JdbcTemplate jdbcTemplate;
//
//	public PurchaseDao(DataSource dataSource) { // dataSource 를 직접 만드는 방식
//		jdbcTemplate = new JdbcTemplate(dataSource);
//	}
//
//	// 계좌 생성
//	public void addAccount(Account account) {
//		String sql = "INSERT INTO Account (customerId, accountNum, accountPasswd, accType, balance, interestRate) VALUES (?, ?, ?, ?, ?, ?)";
//		jdbcTemplate.update(sql, account.getCustomerId(), account.getAccountNum(), account.getAccountPasswd(),
//				account.getAccType(), account.getBalance(), account.getInterestRate());
//	}
//
//	// 전체 계좌 조회
//	public List<Account> getAccountsAll() {
//		String sql = "SELECT * FROM Account";
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
//	}
//
//	// userId 로 계좌 조회
//	public List<Account> getAccountsByUserId(String userId) {
//		String sql = "SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.userId = ?";
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class), userId);
//	}
//
//	// 계좌 번호로 계좌 조회
//	public Account getAccountsByAccountNum(String accountNum) {
//		String sql = "SELECT * FROM Account WHERE accountNum = ?";
//		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), accountNum);
//	}
//
//	// 계좌 번호로 잔액 수정
//	public void setBalanceByAccountNum(Account account) {
//		String sql = "UPDATE Account SET balance = ? WHERE accountNum = ?";
//		jdbcTemplate.update(sql, account.getBalance(), account.getAccountNum());
//	}
//}
