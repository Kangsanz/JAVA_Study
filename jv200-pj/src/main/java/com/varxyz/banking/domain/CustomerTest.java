package com.varxyz.banking.domain;

public class CustomerTest {

	public static void main(String[] args) {
		
		Customer c1 = new Customer("박강산", "1234-1234", "101-015-015", "ID1234", "qwer1234");
		Customer c2 = new Customer("강감찬", "2322-1222", "101-015-015", "ID1234", "qwer1234");
		Customer c3 = new Customer("이순신", "1232-1234", "101-015-015", "ID1234", "qwer1234");
		Customer c4 = new Customer("홍길동", "2322-1234", "101-015-015", "ID1234", "qwer1234");
		Customer c5 = new Customer("이방원", "1234-1232", "101-015-015", "ID1234", "qwer1234");
		
		CustomerServiceImpl2 customerserv = new CustomerServiceImpl2();
		
		customerserv.addCustomer(c1);
		customerserv.addCustomer(c2);
		customerserv.addCustomer(c3);
		customerserv.addCustomer(c4);
		customerserv.addCustomer(c5);
		
		System.out.println(customerserv.getCustomerBySsn("2322-1222").name);
		System.out.println(customerserv.getAllCustomers());
	}
}
