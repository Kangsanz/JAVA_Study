package com.varxyz.banking.domain;

public class SavingsAccount extends Account {
	private static final double DEFALUT_INTEREST_RATE = 0.03;
	double interestRate; // 이자율
	
	public SavingsAccount(String accountNum, double balance) {
		this(accountNum, balance, DEFALUT_INTEREST_RATE);
	}

	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}

	public void withdraw(double amount) throws insufficientException { // 출금 메소드
		if (super.balance - amount < 0) { // 예외 발생 (현재 잔액이 출금할 금액보다 적을 때)
			try {
				throw new insufficientException("잔고 부족"); // 예외 실행
			} catch (insufficientException e) { // 예외 실행 시 값 실행
				System.out.println(e.getMessage() + ", 현재 잔액 = " + super.balance + ", 출금하려는 금액 = " + amount + "\n"
						+ ", 현재 이자율은 = " + interestRate + "입니다." + "\n");
			}
		} else {
			super.balance -= amount; // 현재 잔액에 해당 값 만큼 마이너스
			System.out.println("현재 잔액 = " + super.balance + ", 현재 이자율은 = " + interestRate + "입니다." + "\n");
		}
	}
}
