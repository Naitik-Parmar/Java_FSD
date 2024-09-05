package com.java.client;

import java.util.Scanner;

import com.java.Connect.DataConnect;
import com.java.Student.Dao.IStudentDao;
import com.java.demo.Service.StudentService;

public class Main {

	public static void main(String[] args) {


		StudentService ser = new StudentService();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("Press 1. Add Student");
			System.out.println("Press 2. Show all Student");
			System.out.println("Press 3. Update Fee");
			System.out.println("Press 0. To Exit");
			int input=sc.nextInt();
			if(input==0) {
				System.out.println("Exiting Student Module ...");
				break;
			}
			switch(input) {
			case 1:
				ser.addData();
				break;
			case 2:
				ser.showAllStudents();
				break;
			case 3:
				ser.update();
			}
		}
			
	}

}
