<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="etiquetas"/>

<div id="contenedor">

    <div id="div_negocioInsertar" >

        <div>
            <div>
                <h3 class="margenIzquierda">Detalle del Negocio</h3>
                <hr class="flotarIzquierda60">
            </div>

            <form id="frmNegocioInsertar" >
                <div>
                    <div class="td">
                        <label>Negocio:</label>
                        <p>Nombre del negocio a registrar.</p>
                    </div>
                    <div class="td">
                        <input type="text" id="txtNombre" name="nombre" />
                    </div>
                </div>

                <div>
                    <div class="td">
                        <label>Dirección:</label>
                        <p>Dirección del negocio.</p>
                    </div>
                    <div class="td">
                        <input type="text" id="txtDireccion" name="direccion" />
                    </div>
                </div>

                <div>
                    <div class="td">
                        <label>Contacto:</label>
                        <p>Nombre contacto.</p>
                    </div>
                    <div class="td">
                        <input type="text" id="txtContacto" name="contacto" />
                    </div>
                </div>

                <div>
                    <div class="td">
                        <label>Correo:</label>
                        <p>Correo electronico.</p>
                    </div>
                    <div class="td">
                        <input type="email" id="txtCorreo" name="correo"  />
                    </div>
                </div>

                <div>
                    <div class="td">
                        <label>Descripción:</label>
                        <p>Detallar la descripcion del negocio.</p>
                    </div>
                    <div class="td">
                        <textarea id="txtDescripcion" name="descripcion" style="resize: none;height: 100px;"></textarea>
                    </div>
                </div>
            </form>

            <div>
                <div class="td">
                    <label>Logo:</label>
                    <p>Seleccionar una imagen para usarse como logo.</p>
                </div>
                <div class="td">
                    <form id="frmLogo" >
                        <figure class="figure150">
                            <img id="imgLogo" src="resources/img/none.jpg" />
                        </figure>
                        <input type="file" id="fileLogo" name="file" />
                    </form>
                </div>
            </div>
        </div>

        <div class="margen-superior30">
            <input type="button" id="btnGuardar" value="Guardar" />
            <input type="button" id="btnCancelar" value="Cancelar" />
        </div>

    </div>

</div>
