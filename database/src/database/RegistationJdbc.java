package database;
import java.sql.Connection;
import java.sql.DriverManager;
public class RegistationJdbc {

	public static  Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dsn ="jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dsn,"system","db");
			
			
		} catch (Exception e) {
			System.out.println("Connection"+ e.getMessage());
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
            return conn;
	}

}
