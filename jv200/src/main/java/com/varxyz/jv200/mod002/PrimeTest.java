package com.varxyz.jv200.mod002;

public class PrimeTest {
//	2 ~ 1000까지 소수만 카운팅

	public static void main(String[] args) {
		int asdf = 0;
		for (int i = 2; i <= 1000; i++) {

			for (int j = 2; j <= i; j++) {
				if (i % j == 0) {
					asdf++;
				}
			}

			if (asdf == 1) {
				System.out.println(i);
			}
			asdf = 0;
		}
	}

}
