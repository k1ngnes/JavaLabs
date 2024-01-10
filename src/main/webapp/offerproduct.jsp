<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kingnes.dao.ProductDao"%>
<%@ page import="com.kingnes.model.*"%>
<%@ page import="com.kingnes.services.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
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
<title>Offer Product</title>
<%@ include file="includes/head.jsp"%>
</head>
<body>
 
 <%@ include file="includes/navbar.jsp"%>
 <div class="container">
 <div class="card-header my-3">Offer Product</div>
 <form method="post" action="offer-product" enctype="multipart/form-data">
  <div class="form-group">
    <label for="companyName">Company name</label>
    <input type="text" class="form-control" id="companyName" name="companyName" placeholder="" required>
  </div>
  <div class="form-group">
    <label for="nameOfProduct">Name of the product</label>
    <input type="text" class="form-control" id="productName" name="productName" placeholder="" required>
  </div>
  <div class="form-group">
    <label for="category">Category</label>
    <input type="text" class="form-control" id="category" name="category" placeholder="" required>
  </div>
  <div class="form-group">
    <label for="price">Price</label>
    <input type="number" step="0.01" class="form-control" name="price" id="price" placeholder="" required>
  </div>
  <div class="form-group">
    <label for="image">Image of the Product</label>
    <input type="file" accept="image/jpeg,image/jpg,image/png" name="file" class="form-control-file" id="file" required>
  </div>
  <button type="submit" class="btn btn-warning">Submit</button>
</form>
</div>
 
 <%@ include file="includes/footer.jsp"%>
</body>
</html>