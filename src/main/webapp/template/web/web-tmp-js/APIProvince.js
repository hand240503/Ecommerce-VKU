if (window.location.href.includes("cart")) {
    const host = "https://provinces.open-api.vn/api/";
    var callAPI = (api) => {
        return axios.get(api)
            .then((response) => {
                renderData(response.data, "province", 'Chọn tỉnh/thành phố');
            });
    }
    callAPI('https://provinces.open-api.vn/api/?depth=1');
    var callApiDistrict = (api) => {
        return axios.get(api)
            .then((response) => {
                renderData(response.data.districts, "district",'Chọn quận/huyện');
            });
    }
    var callApiWard = (api) => {
        return axios.get(api)
            .then((response) => {
                renderData(response.data.wards, "ward",'Chọn phường/xã');
            });
    }

    var renderData = (array, select, text) => {
        let row = `<option disabled value="">${text}</option>`;
        array.forEach(element => {
            row += `<option value="${element.code}">${element.name}</option>`;
        });
        document.querySelector("#" + select).innerHTML = row;
    }

    $("#province").change(() => {
        callApiDistrict(host + "p/" + $("#province").val() + "?depth=2");
    });
    $("#district").change(() => {
        callApiWard(host + "d/" + $("#district").val() + "?depth=2");

    });
    $("#ward").change(() => {

    })

}
