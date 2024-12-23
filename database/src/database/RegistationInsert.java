package database;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class RegistationInsert {

	public static void main(String[] args) {
		String fname;
		String lname;
		String dob;
		String gen;
		String user;
		String password;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the First Name:");
		fname=sc.nextLine();
		System.out.println("Enter the Last Name:");
		lname=sc.nextLine();
		System.out.println("Enter the Date of Birth:");
		dob=sc.nextLine();
		System.out.println("Enter the Gender:");
		gen=sc.nextLine();
		System.out.println("Enter the User Name:");
		user=sc.nextLine();
		System.out.println("Enter the Password:");
		password=sc.nextLine();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn =RegistationJdbc.getConnection();
			String sql = "insert into registation values (?,?,?,?,?,?)";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1,fname);
			pstmt.setString(2,lname);
			pstmt.setString(3,dob);
			pstmt.setString(4,gen);
			pstmt.setString(5,user);
			pstmt.setString(6,password);
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
