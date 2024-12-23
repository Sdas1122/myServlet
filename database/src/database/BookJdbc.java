package database;
import java.sql.Connection;
import java.sql.DriverManager;
public class BookJdbc {

	public static Connection getDBConnection() {
		Connection conn= null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dsn ="jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager .getConnection(dsn, "system" , "db");
			//System.out.println(conn);
			
		} catch (Exception e) {
			System.out.println("Connection :" + e.getMessage());
			// TODO: handle exception
		}
		return conn;
	}
}
