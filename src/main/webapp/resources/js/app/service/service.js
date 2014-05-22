
app.service = (function() {
    var BASE_URI = app.baseURI + "services";

    function getJSON(options) {
        $.ajax({
            url: options.url,
            type: "GET",
            success: options.success,
            error: options.error,
            complete: options.complete,
            dataType: "json",
            contentType: "application/json"
        });
    }

    function postJSON(options) {
        $.ajax({
            url: options.url,
            type: "POST",
            data: JSON.stringify(options.data),
            success: options.success,
            error: options.error,
            complete: options.complete,
            dataType: "json",
            contentType: "application/json"
        });
    }
    function postAjax(options) {
        $.ajax({
            url: options.url,
            type: "POST",
            data: options.data,
            success: options.success,
            error: options.error,
            complete: options.complete,
            dataType: "json"
        });
    }

    function putJSON(options) {
        $.ajax({
            url: options.url,
            type: "PUT",
            data: JSON.stringify(options.data),
            success: options.success,
            error: options.error,
            complete: options.complete,
            dataType: "json",
            contentType: "application/json"
        });
    }
    function putAjax(options) {
        $.ajax({
            url: options.url,
            type: "PUT",
            data: options.data,
            success: options.success,
            error: options.error,
            complete: options.complete,
            dataType: "json"
        });
    }

    function deleteJSON(options) {
        $.ajax({
            url: options.url,
            type: "DELETE",
            data: JSON.stringify(options.data),
            success: options.success,
            error: options.error,
            complete: options.complete,
            dataType: "json",
            contentType: "application/json"
        });
    }
    function deleteAjax(options) {
        $.ajax({
            url: options.url,
            type: "DELETE",
            data: options.data,
            success: options.success,
            error: options.error,
            complete: options.complete,
            dataType: "json"
        });
    }

    return {
        baseURI: BASE_URI,
        getJSON: getJSON,
        deleteJSON: deleteJSON,
        deleteAjax: deleteAjax,
        postJSON: postJSON,
        postAjax: postAjax,
        putJSON: putJSON,
        putAjax: putAjax
    };
    
})();