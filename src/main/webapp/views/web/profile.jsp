<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<div class="container">
    <div class="main-body">
        <div class="container mt-5">
            <span class="display-4">Hồ Sơ Của Tôi</span>
        </div>
        <div class="pb-3"></div>
        <div class="row gutters-sm">
            <div class="col-md-8">
                <div class="card pt-3">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Fist Name</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${user.firstName}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Last Name</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${user.lastName}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${user.email}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Phone</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${user.phoneNumber}
                            </div>
                        </div>
                        <hr>
                        <div class="mb-3">
                            <p><a href="<c:url value="/user/password"/>">Thay đổi mật khẩu</a></p>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <a class="btn btn-info " href="<c:url value="/user?t=edit"/>">Edit</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>