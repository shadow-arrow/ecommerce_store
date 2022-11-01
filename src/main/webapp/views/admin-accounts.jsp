<%-- 
    Document   : admin-accounts
    Created on : Oct 21, 2018, 11:36:18 PM
    Author     : Shado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="right-side mb-5">
    <div class="row title">
        <div class="col-md-12">
            <h6>
                Quản lý tài khoản
            </h6>
        </div>
    </div>

    <div class="row mt-2">
        <div class="col-md-12">
            <table id="accounts" table class="table table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Email</th>
                        <th>Loại</th>
                        <th>Trạng thái</th>
                        <th>Chi tiết</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${accounts}" var="i" varStatus="no">
                    <tr>
                        <td>${no.index+1}</td>
                        <td>${i.email}</td>
                        <td>${i.roleId == 1 ? "Admin" : "Khách hàng"}</td>
                        <td>
                            <c:if test="${i.status == 1}">
                                <span class="active">Đang hoạt động</span>
                            </c:if>
                            <c:if test="${i.status != 1}">
                                <span class="deactive">Ngừng hoạt động</span>
                            </c:if>
                        </td>
                        <td>
                            <a href="#" data-toggle="modal" data-target="#myModal" class="g-color">Chi tiết</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- The Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Chi tiết tài khoản</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-success btn-sm" data-dismiss="modal">Cập nhật thông tin</button>
                <button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">Khóa tài khoản</button>
                <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>


