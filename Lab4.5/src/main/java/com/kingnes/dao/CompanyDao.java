package com.kingnes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDao {
	private Connection connection;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public CompanyDao(Connection connection) {
		this.connection = connection;
	}
	
	public boolean insertCompany(String name) {
		boolean result = false;
		
		try {
			query = "insert into companies(name) values(?);";
			pst = this.connection.prepareStatement(query);
			pst.setString(1, name);
			pst.executeUpdate();
			result = true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
