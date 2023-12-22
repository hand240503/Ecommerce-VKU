<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<section class="h-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-10 col-xl-8">
                <div class="card" style="border-radius: 10px;">
                    <div class="card-body p-4">
                        <c:forEach var="items" items="${orders}">
                            <c:forEach var="item" items="${items.orderDetailDTOs}">
                                <div class="card shadow-0 border mb-1">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-2">
                                                <img src="<c:url value="${item.productDTO.imagePath}" />"
                                                     class="img-fluid" alt="Phone">
                                            </div>
                                            <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                                                <p class="text-muted mb-0">${item.productDTO.nameProduct}</p>
                                            </div>
                                            <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                                                <p class="text-muted mb-0 small">${item.productDTO.nameBrand}</p>
                                            </div>
                                            <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                                                <p class="text-muted mb-0 small">Capacity: 64GB</p>
                                            </div>
                                            <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                                                <p class="text-muted mb-0 small">Qty: ${item.quantity}</p>
                                            </div>
                                            <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                                                <p class="text-muted mb-0 small">Total : ${item.productDTO.price} $</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <c:if test="${items.status eq 2}">
                                <div class="float-right pb-1">
                                    <a class="btn btn-sm btn-info" href="#"><i class="icofont-refresh"></i> Hủy đơn</a>
                                </div>
                            </c:if>
                            <div class="clearfix"></div>

                            <c:if test="${items.status eq 1}">
                                <div class="row d-flex align-items-center">
                                    <div class="col-md-2">
                                        <p class="text-muted mb-0 small">Track Order</p>
                                    </div>
                                    <div class="col-md-10">
                                        <div class="progress" style="height: 6px; border-radius: 16px;">
                                            <div class="progress-bar" role="progressbar"
                                                 style="width: 55%; border-radius: 16px; background-color: #8c9eff;"
                                                 aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        <div class="d-flex justify-content-between mt-1">
                                            <div class="text-muted small ms-xl-5">Chưa Xác Nhận</div>
                                            <div class="text-muted small ms-xl-5">Đã Xác Nhận</div>
                                            <div class="text-muted small ms-xl-5">Đã Giao</div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${items.status eq 2}">
                                <div class="row d-flex align-items-center">
                                    <div class="col-md-2">
                                        <p class="text-muted mb-0 small">Track Order</p>
                                    </div>
                                    <div class="col-md-10">
                                        <div class="progress" style="height: 6px; border-radius: 16px;">
                                            <div class="progress-bar" role="progressbar"
                                                 style="width: 30%; border-radius: 16px; background-color: #8c9eff;"
                                                 aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        <div class="d-flex justify-content-between mt-1">
                                            <div class="text-muted small ms-xl-5">Chưa Xác Nhận</div>
                                            <div class="text-muted small ms-xl-5">Đã Xác Nhận</div>
                                            <div class="text-muted small ms-xl-5">Đã Giao</div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

                            <div class="d-flex justify-content-between pb-3">
                                <p class="text-muted font-weight-bold">Mã Đơn Hàng : ${items.id}</p>
                                <p class="text-muted font-weight-bold"><span
                                        class="fw-bold me-4">Tổng đơn hàng: </span> ${items.total} </p>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>