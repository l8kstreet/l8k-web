
$(function() {

    $("#frmLogin").focus();
    $(document).on("submit", "#frmLogin", submitBtnLogin);

});

function submitBtnLogin(e) {
    var user = {};
    user.usuario = $("#frmLogin input[name='usuario']").val();
    user.contrasenha = $("#frmLogin input[name='contrasenha']").val();

    app.service.usuario.logear(user, loginSuccess, loginError);
    return false;
}

function loginSuccess(result) {
    if (result) {
        if (result.estado == 'I') {
            $('#msgError').html('La cuenta haun no se ha confirmado, revise su cuenta de correo(' + result.correo + ').');
            $('#msgError').attr('class', 'error');
        } else {
            window.location.href = app.baseURI + "main.html";
        }
    } else {
        $('#msgError').html('El usuario o la contraseña que ingresaste son incorrectos.');
        $('#msgError').attr('class', 'error');
    }
}

function loginError(result) {
    console.log(result);
    $('#msgError').html('El usuario o la contraseña que ingresaste son incorrectos.');
    $('#msgError').attr('class', 'error');
}
