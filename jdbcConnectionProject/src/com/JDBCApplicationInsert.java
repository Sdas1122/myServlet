package com;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCApplicationInsert {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter the UserName");
	
	String userName = scanner.nextLine();
	
	System.out.println("Enter the Password");
	
	String password = scanner.nextLine();
	
	Connection conn = null;
	Statement stmt = null;
	
	try {
		
		conn= ConnectionFactory.getDBConnection();
		String sql = "insert into login values('" +userName+ "','" +password+ "')";
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		conn.commit();
		System.out.println("User Created");
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	finally {
		scanner.close();
	}
	
	
	}

}
