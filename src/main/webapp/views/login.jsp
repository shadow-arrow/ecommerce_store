<%-- 
    Document   : login
    Created on : Aug 13, 2018, 1:32:22 AM
    Author     : Shado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Đăng nhập</title>
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
                <a href="index.jsp">Shop Balo</a>
            </div>
            <p class="notification"> ${message}&nbsp; </p>
            <form action="/login-user" method="post">
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="Nhập Email" name="txtEmail">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Nhập mật khẩu" name="txtPassword">
                </div>
                <%--                <div class="form-group">
                                    <div class="col">
                                        <label class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="login-remember-me"
                                                   name="login-remember-me">
                                            <span class="custom-control-indicator"></span>
                                            <span class="custom-control-description">Ghi nhớ mật khẩu</span>
                                        </label>
                                    </div>
                                </div>--%>
                <div class="form-group">
                    <div class="col">
                        <button type="submit" class="btn btn-sm">
                            <i class="fas fa-sign-in-alt mr-1"></i> Đăng nhập
                        </button>
                    </div>
                </div>
                <div class="form-group" style="margin-top: 10px;">
                    <div class="col">
                        <a class="link-effect mt-1 mr-1" href="../views/reminder_password.jsp">
                            Quên mật khẩu?
                        </a>
                        <a class="link-effect mt-1 float-right" href="/register-page">
                            Đăng ký
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
