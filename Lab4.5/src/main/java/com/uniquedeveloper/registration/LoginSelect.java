package com.uniquedeveloper.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSelect {

	public static ResultSet selectLoginAndPassword(String uemail, String upassword) {
		Connection con = ConnectionToDB.startConnection();
		ResultSet result = null;
		
		try {
			PreparedStatement pst = con.prepareStatement("select * from users where uemail = ? and upassword = ?;");
			pst.setString(1, uemail);
			pst.setString(2, upassword);
			result = pst.executeQuery();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return result;
		}
	}
}
