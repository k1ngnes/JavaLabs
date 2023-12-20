<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kingnes.services.DbCon"%>
<%@page import="com.kingnes.dao.ProductDao"%>
<%@ page import="com.kingnes.model.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<% 
	User auth = (User) request.getSession().getAttribute("auth");
	if (auth != null) {
		request.setAttribute("auth", auth);		
	} else {
		response.sendRedirect("login.jsp");
	}
	
	ProductDao pd = new ProductDao(DbCon.getConnection());

	List<Product> products = pd.getAllProducts();

	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
<%@ include file="includes/head.jsp"%>
</head>
<body>

	<%@ include file="includes/navbar.jsp" %>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>