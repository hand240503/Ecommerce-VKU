<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<div class="container">
  <div class="main-body">
    <div class="row">
      <div class="container mt-5 mb-3">
        <span class="display-4">Hồ Sơ Của Tôi</span>
      </div>
    <form action="<c:url value="/user?t=edit"/>" class="container" method="post">
      <input type="hidden" name="id" value="${user.id}"/>
      <div class="col-lg-8">
        <div class="card">
          <div class="card-body">
            <div class="row mb-3 mt-3">
              <div class="col-sm-3">
                <h6 class="mb-0">Fist Name</h6>
              </div>
              <div class="col-sm-9 text-secondary">
                <input type="text" class="form-control" name="firstName" value="${user.firstName}">
              </div>
            </div>

            <div class="row mb-3">
              <div class="col-sm-3">
                <h6 class="mb-0">Last Name</h6>
              </div>
              <div class="col-sm-9 text-secondary">
                <input type="text" class="form-control" name="lastName" value="${user.lastName}">
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-sm-3">
                <h6 class="mb-0">Email</h6>
              </div>
              <div class="col-sm-9 text-secondary">
                <input type="text" class="form-control" name="email" value="${user.email}">
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-sm-3">
                <h6 class="mb-0">Phone</h6>
              </div>
              <div class="col-sm-9 text-secondary">
                <input type="text" class="form-control" name="phoneNumber" value="${user.phoneNumber}">
              </div>
            </div>
            <div class="row">
              <div class="col-sm-3"></div>
              <div class="col-sm-9 text-secondary">
                <input type="submit" class="btn btn-primary px-4" value="Save Changes">
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
    </div>
  </div>
</div>