package com.revature.beans;

import java.util.Scanner;

public class Menu {

	static Scanner in = new Scanner(System.in);

	public void startMenu() {
		int menuSelection = 0;
		while (menuSelection != 10) {
			System.out.println("Welcome to One National Bank" 
								+ "\nPlease enter the corresponding value if you want to log in as:"
								+ "\n1. Customer" 
								+ " 2. Employee" 
								+  "3. Bank Admin");
			menuSelection = in.nextInt();

			switch (menuSelection) {
				
			case 1: 
				// so
			
				
			}
			
			}

}
	}
