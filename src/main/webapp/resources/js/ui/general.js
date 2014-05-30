
/*
 * Load
 */
$(function() {
    $(window).scroll(function() {
        y = $(window).scrollTop();
        if (y <= 40) {
            y = 40 - y;
            $("nav").attr("style", "top: " + y + "px");
        }
        else {
            $("nav").attr("style", "top: 0px");
        }
    });
});


/*
 * Navegacion
 */
function irAPagina(src) {
    window.location.href = app.baseURI + src;
}


/*
 * Validaciones
 */
function validateSoloNumeros(event) {
    var respuesta = false
    var controlKeys = [8, 9, 13];
    var isControlKey = controlKeys.join(",").match(new RegExp(event.which));
    if (!event.which || // Control keys in most browsers. e.g. Firefox tab is 0
            (48 <= event.which && event.which <= 57) || // Always 1 through 9
            isControlKey) { // Opera assigns values for control keys.
        respuesta = true;
    }
    return respuesta;
}

function validarFecha($dia, $mes, $anho) {

    value = $dia.val() + "/" + $mes.val() + "/" + $anho.val();

    var datePat = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;
    var fechaCompleta = value.match(datePat);
    if (fechaCompleta == null) {
        return false;
    }

    dia = fechaCompleta[1];
    mes = fechaCompleta[3];
    anio = fechaCompleta[5];

    if (dia < 1 || dia > 31) {
        return false;
    }
    if (mes < 1 || mes > 12) {
        return false;
    }
    if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31) {
        return false;
    }
    if (mes == 2) { // bisiesto
        var bisiesto = (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0));
        if (dia > 29 || (dia == 29 && !bisiesto)) {
            return false;
        }
    }

    return true;
}