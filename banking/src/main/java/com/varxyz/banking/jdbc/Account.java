package com.varxyz.banking.jdbc;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Account {

	private long aid;
	private long customerId;
	private String accountNum;
	private String accType;
	private Double balance;
	private Double interestRate;
	private Date regDate;

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "계좌 정보 [" + "계좌번호 = " + accountNum + " / 계좌타입 = " + accType + " / 잔액 = " + balance + " / 이자율 = "
				+ interestRate + "% / 계좌 개설 시간 = " + regDate + "]";
	}
}