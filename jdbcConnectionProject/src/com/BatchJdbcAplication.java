package com;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class BatchJdbcAplication {

	
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
				String sql1 = "insert into login values('SSSSS','TTTTTTT')";
				String sql2 = "insert into login values('Arnab','arnab1234')";
				stmt = conn.createStatement();
				stmt.addBatch(sql);
				stmt.addBatch(sql1);
				stmt.addBatch(sql2);
				int rs[]=stmt.executeBatch();
				System.out.println("Exeuted Data:"+rs.length);
				
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				scanner.close();
			}
			


	}

}
