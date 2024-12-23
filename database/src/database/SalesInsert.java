package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
  class SalesInsert{
			
	
	public static void main(String[] args) {
		double iprice;
		int sid;
		String iname;
		Scanner sc=null;
		 sc=new Scanner(System.in);
		System.out.println("Enter the Sales ID:");
		 sid =Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Item name:");
		 iname = sc.nextLine();
		 
		System.out.println("Enter the Item pricre:");
		iprice = Double.parseDouble(sc.nextLine());

	
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = BookJdbc.getDBConnection();
			String sql = "insert into sales VALUES (?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			pstmt.setString(2, iname);
			pstmt.setDouble(3, iprice);
			pstmt.executeUpdate();
			System.out.println("Data Inserted successfully");	
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			
		}
		
		}
}
