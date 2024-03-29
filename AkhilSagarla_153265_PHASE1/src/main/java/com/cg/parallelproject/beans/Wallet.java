package com.cg.parallelproject.beans;

import java.math.BigDecimal;

public class Wallet {
	private BigDecimal balance;

	public Wallet() {
		super();
	}

	public Wallet(BigDecimal amount) {
		this.balance = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return ", balance=" + balance;
	}

}
