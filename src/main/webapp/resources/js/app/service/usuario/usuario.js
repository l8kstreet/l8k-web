
app.service.usuario = (function() {

    function logear(usuario, successCallback, errorCallback) {
        var url = app.service.baseURI + "/login";
        app.service.postJSON({
            url: url,
            data: usuario,
            success: successCallback,
            error: errorCallback
        });
    }

    function insertar(usuario, successCallback, errorCallback) {
        var url = app.service.baseURI + "/usuario";
        app.service.postAjax({
            url: url,
            data: usuario,
            success: successCallback,
            error: errorCallback
        });
    }

    function verificarUsurio(user ,successCallback, errorCallback) {
        var url = app.service.baseURI + "/usuario/" + user;
        $.getJSON(url)
                .done(successCallback)
                .fail(errorCallback);
    }

    return {
        logear: logear,
        insertar: insertar,
        verificarUsurio: verificarUsurio
    };
})();
