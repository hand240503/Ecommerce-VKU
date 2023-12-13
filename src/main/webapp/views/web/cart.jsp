<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<main class="main">
    <div class="page-header text-center"
         style="background-image: url(/Ecommerce/template/web/images/page-header-bg.jpg)">
        <div class="container">
            <h1 class="page-title">Shopping Cart<span>Shop</span></h1>
        </div>
    </div>
    <nav aria-label="breadcrumb" class="breadcrumb-nav">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Shop</a></li>
                <li class="breadcrumb-item active" aria-current="page">Shopping Cart</li>
            </ol>
        </div>
    </nav>
    <div class="page-content">
        <div class="cart">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <table class="table table-cart table-mobile">
                            <thead>
                            <tr>
                                <th></th>
                                <th>Product</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th></th>
                                <th></th>

                            </tr>
                            </thead>

                            <tbody class="body-table" id="productTableBody">
                            <c:if test="${not empty product}">
                                <c:forEach var="item" items="${product}">
                                    <tr data-id="${item.id}">
                                        <td class="price-col">
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value=""
                                                       data-id="${item.id}"
                                                       id="flexCheckDefault">
                                                <label class="form-check-label" for="flexCheckDefault">
                                                </label>
                                            </div>
                                        </td>
                                        <td class="product-col">
                                            <div class="product">
                                                <figure class="product-media">
                                                    <a href="#">
                                                        <img src="<c:url value="${item.url}"/>" alt="Product image">
                                                    </a>
                                                </figure>

                                                <h3 class="product-title">
                                                    <a href="#">${item.nameProduct}</a>
                                                </h3>
                                            </div>
                                        </td>
                                        <td class="price-col">$${item.price}</td>
                                        <td class="quantity-col">
                                            <div class="cart-product-quantity">
                                                <input type="number" class="form-control form-quantity quantity-input"
                                                       data-id="${item.id}" value="${item.quantity}" min="1" max="100"
                                                       step="1" data-decimals="0" required>
                                            </div>
                                        </td>
                                        <td class="total-col">${item.total}</td>
                                        <td class="remove-col pr-5">
                                            <button class="btn-remove btn-remove-product" data-id="${item.id}"><i
                                                    class="icon-close"></i></button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-lg-12">
                        <form action="#">
                            <div class="row">
                                <div class="col-lg-8">
                                    <h2 class="checkout-title">Billing Details</h2>

                                    <div class="row">
                                        <div class="col-sm-4">
                                            <label>Tỉnh/Thành phố *</label>
                                            <select id="province" class="form-select form-select-sm form-control"
                                                    aria-label=".form-select-sm example">
                                                <option selected value="0">Chọn tỉnh/thành phố</option>
                                            </select>
                                        </div>

                                        <div class="col-sm-4">
                                            <label>Quận/Huyện *</label>
                                            <select id="district" class="form-select form-select-sm form-control"
                                                    aria-label=".form-select-sm example">
                                                <option selected value="0">Chọn quận/huyện</option>
                                            </select>
                                        </div>

                                        <div class="col-sm-4">
                                            <label>Phường/Xã *</label>
                                            <select id="ward" class="form-select form-select-sm form-control"
                                                    aria-label=".form-select-sm example">
                                                <option selected value="0">Chọn phường/xã</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <label>Địa chỉ nhà *</label>
                                            <input type="text" class="form-control" id="address" >
                                        </div>
                                        <div class="col-sm-6">
                                            <label>Số điện thoại *</label>
                                            <input type="text" class="form-control" id="phone" value="${user.phoneNumber}"
                                                   >
                                        </div>
                                    </div>
                                    <label>Order notes (optional)</label>
                                    <textarea id="description" class="form-control" cols="30" rows="4"
                                              placeholder="Notes about your order, e.g. special notes for delivery"></textarea>
                                </div><!-- End .col-lg-9 -->
                                <aside class="col-lg-4">
                                    <div class="summary">
                                        <h3 class="summary-title">Your Order</h3><!-- End .summary-title -->

                                        <table class="table table-summary">
                                            <thead>
                                            <tr>
                                                <th>Product</th>
                                                <th class="text-right">Quantity</th>
                                                <th>Total</th>
                                            </tr>
                                            </thead>

                                            <tbody id="productBody">

                                            </tbody>
                                            <tfoot>
                                            <tr class="summary-subtotal">
                                                <td>Subtotal:</td>
                                                <td></td>
                                                <td id="subtotal" class="text-right">$0.00</td>
                                            </tr>
                                            <tr>
                                                <td>Shipping:</td>
                                                <td></td>
                                                <td class="text-right">Free shipping</td>
                                            </tr>
                                            <tr class="summary-total">
                                                <td>Total:</td>
                                                <td></td>
                                                <td id="grandTotal" class="text-right">$0.00</td>
                                            </tr><!-- End .summary-total -->
                                            </tfoot>
                                        </table>


                                        <button type="submit"
                                                class="btn btn-outline-primary-2 btn-order btn-order-product btn-block">
                                            <span class="btn-text">Place Order</span>
                                            <span class="btn-hover-text">Proceed to Checkout</span>
                                        </button>
                                    </div>
                                </aside>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>