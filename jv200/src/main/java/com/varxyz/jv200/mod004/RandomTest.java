package com.varxyz.jv200.mod004;

public class RandomTest {
	public static void main(String[] args) {
		
		
	
		for (int i = 0; i < 1000; i++) {
			double randomNum = Math.random() * 10;

			if (randomNum < 0.01) {
				System.out.println("별");
			} else if (randomNum < 0.05) {
				System.out.println("팔각형");
			} else if (randomNum < 0.1) {
				System.out.println("육각형");
			} else if (randomNum < 0.5) {
				System.out.println("오각형");
			} else if (randomNum < 3) {
				System.out.println("사각형");
			} else if (randomNum < 4) {
				System.out.println("삼각형");
			} else if (randomNum < 7) {
				System.out.println("동그라미");
			}
		}
	}
}
