function getDecodedCookie(name) {
    const encodedValue = getCookie(name);
    if (encodedValue !== null) {
        return atob(encodedValue);
    }
    return null;
}

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

function setCookie(name, value, days) {
    value = validateAndClean(value);
    const encodedValue = btoa(value);

    const expirationDate = new Date();
    expirationDate.setDate(expirationDate.getDate() + days);

    const cookieString = `${name}=${encodedValue}; expires=${expirationDate.toUTCString()}; path=/`;

    document.cookie = cookieString;
}


$(document).ready(function () {
    const dataCart = JSON.parse(getDecodedCookie('cart')) || {};
    let cartCount = $('.cart-count');
    if (Object.keys(dataCart).length !== 0) {
        cartCount.text(getTotalQuantity(dataCart));
        loadCartAndRunAjax();
    } else {
        cartCount.text(getTotalQuantity(dataCart));
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
    return total.toFixed(2);
}

function loadCartAndRunAjax() {
    let dataCart = JSON.parse(getDecodedCookie('cart')) || {};
    let listIds = [];

    for (let userId in dataCart) {
        if (dataCart.hasOwnProperty(userId)) {
            let userCart = dataCart[userId].cartItems;
            listIds = listIds.concat(userCart.map(item => item.id));
        }
    }

    $.ajax({
        url: '/Ecommerce/api/cart',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(listIds),
        dataType: 'json',
        success: function (response) {
            let data = response.map(item => {
                let quantity = getQuantityByProductId(item.id, dataCart);

                return {
                    id: item.id,
                    nameProduct: item.nameProduct,
                    description: item.description,
                    pathImageProduct: item.imageModel.pathImageProduct,
                    productPrice: item.priceModel.productPrice,
                    quantity: quantity,
                    totalPrice: item.priceModel.productPrice * quantity,
                };
            });
            renderCart(data);
        },
        error: function (error) {
            console.error('Error:', error);
        }
    });


}

function getUserIdByProductId(productId, dataCart) {
    for (let userId in dataCart) {
        if (dataCart.hasOwnProperty(userId)) {
            let userCart = dataCart[userId].cartItems;
            if (userCart.some(item => item.id === productId)) {
                return userId;
            }
        }
    }
    return null;
}

function getQuantityByProductId(productId, dataCart) {
    for (let userId in dataCart) {
        if (dataCart.hasOwnProperty(userId)) {
            let userCart = dataCart[userId].cartItems;
            let item = userCart.find(item => item.id === productId);
            if (item) {
                return item.quantity;
            }
        }
    }
    return 0;
}

function addToCartAndRunAjax(productId, userId) {
    let dataCart = JSON.parse(getDecodedCookie('cart')) || {};
    const cartCount = $('.cart-count');
    userId = userId || 0;

    if (!dataCart[userId]) {
        dataCart[userId] = {
            userId: userId,
            cartItems: []
        };
    }

    const userCart = dataCart[userId].cartItems;
    const existingCartItem = userCart.find(item => item.id === productId);

    if (existingCartItem) {
        existingCartItem.quantity += 1;
        cartCount.text(getTotalQuantity(dataCart));
    } else {
        userCart.push({
            id: productId,
            quantity: 1
        });
        cartCount.text(getTotalQuantity(dataCart));
    }

    $.toast({
        heading: 'Success',
        text: 'Thêm sản phẩm thành công.',
        showHideTransition: 'slide',
        icon: 'success',
        position: 'bottom-right'
    });

    setCookie('cart', JSON.stringify(dataCart), 30);
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
                                <a href="#" class="btn-remove btn-remove-cart" title="Remove Product" data-id="${item.id}" onclick="remove(${item.id})" ><i
                                        class="icon-close"></i></a>
                            </div>
                        </div>`;
        })

        productContainer.html(productCart);

        totalCart += `
                        <div class="dropdown-cart-total">
                            <span>Total</span> <span class="cart-total-price">$${totalPrice(data)}</span>
                        </div>
                        <div class="dropdown-cart-action">
                            <a href="/Ecommerce/cart" class="btn btn-primary">View Cart</a> 
                        </div>
                        `;
        totalContainer.html(totalCart);
    }
}

function getTotalQuantity(dataCart) {
    let totalQuantity = 0;

    for (let userId in dataCart) {
        if (dataCart.hasOwnProperty(userId)) {
            let userCart = dataCart[userId].cartItems;

            if (userCart && userCart.length > 0) {
                totalQuantity += userCart.reduce((acc, item) => acc + item.quantity, 0);
            }
        }
    }

    return totalQuantity;
}

let remove = (id) => {
    const dataCart = JSON.parse(getDecodedCookie('cart')) || {};
    const cartCount = $('.cart-count');

    for (let userId in dataCart) {
        if (dataCart.hasOwnProperty(userId)) {
            let userCart = dataCart[userId].cartItems;
            let indexToRemove = userCart.findIndex(item => item.id === id);

            if (indexToRemove !== -1) {
                userCart.splice(indexToRemove, 1);

                if (userCart.length === 0) {

                    delete dataCart[userId];
                }

                setCookie('cart', JSON.stringify(dataCart), 30);
                loadCartAndRunAjax();
                cartCount.text(getTotalQuantity(dataCart));

                $.toast({
                    heading: 'Success',
                    text: 'Xóa sản phẩm thành công.',
                    showHideTransition: 'slide',
                    icon: 'success',
                    position: 'bottom-right'
                });

                return;
            }
        }
    }
}


let renderTotalCart = () => {
    const totalContainer = $('#total-cart');

    let totalCart = `<div class="dropdown-cart-total">
                            <span>Total</span> <span class="cart-total-price">0</span>
                        </div>
                        <div class="dropdown-cart-action">
                            <a href="/Ecommerce/cart" class="btn btn-primary">View Cart</a>
                        </div>`;
    totalContainer.html(totalCart);

}

function validateAndClean(jsonStr) {

    const data = JSON.parse(jsonStr);

    for (const userId in data) {
        if (data[userId].hasOwnProperty('cartItems')) {
            data[userId].cartItems = data[userId].cartItems.filter(item =>
                item.hasOwnProperty('id') && item.hasOwnProperty('quantity')
            );
        }
    }
    const cleanedJson = JSON.stringify(data);
    return cleanedJson;
}


