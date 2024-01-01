<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<div class="container">
    <div class="main-body">
        <div class="row">
            <div class="container mt-5 mb-3">
                <span class="display-4">Thay đổi mật khẩu</span>
            </div>
            <form class="container" id="form-edit-pass">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="row mb-3 mt-3">

                                <div class="col-sm-3">
                                    <h6 class="mb-0">Nhập mật khẩu hiện tại</h6>
                                </div>
                                <div class="col-sm-9 text-secondary form-group">
                                    <input type="password" class="form-control" id="pass" name="pass">
                                    <c:if test="${user.countChangePassword >= 5}">
                                        <span class="message" style="color: #f33a58">Xin lỗi, bạn đã nhập sai mật khẩu quá nhiều lần, vui lòng thử lại sau.</span>
                                    </c:if>
                                    <c:if test="${user.countChangePassword < 5}">
                                        <span class="message" style="color: #f33a58"></span>
                                    </c:if>
                                    <span class="message-success" style="color: #3db638"></span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-9 text-secondary">
                                    <c:if test="${user.countChangePassword < 5}">
                                        <input type="submit" class="btn btn-primary px-4" value="Xác minh mật khẩu">
                                    </c:if>
                                    <c:if test="${user.countChangePassword >= 5}">
                                        <input type="submit" disabled class="btn btn-primary px-4"
                                               value="Xác minh mật khẩu" id="btnSubmitPassword">
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        let count = 0;
        let id = ${user.id};
        let countChangePassword = ${user.countChangePassword};
        Validator({
            form: "#form-edit-pass",
            formGroupSelector: ".form-group",
            errorSelector: '.message',
            rules: [
                Validator.isRequired('#pass', 'Vui lòng nhập mật khẩu'),
            ],
            onSubmit: function () {
                count += 1;
                console.log(count)
                let data = {
                    id: id,
                    password: $('#pass').val().trim()
                }
                $.toast({
                    heading: 'Thông báo',
                    text: 'Vui lòng đợi trong vài giây',
                    showHideTransition: 'slide',
                    icon: 'success',
                    position: 'bottom-right',
                    timeout: 2000
                });
                $.ajax({
                    url: '/Ecommerce/api/password',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    dataType: 'json',
                    success: function (response) {
                        if (response) {
                            $('.message-success').text("Vui lòng kiểm tra email");
                            setTimeout(function () {
                                window.location.href = "/Ecommerce/user?t=view";
                            }, 2000)
                        }
                        if (!response) {
                            if (count < 5) {
                                $('.message').text("Mật khẩu không chính xác, vui lòng thử lại")
                            } else {
                              window.location.reload();
                            }
                        }
                    },
                    error: function (error) {
                        console.error("Error:", error);
                    }
                })
            },
        })
    });
</script>