$(document).ready(function () {

    $("#btn-check-out").click(function () {

        const name = $('input[name="name"]').val();
        const mobile = $('input[name="mobile"]').val();
        const address = $('input[name="address"]').val();
        const note = $('input[name="note"]').val();
        const infoOrder = {
            name: name,
            phoneNumber: mobile,
            address: address,
            note: note
        };

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/check-out",
            data: JSON.stringify(infoOrder),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("Success:" + data);
                $(location).prop('href', '/thank-page')
            },
            error: function (e) {
                console.log("ERROR : ", e);
                $(location).prop('href', '/thank-page')
            }
        });

    });
});