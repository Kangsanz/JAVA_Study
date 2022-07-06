package com.varxyz.jv200.mod003;

public class PrimeTest {
	private int day;
	private int month;
	private int year;
	
	public PrimeTest(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public PrimeTest(PrimeTest date) {
		this.day = date.day;
		this.month = date.month;
		this.year = date.year;
	}
	
	public void setDay(int day) {
		this.day = day;
	} 
	
	public String toString() {
		return "day = "+day+", month = "+month+ ", year = "+year;
	}
}
