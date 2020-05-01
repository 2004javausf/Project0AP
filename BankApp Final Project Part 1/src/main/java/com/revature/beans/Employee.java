package com.revature.beans;

import java.io.Serializable;
import java.util.Scanner;

public class Employee implements Serializable {
	private static final long serialVersionUID = 8428831193930907756L;
	static Scanner in = new Scanner(System.in);
	static Scanner st = new Scanner(System.in);
	
	private String firstName;
	private String lastName;
	private CharSequence phoneNumber;
	private String email;
	private String userName;
	private String passWord;
	private String designation;
	private int priority;
	
	public Employee() {
		super();
	}
	public Employee(String firstName, String lastName, CharSequence phoneNumber, String email, String userName,
			String passWord, String designation, int priority) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.userName = userName;
		this.passWord = passWord;
		this.designation = designation;
		this.priority = priority;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "EmpRegister [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", userName=" + userName + ", passWord=" + passWord + ", designation="
				+ designation + ", priority=" + priority + "]";
	}
	
	
	
	

}
