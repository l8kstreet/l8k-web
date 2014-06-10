
var local = {};
var map;
var markers = [];
var latLong;
var tipoEdicion = "NUEVO";
var listImg = [];

$(function() {
    google.maps.event.addDomListener(window, 'load', mapInitialize);

    $("#btnGuardar").on("click", onClickBtnGuardar);
    $("#btnCancelar").on("click", onClickBtnCancelar);
    $("#fileImg").on("change", onChangeFileImg);

    cargarData();
});

function mapInitialize() {
    var mapOptions = {
        zoom: 6,
        center: new google.maps.LatLng(-12.050737, -77.035561)
    };
    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

    google.maps.event.addListener(map, 'click', function(event) {
        addMarker(event.latLng, false);
    });

    if (latLong) {
        addMarker(latLong, true);
    }
}
function addMarker(location, center) {

    if (center === true) {
        map.setCenter(location);
    }

    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
    }
    markers = [];

    var marker = new google.maps.Marker({
        position: location,
        map: map
                //draggable: true
    });
    markers.push(marker);
    $("#pLatLong").html("Latitud: " + location.lat() + ", " + "Longitud: " + location.lng());
}

function cargarData() {

    if (sessionStorage.getItem("local")) {
        local = JSON.parse(sessionStorage.getItem("local"));

        tipoEdicion = "ACTUALIZAR";
        $("#frmLocalInsertar input[name='nombre']").val(local.nombre);
        $("#frmLocalInsertar textarea[name='descripcion']").val(local.descripcion);
        $("#frmLocalInsertar input[name='direccion']").val(local.direccion);
        $("#frmLocalInsertar input[name='horario']").val(local.horario);
        $("#frmLocalInsertar input[name='telefono']").val(local.telefono);
        $("#frmLocalInsertar input[name='correo']").val(local.correo);
        $("#frmLocalInsertar input[name='correoContacto']").val(local.correoContacto);
        $("#frmLocalInsertar input[name='tipo']").val(local.tipo);

        latLong = new google.maps.LatLng(local.latitud, local.longitud);
        listImg = local.fotos;

        for (n = 0; n < local.fotos.length; n++) {
            $("#div_img figure").append("<img src='resources/img/locales/" + local.fotos[n] + "' />");
        }

    } else {
        tipoEdicion = "NUEVO";
    }
}

function onClickBtnGuardar(e) {
    
    if(markers.length === 0){
        alert('No se ha asignado una ubicacion geografica.');
        return;
    }

    local.negocioId = JSON.parse(sessionStorage.getItem("negocio")).negocioId;
    local.nombre = $("#frmLocalInsertar input[name='nombre']").val();
    local.descripcion = $("#frmLocalInsertar textarea[name='descripcion']").val();
    local.direccion = $("#frmLocalInsertar input[name='direccion']").val();
    local.horario = $("#frmLocalInsertar input[name='horario']").val();
    local.telefono = $("#frmLocalInsertar input[name='telefono']").val();
    local.correo = $("#frmLocalInsertar input[name='correo']").val();
    local.correoContacto = $("#frmLocalInsertar input[name='correoContacto']").val();
    local.tipo = $("#frmLocalInsertar input[name='tipo']").val();
    local.fotos = listImg;
    local.longitud = markers[0].position.lng();
    local.latitud = markers[0].position.lat();

    if (tipoEdicion === 'NUEVO') {
        app.service.negocio.insertarLocal(local, undefined, undefined, insertarComplete);
    } else {
        app.service.negocio.actualizarLocal(local, undefined, undefined, insertarComplete);
    }
}
function insertarComplete() {
    irAPagina('mantenimietno/negocio_listar.html');
}

function onClickBtnCancelar() {
    irAPagina('mantenimietno/negocio_listar.html');
}

function onChangeFileImg() {
    app.service.padre.subirImagen(
            $("#frmImg"),
            function(result) {
                listImg.push(result);
                $("#div_img figure").append("<img src='resources/img/temp/" + result + "' />");
            }
    );
}