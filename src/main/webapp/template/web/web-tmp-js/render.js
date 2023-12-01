function loadData(data) {
    $.ajax({
        url: '/Ecommerce/api/products',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (products) {
            console.log(products)
            renderProducts(products);
        },
        error: function (error) {
            console.error("Error:", error);
        }
    });
}


function renderProducts(products) {
    const productsContainer = $('.products .row');
    let producHtml = '';

    if (products && products.length > 0) {
        $.each(products, function (index, item) {
            producHtml += `<div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                <div class="product product-7 text-center">
                                    <figure class="product-media">
                                        <a href="/product/${item.id}"> <img
                                                src="/Ecommerce${item.imageModel.pathImageProduct}"
                                                alt="${item.imageModel.desImage}" class="product-image">
                                        </a>
                                        <div class="product-action">
                                            <a href="#" class="btn-product btn-cart"><span>add
														to cart</span></a>
                                        </div>
                                    </figure>
                                    <div class="product-body">
                                        <div class="product-cat">
                                            <a href="/product/${item.id}">${item.category.categoryName}</a>
                                        </div>

                                        <h3 class="product-title">
                                            <a href="product/${item.id}">${item.nameProduct}</a>
                                        </h3>

                                        <div class="product-price">$${item.priceModel.productPrice}.0</div>

                                        <div class="ratings-container">
                                            <div class="ratings">
                                                <div class="ratings-val" style="width: 0%;"></div>
                                            </div>
                                            <span class="ratings-text">( 0 Reviews )</span>
                                        </div>
                                    </div>
                                </div>
                            </div>`;
        });
    }

    productsContainer.html(producHtml);
}

let loadSearchProduct = ()=>{
    $.ajax({
        url: '/Ecommerce/api/products',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (products) {
            console.log(products)
            renderProducts(products);
        },
        error: function (error) {
            console.error("Error:", error);
        }
    });
}
