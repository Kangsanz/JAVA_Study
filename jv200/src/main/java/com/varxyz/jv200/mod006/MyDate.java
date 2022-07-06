package com.varxyz.jv200.mod006;

public class MyDate {
	private int day;
	private int month;
	private int year;

	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public boolean equals(Object obj) {
		if (obj instanceof MyDate) {
			MyDate x = (MyDate) obj;
			if (this.day == x.day && this.month == x.month && this.year == x.year) {
				return true;
			}
		}
		return false;
	}

//	public static void main(String[] args) {
//		MyDate d1 = new MyDate(1, 1, 2000);
//		MyDate d2 = new MyDate(1, 1, 2000);
//		
//		boolean flag = d1.equals(d2);
//		System.out.println(flag);
//	}
	
}


