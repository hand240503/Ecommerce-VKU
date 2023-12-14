<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card shadow mb-4">
    <div class="card-header py-3 d-flex justify-content-between">
        <h6 class="m-0 font-weight-bold text-primary">Quản lý sản phẩm</h6>
        <div class="btn-group">
            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Sắp xếp
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Separated link</a>
            </div>
        </div>
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
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <c:forEach items="${product}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nameProduct}</td>
                        <td>${item.priceModel.productPrice}</td>
                        <td>${item.category.categoryName}</td>
                        <td><a class="btn btn-info" href="#" role="button">Update</a></td>
                        <td><a class="btn btn-danger" href="#" role="button">Delete</a></td>

                    </tr>
                </c:forEach>
            </table>
        </div>
        <ul class="pagination justify-content-center" id="pagination"></ul>
        <input type="hidden" value="" id="page" name="page"> <input
            type="hidden" value="" id="maxPageItem" name="maxPageItem">
        <input type="hidden" value="" id="code" name="code">
        <input type="hidden" value="" id="sort" name="sort"/>
    </div>
</div>

<script>
    $(function () {
        var totalPages = 10;
        var currentPage = 1;

        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            startPage: currentPage,
            onPageClick: function (event, page) {
                console.log('Page clicked: ' + page);
            }
        });
    });

</script>