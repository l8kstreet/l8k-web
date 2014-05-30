
$(function() {
    
    selecctedNegocio = {};
    
    $("#btnEditarNegocio").on("click", onClickBtnEditarNegocio);
    $("#article_mas figure").on("click", function() {
        sessionStorage.removeItem("negocio");
        irAPagina('mantenimietno/negocio_insertar.html');
    });

    //Listar Negocios
    $("#figure_loading").attr("class", "visible");
    app.service.negocio.listar({}, listarSuccess, undefined);
});

function listarSuccess(resultList) {

    var $list = $("#div_items_negocio");
    var $post = $("#article_mas");

    $.each(resultList, function(index, obj) {
        $clone = $post.clone();

        $clone.attr("id", "article_" + obj.negocioId);

        $clone.find("figure img").attr("src", "resources/img/negociologo/" + obj.logo)
                .on("click", function(e) {
                                cargarItemNegocio(obj);
                            });

        $clone.find("span").text(obj.nombre);

        $clone.hide();
        $list.prepend($clone);
        $clone.fadeIn();
    });

    $("#figure_loading").attr("class", "visible-none");
}

function cargarItemNegocio(negocioObj) {
    selecctedNegocio = negocioObj;
    
    $("#lblNegocio").html(negocioObj.nombre);
    $("#lblDescripcion").html(negocioObj.descripcion);
    $("#lblDireccion").html(negocioObj.direccion);
    $("#lblContacto").html(negocioObj.contacto);
    $("#lblCorreo").html(negocioObj.correo);
    $("#figureLogo img").attr("src", "resources/img/negociologo/" + negocioObj.logo);
}

function onClickBtnEditarNegocio(e){
    sessionStorage.setItem("negocio", JSON.stringify(selecctedNegocio));
    irAPagina("mantenimietno/negocio_insertar.html");
}