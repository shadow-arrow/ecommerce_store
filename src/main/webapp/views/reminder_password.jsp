<%-- 
    Document   : reminder password
    Created on : Aug 13, 2018, 1:32:22 AM
    Author     : Shado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Khôi phục mật khẩu</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" type="text/css" href="css/form.css">
    </head>
    <body>
        <div id="intro">
            <div class="middle signin">
                <div class="login-panel">
                    <div class="logo text-center">
                        <a href="index.jsp">Shop Balo</a>
                    </div>
                    <p class="notification"> ${message}&nbsp; </p>
                    <form class="js-validation-signin">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nhập Email đăng ký" name="txtEmail">
                        </div>
                        <div class="form-group">
                            <div class="col">
                                <button type="submit" class="btn btn-sm">
                                    Xác nhận
                                </button>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <div class="col text-right">
                                <a class="link-effect mt-1" href="login.jsp">
                                    Đăng nhập
                                </a>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>

        <!-- jQuery -->
        <script src="js/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="js/bootstrap/bootstrap.min.js"></script>
    </body>
</html>
