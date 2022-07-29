package com.varxyz.banking.jdbc.example1;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.banking.jdbc.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;

	public CustomerDao(DataSource dataSource) { // dataSource 를 직접 만드는 방식
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 고객 추가
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (userId, passwd, name, ssn, phone) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, customer.getUserId(), customer.getPasswd(), customer.getName(), customer.getSsn(),
				customer.getPhone());
	}

	// 고객 확인
	public Customer findCustomer(String userId, String passwd) {
		String sql = "SELECT * FROM Customer WHERE userId = ? AND passwd = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), userId, passwd);
	}

	//  userId로 고객 찾기
	public Customer getCustomerByUserId(String userId) {
		String sql = "SELECT * FROM Customer WHERE userId = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), userId);
	}
}
