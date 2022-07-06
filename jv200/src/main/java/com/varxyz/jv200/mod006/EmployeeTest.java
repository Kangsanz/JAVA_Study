package com.varxyz.jv200.mod006;

//import java.util.Date;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "유비";
		e.salary = 1000.0;
//		e.birthDate = new Date();
		String detail = e.getDetails();
		System.out.println(e.name);
		System.out.println(detail);
		System.out.println(e.birthDate);
		
		Manager m = new Manager();
		m.department = "영업부";
		m.name = "관우";
		m.salary = 2000.0;
		System.out.println(m.department);
		System.out.println(m.name);
		System.out.println(m.salary);
	}
}
