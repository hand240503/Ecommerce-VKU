<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<c:url value="/admin-home"/>">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin-home"/>">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Home</span></a>
    </li>



    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item active">
        <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true"
           aria-controls="collapsePages">
            <i class="fas fa-fw fa-folder"></i>
            <span>Mangement</span>
        </a>
        <div id="collapsePages" class="collapse show" aria-labelledby="headingPages"
             data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Orders</h6>
                <a class="collapse-item" href="<c:url value="/admin-orders?type=confirmed"/>">Orders Confirmed</a>
                <a class="collapse-item" href="<c:url value="/admin-orders?type=unconfirmed"/>">Orders UnConfirmed</a>

                <div class="collapse-divider"></div>
                <h6 class="collapse-header">Product</h6>
                <a class="collapse-item" href="<c:url value="/admin-products?page=1"/>">List Product</a>
                <a class="collapse-item" href="404.html">Add Product</a>
            </div>
        </div>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>