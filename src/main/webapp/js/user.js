$(document).ready(function () {
    $('#orders').dataTable({
        "oLanguage": vietnamese
    });
    $('#orders').DataTable();

    $('[data-toggle="tooltip"]').tooltip();

    $('.show-modal').click(function () {
        let order_id = $(this).find(".order-id").val();
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/detail-order",
            data: {
                id: order_id,
            },
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS");
                let htmlUpdate = "";
                let listData = data.listOrderDetail;
                let size = listData.length;
                if (size == 0) {
                    htmlUpdate = showProduct(null);
                } else {
                    for (let i = 0; i < size; i++) {
                        htmlUpdate += showProduct(listData[i], i + 1);
                    }
                }
                $("#show-product").empty();
                $("#show-product").html(htmlUpdate);
                $("#name-customer").text(data.shippingAddress.name);
                $("#phone-number").text(data.shippingAddress.phoneNumber);
                $("#address").text(data.shippingAddress.address);
                $('#myModal').modal('show');
            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });
    });
});

function showProduct(data, index) {

    let result = "";
    if (data == null) {
        result = "<div class=\"col-12\">\n"
            + " <h5 class=\"text-center\">Không tìm thấy sản phẩm nào.</h5>\n"
            + "    </div>";
        return result;
    }
    const config = {style: 'currency', currency: 'VND'}
    let money = new Intl.NumberFormat('vi-VN', config).format(data.productPrice);
    let total = new Intl.NumberFormat('vi-VN', config).format(data.productPrice * data.productQuantity);
    result =
        "  <tr>\n"
        + "   <td>" + index + "</td>\n"
        + "   <td>" + data.productName + "</td>\n"
        + "   <td> " + money + "</td>\n"
        + "   <td class=\"text-center\">\n" + data.productQuantity + "</td>\n"
        + "   <td>\n" + total + "</td>\n"
        + " </tr>";
    return result;

}