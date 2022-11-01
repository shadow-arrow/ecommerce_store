<%-- 
    Document   : user-modal-order-detail
    Created on : Nov 6, 2018, 2:52:30 AM
    Author     : Shado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- The Modal -->
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
                            <tbody>
                            <c:if test="${listOrderDetail ne null}">
                                <c:forEach items="${listOrderDetail}" var="i" varStatus="no">
                                    <tr>
                                        <th scope="row">${no.index+1}</th>
                                        <td>${i.productName}</td>
                                        <td>
                                    <fmt:formatNumber type="number" maxFractionDigits="3" value="${i.productPrice}"/><sup>đ</sup>
                                    </td>
                                    <td class="text-center">
                                        ${i.quantity}
                                    </td>
                                    <td>
                                    <fmt:formatNumber type="number" maxFractionDigits="3" value="${i.productPrice * i.quantity}"/><sup>đ</sup>
                                    </td>
                                    </tr>
                                </c:forEach> 
                            </c:if>
                            </tbody>
                        </table>
                    </div>
                    <h6 class="mt-3">Thông tin giao hàng</h6>
                    <div class="address-info mt-2">
                        <table>
                            <tr>
                                <td>Họ và tên:</td>
                                <td><b>${addressDetail.name}</b></td>
                            </tr>
                            <tr>
                                <td>Số điện thoại:</td>
                                <td>${addressDetail.phoneNumber}</td>
                            </tr>
                            <tr>
                                <td>Địa chỉ:</td>
                                <td>${addressDetail.address}</td>
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