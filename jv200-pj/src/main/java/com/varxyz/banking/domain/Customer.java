package com.varxyz.banking.domain;

public class Customer {

	// 이름(name)
	// 주민번호(ssn)
	// 연락처(phone)
	// 고객id(customerId)
	// 비밀번호(passwd)
	// 보유계좌(List<Account> 혹은 Collection<Account>)
	//
	// CustomerService는 고객의 정보를 보관할 수 있는 속성을 유지해야 한다.
	// 고객의 정보를 유지할 수 있는 속성을 정의하라.

	protected String name;
	protected String ssn;
	protected String phone;
	protected String customerId;
	protected String passwd;

	public Customer(String name, String ssn, String phone, String customerId, String passwd) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.customerId = customerId;
		this.passwd = passwd;
	}

	public String getSsn() {
		return ssn;
	}
}
