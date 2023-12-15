<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<nav aria-label="breadcrumb" class="breadcrumb-nav border-0 mb-0">
    <div class="container d-flex align-items-center">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="<c:url value="/trang-chu" />">Home</a></li>
            <li class="breadcrumb-item"><a
                    href="<c:url value="/products?code=${product.category.categoryCode}&page=1" />">${product.category.categoryName}</a>
            </li>
            <li class="breadcrumb-item active" aria-current="page">${product.nameProduct}</li>
        </ol>
    </div>
</nav>
<div class="page-content">
    <div class="container">
        <div class="product-details-top">
            <div class="row">
                <div class="col-md-6">
                    <div class="product-gallery product-gallery-vertical">
                        <div class="row">
                            <figure class="product-main-image">
                                <img id="product-zoom" src="<c:url value="${product.imageModel.pathImageProduct }"/>"
                                     data-zoom-image=""
                                     alt="product image">
                            </figure>
                        </div>
                        <!-- End .row -->
                    </div>
                    <!-- End .product-gallery -->
                </div>
                <!-- End .col-md-6 -->

                <div class="col-md-6">
                    <div class="product-details">
                        <h1 class="product-title">${product.nameProduct}</h1>
                        <!-- End .product-title -->

                        <div class="ratings-container">
                            <a class="ratings-text" href="#product-review-link"
                               id="review-link"></a>
                        </div>
                        <!-- End .rating-container -->

                        <div class="product-price">${product.priceModel.productPrice}</div>
                        <!-- End .product-price -->

                        <div class="product-content">
                            <p>${product.description}</p>
                        </div>
                        <!-- End .product-content -->

                        <div class="details-filter-row details-row-size">
                            <label for="qty">Qty:</label>
                            <div class="product-details-quantity">
                                <input type="number" id="qty" class="form-control form-quantity" value="1" min="1"
                                       max="10" step="1" data-decimals="0" required pattern="[0-9]+">
                            </div>
                            <!-- End .product-details-quantity -->
                        </div>
                        <!-- End .details-filter-row -->

                        <div class="product-details-action">
                            <button class="btn btn-primary btn-addToCart" type="submit" data-id="${product.id}">ADD TO
                                CART
                            </button>
                        </div>
                        <!-- End .product-details-action -->

                        <div class="product-details-footer">
                            <div class="product-cat">
                                <span>Category:</span>
                                <a href="">${product.category.categoryName }</a>
                            </div>
                            <!-- End .product-cat -->
                        </div>
                    </div>
                    <!-- End .product-details -->
                </div>
                <!-- End .col-md-6 -->
            </div>
            <!-- End .row -->
        </div>
        <!-- End .product-details-top -->

        <div class="product-details-tab">
            <ul class="nav nav-pills justify-content-center" role="tablist">
                <li class="nav-item"><a class="nav-link active"
                                        id="product-desc-link" data-toggle="tab" href="#product-desc-tab"
                                        role="tab" aria-controls="product-desc-tab" aria-selected="true">Description</a>
                </li>
                <li class="nav-item"><a class="nav-link"
                                        id="product-review-link" data-toggle="tab"
                                        href="#product-review-tab" role="tab"
                                        aria-controls="product-review-tab" aria-selected="false">Reviews
                </a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane fade show active" id="product-desc-tab"
                     role="tabpanel" aria-labelledby="product-desc-link">
                    <div class="product-desc-content">
                        <h3>Product Information</h3>
                        <p>${product.description}</p>
                    </div>
                    <!-- End .product-desc-content -->
                </div>
                <!-- .End .tab-pane -->
                <div class="tab-pane fade" id="product-review-tab" role="tabpanel"
                     aria-labelledby="product-review-link">
                    <div class="reviews">
                        <h3>Reviews </h3>
                        <section class="content-item" id="comments">
                            <div class="container">
                                <div class="row">
                                    <div class="col-sm-8">
                                        <form>
                                            <fieldset>
                                                <div class="row">
                                                    <div class="form-group col-xs-12 col-sm-9 col-lg-10">
                                                        <textarea class="form-control" id="message"
                                                                  placeholder="Your message" required=""></textarea>
                                                    </div>
                                                </div>
                                            </fieldset>
                                            <button data-id="${product.id}" type="submit"
                                                    class="btn btn-normal pull-right" id="submit-comment">
                                                Submit
                                            </button>
                                        </form>
                                        <!-- COMMENT 1 - START -->
                                        <c:forEach items="${review}" var="item">
                                            <div class="media">
                                                <div class="media-body">
                                                    <p>${item.comment}</p>
                                                    <ul class="list-unstyled list-inline media-detail pull-left">
                                                        <li><i class="icon-calendar"></i>${item.createdDate}</li>
                                                    </ul>
                                                </div>
                                            </div>

                                        </c:forEach>
                                        <!-- COMMENT 1 - END -->
                                    </div>
                                </div>
                            </div>
                        </section>

                    </div>
                    <!-- End .reviews -->
                </div>
                <!-- .End .tab-pane -->
            </div>
            <!-- End .tab-content -->
        </div>
        <!-- End .product-details-tab -->
    </div>
    <!-- End .container -->
</div>
<script>
    $('#submit-comment').on('click', function (e) {
        e.preventDefault();
        let message = $('#message').val().trim();
        let id = $(this).data('id');
        if (message !== "") {
            let data = {comment: message, idProduct: id};
            $.ajax({
                url: '/Ecommerce/api/reviews',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (response) {
                    if (!response) {
                        $.toast({
                            heading: 'Thông báo',
                            text: 'Vui lòng đăng nhập',
                            showHideTransition: 'slide',
                            icon: 'warning',
                            position: 'bottom-right',
                            timeout: 2000
                        });
                    } else {
                        $.toast({
                            heading: 'Thông báo',
                            text: 'Đã thêm thành công bình luận.',
                            showHideTransition: 'slide',
                            icon: 'success',
                            position: 'bottom-right',
                            timeout: 2000
                        });
                    }

                },
                error: function (error) {
                    console.error("Error:", error);

                }
            });

        } else {
            $.toast({
                heading: 'Thông báo',
                text: 'Vui lòng nhập bình luận',
                showHideTransition: 'slide',
                icon: 'warning',
                position: 'bottom-right',
                timeout: 2000
            });
        }
    });

</script>
