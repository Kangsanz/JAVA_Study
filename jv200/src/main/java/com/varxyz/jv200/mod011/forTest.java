package com.varxyz.jv200.mod011;

public class forTest {
	public static void main(String[] args) {
		int[] arr = { 123, 456, 789, 1011, 1213, 1415 };
		for (int i : arr) {
			System.out.println(i);
		}
		// Setting default value to empty array
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
