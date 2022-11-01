<%-- 
    Document   : checkout
    Created on : Oct 30, 2018, 11:41:05 PM
    Author     : Shado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Check out</title>
        <!-- Custom Fonts -->
        <script defer src="font-awesome/js/fontawesome-all.js"></script>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/common.css">
        <style>
            .m-info {
                border: 1px dashed #f96332;
                padding: 10px 15px 15px;
                border-radius: .25rem;
            }
            .m-info .table {
                margin-bottom: 0;
            }
            td {
                padding: 4px 10px 4px 0;
            }
            h4 {
                border-bottom: 1px dashed #f96332;
            }
            .table>thead>tr>th {
                font-weight: 500;
            }
        </style>
    </head>
    <body>
        <%@include file="common/nav.jsp"%>

        <div class="container pt-5 pb-5">
            <c:if test="${listCart eq null}">
                <h5 class="text-center">Không có sản phẩm nào trong giỏ hàng.</h5>
                <div class="text-center">
                    <a href="products.jsp" class="btn btn-info mt-3">Tiếp tục mua hàng</a>
                </div>
            </c:if>
            <c:if test="${listCart ne null}">
                <div class="row">
                    <div class="col-md-12">
                        <h5>Thông tin mua hàng</h5>
                        <p>Xem lại thông tin hàng hóa đã lựa chọn.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8">
                        <div class="m-info">
                            <table class="table mt-1">
                                <thead>
                                    <tr>
                                        <th scope="col">STT</th>
                                        <th scope="col">Tên sản phẩm</th>
                                        <th scope="col">Giá</th>
                                        <th scope="col">Số lượng</th>
                                        <th scope="col">Tổng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listCart}" var="i" varStatus="no">
                                        <tr>
                                            <th scope="row">${no.index+1}</th>
                                            <td>${i.name}</td>
                                            <td>
                                                <fmt:formatNumber type="number" maxFractionDigits="3" value="${i.unitPrice}"/><sup>đ</sup>
                                            </td>
                                            <td class="text-center">
                                                ${i.quantity}
                                            </td>
                                            <td>
                                                <fmt:formatNumber type="number" maxFractionDigits="3" value="${i.unitPrice * i.quantity}"/><sup>đ</sup>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-md-4 text-right mt-4">
                        <c:if test="${totalPrice ne null}">
                            <h4 class="pb-2">Tổng tiền</h4>
                            <h3 class="mt-3"><fmt:formatNumber type="number" maxFractionDigits="3" value="${totalPrice}"/><sup>đ</sup></h3>
                        </c:if>
                    </div>                   
                </div>

                <div class="row mt-4">
                    <div class="col-md-12">
                        <h5>Địa chỉ giao hàng</h5>
                        <p>Chọn địa chỉ giao hàng có sẵn bên dưới:</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8">
                        <div class="m-info">
                            <table>
                                <tr>
                                    <td>Họ và tên:</td>
                                    <td><b>${accountDetailInfo.name}</b></td>
                                </tr>
                                <tr>
                                    <td>Số điện thoại:</td>
                                    <td>${accountDetailInfo.mobile}</td>
                                </tr>
                                <tr>
                                    <td>Địa chỉ:</td>
                                    <td>${accountDetailInfo.address}</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <button type="button" class="btn btn-success w-100" data-toggle="collapse" data-target="#inputForm" aria-expanded="false" aria-controls="inputForm">Giao hàng đến địa chỉ khác</button>
                        <a href="checkout" class="btn btn-danger mt-4 w-100">Xác nhận giao hàng đến địa chỉ này</a>
                    </div>
                </div>

                <div class="row mt-4">
                    <div class="col-md-8 collapse" id="inputForm">
                        <h5>Nhập thông tin địa chỉ giao hàng mới</h5>
                        <p>Hàng hóa sẽ được giao đến địa chỉ này sau khi xác nhận.</p>
                        <div class="m-info">
                            <form action="checkout" method="post">
                                <div class="form-group col-md-6 p-0">
                                    <label>Họ và tên:</label>
                                    <input type="text" class="form-control" name="name">
                                </div>
                                <div class="form-group col-md-6 p-0">
                                    <label>Số điện thoại:</label>
                                    <input type="text" class="form-control" name="mobile">
                                </div>
                                <div class="form-group col-md-12 p-0">
                                    <label>Địa chỉ:</label>
                                    <textarea class="form-control" rows="2" name="address"></textarea>
                                </div>
                                <div class="form-group col-md-12 p-0">
                                    <label>Lưu ý:</label>
                                    <textarea class="form-control" rows="2" name="note"></textarea>
                                    <small id="note" class="form-text text-muted">Lưu ý khi vận chuyển hàng hóa.</small>
                                </div>
                                <input type="submit" class="btn btn-danger" name="btnUpdate" value="Xác nhận giao hàng đến địa chỉ này">
                            </form>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="js/jquery/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="js/bootstrap/bootstrap.min.js"></script>                   
    </body>
</html>
