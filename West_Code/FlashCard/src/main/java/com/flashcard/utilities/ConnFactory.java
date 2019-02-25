package com.flashcard.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {//I don't know if I'm going to need this LOL, yeah I will
	private static ConnFactory cf = new ConnFactory();
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@octocatdb.cwpwwksk2urc.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static final String user = "testing";
	private static final String password = "p4ssw0rd";
	
	
	//this will be a singleton factory
	private ConnFactory() {
		super();
	}
	
	//create method that creates the objects
	public static synchronized ConnFactory getInstance() {
		if (cf==null) {
			cf= new ConnFactory();
		}
		return cf;
	}
	//make a connection...
	public Connection getConnection() {
		Connection conn = null;
		//not hardcoded, but referenced external, the url, username, password->it BAD!
		//Properties prop = new Properties();
		//method from properties
		try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return conn;
	}
}
