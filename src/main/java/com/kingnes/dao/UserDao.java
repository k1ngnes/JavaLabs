package com.kingnes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kingnes.model.User;

public class UserDao {
	private Connection connection;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public UserDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public int userRegistration (String uname, String upassword, String uemail, String umobile) {
		int rowCount = 0;
		
		try {
			query = "insert into users(uname, upassword, uemail, umobile) values(?, ?, ?, ?);";
			pst = this.connection.prepareStatement(query);
			pst.setString(1, uname);
			pst.setString(2, upassword);
			pst.setString(3, uemail);
			pst.setString(4, umobile);
			rowCount = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
		
		try {
			query = "select * from users where uemail = ? and upassword = ?;";
			pst = this.connection.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("uname"));
				user.setEmail(rs.getString("uemail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
