package com.varxyz.jv200.mod003;

public class PassTest {
	public static void changeInt(int value) {
		value = 55;
	}
	
	public static void changeObjectRef(PrimeTest ref) {
		ref = new PrimeTest(1, 1, 2000);
	}
	
	public static void changeObjectAttr(PrimeTest ref) {
		ref.setDay(4);
	}
	
	public static void main(String[] args) {
		PrimeTest date;
		int val;
		val = 11;
		changeInt(val);
		System.out.println("int value is " + val);
		
		date = new PrimeTest(22, 7, 1964);
		changeObjectRef(date);
		System.out.println("Mydate is " + date);
		
		changeObjectAttr(date);
		System.out.println("Mydate is " + date);
	}
}
