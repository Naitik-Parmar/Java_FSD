package com.hexa.springannotation.com.hexa.springannotation1;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	int Roll;
	String Name;
	Double Fee;
	
	@Autowired
	Result Res;
	
	public Result getRes() {
		return Res;
	}


	public void setRes(Result res) {
		Res = res;
	}


	Student(){
		
	}
	
	
	public Student(int roll, String name, Double fee) {
		super();
		Roll = roll;
		Name = name;
		Fee = fee;
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
		return Fee;
	}
	public void setFee(Double fee) {
		Fee = fee;
	}
	@Override
	public String toString() {
		return "Student [Roll=" + Roll + ", Name=" + Name + ", Fee=" + Fee + "]";
	}
	
	void init() {
		System.out.println("Before destroying object");
	}
	void destroy() {
		System.out.println("After finished , object destroyed");
	}
}
