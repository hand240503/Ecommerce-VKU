<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card shadow mb-4">
    <div class="card-header py-3 d-flex justify-content-between">
        <h6 class="m-0 font-weight-bold text-primary">Quản lý sản phẩm</h6>
        <div class="btn-group">
            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false">
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
                <tbody id="productTableBody">
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
                </tbody>
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
        let totalPages = ${pageModel.totalPage};
        let currentPage = ${pageModel.page};
        let maxPageItem = 10;
        let firstLoad = true;

        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: totalPages,
            startPage: currentPage,
            onPageClick: function (event, page) {
                $('#page').val(page);
                var data = {};
                var pageData = [{
                    name: "page",
                    value: page
                }, {
                    name: "maxPageItem",
                    value: maxPageItem
                }
                ];
                $.each(pageData, function (i, v) {
                    if (v.value !== null && v.value !== undefined && v.value !== "") {
                        data["" + v.name + ""] = v.value;
                    }
                });

                if (!firstLoad) {
                    updateUrlParameter('page', page);
                    $.ajax({
                        url: '/Ecommerce/api/admin-products',
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function (products) {
                            renderData(products);
                        },
                        error: function (error) {
                            console.error("Error:", error);
                        }
                    });
                } else {
                    firstLoad = false;
                }
            }
        });
    });

    function updateUrlParameter(key, value) {
        var url = new URL(window.location.href);
        url.searchParams.set(key, value);
        window.history.pushState({}, '', url);
    }

    function renderData(products) {
        var tbody = document.getElementById('productTableBody');

        tbody.innerHTML = '';

        products.forEach(function (item) {
            var row = '<tr>' +
                '<td>' + item.id + '</td>' +
                '<td>' + item.nameProduct + '</td>' +
                '<td>' + item.priceModel.productPrice + '</td>' +
                '<td>' + item.category.categoryName + '</td>' +
                '<td><a class="btn btn-info" href="#" role="button">Update</a></td>' +
                '<td><a class="btn btn-danger" href="#" role="button">Delete</a></td>' +
                '</tr>';

            tbody.innerHTML += row;
        });
    }

</script>