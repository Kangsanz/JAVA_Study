package com.varxyz.banking.jdbc.example1;

import org.springframework.dao.EmptyResultDataAccessException;

import com.varxyz.banking.jdbc.Customer;

public class CustomerService {
	public static void addCustomer(CustomerDao dao, String userId, String passwd, String name, String ssn,
			String phone) {
		Customer c = new Customer();
		c.setUserId(userId);
		c.setPasswd(passwd);
		c.setName(name);
		c.setSsn(ssn);
		c.setPhone(phone);

		dao.addCustomer(c);
	}

	public static boolean findCustomer(CustomerDao dao, String userId, String passwd) {
		boolean result;
		try {
			dao.findCustomer(userId, passwd);
			result = true;
		} catch (EmptyResultDataAccessException e) {
			result = false;
		}
		return result;
	}

	public static Customer getCustomerByAccountNum(CustomerDao dao, String userId) {
		System.out.println("-getCustomerByAccountNum-");
		return dao.getCustomerByAccountNum(userId);
	}
}
