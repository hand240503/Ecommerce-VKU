const searchMenu = $('#search-menu');
const searchInput = $('#search-input');
const searchProductContainer = $('#dropdown-search');
let searchTimeout;

const handleSearchInput = () => {
    const inputValue = searchInput.val().trim();

    clearTimeout(searchTimeout);

    if (inputValue !== "") {
        searchTimeout = setTimeout(() => {
            const data = {
                param: inputValue
            };

            $.ajax({
                url: '/Ecommerce/api/search',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (response) {

                    showSearchMenu();
                    renderSearch(response);
                },
                error: function (error) {
                    console.error("Error:", error);
                }
            });
        }, 1000);
    } else {
        hideSearchMenu();
    }
};

const showSearchMenu = () => {
};

const hideSearchMenu = () => {
    searchMenu.css('display', 'none');
};

const renderSearch = (data) => {
    let productHtml = '';
    if (data && data.length > 0) {
        searchMenu.css('display', 'block');
        $.each(data, function (index, item) {
            productHtml += `
                <div class="product d-flex" style="width: 570px">
                    <figure class="product-image-container mt-1 ml-2">
                        <a href="/Ecommerce/product/${item.id}" class="product-image">
                            <img style="width: 70px; height: 70px" src="/Ecommerce${item.imageModel.pathImageProduct}" alt="${item.imageModel.desImage}">
                        </a>
                    </figure>
                    <div class="product-cart-details d-flex flex-column justify-content-center ml-3">
                        <h4 class="product-title">
                            <a href="/Ecommerce/product/${item.id}">${item.nameProduct}</a>
                        </h4>
                        <span class="product-title"> x $${item.priceModel.productPrice}.0</span>
                    </div>
                </div>`;
        });
    }
    searchProductContainer.html(productHtml);

};

searchInput.on('input', handleSearchInput);
