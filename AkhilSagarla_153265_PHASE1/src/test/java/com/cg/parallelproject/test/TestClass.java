package com.cg.parallelproject.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.net.PasswordAuthentication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.parallelproject.beans.Customer;
import com.cg.parallelproject.beans.Wallet;
import com.cg.parallelproject.exception.InsufficientBalanceException;
import com.cg.parallelproject.exception.InvalidInputException;
import com.cg.parallelproject.service.WalletService;
import com.cg.parallelproject.service.WalletServiceImpl;

public class TestClass {

	static WalletService walletService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		walletService = new WalletServiceImpl();
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateAccount() throws InvalidInputException {
		Customer customer = new Customer();
		Wallet wallet = new Wallet();
		String name = "Akhil";
		String number = "9951610705";
		String username="Sag";
		String password="Sag@213";
		BigDecimal amount = new BigDecimal(5000);
		
		customer.setName(name);
		customer.setMobileNo(number);
		//customer.setUsername(username);
		customer.setPassword(password);
		wallet.setBalance(amount);
		customer.setWallet(wallet);
		
		customer = walletService.createAccount(name, number, amount, password);
		
		assertNotSame(null, customer);
	}
	
	@Test
	public void testshowBalance() throws InvalidInputException {
		String number = "9951610705";
		
		Customer customer = walletService.showBalance(number);
		
		assertNotSame(null, customer);
	}
	
	@Test(expected = InsufficientBalanceException.class)
	public void testWithdrawAmount() throws InvalidInputException, InsufficientBalanceException {
		String name = "Akhil";
		String mobileNumber = "9951610705";
		BigDecimal balance = new BigDecimal(2000);
		String username="Sag";
		String password="Sag@213";
		
		walletService.createAccount(name, mobileNumber, balance,password);
		
		BigDecimal amount = new BigDecimal(3000);
		
		walletService.withdrawAmount(mobileNumber, amount);
	}
	
	@Test
	public void testDepositAmount() throws InvalidInputException {
		String name = "Akhil";
		String mobileNumber = "9951610705";
		BigDecimal balance = new BigDecimal("3000");
		String username="Sag";
		String password="Sag@213";
		Boolean output = false;
		Customer customer = walletService.createAccount(name, mobileNumber, balance,password);
		Customer customer1 = walletService.depositAmount(mobileNumber, new BigDecimal("3000"));
		BigDecimal balanceOne = new BigDecimal(5000);
		if(balanceOne.compareTo(customer1.getWallet().getBalance())>0) {
			output = true;
		}
		assertTrue(output);
	}
	
	@Test(expected = InsufficientBalanceException.class)
	public void testMobileNumber() throws InvalidInputException, InsufficientBalanceException {
		String name = "Akhil";
		String mobileNumber = "9951610705";
		BigDecimal balance = new BigDecimal(3000);
		String username="Sag";
		String password="Sag@213";
		
		walletService.createAccount(name, mobileNumber, balance, password);
		
		BigDecimal amount = new BigDecimal(3000);
		
		walletService.withdrawAmount(mobileNumber, amount);
	}

}
