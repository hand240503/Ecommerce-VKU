<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<section class="signup">
    <div class="container">
        <div class="signup-content">
            <div class="signup-form">
                <h2 class="form-title">Sign up</h2>
                <form method="POST" class="register-form" id="register-form">
                    <div class="form-group">
                        <label for="userName"><i class="zmdi zmdi-account material-icons-name"></i></label>
                        <input type="text" name="userName" id="userName" placeholder="User Name"/>
                        <span class="message"></span>
                    </div>
                    <div class="form-group">
                        <label for="firstName"><i class="zmdi zmdi-account-box-o"></i></i></label>
                        <input type="text" name="firstName" id="firstName" placeholder="Fist Name"/>
                        <span class="message"></span>
                    </div>
                    <div class="form-group">
                        <label for="lastName"><i class="zmdi zmdi-account-box-o"></i></i></label>
                        <input type="text" name="lastName" id="lastName" placeholder="Last Name"/>
                        <span class="message"></span>
                    </div>
                    <div class="form-group">
                        <label for="email"><i class="zmdi zmdi-email"></i></label>
                        <input type="text" name="email" id="email" placeholder="Your Email"/>
                        <span class="message"></span>
                    </div>

                    <div class="form-group">
                        <div class="form-wrap">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="pass" id="pass" placeholder="Password"/>
                            <i class="zmdi zmdi-eye icon-eye" id="icon-eye-pass"></i>
                            <i class="zmdi zmdi-eye-off icon-eye" id="icon-eye-pass-off"></i>
                        </div>
                        <span class="message"></span>
                    </div>
                    <div class="form-group">
                        <div class="form-wrap">
                            <label for="re_pass"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password"/>
                            <i class="zmdi zmdi-eye icon-eye" id="icon-eye-re-pass"></i>
                            <i class="zmdi zmdi-eye-off icon-eye"id="icon-eye-re-pass-off"></i>
                        </div>
                        <span class="message"></span>
                    </div>


                    <div class="form-group form-button">
                        <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                    </div>
                </form>
            </div>
            <div class="signup-image">
                <figure><img src="<c:url value="/template/login/images/signup-image.jpg" />" alt="sing up
                    image"></figure>
                <a href="<c:url value="/account?action=login" />" class="signup-image-link">I am already
                    member</a>
            </div>
        </div>
    </div>
</section>
