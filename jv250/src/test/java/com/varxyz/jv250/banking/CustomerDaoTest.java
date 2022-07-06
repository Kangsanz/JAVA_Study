package com.varxyz.jv250.banking;

import java.util.List;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();

		// findAllCustomers() Test
		List<Customer> customerList = dao.findAllCustomers();
		for (Customer customer : customerList) {
			System.out.println(customer.getName());
		}
		System.out.println("---------------------------------------");
		
//		// find
//		Customer customer = dao.findCustomerBySsn("970115-1234567");
//		System.out.println(customer.getName());
//		System.out.println("---------------------------------------");

//		//addCustomer
//		Customer c = new Customer();
//		c.setName("공명");
//		c.setSsn("950111-4567891");
//		c.setPhone("010-6578-1235");
//		c.setCustomerId("zeroname");
//		c.setPasswd("zero1234");
//		
//		dao.addCustomers(c);
	}
}
