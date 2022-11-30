<%-- 
    Document   : user-orders
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
    <title>Đơn hàng</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/user.css">
</head>
<body>
<%@include file="../common/user-nav.jsp" %>

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
                <%@include file="../common/user-sidenav.jsp" %>
            </div>
        </div>
        <div class="col-md-9">
            <div class="right-side">
                <div class="row title">
                    <div class="col-md-12">
                        <h6>
                            Đơn hàng
                        </h6>
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col-md-12">
                        <table id="orders" table class="table table-bordered" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>STT</th>
                                <th>Ngày đặt</th>
                                <th>Giá trị</th>
                                <th>Trạng thái</th>
                                <th>Chú thích</th>
                                <th>Chi tiết</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orderList}" var="i" varStatus="no">
                                <tr>
                                    <td>${no.index+1}</td>
                                    <td>${i.fmDate}</td>
                                    <td><fmt:formatNumber type="number" maxFractionDigits="3"
                                                          value="${i.totalPrice}"/><sup>đ</sup></td>
                                    <td class="text-center">
                                        <c:if test="${i.status == 1}">
                                            <button type="button" class="btn btn-primary br" data-toggle="tooltip"
                                                    data-placement="right" title="Đang xử lý"></button>
                                        </c:if>
                                        <c:if test="${i.status == 2}">
                                            <button type="button" class="btn btn-warning br" data-toggle="tooltip"
                                                    data-placement="right" title="Đang giao hàng"></button>
                                        </c:if>
                                        <c:if test="${i.status == 4}">
                                            <button type="button" class="btn btn-danger br" data-toggle="tooltip"
                                                    data-placement="right" title="Đang hủy đơn hàng"></button>
                                        </c:if>
                                    </td>
                                    <td>${i.note == null ? "--" : i.note}</td>
                                    <td class="pointer show-modal">
                                        Chi tiết
                                        <input type="hidden" class="order-id" value="${i.id}">
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <form action="" method="">
                <div class="modal-header">
                    <h5 class="modal-title">Chi tiết đơn hàng</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <h6>Danh sách sản phẩm</h6>
                    <div class="products-info mt-2">
                        <table class="table mt-1 mb-1">
                            <thead>
                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Tên sản phẩm</th>
                                <th scope="col">Giá</th>
                                <th scope="col">Số lượng</th>
                                <th scope="col">Tổng</th>
                            </tr>
                            </thead>
                            <tbody id="show-product">
                            </tbody>
                        </table>
                    </div>
                    <h6 class="mt-3">Thông tin giao hàng</h6>
                    <div class="address-info mt-2">
                        <table>
                            <tr>
                                <td>Họ và tên:</td>
                                <td id="name-customer"><b></b></td>
                            </tr>
                            <tr>
                                <td>Số điện thoại:</td>
                                <td id="phone-number"></td>
                            </tr>
                            <tr>
                                <td>Địa chỉ:</td>
                                <td id="address"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger btn-sm" name="cancelOrder">Hủy đơn hàng</button>
                    <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Đóng</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/jquery/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/datatables/jquery.dataTables.min.js"></script>
<script src="js/datatables/datatables.vietnamese.js"></script>
<script src="../js/user.js"></script>
</body>
</html>
