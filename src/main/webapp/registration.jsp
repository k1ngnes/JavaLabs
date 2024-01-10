<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Register</title>

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<input type="hidden" id="status" value=<%= request.getAttribute("status") %>> 

	<div class="main">
		<img class="amazon-logo" src="images/Amazon-logo.png">
		<!-- Sign up form -->
		<section class="signup">
			<div class="container-css">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Create account</h2>
					
						<form method="post" action="register" class="register-form"
							id="register-form">
							<div class="form-group">
								<p class="input-header">Your name</p>
								<input class="input-register"
									type="text" name="name" id="name" placeholder="First and last name" required/>
							</div>
							<div class="form-group">
								<p class="input-header">Email</p>
								<input class="input-register"
									type="email" name="email" id="email" placeholder="" required/>
							</div>
							<div class="form-group">
								<p class="input-header">Password</p>
								<input class="input-register"
									type="password" name="pass" id="pass" placeholder="" required/>
							</div>
							<div class="form-group">
								<p class="input-header">Re-enter password</p>
								<input class="input-register" type="password" name="re_pass" id="re_pass"
									placeholder="" required/>
							</div>
							<div class="form-group">
								<p class="input-header">Mobile number</p>
								<input class="input-register" type="text" name="contact" id="contact"
									placeholder=""/>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
						<div class="terms-of-service form-group">
								<p class="small-conditions-of-use-text">By creating an account, you agree to Amazon's</p>
								<p class="small-conditions-of-use-text"><a class="link-text" href="https://www.amazon.com/gp/help/customer/display.html/ref=ap_register_notification_condition_of_use?ie=UTF8&nodeId=508088">Conditions of Use</a> and <a class="link-text" href="https://www.amazon.com/gp/help/customer/display.html/ref=ap_register_notification_privacy_notice?ie=UTF8&nodeId=468496">Privacy Notice</a>.</p>
							</div>
					</div>
					<div class="signup-image">
					<p class="already-have-account">Already have an account? <a href="login.jsp" class="link-text">Sign in</a></p>
						
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type="text/javascript">
	
		const status = document.getElementById("status").value;
		if(status == "success") {
		swal("Congrats", "Account Created Successfully", "success");
		} else if (status == "failed"){
			swal("An Error Occured", "Maybe your passwords mismatch or we had a server error", "error");
		}
	
	</script>



</body>
</html>