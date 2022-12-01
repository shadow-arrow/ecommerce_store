

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Chi tiết sản phẩm</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/product-details.css">
</head>
<body>
<%@include file="../common/nav.jsp" %>

<div id="main-contain" class="container">
    <c:if test="${product eq null}">
        <div class="row">
            <div class="col-md-12">
                <h4 class="text-center">Không tìm thấy sản phẩm nào.</h4>
                <h6 class="text-center"><a href="home">Quay lại ></a></h6>
            </div>
        </div>
    </c:if>
    <c:if test="${product ne null}">
        <div class="row">
            <div class="col-md-6">
                <div class="img mg-top-15">
                    <img src="assets/images/products/${product.imageLink}" alt="${product.name}">
                </div>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-5">
                <div class="product-details">
                    <h3>${product.name}</h3>
                    <p class="price"><fmt:formatNumber type="number" maxFractionDigits="3"
                                                       value="${product.price}"/><sup>đ</sup>
                        <c:if test="${product.status == 2}">
                            <span class="badge badge-success mg-left-10">SALE</span>
                        </c:if>
                    </p>
                        <%-- <a href="products.jsp" class="go-back">Trở về</a>--%>
                        <%--href="add-to-cart?id=${product.id}"--%>
                    <div class="counter">
                        <span id="decrease" class="down">-</span>
                        <input type="text" id="quantity" value="1">
                        <span id="increase" class="up">+</span>
                        <a class="btn-add-to-cart text-white" id="add-to-cart">
                            <input type="hidden" id="product-id" value="${product.id}">
                            <i class="fas fa-cart-plus fa-fw fa-lg mg-right-5"></i> Thêm vào giỏ hàng
                        </a>
                    </div>
                    <div class="row">
                        <div class="col-md-12 info">
                            <p class="description bd-t pt-3">
                                <label>Chi tiết sản phẩm</label>
                                <span>${product.description}</span>
                            </p>
                            <p class="local bd-t pt-3">
                                <label>Mua hàng trực tiếp tại cửa hàng</label>
                            <ul>
                                <li>133 Thái Hà, Phường Trung Liệt, Q.Đống Đa, Hà Nội</li>
                                <li>135 Nguyễn Văn Cừ, Phường Ngọc Lâm, Quận Long Biên, Hà Nội</li>
                            </ul>
                            </p>
                            <p class="refund bd-t pt-3">
                                <label>Giao hàng và trả lại hàng</label>
                            <ul>
                                <li>Đổi hàng trong vòng 72h</li>
                                <li>Phí vận chuyển nội thành Hà Nội: 20.000</li>
                                <li>Phí vận chuyển ngoại thành/ngoại tỉnh: tùy thuộc vào địa điểm</li>
                                <li>Thanh toán khi nhận hàng</li>
                            </ul>
                            </p>
                            <p class="bd-t"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/jquery/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="../js/product-detail.js"></script>
</body>
</html>
