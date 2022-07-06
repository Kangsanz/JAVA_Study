package com.varxyz.jv200.mod004;

public class ArrayTest {

	public static void main(String[] args) {
		int[] testArray1 = { 93, 75, 95, 76, 70 };

		int[] testArray2 = { 93, 75, 95 };
		int[] testArray3 = { 76, 70 };
		int[] testArray4 = { 12, 24 };

		for (int i = 0; i < testArray2.length; i++) {
			for (int j = 0; j < testArray1.length; j++) {
				if (testArray2[i] == testArray1[j]) {
					System.out.println("testArray2의 숫자 " + testArray2[i] + "는(은) 포함되어 있음");
				}
			}
		}

		for (int i = 0; i < testArray3.length; i++) {
			for (int j = 0; j < testArray1.length; j++) {
				if (testArray3[i] == testArray1[j]) {
					System.out.println("testArray3의 숫자 " + testArray3[i] + "는(은) 포함되어 있음");
				}
			}
		}

		for (int i = 0; i < testArray4.length; i++) {
			for (int j = 0; j < testArray1.length; j++) {
				if (testArray4[i] == testArray1[j]) {
					System.out.println("testArray4의 숫자 " + testArray4[i] + "는(은) 포함되어 있음");
				}
			}
		}
	}
}