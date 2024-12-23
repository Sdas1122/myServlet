package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConnectionFactory {

	public static Connection getDBConnection() {

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dsn = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dsn, "java", "interface");
			System.out.println(conn);

		} catch (Exception e) {
			System.out.println("Connection :" + e.getMessage());

		}

		return conn;

	}
	
	public static void closeConnection(ResultSet rs,CallableStatement cstmt,Connection con)
	{
		
		try {
			if(rs!=null)
			{
				rs.close();
				rs=null;
			}
			
		} catch (Exception e) {
			System.out.println("Exception in closing resultset:"+e.getMessage());
		}
		
		try {
			if(cstmt!=null)
			{
				cstmt.close();
				cstmt=null;
			}
			
		} catch (Exception e) {
			System.out.println("Exception in closing cstmt:"+e.getMessage());
		}
		try {
			if(con!=null)
			{
				con.close();
				con=null;
			}
			
		} catch (Exception e) {
			System.out.println("Exception in closing Connection:"+e.getMessage());
		}
	}


	public static void main(String[] args) {
		getDBConnection();
	}

}
