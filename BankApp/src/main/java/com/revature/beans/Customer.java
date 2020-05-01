package com.revature.beans;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

	public class Customer implements Serializable {

		
		private static final long serialVersionUID = -2346529210673456435L;
		static Scanner in = new Scanner(System.in);
		static Scanner st = new Scanner(System.in);
		
		private String firstName;
		private String lastName;
		private String dob;
		private String gender;
		private String address;
		private CharSequence phoneNumber;
		private String email;
		private String userName;
		private String passWord;
		private String status;
		private long customerID;
		private String atype;
		long[] accountID = new long[10];
		
		

		public Customer() {
			super();
		}
		
		public Customer(String firstName, String lastName, String dob, String gender, String address,
				CharSequence phoneNumber, String email, String userName, String passWord, String status,
				long customerID, String atype, long[] accountID) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.dob = dob;
			this.gender = gender;
			this.address = address;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.userName = userName;
			this.passWord = passWord;
			this.status = status;
			this.customerID = customerID;
			this.atype = atype;
			this.accountID = accountID;
		}

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
		public long getCustomerID() {
			return customerID;
		}
		public void setCustomerID(long customerID) {
			this.customerID = customerID;
		}
		public long[] getAccountID() {
			return accountID;
		}
		public void setAccountID(long[] accountID) {
			this.accountID = accountID;
		}
				
		public String getAtype() {
			return atype;
		}

		public void setAtype(String atype) {
			this.atype = atype;
		}

		@Override
		public String toString() {
			return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender
					+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", userName="
					+ userName + ", passWord=" + passWord + ", status=" + status + ", customerID=" + customerID
					+ ", atype=" + atype + ", accountID=" + Arrays.toString(accountID) + "]";
		}

			
}

	


