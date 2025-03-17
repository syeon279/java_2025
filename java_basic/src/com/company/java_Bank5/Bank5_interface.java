package com.company.java_Bank5;


class Bank {
	private String id;
	private String pass;
	private double balance;

	public String getId() { return id; } 
	public void setId(String id) { this.id = id; }
	public String getPass() { return pass; } public void setPass(String pass) { this.pass = pass; }
	public double getBalance() { return balance; } public void setBalance(double balance) { this.balance = balance; }
	
	public Bank() {
		super();
	}
	public Bank(String id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", pass=" + pass + ", balance=" + balance + "]";
	} 
	
} // E class

public class Bank5_interface {
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.exec();
	}// E main
} // E class

