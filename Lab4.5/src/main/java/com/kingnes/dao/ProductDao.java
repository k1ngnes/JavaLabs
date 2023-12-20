package com.kingnes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.kingnes.model.Cart;
import com.kingnes.model.Product;

public class ProductDao {
	private Connection connection;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ProductDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		
		try {
			query = "select * from products;";
			pst = this.connection.prepareStatement(query);
			rs = pst.executeQuery(); 
			while (rs.next()) {
				Product row = new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getFloat("price"));
				row.setImage(rs.getString("image"));
				
				products.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
		List<Cart> products = new ArrayList<Cart>();
		
		try {
			if (cartList.size() > 0) {
				for (Cart item: cartList) {
					query = "select * from products where id = ?;";
					pst = this.connection.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs = pst.executeQuery();
					while(rs.next()) {
						Cart row = new Cart();
						row.setId(rs.getInt("id"));
						row.setName(rs.getString("name"));
						row.setCategory(rs.getString("category"));
						row.setPrice(rs.getFloat("price") * item.getQuantity());
						row.setQuantity(item.getQuantity());
						products.add(row);
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	public float getTotalCartPrice(ArrayList<Cart> cartList) {
		float sum = 0;
		
		try {
			if (cartList.size() > 0)
			{
				for (Cart item: cartList) {
					query = "select price from products where id = ?;";
					pst = this.connection.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs = pst.executeQuery();
					
					while (rs.next()) {
						sum += rs.getFloat("price") * item.getQuantity();
					}
				}
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return sum;
	}
}
