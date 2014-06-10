
var selecctedNegocio = {};
var selecctedLocal = {};

$(function() {

    $("#btnEditarNegocio").on("click", onClickBtnEditarNegocio);
    $("#article_mas figure").on("click", onClickArticle_mas);
    $("#figure_local_mas").on("click", onClickArticle_local_mas);

    //Listar Negocios
    $("#figure_loading").attr("class", "visible");
    app.service.negocio.listar({}, listarSuccess, undefined);
});

function listarSuccess(resultList) {

    var $list = $("#div_items_negocio");
    var $post = $("#article_mas");

    $.each(resultList, function(index, obj) {
        var $clone = $post.clone();

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

    var n = resultList.length;
    if (n > 0) {
        cargarItemNegocio(resultList[n - 1]);
    }

    $("#figure_loading").attr("class", "visible-none");
}

function cargarItemNegocio(negocioObj) {
    selecctedNegocio = negocioObj;

//Cargar Detalle
    $("#lblNegocio").html(negocioObj.nombre);
    $("#lblDescripcion").html(negocioObj.descripcion);
    $("#lblDireccion").html(negocioObj.direccion);
    $("#lblContacto").html(negocioObj.contacto);
    $("#lblCorreo").html(negocioObj.correo);
    $("#figureLogo img").attr("src", "resources/img/negociologo/" + negocioObj.logo);

//Cargar Lista de Locales

    var $list = $("#div_items_local");
    var $post = $("#div_item");

    $list.empty();
    $.each(negocioObj.listLocal, function(index, item) {
        var $clone = $post.clone();

        $clone.attr("id", "div_item_" + item.localId);
        $clone.attr("class", "border-bottom margenDerecha");
        $clone.append("<input type='button' value='Editar' class='flotarDerecha' />");
        $clone.find("input[type='button']").on("click", function() {
            sessionStorage.setItem("local", JSON.stringify(item));
            sessionStorage.setItem("negocio", JSON.stringify(selecctedNegocio));
            irAPagina("mantenimietno/negocio_local_insertar.html");
        });

        var mapa = new Image();
        mapa.src = "http://maps.googleapis.com/maps/api/staticmap?zoom=15&size=200x200&markers=" + item.latitud + "," + item.longitud + "&sensor=false&center=" + item.latitud + "," + item.longitud + "";

        $clone.find("figure").removeAttr("id");
        
        $clone.find("figure").empty();
        $clone.find("figure").append(mapa);
        
//        $clone.find("figure img").removeAttr("title");
//        $clone.find("figure img").attr("src", "resources/img/none.jpg");

        $clone.find("input[name='txtLocal']").val(item.nombre);
        $clone.find("input[name='txtLocal']").parent().prepend("<label>Local:</label>");

        $clone.find("input[name='txtDireccion']").val(item.direccion);
        $clone.find("input[name='txtDireccion']").parent().prepend("<label>Dirección:</label>");

        $clone.find("input[name='txtTelefono']").val(item.telefono);
        $clone.find("input[name='txtTelefono']").parent().prepend("<label>Teléfono:</label>");
        

        $clone.hide();
        $list.append($clone);
        $clone.fadeIn();
    });

    $post.find("#figure_local_mas").on("click", onClickArticle_local_mas);
    $list.append($post);
}

function onClickBtnEditarNegocio(e) {
    sessionStorage.setItem("negocio", JSON.stringify(selecctedNegocio));
    irAPagina("mantenimietno/negocio_insertar.html");
}
function onClickArticle_mas() {
    sessionStorage.removeItem("negocio");
    irAPagina('mantenimietno/negocio_insertar.html');
}
function onClickArticle_local_mas() {
    sessionStorage.removeItem("local");
    sessionStorage.setItem("negocio", JSON.stringify(selecctedNegocio));
    irAPagina('mantenimietno/negocio_local_insertar.html');
}
