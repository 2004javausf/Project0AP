package com.revature.services;

import java.util.Scanner;


public class Accounts {
	
	static Scanner in = new Scanner (System.in);
	static Scanner st = new Scanner (System.in);

	double balance;
	double previousTransaction;
	String customerName;
	long customerId;
	
	public Accounts() {
		super();
	}
	
	public Accounts(String customerName, long customerId) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
	}

	public double deposit(double amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
		return balance;
	}
	
	public double withdraw(double amount) {
		if(amount!=0) {
			balance = balance - amount;
			previousTransaction = -amount;  
		}
		return balance;
	}
	
	public void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: $" + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdrawn: $" + Math.abs(previousTransaction));
		} else {
			System.out.println("There were no transaction occured");
		}
	}
	
	public void transfer(double amount, Accounts customerID ) {
		if (this.balance<amount){ 
			System.out.println("Insuffecient balance, Transfer fails.");
			}
		else {
		this.balance -= amount;
		customerID.balance += amount;
		this.previousTransaction = -amount;
		customerID.previousTransaction = amount;
		}
		
		
	}
	
	public void showMenu() {
		int option;
		System.out.println("Welcome " + customerName);
		System.out.println("Your ID is " + customerId);
		System.out.println("\n1. Check Balance" + " 2. Deposit" + " 3. Withdraw" 
							+" 4. Previous Transaction" + " 5. Transfer" + " 6. Exit");
		do {
			System.out.print("Enter an option: ");
			option = in.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("Your currrent balance is: " + balance);
				break;
			case 2:
				System.out.print("How much do you want to deposit: ");
				double amount = in.nextDouble();
				System.out.println("Your balance is " + deposit(amount));
				break;
			case 3:
				System.out.print("Enter an amount to withdraw: ");
				double amount2 = in.nextDouble();
				System.out.println("You withdrew: " + amount2);
				System.out.println("Your current balance is: "+ withdraw(amount2));
				break;
			case 4:
				getPreviousTransaction();
				break;
			case 5:
//				System.out.println("Enter transfer amount: ");
//				double tamount = in.nextDouble();
//				System.out.println("Enter transfer Account: ");
//				BankAccount customerID = st.nextLine();
//				transfer(tamount, customerID);
				break;
			case 6:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Invalid Option! Please enter again");
			}
		}
		while(option != 5);
			System.out.println("Thank you for using our service");
			
		}

}
