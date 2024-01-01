<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Quản lý người dùng</h6>
    </div>

    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                <thead>
                <tr>
                    <td>ID</td>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Email</th>
                    <th>Last Name</th>
                    <th>First Name</th>
                    <th>Telephone</th>
<%--                    <th>Status</th>--%>
                </tr>
                </thead>
                <c:forEach items="${user}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.userName}</td>
                        <td>
                            <c:if test="${item.role == 2}">
                                <span class="badge badge-pill badge-success">Người dùng</span>
                            </c:if>
                            <c:if test="${item.role == 1}">
                                <span class="badge badge-pill badge-primary">Quản trị</span>
                            </c:if>
                        </td>
                        <td>${item.email}</td>
                        <td>${item.lastName}</td>
                        <td>${item.firstName}</td>
                        <td>${item.phoneNumber}</td>
<%--                        <c:if test="${item.status == 1}">--%>
<%--                            <td><span class="badge badge-success">Hoạt động</span></td>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${item.status == 2}">--%>
<%--                            --%>
<%--                        </c:if>--%>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>