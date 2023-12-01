$(document).ready(function () {
    let validateInput = (e) => {
        const inputValue = e.currentTarget.value;
        const sanitizedValue = inputValue.replace(/[^0-9]/g, '');
        if (sanitizedValue !== inputValue) {
            e.currentTarget.value = sanitizedValue;
        }
    }

    $('.form-quantity').on('input', validateInput);

    $('.btn-addToCart').on('click', (e) => {
        e.preventDefault();
        const quantity = $('#qty').val();
        const productId = $('.btn-addToCart').data('id')
        addToCart(productId, quantity);
    })

    // Hàm để lấy giá trị của cookie
    let getCookie = (name) => {
        const value = `; ${document.cookie}`;
        const parts = value.split(`; ${name}=`);
        if (parts.length === 2) return parts.pop().split(';').shift();
    }

    // Hàm để đặt giá trị vào cookie
    let setCookie = (name, value, days) => {
        const expirationDate = new Date();
        expirationDate.setTime(expirationDate.getTime() + (days * 24 * 60 * 60 * 1000));
        const expires = `expires=${expirationDate.toUTCString()}`;
        document.cookie = `${name}=${value}; ${expires}; path=/`;
    }

    let addToCart = (productId, quantity) => {
        let cart = JSON.parse(getCookie('cart')) || {}; // Lấy giá trị từ cookie thay vì localStorage
        const cartCount = $('.cart-count');
        let cartItem = {
            id: productId, quantity: parseInt(quantity),
        };

        if (cart[cartItem.id]) {
            cart[cartItem.id].quantity += parseInt(quantity);
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

        setCookie('cart', JSON.stringify(cart), 7);

        loadCartAndRunAjax();
    }
})