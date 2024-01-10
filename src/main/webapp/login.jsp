<%@ page import="com.kingnes.model.*" %>

<% 
	User auth = (User) request.getSession().getAttribute("auth");
	if (auth != null) {
		request.setAttribute("auth", auth);		
		response.sendRedirect("index.jsp");
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign in</title>

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<input type="hidden" id="status" value=<%= request.getAttribute("status") %>> 

	<div class="main">
		<img class="amazon-logo" src="images/Amazon-logo.png">
		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container-css">
				<div class="signin-content">
					<div class="signin-form">
						<h2 class="form-title">Sign in</h2>
						<form method="post" action="login" class="register-form"
							id="login-form">
							<div class="form-group">
								<p class="input-header">Email</p>
								<input class="input-register"
									type="text" name="username" id="username"
									placeholder="" />
							</div>
							<div class="form-group">
								<p class="input-header">Password</p>
								<input class="input-register"
									type="password" name="password" id="password"
									placeholder="" />
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
							<div class="terms-of-service form-group">
								<p class="small-conditions-of-use-text">By continuing, you agree to Amazon's</p>
								<p class="small-conditions-of-use-text"><a class="link-text" href="https://www.amazon.com/gp/help/customer/display.html/ref=ap_register_notification_condition_of_use?ie=UTF8&nodeId=508088">Conditions of Use</a> and <a class="link-text" href="https://www.amazon.com/gp/help/customer/display.html/ref=ap_register_notification_privacy_notice?ie=UTF8&nodeId=468496">Privacy Notice</a>.</p>
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me"
									class="agree-term" /> <label for="remember-me"
									class="label-agree-term "><span><span></span></span>Keep me signed in.</label>
							</div>
						</form>
					</div>
				</div>
				<a href="registration.jsp" class="link-text already-have-account">Create your Amazon account</a>
			</div>
		</section>

	</div>

	<!-- JS -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type="text/javascript">
	
		const status = document.getElementById("status").value;
		if(status == "failed") {
		swal("Sorry", "Wrong Username or Password", "error");
		}
	
	</script>
</body>
</html>