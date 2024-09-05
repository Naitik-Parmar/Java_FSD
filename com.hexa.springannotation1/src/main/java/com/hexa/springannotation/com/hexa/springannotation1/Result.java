package com.hexa.springannotation.com.hexa.springannotation1;

public class Result {
	int Marks;
	String Remarks;
	public int getMarks() {
		return Marks;
	}
	public void setMarks(int marks) {
		Marks = marks;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	@Override
	public String toString() {
		return "Result [Marks=" + Marks + ", Remarks=" + Remarks + "]";
	}
	
	
}
