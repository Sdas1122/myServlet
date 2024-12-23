package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
  class SalesDisplay{
			
	
	public static void main(String[] args) {
		double iprice;
		
		int sid;
		String iname;
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = BookJdbc.getDBConnection();
			String sql = "select * from sales ";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				sid=rs.getInt(1);
				iname=rs.getString(2);
				iprice=rs.getDouble(3);
				System.out.println("Sales Id:"+sid+" Item Name:"+iname+" Price:"+iprice);
				
			}
				
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			
		}
		
		}
}
