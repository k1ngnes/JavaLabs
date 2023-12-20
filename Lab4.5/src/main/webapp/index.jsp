<%@page import="java.util.List"%>
<%@page import="com.kingnes.dao.ProductDao"%>
<%@ page import="com.kingnes.model.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}


ProductDao pd = new ProductDao(DbCon.getConnection());

List<Product> products = pd.getAllProducts();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Amazon</title>
<%@ include file="includes/head.jsp"%>
<%@ page import="com.kingnes.services.*"%>
</head>

<body id="page-top">
	<!-- Navigation-->
	<%@ include file="includes/navbar.jsp"%>

	<div class="container card-container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
		
		<%
			if (!products.isEmpty()) {
				for (Product p: products) { %>
					<div class="col-md-3 my-3">
					<div class="card w-100" style="width: 18rem;">
						<img src="product-image/<%= p.getImage() %>" class="card-img-top" alt="Card image">
						<div class="card-body">
							<h5 class="card-title"> <%= p.getName() %></h5>
							<h6 class="price">Price: $<%= p.getPrice() %></h6>
							<h6 class="category">Category: <%= p.getCategory() %></h6>
							<div class="mt-3 d-flex justify-content-between">
								<a href="add-to-cart?id=<%= p.getId() %>" class="btn btn-dark">Add to Cart</a>
								<a href="#" class="btn btn-warning">Buy Now</a>
								
							</div>
						</div>
					</div>
					</div>
				</div>
			<%	}
			}
		%>
			
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>
