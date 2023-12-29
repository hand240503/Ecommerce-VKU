<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Chi tiết đơn hàng</h6>
    </div>
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
                                                    <p class="text-muted mb-0 small">Price : ${item.productDTO.price}
                                                        $</p>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </c:forEach>
<%--                                <c:if test="${items.status == 2}">--%>
<%--                                    <div class="float-right pb-1">--%>
<%--                                        <a class="btn btn-sm btn-info btn-huydon" data-id="${items.id}" href="#"><i--%>
<%--                                                class="icofont-refresh"></i> Hủy đơn</a>--%>
<%--                                    </div>--%>
<%--                                </c:if>--%>
                                <div class="clearfix"></div>


                                <div class="d-flex justify-content-between pb-3">
                                    <p class="text-muted font-weight-bold">Mã Đơn Hàng : ${items.id}</p>
                                    <p class="text-muted font-weight-bold">
                                        <span class="fw-bold me-4">Tổng đơn hàng: </span> ${items.total}
                                    </p>
                                </div>


                            </c:forEach>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<script>
    // $('.btn-huydon').on('click', function (e) {
    //     e.preventDefault();
    //     Swal.fire({
    //         title: 'Bạn có chắc chắn muốn hủy đơn không?',
    //         icon: 'warning',
    //         showCancelButton: true,
    //         confirmButtonColor: '#3085d6',
    //         cancelButtonColor: '#d33',
    //         confirmButtonText: 'Yes',
    //         cancelButtonText: 'No'
    //     }).then((result) => {
    //         if (result.isConfirmed) {
    //             let id = $(this).data('id');
    //             $.ajax({
    //                 url: '/Ecommerce/api/orders/cancel',
    //                 type: 'POST',
    //                 contentType: 'application/json',
    //                 data: JSON.stringify({id: id}),
    //                 dataType: 'json',
    //                 success: function (response) {
    //                     window.location.href = "/Ecommerce/admin-orders?type=unconfirmed";
    //                 },
    //                 error: function (error) {
    //                     console.error('Error:', error);
    //                 }
    //             });
    //         } else {
    //             console.log('User clicked No');
    //         }
    //     });
    //
    // })
</script>