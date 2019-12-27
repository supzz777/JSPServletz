package com.bridgelabz.ServletJspApp2.controller;
import java.sql.*;

public class CustomerDataImp implements CustomerDAO
{

	Connection con = null;
	PreparedStatement smt = null;

public int registerCustomer(Customer c) 
{
		int rowsAffected = 0;
		try {
		con = ImplementedConnectionProvider.getConnection();
		smt = con.prepareStatement("insert into customer values(?,?,?)");
		smt.setString(1, c.getUsername());
		smt.setString(2, c.getPassword());
		smt.setString(3, c.getName());
		
		rowsAffected = smt.executeUpdate();
		con.close();
		} catch (Exception e) 
		{
		System.out.println(e);
		}
		return rowsAffected;
}

public int getCustomer(String username, String password)
{
		int num = 0;
		
		Customer c = new Customer();
		
		try {
		
			con = ImplementedConnectionProvider.getConnection();
			smt = con.prepareStatement(" select * from customer where username=? && password=?");
			
			smt.setString(1, username);
			smt.setString(2, password);
			System.out.println("user" + username);
			
			System.out.println("passoword" + password);
			ResultSet rs = smt.executeQuery();
			
			while (rs.next()) 
			{
			System.out.println("found");
			c.setUsername(rs.getString(1));
			c.setPassword(rs.getString(2));
			c.setName(rs.getString(3));
			num++;
			System.out.println(c.getName());
			System.out.println(c.getUsername());
			System.out.println(c.getPassword());
			
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		
		
		return num;
	
		
		
     }
}