<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Quản lý đơn hàng</h6>
    </div>

    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <th>Total</th>
                    <th>Description</th>
                    <th>Tỉnh/Thành phố</th>
                    <th>Quận/Huyện</th>
                    <th>Phường/Xã </th>
                    <th>Địa chỉ nhà </th>
                    <th>Số điện thoại *</th>
                    <th>Xác nhập</th>
                </tr>
                </thead>
                <c:forEach items="${orders}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.userModel.firstName}  ${item.userModel.lastName}</td>
                        <td>${item.total}</td>
                        <td>${item.description}</td>
                        <td>${item.address_01}</td>
                        <td>${item.address_02}</td>
                        <td>${item.address_03}</td>
                        <td>${item.address_04}</td>
                        <td>${item.address_05}</td>
                        <td><button type="button" class="btn btn-warning btn-accept" data-id="${item.id}">Xác nhận đơn hàng</button></td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
<script>
  $(document).ready(function() {

    $(".btn-accept").click(function() {
        let id = $(this).data('id');
        if (id != null) {
            let data = { id: id };
            $.ajax({
                url: '/Ecommerce/api/admin-orders',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(data), // Corrected the variable name here
                dataType: 'json',
                success: function(response) {
                    window.location.href = "/Ecommerce/admin-orders?type=confirmed";
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
    });

  });
</script