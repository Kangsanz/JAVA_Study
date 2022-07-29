package com.varxyz.banking.jdbc.example1;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.varxyz.banking.jdbc.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;

	public CustomerServiceImpl(DataSource datasource) {
		dao = new CustomerDao(datasource);
	}

	@Override
	public void addCustomer(CustomerDao dao, String userId, String passwd, String name, String ssn, String phone) {
		Customer c = new Customer();
		c.setUserId(userId);
		c.setPasswd(passwd);
		c.setName(name);
		c.setSsn(ssn);
		c.setPhone(phone);

		dao.addCustomer(c);
	}

	@Override
	public boolean findCustomer(CustomerDao dao, String userId, String passwd) {
		boolean result;
		try {
			dao.findCustomer(userId, passwd);
			result = true;
		} catch (EmptyResultDataAccessException e) {
			result = false;
		}
		return result;
	}

	@Override
	public Customer getCustomerByUserId(CustomerDao dao, String userId) {
		System.out.println("-getCustomerByAccountNum-");
		return dao.getCustomerByUserId(userId);
	}
}
