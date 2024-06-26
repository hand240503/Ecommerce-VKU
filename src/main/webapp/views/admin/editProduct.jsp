<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Cập nhật sản phẩm</h6>
    </div>
    <c:set var="product" value="${product}" />
    <form class="card-body" id="form-add-product" action="<c:url value="/admin-products?t=edit&i=${product.id}"/>" enctype="multipart/form-data" method="POST">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="nameProduct" name="nameProduct" placeholder="Name Product" value="${product.nameProduct}">
            <label for="nameProduct">Tên sản phẩm</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="description" name="description" placeholder="Description" value="${product.description}">
            <label for="description">Description</label>
        </div>
        <input type="hidden" id="image" name="image" value="${product.imageModel.id}">

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="price" name="price" placeholder="Price" value="${product.priceModel.productPrice}" >
            <label for="description">Giá Tiền</label>
        </div>

        <img id="previewImage"
             src="<c:url value="${product.imageModel.pathImageProduct}"/>"
             class="img-fluid" alt="Responsive image" style="height: 218px ; width: 218px">

        <div class="mb-3">
            <label for="formFile" class="form-label">Hình ảnh</label>
            <input class="form-control" name="fileUpload" type="file" id="formFile">
        </div>


        <select class="form-select" aria-label="Đơn vị sản phẩm" id="form-select-unit">
            <option value="0">Đơn vị sản phẩm</option>
            <c:forEach var="item" items="${unit}">
                <c:set var="isSelected" value="${product.unitModel.id eq item.id ? 'selected' : ''}" />
                <option value="${item.id}" ${isSelected}>${item.nameUnit}</option>
            </c:forEach>
        </select>


        <select class="form-select mb-3" id="form-select-category" aria-label="Danh mục sản phẩm">
            <option selected value="0">Danh mục sản phẩm</option>
            <c:forEach var="item" items="${category}">
                <c:set var="isSelected" value="${product.category.categoryCode eq item.categoryCode}" />
                <option value="${item.id}" data-code="${item.categoryCode}" <c:if test="${isSelected}">selected</c:if>>${item.categoryName}</option>
            </c:forEach>
        </select>


        <select class="form-select" aria-label="Thương hiệu sản phẩm" id="brandSelect">
            <option value="0">Thương hiệu sản phẩm</option>
            <c:forEach var="item" items="${brand}">
                <c:set var="isSelected" value="${product.idBrand eq item.id ? 'selected' : ''}" />
                <option value="${item.id}" ${isSelected}>${item.nameBrand}</option>
            </c:forEach>
        </select>

        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="isBestSeller" ${product.isBestSaler eq 1 ? 'checked' : ''}>
            <label class="form-check-label" for="isBestSeller">
                Sản phẩm Best Seller
            </label>
        </div>

        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="isHot" ${product.isHot eq 1 ? 'checked' : ''}>
            <label class="form-check-label" for="isHot">
                Sản phẩm Bán chạy
            </label>
        </div>

        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="isSaleOff" ${product.isSaleOff eq 1 ? 'checked' : ''}>
            <label class="form-check-label" for="isSaleOff">
                Sản phẩm Giảm Giá
            </label>
        </div>

        <div class="form-check  mb-3">
            <input class="form-check-input" type="checkbox" value="" id="isNew" ${product.isNew eq 1 ? 'checked' : ''}>
            <label class="form-check-label" for="isNew">
                Sản phẩm Mới
            </label>
        </div>


        <button type="submit" class="btn btn-primary" id="btnSubmit">Cập nhật sản phẩm</button>
        <input type="hidden" id="selectedUnit" name="unit" value="${product.unitModel.id}">
        <input type="hidden" id="selectedCategory" name="category" value="${product.category.id}">
        <input type="hidden" id="selectedBrand" name="brand" value="${product.idBrand}">

        <input type="hidden" id="isBestSellerValue" name="isBestSellerValue" value="${product.isBestSaler == 1 ? 'true' : 'false'}">
        <input type="hidden" id="isHotValue" name="isHotValue" value="${product.isHot == 1 ? 'true' : 'false'}">
        <input type="hidden" id="isSaleOffValue" name="isSaleOffValue" value="${product.isSaleOff == 1 ? 'true' : 'false'}">
        <input type="hidden" id="isNewValue" name="isNewValue" value="${product.isNew == 1 ? 'true' : 'false'}">

        <input type="hidden" id="id" name="iParam" value="${product.id}">
        <input type="hidden" id="type" name="action" value="edit">
        <input type="hidden" id="idPrice" name="idPrice" value="${product.priceModel.id}">



    </form>
</div>
<script>
    $(document).ready(function () {
        $('#formFile').change(function () {
            var input = this;
            var allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;
            if (!allowedExtensions.exec(input.value)) {
                alert('Chỉ cho phép tải lên các tệp có định dạng JPG, JPEG hoặc PNG.');
                $(this).val('');
                $('#previewImage').attr('src', 'data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22200%22%20height%3D%22200%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20200%20200%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_18ca6c425d7%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A10pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_18ca6c425d7%22%3E%3Crect%20width%3D%22200%22%20height%3D%22200%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2274.42499923706055%22%20y%3D%22104.55999994277954%22%3E200x200%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E');
                return false;
            }

            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#previewImage').attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        });

        $('#form-select-category').change(function (e) {
            let selectedValue = $(this).val();
            if (selectedValue !== '0') {
                let dataCode = $(this).find("option:selected").data("code");
                $.ajax({
                    url: '/Ecommerce/api/category',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(dataCode),
                    dataType: 'json',
                    success: function (data) {
                        load(data)
                    },
                    error: function (error) {
                        console.error("Error calling API: ", error);
                    }
                });
            } else {
                $('#brandSelect').empty();
                $('#brandSelect').append('<option>' + "Thương hiệu sản phẩm" + '</option>');
            }

        })
        $("#formFile").change(function () {
            var fileName = $(this).val().split('\\').pop();

            $("#fileNameInput").val(fileName);
            console.log("File Name:", fileName);
        });

        $('#form-add-product').submit(function(e){
            let nameProduct = $('#nameProduct').val().trim();
            let description = $('#description').val().trim();
            let price = $('#price').val().trim();
            let category = $("#form-select-category").val().trim();
            let brand = $("#brandSelect").val().trim();
            let unit = $("#form-select-unit").val().trim();

            if (isNaN(price)) {
                $.toast({
                    heading: 'Lỗi',
                    text: 'Giá không phải là số.',
                    showHideTransition: 'slide',
                    icon: 'error',
                    position: 'top-right'
                });
                e.preventDefault();

            }
            if (!nameProduct || !description || !price || unit === "0" || brand === "0" || category === "0" || unit === undefined || brand === undefined || category === undefined) {
                $.toast({
                    heading: 'Lỗi',
                    text: 'Vui lòng nhập đầy đủ thông tin và chọn file.',
                    showHideTransition: 'slide',
                    icon: 'error',
                    position: 'top-right'
                });
                e.preventDefault();
            }



        })

        function load(data) {
            $('#brandSelect').empty();
            $('#brandSelect').append('<option value="0">Thương hiệu sản phẩm</option>');
            $.each(data, function (index, brand) {
                $('#brandSelect').append('<option value="' + brand.id + '">' + brand.nameBrand + '</option>');
            });
        }

        function updateSelectedValue(selectId, hiddenFieldId) {
            var selectedValue = $("#" + selectId).val();

            $("#" + hiddenFieldId).val(selectedValue);
        }

        $("#form-select-unit").change(function() {
            updateSelectedValue("form-select-unit", "selectedUnit");
        });

        $("#form-select-category").change(function() {
            updateSelectedValue("form-select-category", "selectedCategory");
        });

        $("#brandSelect").change(function() {
            updateSelectedValue("brandSelect", "selectedBrand");
        });

        function updateCheckboxValue(checkboxId, hiddenFieldId) {
            var isChecked = $("#" + checkboxId).prop("checked");

            $("#" + hiddenFieldId).val(isChecked);
        }

        $("#isHot").change(function() {
            updateCheckboxValue("isHot", "isHotValue");
        });

        $("#isSaleOff").change(function() {
            updateCheckboxValue("isSaleOff", "isSaleOffValue");
        });

        $("#isNew").change(function() {
            updateCheckboxValue("isNew", "isNewValue");
        });

        $("#isBestSeller").change(function() {
            updateCheckboxValue("isBestSeller", "isBestSellerValue");
        });
    });
</script>
