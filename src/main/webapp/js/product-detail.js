$(document).ready(function () {

    $('#add-to-cart').click(function () {
        let id = $(this).find('#product-id').val();
        let quantity = $('#quantity').val();
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/add-to-cart",
            data: {
                id: id,
                quantity: quantity
            },
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS");
                $('#total-product').text(data.listData.length);
            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });


    });


    $('#decrease').click(function () {
        let value = $(this).next().val();
        if (value > 1) {
            value = isNaN(value) ? 0 : value;
            value--;
        }
        $('#quantity').val(value);

    });

    $('#increase').click(function () {
        let value = $(this).prev().val();
        value = isNaN(value) ? 0 : value;
        value++;
        $('#quantity').val(value);

    });


});

/* function increaseCount(a, b) {
        let input = b.previousElementSibling;
        let value = parseInt(input.value, 10);
        value = isNaN(value) ? 0 : value;
        value++;
        input.value(value);
    }

    function decreaseCount(a, b) {
        let input = b.nextElementSibling;
        let value = parseInt(input.value, 10);
        if (value > 1) {
            value = isNaN(value) ? 0 : value;
            value--;
            input.value(value);
        }
    }*/

