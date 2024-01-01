document.addEventListener('DOMContentLoaded', function () {
    Validator({
        form: '#register-form',
        formGroupSelector: '.form-group',
        errorSelector: '.message',
        rules: [
            Validator.isRequired('#userName', 'Vui lòng nhập tên đầy đủ của bạn'),
            Validator.isRequired('#firstName'),
            Validator.isRequired('#lastName'),
            Validator.isRequired('#email', 'Vui lòng nhập email'),
            Validator.isRequired('#re_pass'),
            Validator.minLength('#pass', 8),
            Validator.isEmail('#email'),
            Validator.isRequired('#pass'),
            Validator.isPassword('#pass'),
            Validator.isConfirmed('#re_pass', function () {
                return document.querySelector('#register-form #pass').value;
            }, 'Mật khẩu nhập lại không chính xác')
        ],
        onSubmit: function () {

            let data = {
                userName: $('#userName').val().trim(),
                password: $('#pass').val().trim(),
                firstName: $('#firstName').val().trim(),
                lastName: $('#lastName').val().trim(),
                email: $('#email').val().trim(),
            }
            $.ajax({
                url: '/Ecommerce/api/accounts',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (isExit) {
                    if (isExit) {
                        $('#userName').siblings('.message').text("Tên đăng nhập đã tồn tại");
                    } else {
                        window.location.href = '/Ecommerce/account?action=login';
                    }
                },
                error: function (error) {
                    console.error("Error:", error);
                }
            })
        }
    });
});

$(document).ready(function () {

    function togglePasswordVisibility(iconEye, iconEyeOff, inputField) {
        iconEye.on('click', function () {

            iconEye.hide();
            iconEyeOff.show();

            inputField.attr('type', 'text');
        });

        iconEyeOff.on('click', function () {
            iconEyeOff.hide();
            iconEye.show();

            inputField.attr('type', 'password');
        });
    }


    const iconEye = $('#icon-eye-pass');
    const iconEyeOff = $('#icon-eye-pass-off');
    const passInput = $('#pass');
    togglePasswordVisibility(iconEye, iconEyeOff, passInput);

    const iconEyeRePass = $('#icon-eye-re-pass');
    const iconEyeRePassOff = $('#icon-eye-re-pass-off');
    const rePassInput = $('#re_pass');
    togglePasswordVisibility(iconEyeRePass, iconEyeRePassOff, rePassInput);
});

