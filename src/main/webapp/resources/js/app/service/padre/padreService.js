
app.service.padre = (function() {

    function listarPaises(successCallback, errorCallback) {
        var url = app.service.baseURI + "/padre/listarPaises";
        app.service.getJSON({
            url: url,
            success: successCallback,
            error: errorCallback
        });
    }

    function subirImagen(file, successCallback, errorCallback) {
        var url = app.service.baseURI + "/padre/guardarImagenTemporar";

        var option = {
            url: url,
            type: "POST",
            success: successCallback,
            error: errorCallback || function() {
                                        alert('No se pudo cargar la imagen.');
                                    }
        }

        file.ajaxSubmit(option);
    }

    return {
        listarPaises: listarPaises,
        subirImagen: subirImagen
    };
})();
