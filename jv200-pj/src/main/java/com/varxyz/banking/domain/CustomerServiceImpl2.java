package com.varxyz.banking.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerServiceImpl2 implements CustomerService {
	private List<Customer> customerList = new ArrayList<>();

	@Override
	public void addCustomer(Customer customer) {
		if (getCustomerBySsn(customer.getSsn()) == null) {
			customerList.add(customer);
		}
	}

	@Override
	public Customer getCustomerBySsn(String ssn) {
		for (Customer c : customerList) {
			if (ssn.equals(c.getSsn())) {
				return c;
			}
		}
		return null;
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		return customerList;
	}

	@Override
	public int getNumOfCustomers() {
		return customerList.size();
	};
}
