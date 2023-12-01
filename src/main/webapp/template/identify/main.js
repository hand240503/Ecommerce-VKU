$(document).ready(function () {
    const btnBackToLogin = $('#btn-back-login');
    btnBackToLogin.click(function () {
        window.location.href = "/Ecommerce/account?action=login";
    })

    Validator({
        form: '#identify-form',
        formGroupSelector: '.form-group',
        errorSelector: '.message',
        rules: [
            Validator.isRequired('#username-for-pass','Please enter your username')
        ],
        onSubmit: function () {
            let data = {
                userName: $('#username-for-pass').val().trim()
            }
            $.ajax({
                url: '/Ecommerce/api/identify/forgotPassword',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (isExit) {
                    if (!isExit) {
                        $('.message').text('User not found');
                    }else{
                        $('.message').text('Please check your email.    ');
                        window.location.href = '/Ecommerce/account';
                    }
                },
                error: function (error) {
                    console.log(error);
                }
            })

        }
    })

    Validator({
        form: '.form-horizontal',
        formGroupSelector: '.form-group',
        errorSelector: '.message',
        rules: [
            Validator.isRequired('#pass','Please enter a password'),
            Validator.isPassword('#pass'),
            Validator.minLength('#pass',8,'Password must be at least 8 characters'),
            Validator.isRequired('#re_pass'),
            Validator.isConfirmed('#re_pass', function () {
                return document.querySelector('.form-horizontal #pass').value;
            }, 'Incorect Password')
        ],
        onSubmit:function (){
            document.querySelector('.form-horizontal').submit();
        }
    })
});