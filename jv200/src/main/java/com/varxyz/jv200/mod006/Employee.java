package com.varxyz.jv200.mod006;

public class Employee {
	protected String name;
	protected double salary;
	public MyDate birthDate;

	public String getDetails() {
		return "Name: " + name + "\nSalary: " + salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}

	public boolean equals(Object obj) {
		Employee z = (Employee) obj;
		if (this.name.equals(z.name) && this.birthDate.equals(z.birthDate)) {
			return true;
		} else {
			return false;
		}
	}
}
