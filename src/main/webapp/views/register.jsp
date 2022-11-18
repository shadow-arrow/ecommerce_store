<%-- 
    Document   : register
    Created on : Aug 13, 2018, 1:32:22 AM
    Author     : Shado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Đăng ký</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="../css/form.css">
</head>
<body>
<div id="intro">
    <div class="middle signin">
        <div class="login-panel">
            <div class="logo text-center">
                <a href="/home">Shop Balo</a>
            </div>
            <p class="notification"> ${message}&nbsp; </p>
            <form action="/register" method="POST">
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="Nhập Email" name="email">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Nhập mật khẩu" name="password">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Nhập lại mật khẩu"
                           name="passwordConfirm">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Họ và tên" name="name">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Số điện thoại" name="phoneNumber">
                </div>
                <div class="form-group">
                    <div class="col">
                        <label class="custom-control custom-checkbox mr-4">
                            <input type="radio" class="custom-control-input" value="1" name="gender">
                            <span class="custom-control-indicator"></span>
                            <span class="custom-control-description">Nam</span>
                        </label>
                        <label class="custom-control custom-checkbox">
                            <input type="radio" class="custom-control-input" value="0" name="gender">
                            <span class="custom-control-indicator"></span>
                            <span class="custom-control-description">Nữ</span>
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col">
                        <button type="submit" class="btn btn-sm">
                            <i class="fas fa-edit mr-1"></i> Tạo tài khoản
                        </button>
                    </div>
                </div>
                <div class="form-group" style="margin-top: 10px;">
                    <div class="col text-right">
                        <a class="link-effect mt-1" href="/login-page">
                            <i class="fas fa-sign-in-alt mr-1"></i> Đăng nhập
                        </a>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<!-- jQuery -->
<script src="../js/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="../js/bootstrap/bootstrap.min.js"></script>
</body>
</html>
