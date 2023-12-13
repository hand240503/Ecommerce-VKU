$(document).ready(function () {
    let validateInput = (e) => {
        const inputValue = e.currentTarget.value;
        const sanitizedValue = inputValue.replace(/[^0-9]/g, '');
        if (sanitizedValue !== inputValue) {
            e.currentTarget.value = sanitizedValue || 1;
        }
    }

    $('.form-quantity').on('input', validateInput);
    $('.btn-addToCart').on('click', (e) => {
        e.preventDefault();

        let quantity = $('#qty').val();

        const productId = $('.btn-addToCart').data('id');
        if (quantity === undefined || quantity === null || quantity === '' || parseInt(quantity) === 0) {
            quantity = 1;
        }
        addToCart(productId, quantity);
    });


    let addToCart = (productId, quantity, userId) => {
        let cart = JSON.parse(getDecodedCookie('cart')) || {};
        const cartCount = $('.cart-count');
        userId = userId || 0;

        if (!cart[userId]) {
            cart[userId] = {
                userId: userId,
                cartItems: []
            };
        }

        const userCart = cart[userId].cartItems;
        const existingCartItem = userCart.find(item => item.id === productId);

        if (existingCartItem) {
            if (quantity === undefined || quantity === null || quantity === 1) {
                quantity = 1;
            }
            existingCartItem.quantity += parseInt(quantity ?? 1);

        } else {
            userCart.push({
                id: productId,
                quantity: parseInt(quantity ?? 1)
            });

        }

        $.toast({
            heading: 'Success',
            text: 'Thêm sản phẩm thành công.',
            showHideTransition: 'slide',
            icon: 'success',
            position: 'bottom-right'
        });
        cartCount.text(getTotalQuantity(cart));
        setCookie('cart', JSON.stringify(cart), 30);
        loadCartAndRunAjax();
    };

    $('.btn-remove-product').on('click', function () {
        var itemId = $(this).data('id');

        $('tr[data-id="' + itemId + '"]').remove();
        remove(itemId)
        let cart = JSON.parse(getDecodedCookie('cart')) || {};
        renderCart(cart);
    });

    $('.quantity-input').on('input', function () {
        let quantity = parseInt($(this).val());
        quantity = Math.min(Math.max(quantity || 1, 1), 100);
        $(this).val(quantity);
        let totalColumn = $(this).closest('tr').find('.total-col');
        let productId = $(this).data('id');
        let userId = 0;

        let cart = JSON.parse(getDecodedCookie('cart')) || {};
        const cartCount = $('.cart-count');

        if (!cart[userId]) {
            cart[userId] = {
                userId: userId,
                cartItems: []
            };
        }

        const userCart = cart[userId].cartItems;
        const existingCartItem = userCart.find(item => item.id === productId);

        if (existingCartItem) {
            existingCartItem.quantity = quantity;
        } else {
            userCart.push({
                id: productId,
                quantity: quantity
            });
        }

        cartCount.text(getTotalQuantity(cart));
        setCookie('cart', JSON.stringify(cart), 30);

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
                data.map(item => {
                    if (productId === item.id) {
                        totalColumn.text(item.totalPrice)
                        return;
                    }
                })
                renderCart(data);
                let checkedCheckboxes = $('.form-check-input:checked');

                let checkedIds = checkedCheckboxes.map(function () {
                    return $(this).data('id');
                }).get();

                if (checkedIds.length > 0) {
                    let checkedItems = data.filter(item => checkedIds.includes(item.id));
                    renderProductRows(checkedItems);
                }
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });
    });
})



