<%@page import="java.io.PrintWriter"%>
<%@page import="com.kingnes.dao.CommentDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kingnes.dao.ProductDao"%>
<%@ page import="com.kingnes.model.*"%>
<%@ page import="com.kingnes.services.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
String user_name = null;
int id = (int) request.getSession().getAttribute("id");

if (auth != null) {
	request.setAttribute("auth", auth);
	user_name = auth.getName();
}

PrintWriter outprint = response.getWriter();
out.println(auth);
ProductDao pd = new ProductDao(DbCon.getConnection());

List<Product> products = pd.getAllProducts();

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}

Product product = pd.getSingleProduct(id);
CommentDao commentdao = new CommentDao(DbCon.getConnection());

List<com.kingnes.model.Comment> commentsList = commentdao.getAllComments(id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<%@ include file="includes/head.jsp"%>
</head>
<body>

	<%@ include file="includes/navbar.jsp"%>

	<div class="container card-container">
		<div class="card-header my-3">All Products</div>
		<div class="row">

			<%
			if (!products.isEmpty()) {
			%>
			<div class="col-md-3">
				<div class="card w-100" style="width: 18rem;">
					<img src="product-image/<%=product.getImage()%>"
						class="card-img-top" alt="Card image">
					<div class="card-body">
						<h5 class="card-title">
							<%=product.getName()%></h5>
						<h6 class="price">
							Price: $<%=product.getPrice()%></h6>
						<h6 class="category">
							Category:
							<%=product.getCategory()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="add-to-cart?id=<%=product.getId()%>"
								class="btn btn-dark">Add to Cart</a> <a
								href="order-now?quantity=1&id=<%=product.getId()%>"
								class="btn btn-warning">Buy Now</a>

						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>
	</div>


	<div class="container">
		<div class="card-header my-3">Comments</div>
		<form action="add-comment" method="post" class="form-inline">
			<div class="form-row align-items-center">
				<div class="col-auto">
					<%
					if (user_name != null) {
					%>
					<input type="hidden" name="name" value="<%=user_name%>"
						class="form-input"> <input type="hidden" name="id"
						value="<%=id%>" class="form-input">

					<%
					}
					%>
					<input type="text" name="comment" class="form-control"
						placeholder="Add comment">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-sm btn-primary">Leave
						a comment</button>
				</div>
			</div>
		</form>
		<div class="comment mt-4 text-justify">

			<%
			if (commentsList != null) {
				for (Comment c : commentsList) {
			%>
			<h4><%=c.getName()%></h4>
			<p><%=c.getContent()%></p>

			<%
			}
			}
			%>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>