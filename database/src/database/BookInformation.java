package database;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
  class BookInformation{
			
	
	public static void main(String[] args) {
		float price;
		float discount;
		String book_name;
		String author;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Book name:");
		 book_name = sc.nextLine();
		System.out.println("Enter the Author name:");
		 author = sc.nextLine();
		System.out.println("Enter the Book pricre:");
		price = sc.nextInt();
		System.out.println("Enter the Book discount:");
		discount = sc.nextInt();

	
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = BookJdbc.getDBConnection();
			String sql = "insert into book_details VALUES ('" + book_name + "', '" + author + "', " + price+ ", " + discount + ")";
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			//conn.commit();
			System.out.println("book Name Created");
			System.out.println("author Name Created");
			System.out.println("price  Created");
			System.out.println("discount  Created");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			
		}
		finally {
			sc.close();
		}
		}
}
