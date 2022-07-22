package com.varxyz.jvx330.jdbc.example2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class CustomerDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);

		String date = "2022-07-22";
		SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date formatDate = null;
		try {
			formatDate = newDtFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		findAllCustomers(dao);
		System.out.println("---------------------------");
		findCustomerByRegDate(dao, formatDate);
		System.out.println("---------------------------");
		findCustomerByEmail(dao, "auan@java.com");
		System.out.println("---------------------------");
		countCustomers(dao);
		System.out.println("---------------------------");

		context.close();
	}

	public static void findAllCustomers(CustomerDao dao) {
		System.out.println("-FindAllCustomers-");
		dao.findAllCustomers().forEach(c -> System.out.println(c));
	}

	public static void findCustomerByRegDate(CustomerDao dao, Date regDate) {
		System.out.println("-FindCustomerByRegDate-");
		dao.findCustomerByRegDate(regDate).forEach(c -> System.out.println(c));

	}

	public static void findCustomerByEmail(CustomerDao dao, String email) {
		System.out.println("-FindCustomerByEmail-");
		System.out.println(dao.findCustomerByEmail(email));
	}

	public static void countCustomers(CustomerDao dao) {
		System.out.println("-CountCustomers-");
		System.out.println(dao.countCustomers());
	}
}
