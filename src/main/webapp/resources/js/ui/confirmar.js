
$(function() {

    user = sessionStorage.getItem('usuario');
    correo = sessionStorage.getItem('correo');

    $('#lblUsuario').html(user);
    $('#lblCorreo').html(correo);

});
