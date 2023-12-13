package com.uniquedeveloper.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB {
	public static Connection startConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/amazon?serverTimezone=Europe/Moscow&useSSL=false";
		String user = "root";
		String password = "D%emin071202D%D";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			return con;
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return con;
		}
	}
}
