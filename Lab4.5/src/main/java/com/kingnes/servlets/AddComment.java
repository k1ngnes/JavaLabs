package com.kingnes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.events.Comment;

import com.kingnes.dao.CommentDao;
import com.kingnes.model.Cart;
import com.kingnes.model.User;
import com.kingnes.services.DbCon;

@WebServlet("/add-comment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User auth = (User) request.getSession().getAttribute("auth");
		
		try (PrintWriter out = response.getWriter()) {
			if (auth != null) {
				String content = request.getParameter("comment");
				String user_name = request.getParameter("name");
				int p_id = Integer.parseInt(request.getParameter("id"));
				HttpSession session = request.getSession();
				CommentDao commentdao = new CommentDao(DbCon.getConnection());
				commentdao.insertComment(user_name, content, p_id);
				response.sendRedirect("product.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
