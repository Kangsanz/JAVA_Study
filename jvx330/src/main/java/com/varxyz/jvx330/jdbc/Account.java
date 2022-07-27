package com.varxyz.jvx330.jdbc;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {

	private long aid;
	private long customerId;
	private Customer customer;
	private String accountNum;
	private char accType;
	private Double balance;
	private Double interestRate;
	private Double overAmount;
	private Date regDate;

	public Account() {
		super();
	}
}