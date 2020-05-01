package com.revature.services;

import java.util.Scanner;

import com.revature.beans.Accounts;
import com.revature.beans.Customer;
import com.revature.storage.FileAccess;

public class CustTrans {
	
	
	static Customer c = new Customer();	
	static Accounts[] a = new Accounts[10];
	
	
	public static Customer custLogin(String name, String pass) {
		FileAccess fa = new FileAccess();
		Customer c1 = new Customer();
		int count=0;
		fa.readCustFile();
				
		for(int i=0; i<fa.custList.size();i++) {
			c1 = fa.custList.get(i);
			if(name.equalsIgnoreCase(c1.getUserName()) && pass.equals(c1.getPassWord())) {
				c = c1;
				count++;
				System.out.println("Welcome Back "+ c.getFirstName() + " " + c.getLastName());	
			}
		}
		if(count==0) {
			System.out.println("Username and/or Password incorrect. Check and try again...!!!!");
		}
		return c;
	}
	public static Accounts accessAccount(Customer c) {
		
		FileAccess fa = new FileAccess();
		Scanner in = new Scanner(System.in);
		Accounts a1 = new Accounts();
		long[] aid = new long[10];
		fa.readAcctFile();
		int x=0;
		
		aid=c.getAccountID();
		for(int j=0; j<c.getAccountID().length; j++ ) {
			for(int i=0; i<fa.acctList.size(); i++) {
				a1=fa.acctList.get(i);
				if(aid[j]==a1.getAccountID()) {
					a[x] = a1;
					x++;	
				}
			}
		}
		int y = 1;
		for(Accounts i: a) {
			if(i!=null){
				System.out.println(y+". Account # "+i.getAcctNumber());
				y++;
			}
		}
		System.out.print("Which Account you want to access from above list, enter the number: ");
		return a[(in.nextInt())-1];
				
	}
	
	
}
