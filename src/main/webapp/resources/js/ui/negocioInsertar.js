
$(function() {

    negocio = {};
    logoName = "";

    $("#fileLogo").on("change", onChange);
    $("#btnGuardar").on("click", onClickBtnGuardar);

    $("#btnCancelar").on("click", function() {
        irAPagina('mantenimietno/negocio_listar.html');
    });

    cargarData();
});

function cargarData() {

    if (sessionStorage.getItem("negocio")) {
        negocio = JSON.parse(sessionStorage.getItem("negocio"));
        
        tipoEdicion = "ACTUALIZAR";
        $("#frmNegocioInsertar input[name='nombre']").val(negocio.nombre);
        $("#frmNegocioInsertar textarea[name='descripcion']").val(negocio.descripcion);
        $("#frmNegocioInsertar input[name='direccion']").val(negocio.direccion);
        $("#frmNegocioInsertar input[name='contacto']").val(negocio.contacto);
        $("#frmNegocioInsertar input[name='correo']").val(negocio.correo);
        $("#imgLogo").attr("src", "resources/img/negociologo/" + negocio.logo)
        
        logoName = negocio.logo;
    } else {
        tipoEdicion = "NUEVO";
    }
}

function onChange(e) {
    app.service.padre.subirImagen(
            $("#frmLogo"),
            function(result) {
                logoName = result;
                $("#imgLogo").attr("src", "resources/img/temp/" + logoName);
            }
    );
}
function onClickBtnGuardar(e) {
    
    negocio.nombre = $("#frmNegocioInsertar input[name='nombre']").val();
    negocio.descripcion = $("#frmNegocioInsertar textarea[name='descripcion']").val();
    negocio.direccion = $("#frmNegocioInsertar input[name='direccion']").val();
    negocio.contacto = $("#frmNegocioInsertar input[name='contacto']").val();
    negocio.correo = $("#frmNegocioInsertar input[name='correo']").val();
    negocio.logo = logoName;

    if (tipoEdicion === "NUEVO") {
        app.service.negocio.insertar(negocio, undefined, undefined, insertarComplete);
    } else {
        app.service.negocio.actualizar(negocio, undefined, undefined, insertarComplete);
    }
}

function insertarComplete() {
    irAPagina('mantenimietno/negocio_listar.html');
}
