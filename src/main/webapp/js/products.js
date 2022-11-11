$(document).ready(function () {

    // filter product by category id
    $(".filter").click(function () {
        //  get value from tag input inside class filter
        let id = $(this).find(".category-id").val();
        $("#cid").val(id);
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/filter?categoryId=" + id,
            /*            data: JSON.stringify(search),
                        dataType: 'json',*/
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS : ", data);
                let htmlUpdate = "";
                let listData = data.listData;
                let size = listData.length;
                if (size == 0) {
                    htmlUpdate = showProduct(null);
                } else {
                    for (let i = 0; i < size; i++) {
                        htmlUpdate += showProduct(listData[i]);
                    }
                }
                $(".product").empty();
                $(".product").html(htmlUpdate);

            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });
    });
    $("#sort-descending").click(function () {
        let cid = $("#cid").val();
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/sort",
            data: {
                categoryId: cid,
                flat: '2'
            },
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS : ", data);
                let htmlUpdate = "";
                let listData = data.listData;
                let size = listData.length;
                if (size == 0) {
                    htmlUpdate = showProduct(null);
                } else {
                    for (let i = 0; i < size; i++) {
                        htmlUpdate += showProduct(listData[i]);
                    }
                }
                $(".product").empty();
                $(".product").html(htmlUpdate);

            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });

    });

    $('#sort-ascending').click(function () {
        let cid = $("#cid").val();
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/sort",
            data: {
                categoryId: cid,
                flat: '1'
            },
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS : ", data);
                let htmlUpdate = "";
                let listData = data.listData;
                let size = listData.length;
                if (size == 0) {
                    htmlUpdate = showProduct(null);
                } else {
                    for (let i = 0; i < size; i++) {
                        htmlUpdate += showProduct(listData[i]);
                    }
                }
                $(".product").empty();
                $(".product").html(htmlUpdate);

            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });

    });

});

function showProduct(data) {

    let result = "";
    if (data == null) {
        result = "<div class=\"col-12\">\n"
            + " <h5 class=\"text-center\">Không tìm thấy sản phẩm nào.</h5>\n"
            + "    </div>";
        return result;
    }
    const config = {style: 'currency', currency: 'VND'}
    let money = new Intl.NumberFormat('vi-VN', config).format(data.price);
    result = " <div class=\"col-6 col-md-3 mb-4\">\n"
        + "                                <div class=\"product\">\n";
    result += (data.status == 2) ? "<div class=\"status\">\n" +
        "                                            <img src=\"assets/images/icon-sale.png\" alt=\"icon-sale\">\n" +
        "                                        </div>" : "";
    result += "                                    <div class=\"img\">\n"
        + "                                        <img src=\"assets/images/products/" + data.imageLink + "\" alt=\"${listData[i].imageLink}\">\n"
        + "                                        <div class=\"overlay\">\n"
        + "                                            <p>\n"
        + "                                                <a href=\"addtocart?id=${listData[i].id}\">\n"
        + "                                                    Thêm vào giỏ\n"
        + "                                                </a>\n"
        + "                                            </p>\n"
        + "                                        </div>\n"
        + "                                    </div>\n"
        + "                                    <div class=\"description text-center\">\n"
        + "                                        <h6><a href=\"product?id=" + data.id + "\">" + data.name + "</a></h6>\n"
        + "                                        <p>" + money + "</p>"
        + "                                    </div>\n"
        + "                                </div>\n"
        + "                            </div>";
    return result;
}