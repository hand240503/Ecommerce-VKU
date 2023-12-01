<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="sign-in">
	<div class="container">
		<div class="signin-content">
			<div class="signin-image">
				<figure>
					<img src="<c:url value="/template/login/images/signin-image.jpg"/>" alt="sing up image">
				</figure>
				<a href="<c:url value="/account?action=signup"/>" class="signup-image-link">Create an account</a>
			</div>

			<div class="signin-form">
				<h2 class="form-title">Login</h2>
				<form method="POST" class="register-form" id="login-form" action="">
					<div class="form-group">
						<label for="userName"><i
							class="zmdi zmdi-account material-icons-name"></i></label> <input
							type="text" name="userName" id="userName"
							placeholder="Your Name" required="required" />
					</div>
					<div class="form-group">
						<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
							type="password" name="password" id="password"
							placeholder="Password" required="required"/>
					</div>
                    <c:if  test="${not empty message}">
                    	<div class="alert alert-danger" role="alert">
						  ${message }
						</div>
                    </c:if>
					<div class="form-group">
						<a href="<c:url value="/account/identify"/>" class="label-agree-term forgot__link">Forgot your password</a>
					</div>
					<div class="form-group form-button">
<!-- 						<input type="submit" name="signin" id="signin" class="form-submit" -->
<!-- 							value="Log in" /> -->
						<button id="signin" class="form-submit">Log in</button>
					</div>
				</form>

			</div>
		</div>
	</div>
</section>