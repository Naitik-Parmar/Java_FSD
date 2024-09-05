package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	int Roll;
	String Name;
	Double fee;
	
	public Student() {
		
	}
	public int getRoll() {
		return Roll;
	}
	public void setRoll(int roll) {
		Roll = roll;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Student(int roll, String name, Double fee) {
		super();
		Roll = roll;
		Name = name;
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Student [Roll=" + Roll + ", Name=" + Name + ", fee=" + fee + "]";
	}
	
	

}
