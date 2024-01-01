<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Molla - Bootstrap eCommerce /template</title>
    <meta name="keywords" content="HTML5 /template">
    <meta name="description" content="Molla - Bootstrap eCommerce /template">
    <meta name="author" content="p-themes">
    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="180x180"
          href="<c:url value="/template/web/images/icons/apple-touch-icon.png"/>">
    <link rel="icon" type="image/png" sizes="32x32"
          href="<c:url value='/template/web/images/icons/favicon-32x32.png'/>">
    <link rel="icon" type="image/png" sizes="16x16"
          href="<c:url value='/template/web/images/icons/favicon-16x16.png'/>">
    <link rel="mask-icon"
          href="<c:url value='/template/web/images/icons/safari-pinned-tab.svg'/>"
          color="#666666">
    <link rel="shortcut icon"
          href="<c:url value='/template/web/images/icons/favicon.ico'/>">
    <meta name="apple-mobile-web-app-title" content="Molla">
    <meta name="application-name" content="Molla">
    <meta name="msapplication-TileColor" content="#cc9966">
    <meta name="msapplication-config"
          content="<c:url value='/template/web/images/icons/browserconfig.xml'/>">
    <meta name="theme-color" content="#ffffff">
    <link rel="stylesheet"
          href="<c:url value='/template/web/vendor/line-awesome/line-awesome/line-awesome/css/line-awesome.min.css'/>">
    <!-- Plugins CSS File -->
    <link rel="stylesheet"
          href="<c:url value='/template/web/css/bootstrap.min.css'/>">
    <link rel="stylesheet"
          href="<c:url value='/template/web/css/plugins/owl-carousel/owl.carousel.css'/>">
    <link rel="stylesheet"
          href="<c:url value='/template/web/css/plugins/magnific-popup/magnific-popup.css'/>">
    <link rel="stylesheet"
          href="<c:url value='/template/web/css/plugins/jquery.countdown.css'/>">
    <!-- Main CSS File -->
    <link rel="stylesheet"
          href="<c:url value='/template/web/css/style.css'/>">
    <link rel="stylesheet"
          href="<c:url value='/template/web/css/skins/skin-demo-4.css'/>">
    <link rel="stylesheet"
          href="<c:url value='/template/web/css/demos/demo-4.css'/>">
    <link rel="stylesheet"
          href="<c:url value='/template/web/css/jquery.toast.min.css'/>">
    <script src="<c:url value='/template/web/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/jquery.toast.min.js'/>"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.15.7/dist/sweetalert2.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.15.7/dist/sweetalert2.all.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous"
          referrerpolicy="no-referrer" />
    <style>
        #cartContainer::-webkit-scrollbar {
            width: 10px;
        }

        #cartContainer::-webkit-scrollbar-thumb {
            background-color: #fff;
            border-radius: 5px;
            border: 2px solid #ccc;
        }

        #cartContainer::-webkit-scrollbar-track {
            background-color: #ccc;
            border-radius: 5px;
        }

        .be-comment-block {
            margin-bottom: 50px !important;
            border: 1px solid #edeff2;
            border-radius: 2px;
            padding: 50px 70px;
            border: 1px solid #ffffff;
        }

        .comments-title {
            font-size: 16px;
            color: #262626;
            margin-bottom: 15px;
            font-family: 'Conv_helveticaneuecyr-bold';
        }

        .be-img-comment {
            width: 60px;
            height: 60px;
            float: left;
            margin-bottom: 15px;
        }

        .be-ava-comment {
            width: 60px;
            height: 60px;
            border-radius: 50%;
        }

        .be-comment-content {
            margin-left: 80px;
        }

        .be-comment-content span {
            display: inline-block;
            width: 49%;
            margin-bottom: 15px;
        }

        .be-comment-name {
            font-size: 13px;
            font-family: 'Conv_helveticaneuecyr-bold';
        }

        .be-comment-content a {
            color: #383b43;
        }

        .be-comment-content span {
            display: inline-block;
            width: 49%;
            margin-bottom: 15px;
        }

        .be-comment-time {
            text-align: right;
        }

        .be-comment-time {
            font-size: 11px;
            color: #b4b7c1;
        }

        .be-comment-text {
            font-size: 13px;
            line-height: 18px;
            color: #7a8192;
            display: block;
            background: #f6f6f7;
            border: 1px solid #edeff2;
            padding: 15px 20px 20px 20px;
        }

        .form-group.fl_icon .icon {
            position: absolute;
            top: 1px;
            left: 16px;
            width: 48px;
            height: 48px;
            background: #f6f6f7;
            color: #b5b8c2;
            text-align: center;
            line-height: 50px;
            -webkit-border-top-left-radius: 2px;
            -webkit-border-bottom-left-radius: 2px;
            -moz-border-radius-topleft: 2px;
            -moz-border-radius-bottomleft: 2px;
            border-top-left-radius: 2px;
            border-bottom-left-radius: 2px;
        }

        .form-group .form-input {
            font-size: 13px;
            line-height: 50px;
            font-weight: 400;
            color: #b4b7c1;
            width: 100%;
            height: 50px;
            padding-left: 20px;
            padding-right: 20px;
            border: 1px solid #edeff2;
            border-radius: 3px;
        }

        .form-group.fl_icon .form-input {
            padding-left: 70px;
        }

        .form-group textarea.form-input {
            height: 150px;
        }
    </style>
</head>
<body>
<div class="page-wrapper">
    <!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->

    <div class="main">
        <dec:body/>
    </div>

    <!-- 	footer -->
    <%@ include file="/common/web/footer.jsp" %>
    <!-- 	footer -->
</div>


<script src="<c:url value='/template/web/js/bootstrap.bundle.min.js'/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/js-cookie/3.0.1/js.cookie.min.js"></script>
<script
        src="<c:url value='/template/web/js/jquery.hoverIntent.min.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery.waypoints.min.js'/>"></script>
<script src="<c:url value='/template/web/js/superfish.min.js'/>"></script>
<script src="<c:url value='/template/web/js/owl.carousel.min.js'/>"></script>
<script
        src="<c:url value='/template/web/js/bootstrap-input-spinner.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery.plugin.min.js'/>"></script>
<script
        src="<c:url value='/template/web/js/jquery.magnific-popup.min.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery.countdown.min.js'/>"></script>
<script src="<c:url value='/template/web/js/main.js'/>"></script>
<script src="<c:url value='/template/web/js/demos/demo-4.js'/>"></script>

<script
        src="<c:url value='/template/paging/jquery.twbsPagination.js'/>"></script>
<script
        src="<c:url value='/template/paging/jquery.twbsPagination.min.js'/>"></script>
<script src="<c:url value='/template/validator/validator.js'/>"></script>
<script src="<c:url value='/template/web/web-tmp-js/render.js'/>"></script>
<script src="<c:url value='/template/web/web-tmp-js/SearchInput.js'/>"></script>
<script src="<c:url value='/template/web/web-tmp-js/Cart.js'/>"></script>
<script src="<c:url value='/template/web/web-tmp-js/QuantityProduct.js'/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.26.1/axios.min.js" integrity="sha512-bPh3uwgU5qEMipS/VOmRqynnMXGGSRv+72H/N260MQeXZIK4PG48401Bsby9Nq5P5fz7hy5UGNmC/W1Z51h2GQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="<c:url value='/template/web/web-tmp-js/APIProvince.js'/>"></script>
<script src="<c:url value='/template/web/web-tmp-js/Checkout.js'/>"></script>

</body>
</html>