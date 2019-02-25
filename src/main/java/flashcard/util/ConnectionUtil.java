package flashcard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class ConnectionUtil {
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"flashcard", 
					"password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
