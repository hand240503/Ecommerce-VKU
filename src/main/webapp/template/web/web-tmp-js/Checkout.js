let checkedIds = [];
$('.form-check-input').change(function () {
    let id = $(this).data('id');
    let dataCart = JSON.parse(getDecodedCookie('cart')) || {};

    if ($(this).is(':checked')) {
        checkedIds.push(id);
    } else {
        checkedIds.splice(checkedIds.indexOf(id), 1);
    }
    if (checkedIds.length > 0) {
        $.ajax({
            url: '/Ecommerce/api/cart',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(checkedIds),
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
                renderProductRows(data);
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });
    } else {
        renderProductRows([])
    }
});

function renderProductRows(products) {
    const tableBody = $("#productBody");


    tableBody.empty();


    let grandTotal = 0;

    $.each(products, function (index, product) {
        const row = $("<tr>");
        const nameCell = $("<td>").append($("<a>").attr("href", "#").text(product.nameProduct));
        const quantityCell = $("<td>").addClass("text-right").text(product.quantity);
        var total = parseFloat(product.totalPrice);
        const totalCell = $("<td>").text(`$${total.toFixed(2)}`);

        grandTotal += product.totalPrice;

        row.append(nameCell, quantityCell, totalCell);

        tableBody.append(row);
    });

    $("#subtotal").text(`$${grandTotal.toFixed(2)}`);
    $("#grandTotal").text(`$${grandTotal.toFixed(2)}`);
}


function calculateSubtotal(data) {
    let subtotal = 0;
    data.forEach(item => {
        subtotal += item.totalPrice;
    });
    return subtotal.toFixed(2);
}

$('.btn-order-product').on('click', async function (e) {
    e.preventDefault();
    let dataCart = JSON.parse(getDecodedCookie('cart')) || {};

    let selectedProvince = $("#province").val();
    let selectedDistrict = $("#district").val();
    let selectedWard = $("#ward").val();
    let address = $("#address").val().trim();
    let phone = $("#phone").val().trim();
    let description = $('#description').val().trim();
    if (checkedIds.length > 0) {

        if (selectedProvince !== "0" && selectedDistrict !== "0" && selectedWard !== "0" && address && phone) {
            let province = await fetchDataByType("p", selectedProvince);
            let district = await fetchDataByType("d", selectedDistrict);
            let ward = await fetchDataByType("w", selectedWard);
            let result = checkedIds.map((item) => {
                return {
                    id: item,
                    quantity: getQuantityByProductId(item, dataCart)
                };
            });

            let jsonData = JSON.stringify({
                address_01: province.name,
                address_02: district.name,
                address_03: ward.name,
                address_04: address,
                address_05: phone,
                ids: result,
                description: description
            });
            $.ajax({
                url: '/Ecommerce/api/orders',
                type: 'POST',
                contentType: 'application/json',
                data: jsonData,
                dataType: 'json',
                success: function (response) {
                    if (response) {
                        $.toast({
                            heading: 'Success',
                            text: 'Bạn đã mua hàng thành công.',
                            showHideTransition: 'slide',
                            icon: 'success',
                            position: 'bottom-right',
                            hideAfter: 2000,
                        });
                        var checkboxes = $('.form-check-input');
                        checkboxes.prop('checked', false);
                        result.forEach(item => {
                            removeProduct(item.id);
                        });
                        setTimeout(() => {
                            window.location.href = '/Ecommerce/trang-chu';
                        }, 2000);                    }
                },
                error: function (error) {
                    console.error('Error:', error);
                }
            });

        } else {
            $.toast({
                heading: 'Warning',
                text: 'Vui lòng điền đầy đủ thông tin.',
                position: 'top-right',
                loaderBg: '#ff6849',
                icon: 'warning',
                hideAfter: 3000,
            });

        }
    } else {
        $.toast({
            heading: 'Warning',
            text: 'Vui lòng chọn sản phẩm thanh toán.',
            position: 'top-right',
            loaderBg: '#ff6849',
            icon: 'warning',
            hideAfter: 3000,
        });

    }

})

const fetchDataByType = (endpoint, id) => {
    return new Promise((resolve, reject) => {
        const apiUrl = `https://provinces.open-api.vn/api/${endpoint}/${id}`;

        $.ajax({
            url: apiUrl, method: 'GET', success: function (data) {
                resolve(data);
            }, error: function (error) {
                console.error("Error fetching data:", error);
                reject(error);
            }
        });
    });
};

let removeProduct = (id) => {
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



                return;
            }
        }
    }
}