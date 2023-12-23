package com.kingnes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kingnes.model.Comment;
import com.kingnes.model.Product;

public class CommentDao {
	private Connection connection;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public CommentDao(Connection connection) {
		this.connection = connection;
	}
	
	public boolean insertComment(String user_name, String content, int p_id) {
		boolean result = false;
		
		try {
			query = "insert into comments(user_name, content, p_id) values(?, ?, ?);";
			pst = this.connection.prepareStatement(query);
			pst.setString(1, user_name);
			pst.setString(2, content);
			pst.setInt(3, p_id);
			int rowCount = pst.executeUpdate();
			if (rowCount > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<Comment> getAllComments(int id) {
		List<Comment> comments = new ArrayList<Comment>();
		
		try {
			query = "select * from comments where p_id = ?;";
			pst = this.connection.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery(); 
			while (rs.next()) {
				Comment row = new Comment();
				row.setName(rs.getString("user_name"));
				row.setContent(rs.getString("content"));
				comments.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return comments;
	}
	
}
