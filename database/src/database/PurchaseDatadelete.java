package database;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PurchaseDatadelete {

	public static void main(String[] args) {
		int itemid;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Item Number:");
		itemid= sc.nextInt();
		Connection conn= null;
		PreparedStatement pstmt=null;
        try {

			conn=RegistationJdbc.getConnection();
			String sql= "delete from purchase where item_no= ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, itemid);
			int temp=pstmt.executeUpdate();
			if(temp>0)
			{
				System.out.println("Data Deleted");
			}else {
				System.out.println("Data Deleted not Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());	
			// TODO: handle exception
		}

}
}