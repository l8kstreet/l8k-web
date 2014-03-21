
$(function() {

//    $("#frmRegistrar").validate();
//    jQuery.validator.addMethod("fechaESP", function(value, element)
//    {
//        var validator = this;
//
//    }, "  ");

});

function validarIgualdad() {
    $p = $('#pConfirmar');
    $pass = $('#txtContrasenha');
    $passConfir = $('#txtConfirmar');

    if ($pass.val() == $passConfir.val()) {
        $p.attr('class', 'errornone');
    } else {
        $p.attr('class', 'error');
    }
}

function validarData(blur) {

    $p = $(blur.currentTarget.nextElementSibling);
    item = blur.currentTarget.value;

    if (item.length == 0) {
        $p.html("No puedes dejar este campo en blanco.");
        $p.attr('class', 'error');
        return false;
    } else {
        $p.attr('class', 'errornone');
        return true;
    }

}

function validartxtUsuario(blur) {

    if (validarData(blur) == true) {

        user = blur.currentTarget.value;
        url = "/l8k-web/faces/verificarUsuario/" + user;

        $.ajax({
            url: url,
            dataType: 'json'
        }).done(function(data) {

            console.log(data);
            console.log(data.result);
            
            $p = $('#pUsuario');

            if (data.result == 1) {
                $p.attr('class', 'errornone');
            } else {
                $p.html("El usuario no esta disponible.");
                $p.attr('class', 'error');
            }

        });

    }
}

function validarFecha() {

    $p = $('#pFecha');
    $dia = $('#txtDia');
    $mes = $('#cboMes');
    $anho = $('#txtAnho');

    value = $dia.val() + "/" + $mes.val() + "/" + $anho.val();

    var datePat = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;
    var fechaCompleta = value.match(datePat);
    if (fechaCompleta == null) {
        $p.attr('class', 'error');
        return;
    }

    dia = fechaCompleta[1];
    mes = fechaCompleta[3];
    anio = fechaCompleta[5];

    if (dia < 1 || dia > 31) {
        $p.attr('class', 'error');
        return;
    }
    if (mes < 1 || mes > 12) {
        $p.attr('class', 'error');
        return;
    }
    if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31) {
        $p.attr('class', 'error');
        return;
    }
    if (mes == 2) { // bisiesto
        var bisiesto = (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0));
        if (dia > 29 || (dia == 29 && !bisiesto)) {
            $p.attr('class', 'error');
            return;
        }
    }

    $p.attr('class', 'errornone');
}

$('#txtNombre').on('blur', validarData);
$('#txtCorreo').on('blur', validarData);
$('#txtUsuario').on('blur', validartxtUsuario);
$('#txtContrasenha').on('blur', validarData);
$('#txtConfirmar').on('blur', validarIgualdad);
$('#txtDia').on('blur', validarFecha);
$('#txtAnho').on('blur', validarFecha);
$('#cboMes').on('change', validarFecha);

$('#txtDia').on('keypress', validateSoloNumeros);
$('#txtAnho').on('keypress', validateSoloNumeros);

$('#btnRegistrar').on('click', function() {

    if ($('#txtNombre').val().length == 0) {
        $('#pNombre').html("No puedes dejar este campo en blanco.");
        $('#pNombre').attr('class', 'error');
    }

    if ($('#txtCorreo').val().length == 0) {
        $('#pCorreo').html("No puedes dejar este campo en blanco.");
        $('#pCorreo').attr('class', 'error');
    }

    if ($('#txtUsuario').val().length == 0) {
        $('#pUsuario').html("No puedes dejar este campo en blanco.");
        $('#pUsuario').attr('class', 'error');
    }

    if ($('#txtContrasenha').val().length == 0) {
        $('#pContrasenha').html("No puedes dejar este campo en blanco.");
        $('#pContrasenha').attr('class', 'error');
    }

    validarIgualdad()
    validarFecha()

    if ($('.error').length > 0) {
        return false;
    }
});
