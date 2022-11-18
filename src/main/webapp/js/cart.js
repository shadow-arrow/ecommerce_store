$(document).ready(function () {

    $('.minus-quantity').click(function () {

        let id = $(this).find(".product-id").val();
        calculatedQuantityProduct(id, 1);
    });

    $('.plus-quantity').click(function () {

        let id = $(this).find(".product-id").val();
        calculatedQuantityProduct(id, 2);
    });

    function calculatedQuantityProduct(id, flat) {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/calculate-cart",
            data: {
                id: id,
                flat: flat,
            },
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("Success ");
                $(location).prop('href', '/cart')
            },
            error: function (e) {
                console.log("ERROR : ", e);
                $(location).prop('href', '/cart')
            }
        });
    }

});

