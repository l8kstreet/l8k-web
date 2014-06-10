<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="etiquetas"/>

<div id="contenedor">

    <div style="padding: 0.6em;height: 30px;border-bottom: 1px solid rgba(0, 0, 0, 0.2);">
        Mantenimiento de Negocios y locales:
    </div>

    <div>

        <div id="div_items_negocio" >
            <figure id="figure_loading" class="figure100 visible-none">
                <img src="resources/img/img-loading.gif" />
            </figure>

            <article id="article_mas" >
                <figure class="figure100">
                    <img class="hover transition" src="resources/img/img-mas.png" title="Agregar Negocio" />
                </figure>
            </article>
        </div>

        <div class="flotarDerecha70" >
            <form>
                <div>
                    <h3 class="flotarIzquierda" >Detalle del Negocio</h3>

                    <figure id="figureLogo" class="figure50 flotarDerecha">
                        <img src="" />
                    </figure>
                </div>

                <hr style="display: block;">

                <div class="rowLabel">
                    <label>Negocio:</label>
                    <label id="lblNegocio"></label>
                </div>

                <div class="rowLabel">
                    <label>Dirección:</label>
                    <label id="lblDireccion"></label>
                </div>

                <div class="rowLabel">
                    <label>Contacto:</label>
                    <label id="lblContacto"></label>
                </div>

                <div class="rowLabel">
                    <label>Correo:</label>
                    <label id="lblCorreo"></label>
                </div>

                <div class="rowLabel">
                    <label>Descripción:</label>
                    <label id="lblDescripcion"></label>
                </div>

                <div><input type="button" id="btnEditarNegocio" value="Editar" /></div>
            </form>

            <form>
                <h3 class="margen-superior30">Lista de Locales</h3>
                <hr>

                <div id="div_items_local">
                    <div id="div_item">
                        <figure id="figure_local_mas" class="figure100 flotarIzquierda">
                            <img class="cursorPointer" src="resources/img/img-mas.png" title="Agregar Local" />
                        </figure>

                        <div class="flotarIzquierda">
                            <div>
                                <input type="text" name="txtLocal" class="textLabel" disabled />
                            </div>
                            <div>
                                <input type="text" name="txtDireccion" class="textLabel" disabled />
                            </div>
                            <div>
                                <input type="text" name="txtTelefono" class="textLabel" disabled />
                            </div>
                        </div>
                    </div>
                </div>

            </form>
        </div>

    </div>

</div>
