
app.service.padre = (function() {
    
    function listarPaises(successCallback, errorCallback) {
        var url = app.service.baseURI + "/padre/listarPaises";
        app.service.getJSON({
            url: url,
            success: successCallback,
            error: errorCallback
        });
    }

    return {
        listarPaises: listarPaises
    };
})();
