<%@include file="/common/taglib.jsp" %>
<!doctype html>
<html>
<head>

</head>
<body oncontextmenu='return false' class='snippet-body'>
<div class="container padding-bottom-3x mb-2 mt-5">
    <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10">
            <div class="forgot">
                <h2>Forgot your password?</h2>
                <p>Change your password in three easy steps. This will help you
                    to secure your password!</p>
                <ol class="list-unstyled">
                    <li><span class="text-primary text-medium">1. </span>Enter
                        your username address below.
                    </li>
                    <li><span class="text-primary text-medium">2. </span>Our
                        system will send you an OTP to your email
                    </li>
                    <li><span class="text-primary text-medium">3. </span>Enter the OTP on the
                        next page
                    </li>
                </ol>
            </div>
            <form class="card mt-4" id="identify-form" action="" method="POST">
                <div class="card-body">
                    <div class="form-group">
                        <label for="username-for-pass">Enter your username</label> <input
                            class="form-control" type="text" name="userName" id="username-for-pass"><small
                            class="form-text text-muted">Enter the registered username . Then we'll
                        email a OTP to your email address.</small>
                        <span class="message"></span>
                    </div>
                </div>
                <div class="card-footer">
                    <button class="btn btn-success" href="">Get New
                        Password
                    </button>
                    <a class="btn btn-danger" id="btn-back-login" href="<c:url value="/account?action=login"/>">Back to
                        Login</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>