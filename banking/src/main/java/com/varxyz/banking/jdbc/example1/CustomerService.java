package com.varxyz.banking.jdbc.example1;

import com.varxyz.banking.jdbc.Customer;

public interface CustomerService {
	// 고객 추가
	public void addCustomer(CustomerDao dao, String userId, String passwd, String name, String ssn, String phone);

	// userId와 passwd 로 고객 찾기
	public boolean findCustomer(CustomerDao dao, String userId, String passwd);

	// userId로
	public Customer getCustomerByUserId(CustomerDao dao, String userId);
}