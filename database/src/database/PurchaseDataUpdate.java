package database;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PurchaseDataUpdate {

	public static void main(String[] args) {
		int itemid;
		int updateoid;
		String customername;
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Item Number:");
		itemid=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Updated order Id number:");
		updateoid= Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Updated Customer Name number:");
		customername= sc.nextLine();
		Connection conn= null;
		PreparedStatement pstmt=null;
        try {

			conn=RegistationJdbc.getConnection();
			String sql= "update purchase set ORDER_ID = ?,Customer_name =? where item_no= ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, updateoid);
			pstmt.setString(2, customername);
			pstmt.setInt(3, itemid);
			int temp=pstmt.executeUpdate();
			if(temp>0)
			{
				System.out.println("Data Updated");
			}else {
				System.out.println("Data  not Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());	
			// TODO: handle exception
		}

}
}