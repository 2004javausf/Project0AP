package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.beans.Accounts;
import com.revature.services.AccTrans;

public class AccTransTest {
	private long aID = 1;
	private long[] cID = {1,0,0,0,0,0,0,0,0,0};
	private String aType = "CHECKING";
	private long acctNumber = 1;
	private double balance = 500.0;
	private String[] email = {"abcd.def@gmail.com",null,null,null,null,null,null,null,null,null};
	private String prevTrans = " ";
	private Accounts ac1 = new Accounts(aID, cID, aType, acctNumber, balance, email, prevTrans);
	
	private long aID2 = 2;
	private long[] cID2 = {2,0,0,0,0,0,0,0,0,0};
	private String aType2 = "SAVING";
	private long acctNumber2 = 2;
	private double balance2 = 300.0;
	private String[] email2 = {"xyz.adef@gmail.com",null,null,null,null,null,null,null,null,null};
	private String prevTrans2 = " ";
	private Accounts ac2 = new Accounts(aID2, cID2, aType2, acctNumber2, balance2, email2, prevTrans2);
	
	private AccTrans at = new AccTrans();
	
	
	
	/*
	 * Test for Accounts.java
	 */
	
	// Withdraw
	@Test
	void withdrawTest() {
		double amount = 200;
		at.withdraw(ac1, amount);
		//expected, actual
		assertEquals(300.0, ac1.getBalance());
	}
	
	// Deposit
	@Test
	void depositTest() {
		double amount = 400;
		at.deposit(ac1, amount);
		//expected, actual
		assertEquals(900.0, ac1.getBalance());
	}
	
	// Transfer
	@Test
	void transferTest() {
		double amount = 100;
		at.transfer(ac1, ac2, amount);
		//expected, actual
		assertEquals(400.0, ac1.getBalance());
		assertEquals(400.0, ac2.getBalance());
	}
	
	
		
		
		
	
	
	
	
	
	
	
	
	
	
	
}
