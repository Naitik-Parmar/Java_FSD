package com.Hexaware.hiber1.com.Hexaware.hiber1Login;

import java.util.Scanner;

import com.service.Service;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	Service s = new Service();
    	
    	while(true) {
    		System.out.println("1. To SignUp");
    		System.out.println("2. To Show ALL Users");
    		System.out.println("3. To SignIn");
    		System.out.println("4. To ShowData");
    		System.out.println("5. To Update Password");
    		System.out.println("6. To Delete User");
    		System.out.println("0. To Exit");
    		int ch = sc.nextInt();
    		if(ch==1) {
    			if(s.signUp())
				{
					System.out.println("Details added Successfully");
				}
				else
				{
					System.out.println("Please try again !!!");
				}
    		}
    		if(ch==2) {
    			s.showAll();
    		}
    		if(ch==3) {
    			if(s.signIn()) {
    				System.out.println("Sign In Successfully");
    			}
    			else {
    				System.out.println("Please try again...");
    			}
    		}
    		if(ch==4) {
    			s.showdata();
    		}
    		if(ch==5) {
    			s.update();
    		}
    		if(ch==6) {
    			s.removeHQL();
    		}
    		else if(ch==0){
    			break;
    		}
    		
    	}
    	
        System.out.println( "Welcome" );
    }
}
