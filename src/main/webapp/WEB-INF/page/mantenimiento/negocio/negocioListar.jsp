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

            <figure id="figure_loading" class="visible-none">
                <img src="resources/img/img-loading.gif" />
            </figure>

            <article id="article_mas" >
                <figure>
                    <img src="resources/img/img-mas.png" />
                </figure>
                <span>Agregar Negocio</span>
            </article>

        </div>

        <div id="div_detalle_negocio" class="flotarDerecha70" >
            <form>
                <div>
                    <h3 class="flotarIzquierda" >Detalle del Negocio</h3>

                    <figure id="figureLogo" class="flotarDerecha">
                        <img src="" />
                    </figure>
                </div>

                <hr style="display: block;">

                <div>
                    <label>Negocio:</label>
                    <label id="lblNegocio"></label>
                </div>

                <div>
                    <label>Dirección:</label>
                    <label id="lblDireccion"></label>
                </div>

                <div>
                    <label>Contacto:</label>
                    <label id="lblContacto"></label>
                </div>

                <div>
                    <label>Correo:</label>
                    <label id="lblCorreo"></label>
                </div>

                <div>
                    <label>Descripción:</label>
                    <label id="lblDescripcion"></label>
                </div>

                <div><input type="button" id="btnEditarNegocio" value="Editar" /></div>
                <!--<label><a id="link_editar" href="javascript:" >Editar</a></label>-->
            </form>

            <form>
                <h3 class="margen-superior30">Lista de Locales</h3>
                <hr>



            </form>
        </div>

    </div>

</div>
