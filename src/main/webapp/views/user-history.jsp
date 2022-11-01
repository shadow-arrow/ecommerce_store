<%-- 
    Document   : user-history
    Created on : Aug 17, 2018, 8:21:23 PM
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
        <title>Lịch sử</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/user.css">
    </head>
    <body>
        <%@include file="common/user-nav.jsp"%>

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
                        <%@include file="common/user-sidenav.jsp"%>                      
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="right-side">
                        <div class="row title">
                            <div class="col-md-12">
                                <h6>
                                    Lịch sử
                                </h6>
                            </div>
                        </div>

                        <div class="row mt-2">
                            <div class="col-md-12">
                                <table id="history" table class="table table-bordered" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th>Mã đơn hàng</th>
                                            <th>Ngày tạo</th>
                                            <th>Giá trị</th>
                                            <th>Trạng thái</th>
                                            <th>Chú thích</th>
                                            <th>Chi tiết</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listHistory}" var="i">
                                            <tr>
                                                <td>${i.id}</td>
                                                <td>${i.fmDate}</td>
                                                <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${i.totalPrice}"/><sup>đ</sup></td>
                                                <td>${i.status == 1 ? "Đang xử lý" : i.status == 2 ? "Đang giao hàng" : i.status == 3 ? "Giao hàng thành công" : i.status == 4 ? "Đang hủy đơn hàng" : "Đã hủy bỏ"}</td>
                                                <td>${i.note == null ? "--" : i.note}</td>
                                                <td><a href="#" class="g-color">Chi tiết</a></td>
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

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="js/jquery/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="js/bootstrap/bootstrap.min.js"></script>
        <script src="js/datatables/jquery.dataTables.min.js"></script>
        <script src="js/datatables/datatables.vietnamese.js"></script>
        <script>
            $(document).ready(function () {
                $('#history').dataTable({
                    "oLanguage": vietnamese
                });
                $('#history').DataTable();
            });
        </script>
    </body>
</html>
