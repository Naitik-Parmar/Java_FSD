package com.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Conne.Connt;
import com.model.Login;

public class Dao implements DaoInter{
	
	Scanner sc,sc1;
	SessionFactory f;
	public Dao()
	{
		f=Connt.getSessionFact();
		
		sc= new Scanner (System.in);
		sc1= new Scanner (System.in);
			
	}

	@Override
	public boolean signUP(Login l) {
		try
		{
			Session ses=f.openSession();
			Transaction tx=ses.beginTransaction();
			ses.save(l);
			tx.commit();
			ses.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public void showALL() {
		
		try
		{
			Session ses=f.openSession();
			
			Query q=ses.createQuery("from Login");
			List <Login> li=q.list();
			
			for(Login i: li)
			{
				System.out.print("User_ID: "+i.getUserId());
				System.out.print("User|Pass: "+i.getUserPass());
				System.out.print("Email : "+i.getEmail());
				System.out.println();
			}			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		
	}

	@Override
	public boolean signIN(Login l) {
	    Session ses = null;
	    try {
	        ses = f.openSession();
	        Login existingLogin = ses.get(Login.class, l.getUserId());
	        
	        if (existingLogin != null && existingLogin.getUserPass().equals(l.getUserPass())) {
	      
	            return true;
	        } else {
	            return false;
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        return false;
	    } finally {
	        if (ses != null) {
	            ses.close();
	        }
	    }
	}

	@Override
	public void showData()
    {
		Session ses=f.openSession();
		Transaction tx=ses.beginTransaction();
		String hql = "from Login L where L.userId = :userId";
        Query<Login> q = ses.createQuery(hql, Login.class);
        System.out.println("Enter userID");
        String id=sc.nextLine();
        q.setParameter("userId", id);
        
        List<Login> log = q.list();
        
        // Process or display the retrieved data
        for (Login login : log) {
            System.out.println("User: " + login.toString());
        }
    }

	@Override
	public void updatePass() {
		Session ses=f.openSession();
		Transaction tx=ses.beginTransaction();
	    try {
	    	
	        
	        // Gather user input for the user ID and new password
	        System.out.println("Enter User ID:");
	        String userId = sc.nextLine();
	        
	        
//	        sc.nextLine();  // Consume newline left-over
	        System.out.println("Enter New Password:");
	        String newPassword = sc.nextLine();
	        
	        // HQL update query to set the new password
	        String hql = "UPDATE Login L set L.userPass = :pass where L.userId = :id";
	        Query q = ses.createQuery(hql);
	        
	        q.setParameter("pass", newPassword);
	        q.setParameter("id", userId);
	        
	        int a = q.executeUpdate(); // Capture the number of affected rows
	        
	        if (a == 0) {
	            System.out.println("Password not updated. User ID may not exist.");
	        } else {
	            System.out.println("Password updated successfully.");
	        }
	        
	        tx.commit(); // Commit the transaction
	        
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback(); // Rollback the transaction in case of an error
	        }
	        e.printStackTrace();
	    }
	}

	@Override
	public void deleteHQL() {
		Session ses=f.openSession();
		Transaction tx=ses.beginTransaction();
	    // Start the transaction	    
	    // Get the book number from the user
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter UserID  to delete:");
	    String userId = sc.nextLine();
	    
	    // HQL query to delete the book with the specified book number
	    String hql = "delete from Login L where L.userId = :userId";
	    Query q = ses.createQuery(hql);
	    
	    q.setParameter("userId", userId); // Set the book number parameter
	    
	    int a = q.executeUpdate(); // Execute the delete operation and capture the number of affected rows
	    
	    if (a == 0) {
	        System.out.println("User not found or not removed.");
	    } else {
	        System.out.println("User removed successfully.");
	    }
	    
	    tx.commit();
	}



	
}
