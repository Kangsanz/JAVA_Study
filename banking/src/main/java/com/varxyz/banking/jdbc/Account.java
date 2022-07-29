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
	private String accountPasswd;
	private String accType;
	private Double balance;
	private Double interestRate;
	private Date regDate;

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "계좌번호 = " + accountNum + " / 이자율 = " + interestRate + "%" + " / 계좌 타입 = " + accType;
	}
}