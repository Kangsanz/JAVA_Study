package com.varxyz.jvx330.jdbc.example4;

import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;

	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
	}

	public List<Customer> findCustomerByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer WHERE DATE(regDate)=?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class), regDate);
	}

	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer WHERE email=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), email);
	}

	public long countCustomers() {
		String sql = "SELECT count(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
}
