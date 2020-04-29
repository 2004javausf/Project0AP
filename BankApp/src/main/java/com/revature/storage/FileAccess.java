package com.revature.storage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.beans.Employee;

public class FileAccess {
		public static final String empFile = "EmployeeInfo.txt";
		public static List<Employee> empList = new ArrayList<Employee>();

		public void writeEmpFile(List<Employee> eList) {
			OutputStream ops;
			ObjectOutputStream objOps;

			try {
				ops = new FileOutputStream(empFile);
				objOps = new ObjectOutputStream(ops);
				objOps.writeObject(eList);
				objOps.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		
		@SuppressWarnings("unchecked")
		public void readEmpFile() {
			//InputStream fileIs = null;
			//ObjectInputStream objIs = null;
			try {
				this.empList.clear();
				ObjectInputStream objIs = new ObjectInputStream(new FileInputStream(empFile));
				this.empList.addAll((Collection<? extends Employee>) objIs.readObject());
				objIs.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		
		public static final String custFile = "AccountInfo.txt";
		public static List<Customer> custList = new ArrayList<Customer>();

		public void writeCustFile(List<Customer> cList) {
			OutputStream ops;
			ObjectOutputStream objOps;

			try {
				ops = new FileOutputStream(custFile);
				objOps = new ObjectOutputStream(ops);
				objOps.writeObject(cList);
				objOps.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		@SuppressWarnings("unchecked")
		public void readCustFile() {
			//InputStream fileIs = null;
			//ObjectInputStream objIs = null;
			try {
				this.custList.clear();
				ObjectInputStream objIs = new ObjectInputStream(new FileInputStream(custFile));
				this.custList.addAll((Collection<? extends Customer>) objIs.readObject());
				objIs.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		public static final String appFile = "Applications.txt";
		public static List<Customer> appList = new ArrayList<Customer>();

		public void writeAppFile(List<Customer> aList) {
			OutputStream ops;
			ObjectOutputStream objOps;

			try {
				ops = new FileOutputStream(appFile);
				objOps = new ObjectOutputStream(ops);
				objOps.writeObject(aList);
				objOps.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		
		@SuppressWarnings("unchecked")
		public void readAppFile() {
			//InputStream fileIs = null;
			//ObjectInputStream objIs = null;
			try {
				this.appList.clear();
				ObjectInputStream objIs = new ObjectInputStream(new FileInputStream(appFile));
				this.appList.addAll((Collection<? extends Customer>) objIs.readObject());
				objIs.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		
//		public static void main(String[] args) {
//			Scanner in = new Scanner(System.in);
//			Scanner st = new Scanner(System.in);
//			Employee e = new Employee();
//			Employee e2 = new Employee();
//			MyObjectFileStore mof = new MyObjectFileStore();
//			mof.displayObject();
//			int l,id;
//			System.out.println("Enter your name: ");
//			e2.setName(st.nextLine());
//			//System.out.println("Enter your ID: ");
//			//e2.setId(in.nextInt());
//			l=mof.empList.size();
//			e = mof.empList.get(l-1);
//			e2.setId((e.getId()+1));
//			System.out.println("What is your Salary: ");
//			e2.setSalary(st.nextLine());		
//			
////			Employee e1 = new Employee("Abid", 1, "60000");
////			mof.empList.add(e1);
////			mof.storeObject();
//			mof.empList.add(e2);
//			mof.storeObject(mof.empList);
//			mof.displayObject();
//			
//			for (Employee i : mof.empList) {
//				System.out.println(i);
//				}
//			//System.out.println(mof.empList);
//		}
	}

