package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Student {
	
	@Id
	int Roll;
	
	@NotEmpty
	String Name;
	
	@Min(value=18,message="age cannot be less than 18")
	@Max(value=60,message="age cannot be greater than 60")
	int age;
	
	@Email
	String email;
	
	@Size(min=4,max=50)
	String address;
	
//	@Pattern(regexp = "^[0-9]{6}$")
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
