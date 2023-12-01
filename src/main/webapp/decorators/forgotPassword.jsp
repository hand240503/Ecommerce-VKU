<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/13/2023
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>Snippet - BBBootstrap</title>
    <link
            href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'
            rel='stylesheet'>
    <link href='' rel='stylesheet'>
    <script type='text/javascript'
            src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <style>
        body {
            background-position: center;
            background-color: #eee;
            background-repeat: no-repeat;
            background-size: cover;
            color: #505050;
            font-family: "Rubik", Helvetica, Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            line-height: 1.5;
            text-transform: none
        }

        .forgot {
            background-color: #fff;
            padding: 12px;
            border: 1px solid #dfdfdf
        }

        .padding-bottom-3x {
            padding-bottom: 72px !important
        }

        .card-footer {
            background-color: #fff
        }

        .btn {
            font-size: 13px
        }

        .form-control:focus {
            color: #495057;
            background-color: #fff;
            border-color: #76b7e9;
            outline: 0;
            box-shadow: 0 0 0 0px #28a745
        }
        .message{
            color: #f33a58;
        }
    </style>
</head>
<body>
<dec:body/>

<script type='text/javascript'
        src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
<script src="<c:url value='/template/validator/validator.js'/>"></script>
<script src="<c:url value="/template/identify/main.js"/>"></script>
</body>
</html>
