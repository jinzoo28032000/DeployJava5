package com.example.ass.beans;

import java.util.Date;

public class OrderBean {
	private AccountBean account;
	private Date createDate;
	private String address;

	public OrderBean() {
		super();
	}

	public OrderBean(AccountBean account, Date createDate, String address) {
		super();
		this.account = account;
		this.createDate = createDate;
		this.address = address;
	}

	public AccountBean getAccount() {
		return account;
	}

	public void setAccount(AccountBean account) {
		this.account = account;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
