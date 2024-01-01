<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<header class="header header-intro-clearance header-4">
    <div class="header-top">
        <div class="container">
            <div class="header-left">
                <a href="#"><i class="icon-phone"></i>Call: +0123 456 789</a>
            </div>
            <div class="header-right">
                <ul class="top-menu p-3">
                    <li>
                        <ul>
                            <c:if test="${ empty user }">
                                <li>
                                    <a href="<c:url value="/account?action=login"/>">Sign in</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/account?action=signup"/>">Sign up</a>
                                </li>
                            </c:if>
                            <c:if test="${ not empty user }">
                                <li>
                                    <div class="header-dropdown">
                                        <a href="#">Xin chào bạn : ${user.lastName } ${user.firstName}</a>
                                        <div class="header-menu">
                                            <ul>
                                                <li><a href="<c:url value="/orders"/>">Đơn hàng của tôi</a></li>
                                                <li><a href="<c:url value="/user?t=view"/>">Tài khoản của tôi</a></li>

                                                <c:if test="${user.role eq 1}">
                                                    <li><a href="<c:url value="/admin-home"/>">Trang Admin</a></li>
                                                </c:if>
                                                <li><a href="<c:url value="/account?action=logout"/>">Đăng Xuất</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </li>
                            </c:if>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="header-middle">
        <div class="container">
            <div class="header-left">
                <button class="mobile-menu-toggler">
                    <span class="sr-only">Toggle mobile menu</span> <i
                        class="icon-bars"></i>
                </button>

                <a href="<c:url value="/trang-chu" />" class="logo"> <img
                        src="<c:url value='/template/web/images/demos/demo-4/logo.png'/>"
                        alt="Molla Logo" width="105" height="25">
                </a>
            </div>
            <div class="header-center">
                <div
                        class="header-search header-search-extended header-search-visible d-none d-lg-block">
                    <a href="#" class="search-toggle" role="button"><i
                            class="icon-search"></i></a>
                    <div class="header-search-wrapper search-wrapper-wide">
                        <label for="search-input" class="sr-only">Search</label>
                        <button class="btn btn-primary" type="submit">
                            <i class="icon-search"></i>
                        </button>
                        <input type="text" class="form-control search-input" id="search-input" autocomplete="off"
                               oninput="handleSearchInput()"
                               placeholder="Search product ..." required>
                    </div>
                    <div class="dropdown-menu dropdown-menu-left shadow" id="search-menu">
                        <div class="dropdown-search" id="dropdown-search">

                        </div>
                    </div>
                </div>
            </div>

            <div class="header-right">
                <div class="dropdown cart-dropdown" id="cart-dropdown">
                    <a href="#" class="dropdown-toggle" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                       data-display="static">
                        <div class="icon">
                            <i class="icon-shopping-cart"></i> <span class="cart-count"></span>
                        </div>
                        <p>Cart</p>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right shadow" id="dropdownMenuCart">
                        <div id="cartContainer" style=" padding: 0px 10px 0 0;">

                        </div>
                        <div id="total-cart">

                        </div>

                    </div>
                    <!-- End .dropdown-menu -->
                </div>

            </div>
            <!-- End .header-right -->
        </div>
        <!-- End .container -->
    </div>
    <!-- End .header-middle -->

    <div class="header-bottom sticky-header">
        <div class="container">
            <div class="header-left">
                <div class="dropdown category-dropdown">
                    <a href="#" class="dropdown-toggle" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                       data-display="static" title="Browse Categories"> Browse
                        Categories <i class="icon-angle-down"></i>
                    </a>

                    <div class="dropdown-menu">
                        <nav class="side-nav">
                            <ul class="menu-vertical sf-arrows">
                                <c:forEach items="${category}" var="cate">
                                    <li class="item-lead"><a
                                            href="<c:url value='/products?code=${cate.categoryCode }&page=1'/>">${cate.categoryName}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                            <!-- End .menu-vertical -->
                        </nav>
                        <!-- End .side-nav -->
                    </div>
                    <!-- End .dropdown-menu -->
                </div>
                <!-- End .category-dropdown -->
            </div>
            <!-- End .header-left -->

            <div class="header-center">
                <nav class="main-nav">
                    <ul class="menu">
                        <li class="megamenu-container"><a
                                href="<c:url value="/trang-chu" />" class="">Home</a></li>
                        <li class="megamenu-container"><a
                                href="<c:url value="/cart" />" class="">Giỏ hàng</a></li>
                        <li class="megamenu-container"><a
                                href="<c:url value="/orders"/>" class="">Đơn hàng</a></li>
                    </ul>
                    <!-- End .menu -->
                </nav>
                <!-- End .main-nav -->
            </div>
            <!-- End .header-center -->
        </div>
        <!-- End .container -->
    </div>
    <!-- End .header-bottom -->
</header>

