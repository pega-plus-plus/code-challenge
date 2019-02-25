package com.abc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			String[] info = System.getenv("DB_baicham").split(";");
			try {
				Class.forName(info[0]);
			}catch(ClassNotFoundException e) {
				System.out.println("The class is not found");
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(info[1], info[2], info[3]);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
