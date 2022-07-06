package com.varxyz.banking.domain;

import java.util.Collection;

//.addCustomer() : 신규 고객추가
//.getCustomerBySsn : 주민번호로 고객 조회
//.getAllCustomers() : 전체 고객 목록
//.getNumOfCustomers() : 전체 고객 수

//Customer에 대한 서비스를 처리하는 클래스
public interface CustomerService {
	void addCustomer(Customer customer);

	Customer getCustomerBySsn(String ssn);

	Collection<Customer> getAllCustomers();

	int getNumOfCustomers();
}
