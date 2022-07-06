package com.varxyz.banking.domain;

public class CheckingAccount extends Account {
	protected double overdraftAmount; // 마이너스 대출 한도액

	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public void withdraw(double amount) throws insufficientMaxException { // 출금 메소드
		if (super.balance < amount) {
			// 잔고 부족 시 overdraftAmount 금액 한도 내에서 추가 출금을 승인
			try {
				throw new insufficientMaxException("잔고 부족"); // 예외 실행
			} catch (insufficientMaxException e) { // 예외 실행 시 값 실행
				if (super.balance + overdraftAmount >= amount) { // 마이너스 대출 한도 안 일 때 실행
					super.balance += overdraftAmount; // 현재 잔액에 마이너스 대출 한도액 추가
					super.balance -= amount; // 추가된 잔액에 출금
					System.out.println(e.getMessage() + ", 현재 잔액 = " + balance + ", 출금하려는 금액 = " + amount + "\n"
							+ "잔고 부족으로 " + overdraftAmount + " 만큼 대출 실행 완료, 현재 잔액 : " + balance);
				} else { // 마이너스 대출 한도 초과 일 때 실행
					System.out.println("출금하려는 금액이 마이너스 대출 한도액을 넘어섭니다.");
				}
			}

		} else { // 현재 잔액에 해당 값 만큼 마이너스
			super.balance -= amount;
			System.out.println("현재 잔액 = " + balance);
		}
	}
}
