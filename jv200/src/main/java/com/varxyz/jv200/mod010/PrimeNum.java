package com.varxyz.jv200.mod010;

public class PrimeNum {
	public static void main(String[] args) throws MyPrimeException {
		int num = 785*785;

		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count += 1;
			}
		}

		try {
			if (count == 2) {
				System.out.println(num + "은 소수입니다.");
			} else if (count < 2) {
				System.out.println("1보다 큰 양의 정수를 입력해주세요.");
			} else {
				throw new MyPrimeException(num + "은 약수입니다. \n");
			}

		} catch (MyPrimeException e) {
			System.out.println(e.getMessage() + divisor(num) + "\n" + divisor2(num));
		}
	}

	public static String divisor(int num) {
		String result = num + "의 약수 : ";
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				result += i + " ";
			}
		}
		return result;
	}

	public static String divisor2(int num) {
		int num2 = 0;
		for (int i = 1; i <= num; i++) {
			if (i * i == num) {
				num2 = i;
			}
		}
		String result = num + "은 " + num2 + "의 제곱수";
		return result;
	}
}
