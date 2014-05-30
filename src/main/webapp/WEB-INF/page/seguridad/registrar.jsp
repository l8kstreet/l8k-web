<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="etiquetas"/>

<div id="contenido">
    <h1>Regístrate</h1>

    <form id="frmRegistrar" >

        <label for="txtNombre" >Nombre completo</label>
        <input type="text" id="txtNombre" name="nombre" required />
        <p id="pNombre" class="errornone">No puedes dejar este campo en blanco.</p>

        <label for="txtCorreo" >Dirección de correo electrónico</label>
        <input type="email" id="txtCorreo" name="correo" required />
        <p id="pCorreo" class="errornone">No puedes dejar este campo en blanco.</p>

        <label for="txtUsuario" >Escoge tu nombre de usuario</label>
        <input type="text" id="txtUsuario" name="usuario" required />
        <p id="pUsuario" class="errornone">No puedes dejar este campo en blanco.</p>

        <label for="txtContrasenha" >Crea una contraseña</label>
        <input type="password" id="txtContrasenha" name="contrasenha" required />
        <p id="pContrasenha" class="errornone">No puedes dejar este campo en blanco.</p>

        <label for="txtConfirmar" >Confirma tu contraseña</label>
        <input type="password" id="txtConfirmar" required />
        <p id="pConfirmar" class="errornone">Las contraseñas no coinciden.</p>

        <label>Fecha de Nacimiento</label>
        <div>
            <input type="text" id="txtDia" name="txtDia" placeholder="Dia" maxlength="2" required />

            <select id="cboMes" name="cboMes" >
                <option value="1"><fmt:message key="lk_mes_enero"/></option>
                <option value="2"><fmt:message key="lk_mes_febrero"/></option>
                <option value="3"><fmt:message key="lk_mes_marzo"/></option>
                <option value="4"><fmt:message key="lk_mes_abril"/></option>
                <option value="5"><fmt:message key="lk_mes_mayo"/></option>
                <option value="6"><fmt:message key="lk_mes_junio"/></option>
                <option value="7"><fmt:message key="lk_mes_julio"/></option>
                <option value="8"><fmt:message key="lk_mes_agosto"/></option>
                <option value="9"><fmt:message key="lk_mes_septiembre"/></option>
                <option value="10"><fmt:message key="lk_mes_octubre"/></option>
                <option value="11"><fmt:message key="lk_mes_noviembre"/></option>
                <option value="12"><fmt:message key="lk_mes_diciembre"/></option>
            </select>

            <input type="text" id="txtAnho" name="txtAnho" placeholder="Año" maxlength="4" required />
        </div>
        <p id="pFecha" class="errornone">Parece que la fecha no es correcta.</p>

        <label for="cboPais" >Pais</label>
        <select id="cboPais" name="pais" >
        </select>
        
        <input id="btnRegistrar" type="submit" value="Crear cuenta" />
        <a href='<c:url value="/" />' >Cancelar</a>
    </form>
</div>