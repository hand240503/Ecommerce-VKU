<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Quản lý sản phẩm</h6>
    </div>

    <div class="card-body">

        <div class="table-responsive">

            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                <thead>
                <tr>
                    <td>ID</td>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Unit</th>
                    <th>Category</th>
                </tr>
                </thead>
                <c:forEach items="${product}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nameProduct}</td>
                        <td>${item.priceModel.productPrice}</td>
                        <td>${item.category.categoryName}</td>
                        <td>${item.unitModel.nameUnit}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>