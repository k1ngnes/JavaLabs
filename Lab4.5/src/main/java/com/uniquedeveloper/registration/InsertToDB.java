package com.uniquedeveloper.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertToDB {
	public static int insert(String uname, String upassword, String uemail, String umobile) {
		Connection con = ConnectionToDB.startConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement("insert into users(uname, upassword, uemail, umobile) values(?, ?, ?, ?);");
			pst.setString(1, uname);
			pst.setString(2, upassword);
			pst.setString(3, uemail);
			pst.setString(4, umobile);
				
			int rowCount = pst.executeUpdate();
			
			return rowCount;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
