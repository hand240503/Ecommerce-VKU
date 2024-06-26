<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card shadow mb-4">
    <div class="card-header py-3 d-flex justify-content-between">
        <h6 class="m-0 font-weight-bold text-primary">Quản lý sản phẩm</h6>

    </div>

    <div class="card-body" style="height: 784px">

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
                        <td class="text-right">${item.priceModel.productPrice}</td>
                        <td>${item.category.categoryName}</td>
                        <td class="text-center"><a href="<c:url value="/admin-products?t=edit&i=${item.id}"/>"
                                                   class="btn btn-info btn-circle">
                            <i class="fas fa-info-circle"></i>
                        </a></td>
                        <td class="text-center"><a href="#" data-id="${item.id}" onclick="deleteProduct(${item.id})"
                                                   class="btn btn-danger btn-circle"> <i
                                class="fas fa-trash"></i> </a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
    <ul class="pagination justify-content-center" id="pagination"></ul>
    <input type="hidden" value="" id="page" name="page"> <input
        type="hidden" value="" id="maxPageItem" name="maxPageItem">
    <input type="hidden" value="" id="code" name="code">
    <input type="hidden" value="" id="sort" name="sort"/>
</div>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
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

    function deleteProduct(productId) {

        Swal.fire({
            title: 'Bạn có chắc chắn muốn ngừng bán sản phẩm này ?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes',
            cancelButtonText: 'No'
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: '/Ecommerce/api/admin-delete-products',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify({id: productId}),
                    dataType: 'json',
                    success: function (response) {
                        window.location.reload();
                    },
                    error: function (error) {
                        console.error('Error:', error);
                    }
                });
            } else {
                console.log('User clicked No');
            }
        });

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
                '<td class="text-center"><a href="/Ecommerce/admin-products?t=edit&i=' + item.id + '" class="btn btn-info btn-circle"> <i class="fas fa-info-circle"></i> </a></td>' +
                '<td class="text-center" onclick="deleteProduct(' + item.id + ')"><a href="#" data-id="' + item.id + '" class="btn btn-danger btn-circle"> <i class="fas fa-trash"></i> </a></td>' +
                '</tr>';
            tbody.innerHTML += row;
        });


    }

</script>