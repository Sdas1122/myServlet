package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class PurchaseInsert {

	public static void main(String[] args) {
		int oid;
		int cid;
		int  inumber;
		String cname;
		String pdate;
		int price;
		String status;
		Scanner sc=null;
		sc = new Scanner(System.in);
		System.out.println("Enter the Order ID:");
		oid=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Customer ID:");
		cid=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Item Number:");
		inumber=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Customer Name:");
		cname=sc.nextLine();		
		System.out.println("Enter the Purchase Date:");
		pdate=sc.nextLine();
		System.out.println("Enter the Price:");
		price=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter the Status:");
		status=sc.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = RegistationJdbc.getConnection();
			String sql = "insert into purchase values (?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,oid);
			pstmt.setInt(2,cid);
			pstmt.setInt(3,inumber);
			pstmt.setString(4,cname);
			pstmt.setString(5,pdate);
			pstmt.setInt(6,price);
			pstmt.setString(7,status);
			pstmt.executeUpdate();
		    conn.commit();
			System.out.println("Data Inserted successfully");	
			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
			// TODO: handle exception
		}
		 finally {
				sc.close();
		}
		// TODO Auto-generated method stub

	}

}
