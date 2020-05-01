package com.revature.services;

import java.util.Scanner;

import com.revature.beans.Accounts;
import com.revature.beans.Customer;
import com.revature.beans.Menu;
import com.revature.storage.FileAccess;

public class AccTrans {
	
	static Scanner in = new Scanner (System.in);
	static Scanner st = new Scanner (System.in);

	static double balance;
	static double balance2;
	static double previousTransaction;
		
		
	public static void deposit(Accounts a, double amount) {
		balance = a.getBalance();
		if(amount != 0) {
			balance = balance + amount;
			a.setPrevTrans("Deposited $"+Double.toString(amount));
		}
		a.setBalance(balance);
		System.out.println("You have deposited $"+amount+" successfully.");
	}
	
	public static void withdraw(Accounts a, double amount) {
		balance = a.getBalance();
		if(amount!=0) {
			balance = balance - amount;
			a.setPrevTrans("Withdrawn $"+Double.toString(amount));
		}
		a.setBalance(balance);
		System.out.println("You have withdrawn $"+amount+" successfully.");
	}
	
	public static void showPreviousTransaction(Accounts a) {
		System.out.println(a.getPrevTrans());
	}
	
	public static void showBalance(Accounts a) {
		System.out.println("The Current balance is "+ a.getBalance());
	}
	
	public static void transfer(Accounts a1, Accounts a2, double amount) {
		balance = a1.getBalance();
		balance2 = a2.getBalance();
		if (balance<amount){ 
			System.out.println("Insuffecient balance, Transfer fails.");
		}
		else {
		balance = balance - amount;
		balance2 = balance2 + amount;
		a1.setPrevTrans("Transfered $"+Double.toString(amount)+" to "+a2.getAcctNumber());
		a2.setPrevTrans("Deposited via transfer $"+Double.toString(amount)+" from "+a1.getAcctNumber());
		}
		
		a1.setBalance(balance);	
		a2.setBalance(balance2);
		showBalance(a1);
	}
	
	public static void apply() {
		Validations v = new Validations();
		Customer r = new Customer();
		FileAccess app = new FileAccess();
		Menu m = new Menu();
		boolean b = false;
		app.readAppFile();
		
		System.out.print("What type of Account you want to open?\n[C]hecking\n[S]aving\nEneter your choice: ");
		r.setAtype(st.nextLine());
		
		System.out.print("First Name: ");
		r.setFirstName(st.nextLine());
		
		System.out.print("Last Name: ");
		r.setLastName(st.nextLine());
		do {
		System.out.print("Gender <M or F>: ");
		r.setGender(st.nextLine().toUpperCase());
		b = v.validateGender(r.getGender());
		} while(b == false);
		
		do {
		System.out.print("DOB <MM/DD/YYYY>: ");
		r.setDob(st.nextLine());
		b = v.validateDate(r.getDob());
		} while(b == false);
		
		System.out.print("Residential Address ");
		r.setAddress(st.nextLine());
		do {
		System.out.print("Phone Number: ");
		r.setPhoneNumber(st.nextLine());
		b=v.validatePhone(r.getPhoneNumber());
		} while(b == false);
		
		do {
		System.out.print("Email Id: ");
		r.setEmail(st.nextLine());
		b=v.validateEmail(r.getEmail());
		} while(b == false);

		System.out.print("Enter Username: ");
		r.setUserName(st.nextLine());
		
		do {
		System.out.print("Enter a password: ");
		r.setPassWord(st.nextLine());
		b = v.validatePassword(r.getPassWord());
		} while (b == false);
		
			System.out.println(r);	
			System.out.print("Menu" + "\n1. Submit" + "\n2. Cancel" + "\n Enter the number: ");
			int selection = in.nextInt();
			switch(selection) {
			case 1:
				app.appList.add(r);
				app.writeAppFile(app.appList);
				System.out.println("Thank you for Applying! Give us few days to review your Application.");
				m.startMenu();
				break;
				
			default:
				m.startMenu();
				break;
			}
			
		}

	
//	public void showMenu() {
//		int option;
//		System.out.println("Welcome " + customerName);
//		System.out.println("Your ID is " + customerId);
//		System.out.println("\n1. Check Balance" + " 2. Deposit" + " 3. Withdraw" 
//							+" 4. Previous Transaction" + " 5. Transfer" + " 6. Exit");
//		do {
//			System.out.print("Enter an option: ");
//			option = in.nextInt();
//			
//			switch(option) {
//			case 1:
//				System.out.println("Your currrent balance is: " + balance);
//				break;
//			case 2:
//				System.out.print("How much do you want to deposit: ");
//				double amount = in.nextDouble();
//				System.out.println("Your balance is " + deposit(amount));
//				break;
//			case 3:
//				System.out.print("Enter an amount to withdraw: ");
//				double amount2 = in.nextDouble();
//				System.out.println("You withdrew: " + amount2);
//				System.out.println("Your current balance is: "+ withdraw(amount2));
//				break;
//			case 4:
//				getPreviousTransaction();
//				break;
//			case 5:
////				System.out.println("Enter transfer amount: ");
////				double tamount = in.nextDouble();
////				System.out.println("Enter transfer Account: ");
////				BankAccount customerID = st.nextLine();
////				transfer(tamount, customerID);
//				break;
//			case 6:
//				System.out.println("Exit");
//				break;
//			default:
//				System.out.println("Invalid Option! Please enter again");
//			}
//		}
//		while(option != 5);
//			System.out.println("Thank you for using our service");
//			
//		}

}
