package com.assignment.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory cf = new ConnectionFactory();
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@javadevinstance.c26ppewplieh.us-east-1.rds.amazonaws.com:1521:ORCL";
	private static final String user = "flashcard_user";
	private static final String password = "p4ssw0rd";
	
	private ConnectionFactory() {
		super();
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if (cf == null) {
			cf = new ConnectionFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
