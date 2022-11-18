<%-- 
    Document   : products
    Created on : Aug 17, 2018, 8:21:23 PM
    Author     : Shado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Sản phẩm</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="../css/products.css">
</head>
<body>
<%@include file="../common/nav.jsp" %>

<%--        <c:if test="${listProduct eq null}">
            <c:redirect url="filter"/>
        </c:if>--%>

<!-- Cover -->
<div id="main-contain" class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="left-side">
                <div class="row title">
                    <div class="col-md-12">
                        <h6>Danh mục sản phẩm</h6>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="side-nav">
                            <ul class="navbar-nav ml-auto">
                                <c:choose>
                                    <c:when test="${cId == 0}">
                                        <li class="nav-item">
                                            <a class="nav-link active filter">
                                                <i class="mr-2"></i> Tất cả
                                                <input class="category-id" type="hidden" value="0">
                                            </a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="nav-item">
                                            <a class="nav-link filter">
                                                <i class="mr-2"></i> Tất cả
                                                <input class="category-id" type="hidden" value="0">
                                            </a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                                <c:forEach items="${listCategory}" var="i">
                                    <c:choose>
                                        <c:when test="${cId == i.id}">
                                            <li class="nav-item">
                                                <a class="nav-link active filter">
                                                    <i class="mr-2"></i> ${i.category}
                                                    <input class="category-id" type="hidden" value="${i.id}">
                                                </a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="nav-item">
                                                <a class="nav-link filter">
                                                    <i class="mr-2"></i> ${i.category}
                                                    <input class="category-id" type="hidden" value="${i.id}">
                                                </a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-9">
            <div class="right-side">
                <div class="row title">
                    <div class="col-md-12">
                        <h6>
                            Sản phẩm
                            <span class="float-right sort" style="font-size: 1rem;">
                                        Sắp xếp giá:
                                        <a class="mr-2 ml-2" id="sort-ascending">Tăng dần</a>
                                        <a id="sort-descending">Giảm dần</a>
                                        <input type="hidden" id="cid" value="0">
                                    </span>
                        </h6>
                    </div>
                </div>

                <div class="row mt-2 product">
                    <c:if test="${listProduct eq null || listProduct.size() == 0}">
                        <div class="col-12">
                            <h5 class="text-center">Không tìm thấy sản phẩm nào.</h5>
                        </div>
                    </c:if>
                    <c:forEach items="${listProduct}" var="i">
                        <c:if test="${i.status != 4}">
                            <div class="col-6 col-md-3 mb-4">
                                <div class="product">
                                    <c:if test="${i.status == 2}">
                                        <div class="status">
                                            <img src="assets/images/icon-sale.png" alt="icon-sale">
                                        </div>
                                    </c:if>
                                    <div class="img">
                                        <img src="assets/images/products/${i.imageLink}" alt="${i.imageLink}">
                                            <%-- <div class="overlay">
                                                 <p>
                                                     <a class="add-to-cart">
                                                         <input type="hidden" class="product-id" value="${i.id}">&lt;%&ndash;href="/add-to-cart?id=${i.id}"&ndash;%&gt;
                                                         Thêm vào giỏ
                                                     </a>
                                                 </p>
                                             </div>--%>
                                    </div>
                                    <div class="description text-center">
                                        <h6><a href="/product?id=${i.id}">${i.name}</a></h6>
                                        <p>
                                            <fmt:formatNumber type="number" maxFractionDigits="3"
                                                              value="${i.price}"/><sup>đ</sup>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/jquery/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="../js/products.js"></script>
</body>
</html>
