package database;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PurchaseIdDisplay {

	public static void main(String[] args) {
		int itemid;
		int oid;
		int cid;
		int  inumber;
		String cname;
		String pdate;
		int price;
		String status;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Item Number:");
		itemid= sc.nextInt();
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=RegistationJdbc.getConnection();
			String sql= "select * from purchase where item_no= ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, itemid);
			rs= pstmt.executeQuery();
			if(rs.next()) 
			{
					oid=rs.getInt(1);
					cid=rs.getInt(2);
					inumber=rs.getInt(3);
					cname=rs.getString(4);
					pdate=rs.getString(5);
					price=rs.getInt(6);
					status=rs.getString(7);
					
					
					System.out.println("ORDER_ID:" +oid+" "+"CUSTOMER_ID:"+cid +" "+"ITEM_NO:"+ inumber +" "+"CUSTOMER_NAME:"+ cname+" "+"PURCHASE_D:"+pdate+" "+"PRICE:" +price+" "+"STATUS:"+status);		
								
				}else {
					System.out.println("Not found");
				}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
