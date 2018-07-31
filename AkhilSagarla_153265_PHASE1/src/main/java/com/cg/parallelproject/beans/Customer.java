package com.cg.parallelproject.beans;

public class Customer {

	private String custName;
	//private String username;
	private String password;
	private String mobileNo;
	private Wallet wallet;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String custName, Wallet wallet) {
		super();
		this.custName = custName;
		this.wallet = wallet;
	}

	public Customer(String name2, String mobileNo2, Wallet wallet2) {
		this.custName = name2;
		this.mobileNo = mobileNo2;
		this.wallet = wallet2;
	}

	public String getName() {
		return custName;
	}

	public void setName(String name) {
		this.custName = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	

	/*public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}*/

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [custName=" + custName  + ", password=" + password + ", mobileNo="
				+ mobileNo + ", wallet=" + wallet + "]";
	}

	
}
