package Raildatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
class RailwayBookingData{
	int tnumber;
	String sfrom;
	String sto;
	String jdate;
	String Pname;
	int age;
	String gender;
	String berth;
	String tclass;
	String quota;
	Scanner sc = new Scanner(System.in);
	Connection conn= null;
	PreparedStatement pstmt= null;
	ResultSet rs= null;
	int temp;
	

	public void RailwayDataInsert(){
	System.out.println("Enter the Tranin Number:");
	tnumber=Integer.parseInt(sc.nextLine());
	System.out.println("Enter the Station Name From:");
	sfrom=sc.nextLine();
	System.out.println("Enter the Station Name To:");
	sto=sc.nextLine();
	System.out.println("Enter the Journey Date:");
	jdate=sc.nextLine();
	System.out.println("Enter the Passenger Name:");
	Pname=sc.nextLine();
	System.out.println("Enter the age:");
	age=Integer.parseInt(sc.nextLine());
	System.out.println("Enter the Gender:");
	gender=sc.nextLine();
	System.out.println("Enter the Berth:");
	berth=sc.nextLine();
	System.out.println("Enter the CLass:");
	tclass=sc.nextLine();
	System.out.println("Enter the quota:");
	quota=sc.nextLine();
	
		
		try {
			conn =RailwayJdbc.getDBConnection();
			String sql = "insert into railway_booking values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
			pstmt=conn.prepareStatement(sql);	
			pstmt.setInt(1,tnumber);
			pstmt.setString(2,sfrom);
			pstmt.setString(3,sto);
			pstmt.setString(4,jdate);
			pstmt.setString(5,Pname);
			pstmt.setInt(6,age);
			pstmt.setString(7,gender);
			pstmt.setString(8,berth);
			pstmt.setString(9,tclass);
			pstmt.setString(10,quota);
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("Data Inserted successfully");
		} catch ( Exception e) {
			System.out.println(e.getMessage());	
			// TODO: handle exception
		}
	}
	
	public void RailwayDataDisplay() {
		System.out.println("Enter the Train Number:");
		tnumber= sc.nextInt();
		try {
			conn =RailwayJdbc.getDBConnection();
			String sql = "select * from railway_booking where TRAIN_NO= ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,tnumber);
            rs=pstmt.executeQuery();
            if(rs.next()) {
            	tnumber=rs.getInt(1);
            	sfrom=rs.getString(2);
            	sto=rs.getString(3);
            	jdate=rs.getString(4);
            	Pname=rs.getString(5);
            	age=rs.getInt(6);
            	gender=rs.getString(7);
            	berth=rs.getString(8);
            	tclass=rs.getString(9);
            	quota=rs.getString(10);
            	
            	System.out.println("TRAIN_NO:" +tnumber+" "+"TRAIN_FROM:"+sfrom +" "+"TRAIN_TO:"+ sto +" "+"JOURNEY_DATE:"+ jdate+" "+"NAME:"+Pname+" "+"AGE:" +age+" "+"GENDER:"+gender+ " "+"BERTH:"+berth+" "+"CLASS:"+tclass+" "+"QUOTA:"+quota);
            }else {
            	System.out.println("Data Not Found");
            }    
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}
	public void RailwayDataDisplayAll() {
		System.out.println("SHOW ALL DATA :");
		try {
			conn =RailwayJdbc.getDBConnection();
			String sql = "select * from railway_booking";
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();
			
            while(rs.next()) {
            	tnumber=rs.getInt(1);
            	sfrom=rs.getString(2);
            	sto=rs.getString(3);
            	jdate=rs.getString(4);
            	Pname=rs.getString(5);
            	age=rs.getInt(6);
            	gender=rs.getString(7);
            	berth=rs.getString(8);
            	tclass=rs.getString(9);
            	quota=rs.getString(10);
            	
            	System.out.println("TRAIN_NO:" +tnumber+" "+"TRAIN_FROM:"+sfrom +" "+"TRAIN_TO:"+ sto +" "+"JOURNEY_DATE:"+ jdate+" "+"NAME:"+Pname+" "+"AGE:" +age+" "+"GENDER:"+gender+ " "+"BERTH:"+berth+" "+"CLASS:"+tclass+" "+"QUOTA:"+quota);
            }	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}

	public void RailwayDataUpdate() {
	 //  sc = new Scanner(System.in);
		System.out.println("Enter the Train Number For Update:");
		tnumber=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the New Berth:");
		berth= sc.nextLine();
		System.out.println("Enter the Class:");
		tclass=sc.nextLine();
		
		try {
			conn=RailwayJdbc.getDBConnection();
			String sql= "update railway_booking set BERTH = ?,CLASS =? where TRAIN_NO= ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1,berth);
			pstmt.setString(2, tclass);
			pstmt.setInt(3, tnumber);
			temp=pstmt.executeUpdate();
			if(temp>0)
			{
				System.out.println("Data Updated Successfully");
			}else {
				System.out.println("Data  Not Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());	
			// TODO: handle exception
		}			
	}
	
	public void RailwayDataDelete() {
		System.out.println("Enter the Train Number For Delete:");
		tnumber= sc.nextInt();
		try {
			conn=RailwayJdbc.getDBConnection();
			String sql= "delete from railway_booking where TRAIN_NO= ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, tnumber);
			temp=pstmt.executeUpdate();
			if(temp>0)
			{
				System.out.println("Data Deleted Successfully");
			}else {
				System.out.println("Data  Not Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());	
			// TODO: handle exception
		}
	}
}

public class RailwayBookingInformation {

	public static void main(String[] args) {
		
		RailwayBookingData rbd=new RailwayBookingData();
		rbd.RailwayDataInsert();
		rbd.RailwayDataDisplay();
		rbd.RailwayDataDisplayAll();
		rbd.RailwayDataUpdate();
		rbd.RailwayDataDelete();
		
		
		
		// TODO Auto-generated method stub

	}

}
