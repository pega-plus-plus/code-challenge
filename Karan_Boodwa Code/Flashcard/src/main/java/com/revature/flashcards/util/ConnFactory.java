package com.revature.flashcards.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {

	private static ConnFactory cf = new ConnFactory();

	private ConnFactory() {
		super();
	}

	public static ConnFactory getInstance() {
		if (cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}

	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			/*prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));*/
			
			String url = "jdbc:oracle:thin:@revfullstack.cgve9eo1tenv.us-east-1.rds.amazonaws.com:1521:ORCL";
			String user = "flashcard";
			String password = "p4ssw0rd";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
}