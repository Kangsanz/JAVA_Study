package com.varxyz.jv250.banking;

import java.util.List;

public class Customer {
	private Long cid;
	private String name;
	private String ssn;
	private String phone;
	private String customerId;
	private String passwd;
	private List<Account> accounntList;

	public Customer() {

	}

	public Customer(long cid) {
		this.cid = cid;
	}

	public List<Account> getAccounntList() {
		return accounntList;
	}

	public void setAccounntList(List<Account> accounntList) {
		this.accounntList = accounntList;
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

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPasswd() {
		return passwd;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", ssn=" + ssn + ", phone=" + phone + ", customerId="
				+ customerId + ", passwd=" + passwd + ", accounntList=" + accounntList + "]";
	}
}
