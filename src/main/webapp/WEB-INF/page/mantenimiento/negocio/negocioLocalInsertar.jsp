<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="etiquetas"/>

<div id="contenedor">

    <div>

        <div>
            <div>
                <h3 class="margenIzquierda">Local:</h3>
                <hr class="flotarIzquierda60">
            </div>

            <form id="frmLocalInsertar" class="flotarIzquierda50">
                <div>
                    <div class="tdSmall">
                        <label>Local:</label>
                        <p>Nombre del local.</p>
                    </div>
                    <div class="tdSmall">
                        <input type="text" name="nombre" required />
                    </div>
                </div>

                <div>
                    <div class="tdSmall">
                        <label>Dirección:</label>
                        <p>Dirección del local.</p>
                    </div>
                    <div class="tdSmall">
                        <input type="text" name="direccion" required />
                    </div>
                </div>

                <div>
                    <div class="tdSmall">
                        <label>Horario:</label>
                        <p>Horario de atención.</p>
                    </div>
                    <div class="tdSmall">
                        <input type="text" name="horario" required />
                    </div>
                </div>

                <div>
                    <div class="tdSmall">
                        <label>Teléfono:</label>
                        <p>Teléfono del local.</p>
                    </div>
                    <div class="tdSmall">
                        <input type="text" name="telefono" required />
                    </div>
                </div>

                <div>
                    <div class="tdSmall">
                        <label>Correo:</label>
                        <p>Correo del local.</p>
                    </div>
                    <div class="tdSmall">
                        <input type="email" name="correo" required />
                    </div>
                </div>

                <div>
                    <div class="tdSmall">
                        <label>Correo de Contacto:</label>
                        <p>Correo de contacto del local.</p>
                    </div>
                    <div class="tdSmall">
                        <input type="email" name="correoContacto" required />
                    </div>
                </div>

                <div>
                    <div class="tdSmall">
                        <label>Tipo:</label>
                        <p>Tipo de negocio.</p>
                    </div>
                    <div class="tdSmall">
                        <input type="text" name="tipo" required />
                    </div>
                </div>

                <div>
                    <div class="tdSmall">
                        <label>Descripcion:</label>
                        <p>Detallar la descripcion del correo.</p>
                    </div>
                    <div class="tdSmall">
                        <textarea name="descripcion" style="resize: none;height: 100px;"></textarea>
                    </div>
                </div>
            </form>

            <div class="flotarIzquierda50">
                <div>
                    <div id="map-canvas" style="width: 445px;height: 300px;">
                    </div>

                    <div>
                        <div class="tdSmall">
                            <p>Ubicacion geografica:</p>
                        </div>
                        <div class="tdSmall">
                            <p id="pLatLong"></p>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div id="div_img" class="margen-superior30 margenIzquierda margenDerecha">

            <figure class="figure100 inline-block">
            </figure>

            <div class="margen-superior30">
                <form id="frmImg" >
                    <input id="fileImg" type="file" name="file" />
                </form>
            </div>
        </div>

        <div class="margen-superior30">
            <input type="button" id="btnGuardar" value="Guardar" />
            <input type="button" id="btnCancelar" value="Cancelar" />
        </div>

    </div>

</div>
