<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<div class="container">
    <div class="intro-slider-container mb-5">
        <div
                class="intro-slider owl-carousel owl-theme owl-nav-inside owl-light"
                data-toggle="owl"
                data-owl-options='{
                        "dots": true,
                        "nav": false, 
                        "responsive": {
                            "1200": {
                                "nav": true,
                                "dots": false
                            }
                        }
                    }'>
            <div class="intro-slide"
                 style="background-image: url(/Ecommerce/template/web/images/demos/demo-4/slider/slide-1.png);">
                <div class="container intro-content">
                    <div class="row justify-content-end">
                        <div class="col-auto col-sm-7 col-md-6 col-lg-5">
                            <h3 class="intro-subtitle text-third">Deals and Promotions</h3>
                            <!-- End .h3 intro-subtitle -->
                            <h1 class="intro-title">Beats by</h1>
                            <h1 class="intro-title">Dre Studio 3</h1>
                            <!-- End .intro-title -->

                            <div class="intro-price">
                                <sup class="intro-old-price">$349,95</sup> <span
                                    class="text-third"> $279<sup>.99</sup>
								</span>
                            </div>

                        </div>
                        <!-- End .col-lg-11 offset-lg-1 -->
                    </div>
                    <!-- End .row -->
                </div>
                <!-- End .intro-content -->
            </div>
            <!-- End .intro-slide -->

            <div class="intro-slide"
                 style="background-image: url(/Ecommerce/template/web/images/demos/demo-4/slider/slide-2.png);">
                <div class="container intro-content">
                    <div class="row justify-content-end">
                        <div class="col-auto col-sm-7 col-md-6 col-lg-5">
                            <h3 class="intro-subtitle text-primary">New Arrival</h3>
                            <!-- End .h3 intro-subtitle -->
                            <h1 class="intro-title">
                                Apple iPad Pro <br>12.9 Inch, 64GB
                            </h1>
                            <!-- End .intro-title -->

                            <div class="intro-price">
                                <sup>Today:</sup> <span class="text-primary"> $999<sup>.99</sup>
								</span>
                            </div>
                            <!-- End .intro-price -->
                        </div>
                        <!-- End .col-md-6 offset-md-6 -->
                    </div>
                    <!-- End .row -->
                </div>
                <!-- End .intro-content -->
            </div>
            <!-- End .intro-slide -->
        </div>
        <!-- End .intro-slider owl-carousel owl-simple -->

        <span class="slider-loader"></span>
        <!-- End .slider-loader -->
    </div>
    <!-- End .intro-slider-container -->
    <div class="mb-5"></div>
    <div class="cat-blocks-container">
        <div class="row">
            <div class="col-6 col-sm-4 col-lg-2">
                <a href="<c:url value="/products?code=lap-top&page=1"/>" class="cat-block">
                    <figure>
						<span> <img
                                src="<c:url value='/template/web/images/demos/demo-4/cats/1.png'/>"
                                alt="Category image">
						</span>
                    </figure>

                    <h3 class="cat-block-title">Computer & Laptop</h3>
                </a>
            </div>
            <!-- End .col-sm-4 col-lg-2 -->

            <div class="col-6 col-sm-4 col-lg-2">
                <a href="<c:url value="/products?code=camera&page=1"/>" class="cat-block">
                    <figure>
						<span> <img
                                src="<c:url value='/template/web/images/demos/demo-4/cats/2.png'/>"
                                alt="Category image">
						</span>
                    </figure>

                    <h3 class="cat-block-title">Digital Cameras</h3> <!-- End .cat-block-title -->
                </a>
            </div>
            <!-- End .col-sm-4 col-lg-2 -->

            <div class="col-6 col-sm-4 col-lg-2">
                <a href="<c:url value="/products?code=dien-thoai&page=1"/>" class="cat-block">
                    <figure>
						<span> <img
                                src="<c:url value='/template/web/images/demos/demo-4/cats/3.png'/>"
                                alt="Category image">
						</span>
                    </figure>

                    <h3 class="cat-block-title">Smart Phones</h3> <!-- End .cat-block-title -->
                </a>
            </div>
            <!-- End .col-sm-4 col-lg-2 -->

            <div class="col-6 col-sm-4 col-lg-2">
                <a href="<c:url value="/products?code=tv&page=1"/>" class="cat-block">
                    <figure>
						<span> <img
                                src="<c:url value='/template/web/images/demos/demo-4/cats/4.png'/>"
                                alt="Category image">
						</span>
                    </figure>

                    <h3 class="cat-block-title">Televisions</h3> <!-- End .cat-block-title -->
                </a>
            </div>
            <!-- End .col-sm-4 col-lg-2 -->

            <div class="col-6 col-sm-4 col-lg-2">
                <a href="<c:url value="/products?code=phu-kien&page=1"/>" class="cat-block">
                    <figure>
						<span> <img
                                src="<c:url value='/template/web/images/demos/demo-4/cats/5.png'/>"
                                alt="Category image">
						</span>
                    </figure>

                    <h3 class="cat-block-title">Accessories</h3> <!-- End .cat-block-title -->
                </a>
            </div>
            <!-- End .col-sm-4 col-lg-2 -->

            <div class="col-6 col-sm-4 col-lg-2">
                <a href="<c:url value="/products?code=smart-watch&page=1"/>" class="cat-block">
                    <figure>
						<span> <img
                                src="<c:url value='/template/web/images/demos/demo-4/cats/6.png'/>"
                                alt="Category image">
						</span>
                    </figure>

                    <h3 class="cat-block-title">Smart Watches</h3> <!-- End .cat-block-title -->
                </a>
            </div>
            <!-- End .col-sm-4 col-lg-2 -->
        </div>
        <!-- End .row -->
    </div>
    <!-- End .cat-blocks-container -->
</div>

<div class="mb-5"></div>
<div class="container new-arrivals">
    <div class="heading heading-flex mb-3">
        <div class="heading-left">
            <h2 class="title">New Arrivals</h2>
            <!-- End .title -->
        </div>

    </div>
    <div class="tab-content tab-content-carousel just-action-icons-sm">
        <div class="tab-pane p-0 fade show active"
             role="tabpanel" aria-labelledby="new-all-link">
            <div
                    class="owl-carousel owl-full carousel-equal-height carousel-with-shadow"
                    data-toggle="owl"
                    data-owl-options='{
                                "nav": true, 
                                "dots": true,
                                "margin": 20,
                                "loop": false,
                                "responsive": {
                                    "0": {
                                        "items":2
                                    },
                                    "480": {
                                        "items":2
                                    },
                                    "768": {
                                        "items":3
                                    },
                                    "992": {
                                        "items":4
                                    },
                                    "1200": {
                                        "items":5
                                    }
                                }
                            }'>
                <c:forEach items="${product}" var="item">
                    <c:if test="${item.isNew == 1 || item.isHot == 1}">
                        <div class="product product-2" data-id='${item.id}'>
                            <figure class="product-media">
                                <a href="<c:url value='/product/${item.id}'/>"> <img
                                        src="<c:url value='${item.imageModel.pathImageProduct}'/>"
                                        alt="Product image" class="product-image">
                                </a>

                                <div class="product-action">
                                    <a href="#" class="btn-product btn-cart btn-add" data-id="${item.id}" title="Add to cart"><span style="display: block">add
										to cart</span></a>
                                </div>
                                <!-- End .product-action -->
                            </figure>
                            <!-- End .product-media -->

                            <div class="product-body">
                                <!-- End .product-cat -->
                                <h3 class="product-title">
                                    <a href="<c:url value='/product/${item.id}'/>">${item.nameProduct}</a>
                                </h3>
                                <!-- End .product-title -->
                                <div class="product-price">$${item.priceModel.productPrice}</div>
                                <!-- End .product-price -->
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<div class="mb-5"></div>
<div class="container">
    <div class="cta cta-border mb-5"
         style="background-image: url(<c:url value='template/web/images/demos/demo-4/bg-1.jpg'/>);">
        <img
                src="<c:url value='template/web/images/demos/demo-4/camera.png'/>"
                alt="camera" class="cta-img">
        <div class="row justify-content-center">
            <div class="col-md-12">
                <div class="cta-content">
                    <div class="cta-text text-right text-white">
                        <p>
                            Shop Today’s Deals <br> <strong>Awesome Made Easy.</strong>
                        </p>
                    </div>
                    <!-- End .cta-text -->
                    <a href="#" class="btn btn-primary btn-round"><span>Shop
							Now</span><i class="icon-long-arrow-right"></i></a>
                </div>
                <!-- End .cta-content -->
            </div>
            <!-- End .col-md-12 -->
        </div>
        <!-- End .row -->
    </div>
    <!-- End .cta -->
</div>
<!-- End .container -->
<div class="bg-light pt-5 pb-6">
    <div class="container trending-products">
        <div class="heading heading-flex mb-3">
            <div class="heading-left">
                <h2 class="title">Trending Phones</h2>
                <!-- End .title -->
            </div>
            <!-- End .heading-left -->

            <div class="heading-right">
                <a href="#" class="title-link">Shop Now<i
                        class="icon-long-arrow-right"></i></a>
            </div>
            <!-- End .heading-right -->
        </div>
        <!-- End .heading -->

        <div class="row">
            <div class="col-xl-5col d-none d-xl-block">
                <div class="banner">
                    <a href="#"> <img
                            src="<c:url value='template/web/images/demos/demo-4/banners/banner-4.jpg'/>"
                            alt="banner">
                    </a>
                </div>
                <!-- End .banner -->
            </div>
            <!-- End .col-xl-5col -->

            <div class="col-xl-4-5col">
                <div class="tab-content tab-content-carousel just-action-icons-sm">
                    <div class="tab-pane p-0 fade show active" id="trending-top-tab"
                         role="tabpanel" aria-labelledby="trending-top-link">
                        <div
                                class="owl-carousel owl-full carousel-equal-height carousel-with-shadow"
                                data-toggle="owl"
                                data-owl-options='{
                                            "nav": true, 
                                            "dots": false,
                                            "margin": 20,
                                            "loop": false,
                                            "responsive": {
                                                "0": {
                                                    "items":2
                                                },
                                                "480": {
                                                    "items":2
                                                },
                                                "768": {
                                                    "items":3
                                                },
                                                "992": {
                                                    "items":4
                                                }
                                            }
                                        }'>
                            <c:forEach items="${product}" var="item">
                                    <c:if test="${item.category.categoryCode eq 'dien-thoai'}">
                                        <div class="product product-2" data-id="${item.id}">
                                            <figure class="product-media">
                                                <a href="<c:url value='/product/${item.id}'/>"> <img
                                                        src="<c:url value='${item.imageModel.pathImageProduct}'/>"
                                                        alt="Product image" class="product-image">
                                                </a>

                                                <div class="product-action">
                                                    <a href="#" class="btn-product btn-cart btn-add" data-id="${item.id}" title="Add to cart"><span style="display: block">add
										to cart</span></a>
                                                </div>
                                                <!-- End .product-action -->
                                            </figure>
                                            <!-- End .product-media -->

                                            <div class="product-body">
                                                <div class="product-cat">
                                                    <a href="#">Smart Home</a>
                                                </div>
                                                <!-- End .product-cat -->
                                                <h3 class="product-title">
                                                    <a href="<c:url value='/product/${item.id}'/>">${item.nameProduct}</a>
                                                </h3>
                                                <!-- End .product-title -->
                                                <div class="product-price">$${item.priceModel.productPrice}</div>
                                                <!-- End .product-price -->
                                                <!-- End .rating-container -->
                                            </div>
                                            <!-- End .product-body -->
                                        </div>
                                    </c:if>
                            </c:forEach>
                        </div>
                        <!-- End .owl-carousel -->
                    </div>
                    <!-- .End .tab-pane -->
                </div>
                <!-- End .tab-content -->
            </div>
            <!-- End .col-xl-4-5col -->
        </div>
        <!-- End .row -->
    </div>
    <!-- End .container -->
</div>
<!-- End .bg-light pt-5 pb-6 -->
<div class='mt-3'></div>
<div class="container new-arrivals">
    <div class="heading heading-flex mb-3">
        <div class="heading-left">
            <h2 class="title">Trending Laptop</h2>
            <!-- End .title -->
        </div>

        <div class="heading-right">
            <a href="#" class="title-link">Shop Now<i
                    class="icon-long-arrow-right"></i></a>
        </div>

    </div>
    <div class="tab-content tab-content-carousel just-action-icons-sm">
        <div class="tab-pane p-0 fade show active" id="new-all-tab"
             role="tabpanel" aria-labelledby="new-all-link">
            <div
                    class="owl-carousel owl-full carousel-equal-height carousel-with-shadow"
                    data-toggle="owl"
                    data-owl-options='{
                                "nav": true, 
                                "dots": true,
                                "margin": 20,
                                "loop": false,
                                "responsive": {
                                    "0": {
                                        "items":2
                                    },
                                    "480": {
                                        "items":2
                                    },
                                    "768": {
                                        "items":3
                                    },
                                    "992": {
                                        "items":4
                                    },
                                    "1200": {
                                        "items":5
                                    }
                                }
                            }'>
                <c:forEach items="${product}" var="item">
                        <c:if test="${item.category.categoryCode eq 'lap-top'}">
                            <div class="product product-2"  data-id="${item.id}">
                                <figure class="product-media">
                                    <span class="product-label label-circle label-top">Top</span>
                                    <a href="<c:url value='/product/${item.id}'/>"> <img
                                            src="<c:url value='${item.imageModel.pathImageProduct}'/>"
                                            alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart btn-add" data-id="${item.id}" title="Add to cart"><span style="display: block">add
												to cart</span></a>
                                    </div>
                                    <!-- End .product-action -->
                                </figure>
                                <!-- End .product-media -->

                                <div class="product-body">
                                    <!-- End .product-cat -->
                                    <h3 class="product-title">
                                        <a href="<c:url value='/product/${item.id}'/>">${item.nameProduct}</a>
                                    </h3>
                                    <!-- End .product-title -->
                                    <div class="product-price">$${item.priceModel.productPrice}</div>
                                    <!-- End .product-price -->
                                </div>
                            </div>
                        </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<div class="mb-5"></div>
<div class="container new-arrivals">
    <div class="heading heading-flex mb-3">
        <div class="heading-left">
            <h2 class="title">Trending Accessories</h2>
            <!-- End .title -->
        </div>

        <div class="heading-right">
            <a href="#" class="title-link">Shop Now<i
                    class="icon-long-arrow-right"></i></a>
        </div>

    </div>
    <div class="tab-content tab-content-carousel just-action-icons-sm">
        <div class="tab-pane p-0 fade show active" id=""
             role="tabpanel" aria-labelledby="new-all-link">
            <div
                    class="owl-carousel owl-full carousel-equal-height carousel-with-shadow"
                    data-toggle="owl"
                    data-owl-options='{
                                "nav": true,
                                "dots": true,
                                "margin": 20,
                                "loop": false,
                                "responsive": {
                                    "0": {
                                        "items":2
                                    },
                                    "480": {
                                        "items":2
                                    },
                                    "768": {
                                        "items":3
                                    },
                                    "992": {
                                        "items":4
                                    },
                                    "1200": {
                                        "items":5
                                    }
                                }
                            }'>
                <c:forEach items="${product}" var="item">
                        <c:if test="${item.category.categoryCode eq 'phu-kien'}">
                            <div class="product product-2" data-id="${item.id}" >
                                <figure class="product-media">
                                    <span class="product-label label-circle label-top">Top</span>
                                    <a href="<c:url value='/product/${item.id}'/>"> <img
                                            src="<c:url value='${item.imageModel.pathImageProduct}'/>"
                                            alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart btn-add"  data-id="${item.id}" title="Add to cart"><span style="display: block">add
												to cart</span></a>
                                    </div>
                                    <!-- End .product-action -->
                                </figure>
                                <!-- End .product-media -->

                                <div class="product-body">
                                    <!-- End .product-cat -->
                                    <h3 class="product-title">
                                        <a href="<c:url value='/product/${item.id}'/>">${item.nameProduct}</a>
                                    </h3>
                                    <!-- End .product-title -->
                                    <div class="product-price">$${item.priceModel.productPrice}</div>
                                    <!-- End .product-price -->
                                </div>
                            </div>
                        </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<div class="container new-arrivals">
    <div class="heading heading-flex mb-3">
        <div class="heading-left">
            <h2 class="title">Trending Smart Watches</h2>
            <!-- End .title -->
        </div>

        <div class="heading-right">
            <a href="#" class="title-link">Shop Now<i
                    class="icon-long-arrow-right"></i></a>
        </div>

    </div>
    <div class="tab-content tab-content-carousel just-action-icons-sm">
        <div class="tab-pane p-0 fade show active" id="new-all-tab"
             role="tabpanel" aria-labelledby="new-all-link">
            <div
                    class="owl-carousel owl-full carousel-equal-height carousel-with-shadow"
                    data-toggle="owl"
                    data-owl-options='{
                                "nav": true,
                                "dots": true,
                                "margin": 20,
                                "loop": false,
                                "responsive": {
                                    "0": {
                                        "items":2
                                    },
                                    "480": {
                                        "items":2
                                    },
                                    "768": {
                                        "items":3
                                    },
                                    "992": {
                                        "items":4
                                    },
                                    "1200": {
                                        "items":5
                                    }
                                }
                            }'>
                <c:forEach items="${product}" var="item">
                        <c:if test="${item.category.categoryCode eq 'smart-watch'}">
                            <div class="product product-2" data-id="${item.id}" >
                                <figure class="product-media">
                                    <span class="product-label label-circle label-top">Top</span>
                                    <a href="<c:url value='/product/${item.id}'/>"> <img
                                            src="<c:url value='${item.imageModel.pathImageProduct}'/>"
                                            alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart btn-add" data-id="${item.id}" title="Add to cart"><span style="display: block">add
												to cart</span></a>
                                    </div>
                                    <!-- End .product-action -->
                                </figure>
                                <!-- End .product-media -->

                                <div class="product-body">
                                    <!-- End .product-cat -->
                                    <h3 class="product-title">
                                        <a href="<c:url value='/product/${item.id}'/>">${item.nameProduct}</a>
                                    </h3>
                                    <!-- End .product-title -->
                                    <div class="product-price">$${item.priceModel.productPrice}</div>
                                    <!-- End .product-price -->
                                </div>
                            </div>
                        </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<div class="mb-5"></div>

<div class="container new-arrivals">
    <div class="heading heading-flex mb-3">
        <div class="heading-left">
            <h2 class="title">Trending Televisions</h2>
            <!-- End .title -->
        </div>

        <div class="heading-right">
            <a href="#" class="title-link">Shop Now<i
                    class="icon-long-arrow-right"></i></a>
        </div>

    </div>
    <div class="tab-content tab-content-carousel just-action-icons-sm">
        <div class="tab-pane p-0 fade show active" id="new-all-tab"
             role="tabpanel" aria-labelledby="new-all-link">
            <div
                    class="owl-carousel owl-full carousel-equal-height carousel-with-shadow"
                    data-toggle="owl"
                    data-owl-options='{
                                "nav": true,
                                "dots": true,
                                "margin": 20,
                                "loop": false,
                                "responsive": {
                                    "0": {
                                        "items":2
                                    },
                                    "480": {
                                        "items":2
                                    },
                                    "768": {
                                        "items":3
                                    },
                                    "992": {
                                        "items":4
                                    },
                                    "1200": {
                                        "items":5
                                    }
                                }
                            }'>
                <c:forEach items="${product}" var="item">
                    <c:if test="${item.category.categoryCode eq 'tv'}">
                        <div class="product product-2" data-id="${item.id}">
                            <figure class="product-media">
                                <span class="product-label label-circle label-top">Top</span>
                                <a href="<c:url value='/product/${item.id}'/>"> <img
                                        src="<c:url value='${item.imageModel.pathImageProduct}'/>"
                                        alt="Product image" class="product-image">
                                </a>

                                <div class="product-action">
                                    <a href="#" class="btn-product btn-cart btn-add"  data-id="${item.id}" title="Add to cart"><span style="display: block">add
												to cart</span></a>
                                </div>
                                <!-- End .product-action -->
                            </figure>
                            <!-- End .product-media -->

                            <div class="product-body">
                                <!-- End .product-cat -->
                                <h3 class="product-title">
                                    <a href="<c:url value='/product/${item.id}'/>">${item.nameProduct}</a>
                                </h3>
                                <!-- End .product-title -->
                                <div class="product-price">$${item.priceModel.productPrice}</div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<div class="mb-5"></div>
<!-- End .mb-5 -->
<div class="container for-you">
    <div class="heading heading-flex mb-3">
        <div class="heading-left">
            <h2 class="title">Recommendation For You</h2>
            <!-- End .title -->
        </div>
        <!-- End .heading-left -->

        <div class="heading-right">
            <a href="#" class="title-link">Shop Now<i
                    class="icon-long-arrow-right"></i></a>
        </div>
        <!-- End .heading-right -->
    </div>
    <!-- End .heading -->

    <div class="products">
        <div class="row justify-content-center">
            <c:forEach items="${product}" var='item' begin="0" end="7">
              <c:if test="${item.isBestSaler == 1 || item.isHot == 1 || item.isNew == 1 || item.isSaleOff == 1}">
                  <div class="col-6 col-md-4 col-lg-3">
                      <div class="product product-2" data-id="${item.id}">
                          <figure class="product-media">
                              <a href="<c:url value='/product/${item.id}'/>"> <img
                                      src="<c:url value='${item.imageModel.pathImageProduct}'/>"
                                      alt="Product image" class="product-image">
                              </a>

                              <div class="product-action">
                                  <a href="#" class="btn-product btn-cart btn-add" data-id="${item.id}" title="Add to cart"><span >add
										to cart</span></a>
                              </div>
                              <!-- End .product-action -->
                          </figure>
                          <!-- End .product-media -->

                          <div class="product-body">
                              <h3 class="product-title">
                                  <a href="<c:url value='/product/${item.id}'/>">${item.nameProduct}</a>
                              </h3>
                              <!-- End .product-title -->
                              <div class="product-price">$${item.priceModel.productPrice}</div>
                              <!-- End .rating-container -->
                          </div>
                          <!-- End .product-body -->
                      </div>
                      <!-- End .product -->
                  </div>
              </c:if>
            </c:forEach>
            <!-- End .col-sm-6 col-md-4 col-lg-3 -->
        </div>
        <!-- End .row -->
    </div>
    <!-- End .products -->
</div>
<!-- End .container -->
<div class="icon-boxes-container bg-transparent">
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-lg-3">
                <div class="icon-box icon-box-side">
					<span class="icon-box-icon text-dark"> <i
                            class="icon-rocket"></i>
					</span>
                    <div class="icon-box-content">
                        <h3 class="icon-box-title">Free Shipping</h3>
                        <!-- End .icon-box-title -->
                        <p>Orders $50 or more</p>
                    </div>
                    <!-- End .icon-box-content -->
                </div>
                <!-- End .icon-box -->
            </div>
            <!-- End .col-sm-6 col-lg-3 -->

            <div class="col-sm-6 col-lg-3">
                <div class="icon-box icon-box-side">
					<span class="icon-box-icon text-dark"> <i
                            class="icon-rotate-left"></i>
					</span>

                    <div class="icon-box-content">
                        <h3 class="icon-box-title">Free Returns</h3>
                        <!-- End .icon-box-title -->
                        <p>Within 30 days</p>
                    </div>
                    <!-- End .icon-box-content -->
                </div>
                <!-- End .icon-box -->
            </div>
            <!-- End .col-sm-6 col-lg-3 -->

            <div class="col-sm-6 col-lg-3">
                <div class="icon-box icon-box-side">
					<span class="icon-box-icon text-dark"> <i
                            class="icon-info-circle"></i>
					</span>

                    <div class="icon-box-content">
                        <h3 class="icon-box-title">Get 20% Off 1 Item</h3>
                        <!-- End .icon-box-title -->
                        <p>when you sign up</p>
                    </div>
                    <!-- End .icon-box-content -->
                </div>
                <!-- End .icon-box -->
            </div>
            <!-- End .col-sm-6 col-lg-3 -->

            <div class="col-sm-6 col-lg-3">
                <div class="icon-box icon-box-side">
					<span class="icon-box-icon text-dark"> <i
                            class="icon-life-ring"></i>
					</span>

                    <div class="icon-box-content">
                        <h3 class="icon-box-title">We Support</h3>
                        <!-- End .icon-box-title -->
                        <p>24/7 amazing services</p>
                    </div>
                    <!-- End .icon-box-content -->
                </div>
                <!-- End .icon-box -->
            </div>
            <!-- End .col-sm-6 col-lg-3 -->
        </div>
        <!-- End .row -->
    </div>
    <!-- End .container -->
</div>


<!-- End .icon-boxes-container -->
