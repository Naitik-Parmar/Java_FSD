package com.java.Student.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.Connect.DataConnect;
import com.java.Model.Student;

public class IStudentDao {
	
	Connection con;
	PreparedStatement stat;
	public IStudentDao()
	{
		con=DataConnect.getConnect();
		
	}

	public void insert1(Student s) {
		try
		{
		stat=con.prepareStatement("insert into student values(?,?,?)");
		stat.setInt(1, s.getRollno());
		stat.setString(2, s.getName());
		stat.setDouble(3,s.getFee());
		
		stat.executeUpdate();
		System.out.println("Insert added to DB...");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}	
	}
	public void showAll() {
		try {
			String sql = "select * from student";
			stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				System.out.println("Roll No: " + rs.getInt(1));
				System.out.println("Name: " + rs.getString(2));
				System.out.println("Fee: " + rs.getDouble(3));
				System.out.println("-------------------------");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateFee(int roll, double fee) {
		try {
			String sql = "update student set fee=? where rollno=?";
			stat = con.prepareStatement(sql);
			stat.setDouble(1, fee);
			stat.setInt(2, roll);
			int k = stat.executeUpdate();
			
			if (k > 0) {
				System.out.println("Record updated");
			} else {
				System.out.println("Record not found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
public  void remove(int roll)
	{
		
		
		
		
	}
}
