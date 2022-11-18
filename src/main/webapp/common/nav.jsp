<%-- 
    Document   : nav
    Created on : Aug 24, 2018, 7:57:01 PM
    Author     : Shado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!-- Nav -->
<nav class="navbar navbar-expand-md bg-light navbar-light">
    <div class="container pr-0">
        <a class="mr-4 brand" href="home">Shop Balo</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <div class="ml-auto">
                <ul class="navbar-nav">
                    <form class="form-inline mr-3" action="search" method="get">
                        <div class="input-group">
                            <input type="text" class="form-control" name="txtSearch" placeholder="Tìm kiếm">
                            <div class="input-group-append">
                                <button type="submit" name="btn-search" class="input-group-text">Tìm kiếm</button>
                            </div>
                        </div>
                    </form>
                    <li class="nav-item mr-2">
                        <a class="nav-link" href="cart">
                            Giỏ hàng
                            <span id="total-product"
                                  class="badge badge-danger">${listCart ne null ? listCart.size() : 0}</span>
                        </a>
                    </li>
                    <c:if test="${account ne null}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    ${account.email}
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="user-profile.jsp">Thông tin cá nhân</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/logout">Đăng xuất</a>
                            </div>
                        </li>
                    </c:if>
                    <c:if test="${account eq null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/register-page">Đăng ký</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/login-page">Đăng nhập</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</nav>