
app.service.negocio = (function() {

    function listar(negocio, successCallback, errorCallback) {
        var url = app.service.baseURI + "/controller/mantenimiento/negocio-listar";
        app.service.postJSON({
            url: url,
            data: negocio,
            success: successCallback,
            error: errorCallback
        });
    }

    function insertar(negocio, successCallback, errorCallback, completeCallback) {
        var url = app.service.baseURI + "/controller/mantenimiento/negocio-insertar";
        app.service.postJSON({
            url: url,
            data: negocio,
            success: successCallback,
            error: errorCallback,
            complete: completeCallback
        });
    }

    function actualizar(negocio, successCallback, errorCallback, completeCallback) {
        var url = app.service.baseURI + "/controller/mantenimiento/negocio-actualizar";
        app.service.postJSON({
            url: url,
            data: negocio,
            success: successCallback,
            error: errorCallback,
            complete: completeCallback
        });
    }

    return {
        listar: listar,
        insertar: insertar,
        actualizar: actualizar
    };
})();
