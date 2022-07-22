package com.varxyz.jvx330.jdbc.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AddCustomerDaoTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AddCustomerDao dao = context.getBean("addCustomerDao", AddCustomerDao.class);

		addCustomer3(dao);

		context.close();
	}

	public static void addCustomer(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("quan@java.com");
		c.setPasswd("1111");
		c.setName("유비");
		c.setSsn("106611-4564567");
		c.setPhone("010-1865-2889");

		dao.addCustomer(c);
		System.out.println("-Inserted-");
	}

	public static void addCustomer2(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("quan@java.com");
		c.setPasswd("2222");
		c.setName("관우");
		c.setSsn("206611-4564567");
		c.setPhone("010-2865-2889");

		dao.addCustomer2(c);
		System.out.println("-Inserted-");
	}

	public static void addCustomer3(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("auan@java.com");
		c.setPasswd("3333");
		c.setName("장비");
		c.setSsn("306611-4564567");
		c.setPhone("010-3865-2889");

		long key = dao.addCustomer3(c);
		System.out.println("-key-" + key);
		System.out.println("-Inserted-");
	}
}
