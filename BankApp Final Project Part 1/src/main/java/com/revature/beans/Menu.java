package com.revature.beans;

import java.util.Scanner;

import com.revature.services.AccTrans;
import com.revature.services.CustTrans;
import com.revature.services.EmpTransactions;
import com.revature.storage.FileAccess;

public class Menu {

	static Scanner in = new Scanner(System.in);
	
	
	

	public void startMenu() {
		EmpTransactions etrans = new EmpTransactions();
		int menuSelection = 0;
		do {
			System.out.print("**********************************************************\n*                   Welcome to AV Bank                   *\n**********************************************************" 
							+ "\nPlease enter the corresponding value if you want to log in as:"
							+ "\n1. Customer" + "\n2. Employee" + "\n3. Exit"+"\nEnter the number [1-3]: ");
			menuSelection = in.nextInt();

			switch (menuSelection) {

			case 1:
				custMainMenu();
				break;

			case 2:
				etrans.empLogin();
				break;
			case 3:
				System.out.println("Thank you for using our Service! Good Bye");
				System.exit(0);
				break;

			}

		} while (menuSelection != 3);

	}
	
	public void custMainMenu() {
		Scanner st = new Scanner(System.in);
		Accounts ac = new Accounts();
		Customer ca = new Customer();
		int menuSelection = 0;
		do {
			System.out.println("\n************\n*   Menu   *\n************"+ "\n1. New Customer" + "\n2. Existing Cusomter" + "\n3. Go Back"+"\nEnter the number [1-3]: ");
			menuSelection = in.nextInt();

			switch (menuSelection) {

			case 1:
				System.out.println("Apply for an Account...");
				AccTrans.apply();
				break;

			case 2:
				System.out.println("Login");
				
				System.out.print("Enter User Name: ");
				String uname = st.nextLine();
				System.out.print("Enter Password: ");
				String password = st.nextLine();
				ca=CustTrans.custLogin(uname, password);
				ac=CustTrans.accessAccount(ca);
				
				custTransMenu(ac, ca);				
				break;
				
			default:
				System.out.println("Return to the Main Menu");
				startMenu();
				break;

			}

		} while (menuSelection != 3);		
	}
	
	public void custTransMenu(Accounts a, Customer c) {
		FileAccess fa = new FileAccess();
		Accounts ac = new Accounts();
		Accounts ac2 = new Accounts();
		Customer ca = new Customer();
		long ta;
		ac = a;
		ca = c;
		
		
		int menuSelection = 0;
		do {
			System.out.println("\n************\n*   Menu   *\n************" + "\n1. Apply for a New Account" + "\n2. Add another Person to Existing Account" 
					+ "\n3. Deposit" + "\n4. Withdraw" + "\n5. Transfer Amount to Another Account"
					+ "\n6. View Balance " + "\n7. View Previous Transactions" + "\n8. Access another Account" + "\n9. Log out"
					+ "\n10. Save and Exit" +"\nEnter the number [1-10]: ");
			menuSelection = in.nextInt();
			
			switch (menuSelection) {
			
			case 1:
				AccTrans.apply();
				break;
			
			case 2:
				// Call Method For adding New User
				break;
			case 3:
				System.out.println("Enter the amount you want to deposit: ");
				AccTrans.deposit(ac, in.nextDouble());
				AccTrans.showBalance(ac);
				break;
			case 4:
				System.out.println("Enter the amount you want to withdraw: ");
				AccTrans.withdraw(ac, in.nextDouble());
				AccTrans.showBalance(ac);
				break;
			case 5:
				System.out.print("Enter the Account Number you want to send money to: ");
				ta=in.nextLong();
				
				fa.readAcctFile();
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac2=fa.acctList.get(i);
					}
				}
				
				System.out.println("Enter the amount you to transfer: ");
				AccTrans.transfer(ac, ac2, in.nextDouble());
				AccTrans.showBalance(ac);
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						fa.acctList.set(i, ac2);
					}
				}
				break;
			case 6:
				AccTrans.showBalance(ac);
				break;
			case 7:
				AccTrans.showPreviousTransaction(ac);
				break;
			case 8:
				ac=CustTrans.accessAccount(ca);
				break;
			default:
				System.out.println("DO you want to save changes? \n1. Yes \n2.No \nEnter the number [1-2]: ");
				if(in.nextInt()==1)
				{
					for(int i=0; i<fa.acctList.size(); i++) {
						if(fa.acctList.get(i).getAcctNumber()==ac.getAcctNumber()) {
							fa.acctList.set(i, ac);
						}
					}
					fa.writeAcctFile(fa.acctList);
				}
				System.out.println("Log Out Successfully");
				System.out.println("Return to the Main Menu");
				startMenu();
				break;
			
			}

		} while (menuSelection < 9);		
	}
	
	
	public void empTransMenu() {
		FileAccess fa = new FileAccess();
		Accounts ac = new Accounts();
		Accounts ac2 = new Accounts();
		Customer ca = new Customer();
		long ta;
		
		fa.readAcctFile();
		
		EmpTransactions etrans = new EmpTransactions();
		int menuSelection = 0;
		do {
			System.out.println("\n************\n*   Menu   *\n************"+ "\n1. View All Customers" + "\n2. View All Accounts" + "\n3. View Pending Applications" 
								+ "\n4. Deposit" + "\n5. Withdraw" + "\n6. Transfer Amount to Another Account"
								+ "\n7. View Balance " + "\n8. View Previous Transaction" + "\n9. Log out"
								+ "\n10. Save and Exit"+"\nEnter the number [1-10]: ");
			menuSelection = in.nextInt();

			switch (menuSelection) {

			case 1:
				etrans.viewAllCustomers();
				break;

			case 2:
				etrans.viewAllAccounts();
				break;
			case 3:
				etrans.viewApplication(); 
				break;
			case 4:
				System.out.println("Eneter the account number you want to Access: ");
				ta=in.nextLong();
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac=fa.acctList.get(i);
					}
				}
				
				System.out.println("Enter the amount you want to deposit: ");
				AccTrans.deposit(ac, in.nextDouble());
				AccTrans.showBalance(ac);
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						fa.acctList.set(i, ac);
					}
				}
				break;
			case 5:
				System.out.println("Eneter the account number you want to Access: ");
				ta=in.nextLong();
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac=fa.acctList.get(i);
					}
				}
				
				System.out.println("Enter the amount you want to withdraw: ");
				AccTrans.withdraw(ac, in.nextDouble());
				AccTrans.showBalance(ac);
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						fa.acctList.set(i, ac);
					}
				}
				break;
			case 6:
				System.out.println("Eneter the account number you want to Access: ");
				ta=in.nextLong();
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac=fa.acctList.get(i);
					}
				}
				
				System.out.print("Enter the Account Number you want to send money to: ");
				ta=in.nextLong();
				
				fa.readAcctFile();
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac2=fa.acctList.get(i);
					}
				}
				
				System.out.println("Enter the amount you to transfer: ");
				AccTrans.transfer(ac, ac2, in.nextDouble());
				AccTrans.showBalance(ac);
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						fa.acctList.set(i, ac2);
					}
					if(fa.acctList.get(i).getAcctNumber()==ac.getAcctNumber()) {
						fa.acctList.set(i, ac);
					}
				}
				break;
			case 7:
				System.out.println("Enter the account number you want to Access: ");
				ta=in.nextLong();
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac=fa.acctList.get(i);
					}
				}
				AccTrans.showBalance(ac);
				break;
			case 8:
				System.out.println("Eneter the account number you want to Access: ");
				ta=in.nextLong();
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac=fa.acctList.get(i);
					}
				}
				AccTrans.showPreviousTransaction(ac);
				break;
			default:
				System.out.println("DO you want to save changes? \n1. Yes \n2.No \nEnter the number [1-2]: ");
				if(in.nextInt()==1)
				{
					for(int i=0; i<fa.acctList.size(); i++) {
						if(fa.acctList.get(i).getAcctNumber()==ac.getAcctNumber()) {
							fa.acctList.set(i, ac);
						}
					}
					fa.writeAcctFile(fa.acctList);
				}
				System.out.println("Log Out Successfully");
				System.out.println("Return to the Main Menu");
				startMenu();
				break;
			}

		}while (menuSelection <9);
	
	
	}
	
	public void adminTransMenu() {
	
		FileAccess fa = new FileAccess();
		Accounts ac = new Accounts();
		Accounts ac2 = new Accounts();
		Customer ca = new Customer();
		long ta;
		
		fa.readAcctFile();
		EmpTransactions etrans = new EmpTransactions();
		int menuSelection = 0;
		
		do {
			System.out.println("\n************\n*   Menu   *\n************"+ "\n1. View All Customers" + "\n2. View All Accounts" 
								+ "\n3. View Pending Applications" + "\n4. Deposit" + "\n5. Withdraw" + "\n6. Transfer Amount to Another Account"
								+ "\n7. View Balance " + "\n8. View Previous Transaction" + "\n9. Add Employee"+"\n10. Log out"
								+ "\n11. Save and Exit"+"\nEnter the number [1-11]: ");
			menuSelection = in.nextInt();

			switch (menuSelection) {

			case 1:
				etrans.viewAllCustomers();
				break;

			case 2:
				etrans.viewAllAccounts();
				break;
			case 3:
				etrans.viewApplication(); 
				break;
			case 4:
				System.out.println("Eneter the account number you want to Access: ");
				ta=in.nextLong();
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac=fa.acctList.get(i);
					}
				}
				
				System.out.println("Enter the amount you want to deposit: ");
				AccTrans.deposit(ac, in.nextDouble());
				AccTrans.showBalance(ac);
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						fa.acctList.set(i, ac);
					}
				}
				break;
			case 5:
				System.out.println("Eneter the account number you want to Access: ");
				ta=in.nextLong();
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac=fa.acctList.get(i);
					}
				}
				
				System.out.println("Enter the amount you want to withdraw: ");
				AccTrans.withdraw(ac, in.nextDouble());
				AccTrans.showBalance(ac);
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						fa.acctList.set(i, ac);
					}
				}
				break;
			case 6:
				System.out.println("Eneter the account number you want to Access: ");
				ta=in.nextLong();
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac=fa.acctList.get(i);
					}
				}
				
				System.out.print("Enter the Account Number you want to send money to: ");
				ta=in.nextLong();
				
				fa.readAcctFile();
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac2=fa.acctList.get(i);
					}
				}
				
				System.out.println("Enter the amount you to transfer: ");
				AccTrans.transfer(ac, ac2, in.nextDouble());
				AccTrans.showBalance(ac);
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						fa.acctList.set(i, ac2);
					}
					if(fa.acctList.get(i).getAcctNumber()==ac.getAcctNumber()) {
						fa.acctList.set(i, ac);
					}
				}
				break;
			case 7:
				System.out.println("Eneter the account number you want to Access: ");
				ta=in.nextLong();
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac=fa.acctList.get(i);
					}
				}
				AccTrans.showBalance(ac);
				break;
			case 8:
				System.out.println("Eneter the account number you want to Access: ");
				ta=in.nextLong();
				
				for(int i=0; i<fa.acctList.size(); i++) {
					if(fa.acctList.get(i).getAcctNumber()==ta) {
						ac=fa.acctList.get(i);
					}
				}
				AccTrans.showPreviousTransaction(ac);
				break;
			case 9:
				etrans.addEmployee();
				break;
			default:
				System.out.println("DO you want to save changes? \n1. Yes \n2.No \nEnter the number [1-2]: ");
				if(in.nextInt()==1)
				{
					for(int i=0; i<fa.acctList.size(); i++) {
						if(fa.acctList.get(i).getAcctNumber()==ac.getAcctNumber()) {
							fa.acctList.set(i, ac);
						}
					}
					fa.writeAcctFile(fa.acctList);
				}
				System.out.println("Log Out Successfully");
				System.out.println("Return to the Main Menu");
				startMenu();
				break;

			}

		}while (menuSelection <10);
	
	}
	
	
	
	
	
	
	
}
