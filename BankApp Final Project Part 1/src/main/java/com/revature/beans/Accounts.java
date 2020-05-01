package com.revature.beans;

import java.io.Serializable;
import java.util.Arrays;

public class Accounts implements Serializable {
	private static final long serialVersionUID = -4844612298949812687L;
	
	private long accountID;
	private long[] customerID = new long[10];
	private String accountType;
	private long acctNumber;
	private double balance;
	private String[] email = new String[10];
	private String prevTrans;
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Accounts(long accountID, long[] customerID, String accountType, long acctNumber, double balance,
			String[] email, String prevTrans) {
		super();
		this.accountID = accountID;
		this.customerID = customerID;
		this.accountType = accountType;
		this.acctNumber = acctNumber;
		this.balance = balance;
		this.email = email;
		this.prevTrans = prevTrans;
	}
	public long getAccountID() {
		return accountID;
	}
	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
	public long[] getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long[] customerID) {
		this.customerID = customerID;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getAcctNumber() {
		return acctNumber;
	}
	public void setAcctNumber(long acctNumber) {
		this.acctNumber = acctNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String[] getEmail() {
		return email;
	}
	public void setEmail(String[] email) {
		this.email = email;
	}
	public String getPrevTrans() {
		return prevTrans;
	}
	public void setPrevTrans(String prevTrans) {
		this.prevTrans = prevTrans;
	}
	@Override
	public String toString() {
		return "Accounts [accountID=" + accountID + ", customerID=" + Arrays.toString(customerID) + ", accountType="
				+ accountType + ", acctNumber=" + acctNumber + ", balance=" + balance + ", email="
				+ Arrays.toString(email) + ", prevTrans=" + prevTrans + "]";
	}
}
	
	
	
