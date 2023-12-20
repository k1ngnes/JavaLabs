package com.kingnes.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		if(connection == null) {
			String url = "jdbc:mysql://localhost:3306/amazon?serverTimezone=Europe/Moscow&useSSL=false";
			String user = "root";
			String password = "D%emin071202D%D";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		}
		
		return connection;
	}
	
}
