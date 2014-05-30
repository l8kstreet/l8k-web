
$(function() {

    $("#frmRegistrar").focus();
    $(document).on("submit", "#frmRegistrar", submitBtnRegistrar);

    $('#txtNombre').on('blur', validarData);
    $('#txtCorreo').on('blur', validarData);
    $('#txtUsuario').on('blur', validartxtUsuario);
    $('#txtContrasenha').on('blur', validarData);
    $('#txtConfirmar').on('blur', validarIgualdad);
    $('#txtDia').on('blur', validarDate);
    $('#txtAnho').on('blur', validarDate);
    $('#cboMes').on('change', validarDate);

    $('#txtDia').on('keypress', validateSoloNumeros);
    $('#txtAnho').on('keypress', validateSoloNumeros);

    $('#btnRegistrar').on('click', onClickBtnRegistrar);

    //Listar Paises
    app.service.padre.listarPaises(listarPaisesSuccess, undefined);
});

function listarPaisesSuccess(resultList) {
    var $cboPais = $('#cboPais');
    var options = undefined;

    if ($cboPais.prop)
        options = $cboPais.prop('options');
    else
        options = $cboPais.attr('options');

    $.each(resultList, function(index, obj) {
        options[options.length] = new Option(obj.descripcion, obj.codigo);
    });
}

function onClickBtnRegistrar(e) {
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

    validarIgualdad();
    validarDate();

    if ($('.error').length > 0) {
        return false;
    }
}

function submitBtnRegistrar(e) {
    var user = {};
    user.nombre = $("#frmRegistrar input[name='nombre']").val();
    user.correo = $("#frmRegistrar input[name='correo']").val();
    user.usuario = $("#frmRegistrar input[name='usuario']").val();
    user.contrasenha = $("#frmRegistrar input[name='contrasenha']").val();
    user.pais = $("#frmRegistrar select[name='pais']").val();
    user.txtDia = $("#frmRegistrar input[name='txtDia']").val();
    user.cboMes = $("#frmRegistrar select[name='cboMes']").val();
    user.txtAnho = $("#frmRegistrar input[name='txtAnho']").val();

    app.service.usuario.insertar(user, insertarSuccess, insertarError);
    return false;
}
function insertarSuccess(result) {
    console.log(result);
    sessionStorage.setItem('usuario', result.usuario);
    sessionStorage.setItem('correo', result.correo);
    irAPagina("confirmar.html");
}
function insertarError(result) {
    console.log(result);
    alert('Error');
}

function validarDate() {
    if(validarFecha($('#txtDia'), $('#cboMes'), $('#txtAnho')))
        $('#pFecha').attr('class', 'errornone');
    else
        $('#pFecha').attr('class', 'error');
}

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

        app.service.usuario.verificarUsurio(user, function(data) {

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