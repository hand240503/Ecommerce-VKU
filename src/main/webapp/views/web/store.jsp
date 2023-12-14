<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api/products"/>
<nav aria-label="breadcrumb" class="breadcrumb-nav mb-2">
    <div class="container">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a
                    href="<c:url value="/" />">Home</a></li>
            <li class="breadcrumb-item"><a
                    href="<c:url value="/products?code=${code}&page=1" />">${product[0].category.categoryName}</a>
            </li>
        </ol>
    </div>
</nav>
<div class="page-content">
    <div class="container">
        <div class="row">
            <div class="col-lg-9">
                <div class="toolbox">
                    <div class="toolbox-right">
                        <div class="toolbox-sort">
                            <h1 id="alo"></h1>
                            <div class="">
                                <a class="dropdown-toggle" href="#" role="button"
                                   id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                                   aria-expanded="false">
                                    Sắp xếp
                                </a>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                    <a class="dropdown-item" data-value="ban-chay-nhat">Sản phẩm bán chạy</a>
                                    <a class="dropdown-item" data-value="new">Mới nhất</a>
                                    <a class="dropdown-item" data-value="price-asc">Giá tăng dần</a>
                                    <a class="dropdown-item" data-value="price-desc">Giá giảm dần</a>
                                </div>
                            </div>
                        </div>
                        <!-- End .toolbox-sort -->
                    </div>
                    <!-- End .toolbox-right -->
                </div>
                <!-- End .toolbox -->
                <div class="products mb-3">
                    <div class="row justify-content-center">
                        <c:forEach items="${product}" var="item">
                            <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                <div class="product product-7 text-center data-id='${item.id}" id="product">
                                    <figure class="product-media">
                                        <a href="<c:url value='/product/${item.id}'/>"> <img
                                                src="<c:url value='${item.imageModel.pathImageProduct}'/>"
                                                alt="${item.imageModel.desImage}" class="product-image">
                                        </a>
                                        <div class="product-action">
                                            <a href="#" class="btn-product btn-cart"><p>add
														to cart</p></a>
                                        </div>
                                    </figure>
                                    <div class="product-body">
                                        <div class="product-cat">
                                            <a href="<c:url value='/product/${item.id}'/>">${item.category.categoryName }</a>
                                        </div>

                                        <h3 class="product-title">
                                            <a href="product/${item.id}">${item.nameProduct}</a>
                                        </h3>

                                        <div class="product-price">$${item.priceModel.productPrice
                                                }</div>

                                        <div class="ratings-container">
                                            <div class="ratings">
                                                <div class="ratings-val" style="width: 0%;"></div>
                                            </div>
                                            <span class="ratings-text">( 0 Reviews )</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                    <div class="mb-10"></div>
                    <ul class="pagination justify-content-center" id="pagination"></ul>
                    <input type="hidden" value="" id="page" name="page"> <input
                        type="hidden" value="" id="maxPageItem" name="maxPageItem">
                    <input type="hidden" value="" id="code" name="code">
                    <input type="hidden" value="" id="sort" name="sort"/>
                </div>
            </div>
            <!-- End .col-lg-9 -->
            <aside class="col-lg-3 order-lg-first">
                <div class="sidebar sidebar-shop">
                    <div class="widget widget-clean">
                        <label>Filters:</label> <a href="#" class="clean-all">Clean
                        All</a>
                    </div>
                    <!-- End .widget widget-clean -->
                    <div class="widget widget-collapsible">
                        <h3 class="widget-title">
                            <a data-toggle="collapse" href="#widget-4" role="button"
                               aria-expanded="true" aria-controls="widget-4"> Brand </a>
                        </h3>
                        <!-- End .widget-title -->

                        <div class="collapse show" id="widget-4">
                            <div class="widget-body">
                                <div class="filter-item">
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input brand-check" checked
                                               id="brand-1" data-href="" data-brand="all"> <label
                                            class="custom-control-label"
                                            for="brand-1">Tất cả</label>
                                    </div>
                                    <!-- End .custom-checkbox -->
                                </div>
                                <div class="filter-items">
                                    <c:forEach items="${brand}" var="item" varStatus="loop">
                                        <div class="filter-item">
                                            <div class="custom-control custom-checkbox">
                                                <input type="checkbox" id="brand-${loop.index + 2}"
                                                       class="custom-control-input brand-check"
                                                       data-brand="${item.codeBrand}">
                                                <label class="custom-control-label"
                                                       for="brand-${loop.index + 2}">${item.nameBrand}</label>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <!-- End .filter-items -->
                            </div>
                            <!-- End .widget-body -->
                        </div>
                        <!-- End .collapse -->
                    </div>
                    <!-- End .widget -->

                    <div class="widget widget-collapsible">
                        <h3 class="widget-title">
                            <a data-toggle="collapse" href="#widget-5" role="button"
                               aria-expanded="true" aria-controls="widget-5"> Price </a>
                        </h3>
                        <!-- End .widget-title -->

                        <div class="collapse show" id="widget-5">
                            <div class="widget-body">
                                <div class="filter-price">
                                    <div class="filter-price-text">
                                        Price Range: <span id="filter-price-range"></span>
                                    </div>
                                    <!-- End .filter-price-text -->

                                    <div id="price-slider"></div>
                                    <!-- End #price-slider -->
                                </div>
                                <!-- End .filter-price -->
                            </div>
                            <!-- End .widget-body -->
                        </div>
                        <!-- End .collapse -->
                    </div>
                    <!-- End .widget -->
                </div>
                <!-- End .sidebar sidebar-shop -->
            </aside>
            <!-- End .col-lg-3 -->
        </div>
        <!-- End .row -->
    </div>
    <!-- End .container -->
</div>
<script>
    var totalPage = ${pageModel.totalPage};
    var currentPage = ${pageModel.page};
    var code = "${code}";
    var maxPageItem = 5;
    var firstLoad = true;

    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage,
            visiblePages: totalPage,
            startPage: currentPage,
            onPageClick: function (event, page) {
                event.preventDefault();
                $('#page').val(page);
                var data = {};
                const sort = $('#sort').val();

                var checkedDataBrands = getCheckedDataBrand();
                if (checkedDataBrands.length === 0) {
                    checkedDataBrands = 'all'
                }

                var pageData = [{
                    name: "page",
                    value: page
                }, {
                    name: "maxPageItem",
                    value: maxPageItem
                }, {
                    name: "code",
                    value: code
                }, {
                    name: "sortName",
                    value: sort
                }, {
                    name: "sortBy",
                    value: sort
                }
                    , {
                        name: 'brand',
                        value: checkedDataBrands
                    }
                ];

                $.each(pageData, function (i, v) {
                    if (v.value !== null && v.value !== undefined && v.value !== "") {
                        data["" + v.name + ""] = v.value;
                    }
                });


                if (!firstLoad) {
                    loadData(data);
                    updateUrlParameter('page', page);
                } else {
                    firstLoad = false;
                }
            }
        });
    });

    function updateDataAndLoad() {
        let sort = $('#sort').val();
        let page = $('#page').val();
        let data = {};

        let checkedDataBrands = getCheckedDataBrand();
        if (checkedDataBrands.length === 0) {
            checkedDataBrands = 'all';
        }

        let pageData = [
            { name: 'page', value: page },
            { name: 'maxPageItem', value: maxPageItem },
            { name: 'code', value: code },
            { name: 'sortName', value: sort },
            { name: 'sortBy', value: sort },
            { name: 'brand', value: checkedDataBrands }
        ];

        $.each(pageData, function (i, v) {
            if (v.value !== null && v.value !== undefined && v.value !== "") {
                data[v.name] = v.value;
            }
        });
        if (!firstLoad) {
            console.log(data);
            loadData(data);
        } else {
            firstLoad = false;
        }
    }

    $('.dropdown-item').click(function () {
        let sort = $(this).data('value');
        $('#dropdownMenuLink').text($(this).text());
        $('#sort').val(sort);

        updateUrlParameter('sortName', sort);
        updateUrlParameter('sortBy', sort);

        updateDataAndLoad();
    });

    $('.brand-check').on('click', function () {
        if ($(this).attr('id') === 'brand-1') {
            $('.brand-check').not(this).prop('checked', false);
        } else {
            $('#brand-1').prop('checked', false);
        }

        updateDataAndLoad();
    });

    $('.clean-all').on('click', function () {
        $('.brand-check').prop('checked', false);
        $('#brand-1').prop('checked', true);

        let checkedDataBrands = getCheckedDataBrand();


        updateDataAndLoad();
    });

    function updateUrlParameter(key, value) {
        var url = new URL(window.location.href);
        url.searchParams.set(key, value);
        window.history.pushState({}, '', url);
    }

    function getCheckedDataBrand() {
        var checkedDataBrands = [];

        // Iterate over all checkboxes with the class 'brand-check'
        $('.brand-check').each(function () {
            // Check if the current checkbox is checked
            if ($(this).prop('checked')) {
                // Retrieve and store the data-brand value
                var dataBrandValue = $(this).data('brand');
                checkedDataBrands.push(dataBrandValue);
            }
        });

        return checkedDataBrands;
    }


</script>
