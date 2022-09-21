function ajaxCall(ajaxParams, succCallback, errorCallback, beforeSend, complete) {
    $.ajax({
        type: ajaxParams.type,
        url: ajaxParams.url,
        contentType: ajaxParams.contentType,
        processData: ajaxParams.processData,
        // You are expected to receive the generated JSON (json_encode($data))
        beforeSend: function () {
            if (typeof beforeSend !== 'undefined' && beforeSend != null) {
                    beforeSend();
            }
        },
        complete: function () {
            if (typeof complete !== 'undefined' && complete != null) {
                complete();
            }
        },
        success: function (data) {
            if (typeof succCallback !== 'undefined' && succCallback != null) {
                succCallback(data,ajaxParams.succCallBackParams);
            }
        },
        error: function (er) {
            if (typeof errorCallback !== 'undefined' && errorCallback != null) {
                errorCallback(er);
            }
        }
    });
}