package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class CallableStatementDemo {

	
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter the UserName");
			
			String userName = scanner.nextLine();
			
			System.out.println("Enter the Password");
			
			String password = scanner.nextLine();
			
			Connection conn = null;
			CallableStatement cstmt = null;
			
			try {
				
				conn= ConnectionFactory.getDBConnection();
				String procName="{call insertData(?,?)}";
				cstmt=conn.prepareCall(procName);
			    cstmt.setString(1, userName);
			    cstmt.setString(2, password);
			    cstmt.execute();
			    System.out.println("Data Inserted Successfully");
				
				
				
				
				
				
			} catch (Exception e) {
				System.out.println("Exception :"+e.getMessage());
			}
			finally {
				scanner.close();
				ConnectionFactory.closeConnection(null, cstmt, conn);
				
			}
			


	}

}
