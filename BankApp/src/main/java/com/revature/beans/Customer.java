package com.revature.beans;
import java.io.Serializable;
import java.util.Scanner;

import com.revature.services.Validations;

	public class Customer implements Serializable {

		private static final long serialVersionUID = -223626428111126439L;
		static Scanner in = new Scanner(System.in);
		static Scanner st = new Scanner(System.in);
		
		private String firstName;
		private String lastName;
		private String dob;
		private String gender;
		private String address;
		private CharSequence phoneNumber;
		private String email;
		private String accountType;
		private String userName;
		private String passWord;
		private String status;
		private long acctNumber;
		private long customerID;
		
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Customer(String firstName, String lastName, String dob, String gender, String address,
				CharSequence phoneNumber, String email, String accountType, String userName, String passWord, String status,
				long acctNumber, long customerId) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.dob = dob;
			this.gender = gender;
			this.address = address;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.accountType = accountType;
			this.userName = userName;
			this.passWord = passWord;
			this.status = status;
			this.acctNumber = acctNumber;
			this.customerID = customerId;
		}		
		// Getters and Setters
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public CharSequence getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(CharSequence phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAccountType() {
			return accountType;
		}

		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassWord() {
			return passWord;
		}

		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public long getAcctNumber() {
			return acctNumber;
		}

		public void setAcctNumber(long acctNumber) {
			this.acctNumber = acctNumber;
		}
		
		public long getCustomerID() {
			return customerID;
		}

		public void setCustomerID(long customerID) {
			this.customerID = customerID;
		}

		public static void apply() {
			Validations v = new Validations();
			Customer r = new Customer();
			boolean b = false;
			
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
			
			System.out.print("Account Type: ");
			r.setAccountType(st.nextLine());
			
			System.out.print("Enter Username: ");
			r.setUserName(st.nextLine());
			
			System.out.print("Enter a password: ");
			r.setPassWord(st.nextLine());
			
				System.out.println(r);		
			}

		@Override
		public String toString() {
			return "Application [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender="
					+ gender + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email
					+ ", accountType=" + accountType + ", userName=" + userName + ", passWord=" + passWord + ", status="
					+ status + ", acctNumber=" + acctNumber + ", customerID=" + customerID + "]";
		}
		
		public static void main(String[] args) {
			apply();
		}
		
		
		

		
		}

	


