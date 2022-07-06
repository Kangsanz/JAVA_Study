package com.varxyz.jv200.mod006;

public class Manager extends Employee {
	public String department;

	public String getDetails() {
		return super.getDetails() + "\nDepartment: " + department;
	}
}
