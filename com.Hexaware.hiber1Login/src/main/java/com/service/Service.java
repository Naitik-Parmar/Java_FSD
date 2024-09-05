package com.service;

import java.util.Scanner;

import com.dao.Dao;
import com.dao.DaoInter;
import com.model.Login;

public class Service {
	Scanner sc;
	DaoInter di;
	Login l;
	
	public Service(){
		sc=new Scanner(System.in);
		di=new Dao();
		l=new Login();
	}
	
	public boolean signUp() {
		System.out.println("Enter userId: ");
		String id = sc.nextLine();
		System.out.println("Enter userPassword: ");
		String userName = sc.nextLine();
		System.out.println("Enter email:");
		String pass = sc.nextLine();

		
		Login l=new Login(id,userName,pass);
		
		if(di.signUP(l))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void showAll() {
		di.showALL();
	}

	public boolean signIn() {
		// TODO Auto-generated method stub
		System.out.println("Enter userId: ");
		String id = sc.nextLine();
		System.out.println("Enter userPassword: ");
		String userName = sc.nextLine();
		
		Login l = new Login(id,userName,"");
		if(di.signIN(l)) {
			return true;
		}
		else {
			return false;
		}
	}

	public void showdata() {
		// TODO Auto-generated method stub
		di.showData();
	}

	public void update() {
		// TODO Auto-generated method stub
		di.updatePass();
	}

	public void removeHQL() {
		// TODO Auto-generated method stub
		di.deleteHQL();
	}
}
