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

	public void addCustomer(Customer customer) { // 실전에서 쓰는 방법, 위의 방법과 값은 같음
		String sql = "INSERT INTO Customer (userId, passwd, name, ssn, phone) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, customer.getUserId(), customer.getPasswd(), customer.getName(), customer.getSsn(),
				customer.getPhone());
	}

	public Customer findCustomer(String userId, String passwd) { // 실전에서 쓰는 방법, 위의 방법과 값은 같음
		String sql = "SELECT * FROM Customer WHERE userId = ? AND passwd = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), userId, passwd);
	}

	public Customer getCustomerByAccountNum(String userId) {
		String sql = "SELECT * FROM Customer WHERE userId = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), userId);
	}
}
