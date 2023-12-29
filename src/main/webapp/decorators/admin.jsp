<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SB Admin 2</title>
    <link rel="stylesheet" href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css'/>">

    <link rel="stylesheet" href="<c:url value='/template/admin/css/sb-admin-2.css'/>">
    <link href="<c:url value="/template/admin/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>
    <link rel="stylesheet"
          href="<c:url value='/template/web/css/jquery.toast.min.css'/>">
    <script src="<c:url value='/template/web/js/jquery.toast.min.js'/>"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10/dist/sweetalert2.min.css">

</head>
<body id="page-top">
<div id="wrapper">

    <!-- content -->
    <%@ include file="/common/admin/nav_bar.jsp" %>
    <!-- content -->

    <!-- nav -->
    <%@ include file="/common/admin/content.jsp" %>
    <!-- nav -->

</div>

<script src="<c:url value='/template/admin/js/sb-admin-2.min.js'/>"></script>
<script
        src="<c:url value='/template/paging/jquery.twbsPagination.js'/>"></script>
<script
        src="<c:url value='/template/paging/jquery.twbsPagination.min.js'/>"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

</body>
</html>