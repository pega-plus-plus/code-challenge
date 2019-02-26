package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory 
{
	private static Connection conn = null;
	private ConnFactory()
	{
		super();
	}
	public static synchronized Connection getInstance()
	{
		if (conn == null)
		{
			conn = getConnection();
		}
		return conn;
	}
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
