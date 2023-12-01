$(document).ready(function () {
    $('#signin').click(function () {
        let userName = $('#userName').val();
        let password = $('#password').val();

        if (userName === '' || password === '') {
            return;
        }

        let data = {
            userName: userName,
            password: password
        }

        $.ajax({
            type: 'POST',
            url: '/Ecommerce/login',
            data: data,
            success: function (result) {
                console.log('ok');
            },
            error: function (error) {
                console.log('not ok');
            }
        });
    });
});