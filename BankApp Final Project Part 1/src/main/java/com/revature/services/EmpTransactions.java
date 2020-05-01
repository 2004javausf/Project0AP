package com.revature.services;

import java.util.Scanner;

import com.revature.beans.Accounts;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.Menu;
import com.revature.storage.FileAccess;

public class EmpTransactions {
	Employee e = new Employee();
	Validations v = new Validations();
	FileAccess emp = new FileAccess();
	Scanner in = new Scanner(System.in);
	Scanner st = new Scanner(System.in);
	int priority;
	
	
	public void addEmployee() {
		boolean b = false;	
		emp.readEmpFile();
		System.out.print("Enter Employee's First Name: ");
		e.setFirstName(st.nextLine());
		System.out.print("Enter Employee's Last Name: ");
		e.setLastName(st.nextLine());
		
		do {
			System.out.print("Phone Number: ");
			e.setPhoneNumber(st.nextLine());
			b=v.validatePhone(e.getPhoneNumber());
		} while(b == false);
			
		do {
			System.out.print("Email Id: ");
			e.setEmail(st.nextLine());
			b=v.validateEmail(e.getEmail());
		} while(b == false);

		System.out.print("Enter Username: ");
		e.setUserName(st.nextLine());
			
		do {
			System.out.print("Enter a password: ");
			e.setPassWord(st.nextLine());
			b = v.validatePassword(e.getPassWord());
		} while (b == false);
		
		System.out.print("Enter Employee's Designation: ");
		e.setDesignation(st.nextLine());
		
		if(e.getDesignation().equalsIgnoreCase("Admin")){
			e.setPriority(1);
		}
		else {
			e.setPriority(2);
		}
		
		emp.empList.add(e);
		emp.writeEmpFile(emp.empList);
		
		
		
	}
	
	public void empLogin() {
		emp.readEmpFile();
		String uName;
		String password;
		Menu menu = new Menu();
		
		System.out.print("Enter Username: ");
		uName = st.nextLine();
		
		System.out.print("Enter Password: ");
		password = st.nextLine();
		
		for (int i = 0; i < emp.empList.size(); i++) {

			e = emp.empList.get(i);
			if(uName.equalsIgnoreCase(e.getUserName()) && password.equals(e.getPassWord())) {
				priority = e.getPriority();
				if(e.getPriority() == 1) {
					menu.adminTransMenu();
				}
				else {
					menu.empTransMenu();
				}
				
			}
		}
		System.out.println("Username and/or Password incorrect. Check and try again...!!!!");
		
	}
	
	public void viewApplication() {
		FileAccess app = new FileAccess();
		Customer cApp = new Customer();
		Accounts cAcct = new Accounts();
		app.readAppFile();
		for (int i = 0; i < app.appList.size(); i++) {
			cApp = app.appList.get(i);
			if(cApp.getStatus() == null) {
				System.out.println(cApp);
				System.out.println("\n************\n*   Menu   *\n************" + "\n1. Approve Application" + "\n2. Deny Application"
									+ "\n3. View Next Application" + "\n4. Go Back to Previous Menu"
									+ "\nEnter Your Choice: ");
				int choice = in.nextInt();
				switch(choice) {
				case 1:
					String[] email = new String [10];
					long[] aid = new long [10];
					long[] cid = new long [10];
					
					app.appList.get(i).setStatus("Approved");
					if(app.appList.get(i).getAtype().equalsIgnoreCase("C")) {
						app.appList.get(i).setAtype("CHECKING");
					}
					else {
						app.appList.get(i).setAtype("SAVING");
					}
					app.readCustFile();
					app.readAcctFile();
					if(app.acctList.size()==0) {
						cAcct.setAccountID(1);
					}
					else {
							Accounts a = new Accounts();
							a=app.acctList.get((app.acctList.size())-1);
							cAcct.setAccountID((a.getAccountID())+1);	
					}
					
					if(app.custList.size() == 0) {
						cApp.setCustomerID(1);
						app.appList.get(i).setCustomerID(cApp.getCustomerID());
						aid[0]=cAcct.getAccountID();
						cApp.setAccountID(aid);
						cApp.setStatus("Active");
						cApp.setAtype(" ");
						
						app.custList.add(cApp);
					}
					else {
						int count=0;
						for (int j = 0; j <app.custList.size(); j++) {
							Customer c = new Customer();
							c=app.custList.get(j);
							if(cApp.getFirstName().equalsIgnoreCase(c.getFirstName()) && cApp.getLastName().equalsIgnoreCase(c.getLastName()) && cApp.getEmail().equalsIgnoreCase(c.getEmail())) {
								app.appList.get(i).setCustomerID(c.getCustomerID());
								aid=c.getAccountID();
								int x=0;
								for(int z=aid.length-1; z>=0; z--) {
									if(aid[z] == 0) {
										x=z;
									}
								}
								aid[x]=cAcct.getAccountID();
								c.setAccountID(aid);
								if(c.getStatus().equalsIgnoreCase("Inactive")) {
									c.setStatus("Active");
								}
								c.setAtype(" ");
								app.custList.set(j, c);	
								count++;
							}
						}
						if(count==0) {
							Customer c = new Customer();
							c=app.custList.get((app.custList.size())-1);
							cApp.setCustomerID((c.getCustomerID())+1);	
							app.appList.get(i).setCustomerID(cApp.getCustomerID());
							aid[0]=cAcct.getAccountID();
							cApp.setAccountID(aid);
							cApp.setStatus("Active");
							cApp.setAtype(" ");
								
							app.custList.add(cApp);
						}
					}
					cAcct.setAcctNumber(cAcct.getAccountID());
					int x=0;
					for(int z=cid.length-1; z>=0; z--) {
						if(cid[z] == 0) {
							x=z;
						}
					}
					cid[x]=app.appList.get(i).getCustomerID();
					cAcct.setCustomerID(cid);
					x=0;
					for(int z=email.length-1; z>=0; z--) {
						if(email[z] == null) {
							x=z;
						}
					}
					email[x]=cApp.getEmail();
					cAcct.setEmail(email);
					cAcct.setAccountType(app.appList.get(i).getAtype());
					app.acctList.add(cAcct);
					
					app.writeAcctFile(app.acctList);
					app.writeCustFile(app.custList);
					
					break;
				case 2:
					cApp.setStatus("Denied");
					break;
				case 3: 
					break;
				case 4: 
					Menu menu = new Menu();
					app.readRevFile();
					app.revList.add(app.appList.get(i));
					app.writeRevFile(app.revList);
					app.appList.remove(i);
					app.writeAppFile(app.appList);
					if(priority == 1) {
						menu.adminTransMenu();
					}
					else {
						menu.empTransMenu();
					}
					break;
			
				}
				
			}
		}
		System.out.println("\n Menu" + "\n1. Go Back to Previous Menu"
				+ "\nEnter Your Choice: ");
		int choice = in.nextInt();
		switch(choice){
		default: 
		Menu menu1 = new Menu();
		app.writeAppFile(app.appList);
		if(priority == 1) {
			menu1.adminTransMenu();
		}
		else {
			menu1.empTransMenu();
		}
		break;
		}
	}
	
	public void viewAllAccounts() {
		FileAccess app = new FileAccess();
		Accounts cAcct = new Accounts();
		
		app.readAcctFile();
		for(Accounts i : app.acctList) {
			System.out.println(i);
		}
		System.out.println("\n Menu" + "\n1. Go Back to Previous Menu"
				+ "\nEnter Your Choice: ");
		int choice = in.nextInt();
		switch(choice){
			default: 
				Menu menu1 = new Menu();
				if(priority == 1) {
					menu1.adminTransMenu();
				}
				else {
					menu1.empTransMenu();
				}
				break;
		}
	}
	public void viewAllCustomers() {
		FileAccess app = new FileAccess();
		
		app.readCustFile();;
		for(Customer i : app.custList) {
			System.out.println(i);
		}
		System.out.println("\n Menu" + "\n1. Go Back to Previous Menu"
				+ "\nEnter Your Choice: ");
		int choice = in.nextInt();
		switch(choice){
			default: 
				Menu menu1 = new Menu();
				if(priority == 1) {
					menu1.adminTransMenu();
				}
				else {
					menu1.empTransMenu();
				}
				break;
		}
	}
	public void viewAllApps() {
		FileAccess app = new FileAccess();
		Customer cApp = new Customer();
		
		app.readAppFile();;
		for(Customer i : app.appList) {
			System.out.println(i);
		}
		System.out.println("\n Menu" + "\n1. Go Back to Previous Menu"
				+ "\nEnter Your Choice: ");
		int choice = in.nextInt();
		switch(choice){
			default: 
				Menu menu1 = new Menu();
				if(priority == 1) {
					menu1.adminTransMenu();
				}
				else {
					menu1.empTransMenu();
				}
				break;
		}
	}
}
