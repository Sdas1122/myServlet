package LoginDbms;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

 interface LoginInterface  {
	
public void loginInformation();

}

public class Insert implements LoginInterface {
	 String uname;
	 String pword;
	 String name;
	 String mid;
	 String gender;
	 String bdate;
	 String mailid;
	 
	 public Insert() {
		 this.uname=uname;
		 this.pword=pword;
		 this.name=name;
		 this.mid=mid;
		 this.gender=gender;
		 this.bdate=bdate;
		 this.mailid=mailid;
	 }
	 public void getdata() {
		 Scanner sc = new Scanner(System.in);
		 try {
			 System.out.println("Enter the User Name:");
			 uname=sc.nextLine();
			 System.out.println("Enter the Password:");
			 pword=sc.nextLine();
			 System.out.println("Enter the Name:");
			 name=sc.nextLine();
			 System.out.println("Enter the Mail ID:");
			 mid=sc.nextLine();
			 System.out.println("Enter the Gender:");
			 gender=sc.nextLine();
			 System.out.println("Enter the Birth Date:");
			 bdate=sc.nextLine();
		} catch (Exception e) {
			System.out.println("Exception :"+e.getMessage());
			// TODO: handle exception
		}
	 }
	 public void loginInformation() {
		 
		 Connection conn = null;
	     CallableStatement cstmt = null;
	     
	     try {
	    	 getdata();
	    	 conn= LoginConnection.getDBConnection();
	    	 String procName="{call loginInfoInsertData(?,?,?,?,?,?)}";
			 cstmt=conn.prepareCall(procName);
			 cstmt.setString(1, uname);
			 cstmt.setString(2, pword);
			 cstmt.setString(3, name);
			 cstmt.setString(4, mid);
			 cstmt.setString(5, gender);
			 cstmt.setString(6, bdate);
			    cstmt.execute();
			    conn.commit();
			    System.out.println("Data Inserted Successfully");
			 
		} catch (Exception e) {
			System.out.println("Exception :"+e.getMessage());
			// TODO: handle exception
		}
	     finally {
	    	
	    	 LoginConnection.closeConnection(null, cstmt, conn);
		}
	 }
	 
	public void loginDisplayData() {
		System.out.println("Enter The Mail Id:");
		Scanner sc = new Scanner(System.in);
		mailid= sc.nextLine();
		Connection conn = null;
	     CallableStatement cstmt = null;
		try {
			conn= LoginConnection.getDBConnection();
			String procName="{call loginInfoDisplayData(?)}";
			cstmt=conn.prepareCall(procName);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

    public static void main(String[] args) {
    	Insert lnt;
   
    	Insert insert = new Insert();
    	lnt=insert;
    	lnt.loginInformation();
    	
        
    }
}
