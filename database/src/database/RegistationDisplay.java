package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class RegistationDisplay {

	public static void main(String[] args) {
		String fname;
		String lname;
		String dob;
		String gen;
		String user;
		String password;
		
		Connection conn=null;
		PreparedStatement  ptsmt= null;
		ResultSet rs=null;
		
		try {
			conn = RegistationJdbc.getConnection();
			String sql = "select * from registation";
			ptsmt= conn.prepareStatement(sql);
			rs= ptsmt.executeQuery();
			while(rs.next()) 
			{
				fname=rs.getString(1);
				lname=rs.getString(2);
				dob=rs.getString(3);
				gen=rs.getString(4);
				user=rs.getString(5);
				password=rs.getString(6);
				
				System.out.println("First Name:" +fname+" "+"Last Name:"+lname +" "+"Date of birth:"+ dob +" "+"Gender:"+ gen+" "+"User Name:"+user+" "+"Password:" +password);
				
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
		
		
		// TODO Auto-generated method stub

	}

}
