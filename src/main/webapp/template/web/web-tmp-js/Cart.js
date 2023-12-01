
function getCookie(name) {
    const cookies = document.cookie.split(';');
    for (let i = 0; i < cookies.length; i++) {
        const cookie = cookies[i].trim();
        if (cookie.startsWith(name + '=')) {
            return cookie.substring(name.length + 1);
        }
    }
    return null;
}

// Định nghĩa hàm để đặt cookies
function setCookie(name, value, days) {
    const expirationDate = new Date();
    expirationDate.setDate(expirationDate.getDate() + days);
    const cookieString = `${name}=${value}; expires=${expirationDate.toUTCString()}; path=/`;
    document.cookie = cookieString;
}

$(document).ready(function () {
    const dataCart = JSON.parse(getCookie('cart')) || {};
    let cartCount = $('.cart-count');
    if (Object.keys(dataCart).length !== 0) {
        cartCount.text(Object.keys(dataCart).length);
        loadCartAndRunAjax();
    } else {
        cartCount.text(0);
        renderTotalCart();
    }
});

$('.btn-add').on('click', function (event) {
    event.preventDefault();
    addToCartAndRunAjax($(this).data('id'));
});

function totalPrice(data) {
    let total = 0;
    for (let i = 0; i < data.length; i++) {
        total += data[i].totalPrice;
    }
    return total;
}

function loadCartAndRunAjax() {
    let dataCart = JSON.parse(getCookie('cart')) || {};
    let cartArray = Object.keys(dataCart);

    $.ajax({
        url: '/Ecommerce/api/cart',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(cartArray),
        dataType: 'json',
        success: function (response) {
            let data = response.map(item => ({
                id: item.id,
                nameProduct: item.nameProduct,
                description: item.description,
                pathImageProduct: item.imageModel.pathImageProduct,
                productPrice: item.priceModel.productPrice,
                quantity: dataCart[item.id] ? dataCart[item.id].quantity : 0,
                totalPrice: item.priceModel.productPrice * (dataCart[item.id] ? dataCart[item.id].quantity : 0)
            }));

            console.log(data);

            renderCart(data);
        },
        error: function (error) {
            console.error('Error:', error);
        }
    });
}

function addToCartAndRunAjax(productId) {
    let cart = JSON.parse(getCookie('cart')) || {};
    const cartCount = $('.cart-count');
    let cartItem = {
        id: productId, quantity: 1,
    };
    if (cart[cartItem.id]) {
        cart[cartItem.id].quantity += cartItem.quantity;
    } else {
        cart[cartItem.id] = cartItem;
        cartCount.text(Object.keys(cart).length);
    }
    $.toast({
        heading: 'Success',
        text: 'Thêm sản phẩm thành công.',
        showHideTransition: 'slide',
        icon: 'success',
        position: 'bottom-right'
    });
    setCookie('cart', JSON.stringify(cart), 30); // 30 days expiration
    loadCartAndRunAjax();
}

let renderCart = (data) => {
    const productContainer = $('#cartContainer');
    const totalContainer = $('#total-cart');
    let productCart = '';
    let totalCart = '';
    let totalPriceProduct = totalPrice(data);
    const maxHeight = Object.keys(data).length > 3 ? '260px' : 'none';
    const overflowY = Object.keys(data).length > 3 ? 'auto' : 'visible';

    productContainer.css({
        'max-height': maxHeight, 'overflow-y': overflowY
    });
    if (data) {
        $.each(data, (index, item) => {
            productCart += `<div class="cartContainer">
                            <div class="product">
                                <div class="product-cart-details">
                                    <h4 class="product-title">
                                        <a href="/Ecommerce/product/${item.id}">${item.nameProduct}</a>
                                    </h4>

                                    <span class="cart-product-info"> <span
                                            class="cart-product-qty">${item.quantity}</span> x $${item.productPrice}</span>
                                </div>

                                <figure class="product-image-container">
                                    <a href="/Ecommerce/product/${item.id}" class="product-image"> <img
                                            src="/Ecommerce${item.pathImageProduct}"
                                            alt="product">
                                    </a>
                                </figure>
                                <a href="#" class="btn-remove" title="Remove Product" onclick="remove(${item.id})" ><i
                                        class="icon-close"></i></a>
                            </div>
                        </div>`;
        })

        productContainer.html(productCart);

        totalCart += `
                        <div class="dropdown-cart-total">
                            <span>Total</span> <span class="cart-total-price">${totalPrice(data).toLocaleString()}</span>
                        </div>
                        <div class="dropdown-cart-action">
                            <a href="cart.html" class="btn btn-primary">View Cart</a> <a
                                href="checkout.html" class="btn btn-outline-primary-2"><span>Checkout</span><i
                                class="icon-long-arrow-right"></i></a>
                        </div>
                        `;
        totalContainer.html(totalCart);
    }
}

let remove = (id) => {
    const dataCart = JSON.parse(getCookie('cart')) || {};
    const cartCount = $('.cart-count');

    if (id in dataCart) {
        delete dataCart[id];
        setCookie('cart', JSON.stringify(dataCart), 30); // 30 days expiration
        loadCartAndRunAjax();
        cartCount.text(Object.keys(dataCart).length);
    }
}

let renderTotalCart = () => {
    const totalContainer = $('#total-cart');

    let totalCart = `<div class="dropdown-cart-total">
                            <span>Total</span> <span class="cart-total-price">0</span>
                        </div>
                        <div class="dropdown-cart-action">
                            <a href="cart.html" class="btn btn-primary">View Cart</a> <a
                                href="checkout.html" class="btn btn-outline-primary-2"><span>Checkout</span><i
                                class="icon-long-arrow-right"></i></a>
                        </div>`;
    totalContainer.html(totalCart);

}
