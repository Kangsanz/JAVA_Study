package com.varxyz.jv251.domain;

import java.util.List;

public class Customer {
	private Long cid;
	private String name;
	private String ssn;
	private String phone;
	private String userId;
	private String passwd;
	private List<Account> accountList;

	public Customer() {

	}

	public Customer(String name, String ssn, String phone, String userId, String passwd) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userId = userId;
		this.passwd = passwd;
	}

	public Customer(long cid) {
		this.cid = cid;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public Customer(String name, String ssn, String phone) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return cid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getSsn() {
		return ssn;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPasswd() {
		return passwd;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", ssn=" + ssn + ", phone=" + phone + ", userId=" + userId
				+ ", passwd=" + passwd + "]";
	}
}
