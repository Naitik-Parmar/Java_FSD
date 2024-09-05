package com.example.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bank {
	@Id
	int accNo;
	String name;
	double balance;
	String email;
	public int getAccNo() {
		return accNo;
	}
	public Bank(){
		
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Bank [accNo=" + accNo + ", name=" + name + ", balance=" + balance + ", email=" + email + "]";
	}
	public Bank(int accNo, String name, double balance, String email) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
		this.email = email;
	}
	
	
}
