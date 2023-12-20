package com.kingnes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kingnes.dao.OrderDao;
import com.kingnes.model.Cart;
import com.kingnes.model.Order;
import com.kingnes.model.User;
import com.kingnes.services.DbCon;

@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			
			User auth = (User) request.getSession().getAttribute("auth");
			
			if (auth != null) {
				int productId = Integer.parseInt(request.getParameter("id"));
				int productQuantity = Integer.parseInt(request.getParameter("quantity"));
				
				if (productQuantity <= 0) {
					productQuantity = 1;
				}
				
				Order orderModel = new Order();
				orderModel.setId(productId);
				orderModel.setUid(auth.getId());
				orderModel.setQuantity(productQuantity);
				orderModel.setDate(formater.format(date));
				
				OrderDao orderDao = new OrderDao(DbCon.getConnection());
				boolean result = orderDao.insertOrder(orderModel);
				
				if (result) {
					ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
					
					if (cart_list != null) {
						for (Cart c: cart_list) {
							if (c.getId() == productId) {
								cart_list.remove(cart_list.indexOf(c));
								break;
							}
						}
					}
					response.sendRedirect("orders.jsp");
				} else {
					out.println("order failed");
				}
				
				
			} else {
				response.sendRedirect("login.jsp");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
