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

import com.revature.beans.Accounts;
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
		
		
		public static final String custFile = "CustomerInfo.txt";
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
		
		public static final String acctFile = "AccountInfo.txt";
		public static List<Accounts> acctList = new ArrayList<Accounts>();

		public void writeAcctFile(List<Accounts> aList) {
			OutputStream ops;
			ObjectOutputStream objOps;

			try {
				ops = new FileOutputStream(acctFile);
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
		public void readAcctFile() {
			//InputStream fileIs = null;
			//ObjectInputStream objIs = null;
			try {
				this.acctList.clear();
				ObjectInputStream objIs = new ObjectInputStream(new FileInputStream(acctFile));
				this.acctList.addAll((Collection<? extends Accounts>) objIs.readObject());
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
		
		public static final String revFile = "ReviewedApps.txt";
		public static List<Customer> revList = new ArrayList<Customer>();

		public void writeRevFile(List<Customer> rList) {
			OutputStream ops;
			ObjectOutputStream objOps;

			try {
				ops = new FileOutputStream(revFile);
				objOps = new ObjectOutputStream(ops);
				objOps.writeObject(rList);
				objOps.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		@SuppressWarnings("unchecked")
		public void readRevFile() {
			//InputStream fileIs = null;
			//ObjectInputStream objIs = null;
			try {
				this.revList.clear();
				ObjectInputStream objIs = new ObjectInputStream(new FileInputStream(revFile));
				this.revList.addAll((Collection<? extends Customer>) objIs.readObject());
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
}