package com.kingnes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kingnes.dao.UserDao;
import com.kingnes.services.DbCon;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("name");
		String upassword = request.getParameter("pass");
		String repassword = request.getParameter("re_pass");
		String uemail = request.getParameter("email");
		String umobile = request.getParameter("contact");
		
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
		
		boolean doPasswordsMatch = repassword.equals(upassword);
		int rowCount = 0;
		
		if (doPasswordsMatch) {
			UserDao udao = null;
			try {
				udao = new UserDao(DbCon.getConnection());
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			rowCount = udao.userRegistration(uname, upassword, uemail, umobile);
		}
	
		if (rowCount > 0) {
			request.setAttribute("status", "success");
		} else {
			request.setAttribute("status", "failed");
		}
		dispatcher.forward(request, response);
	}

}
