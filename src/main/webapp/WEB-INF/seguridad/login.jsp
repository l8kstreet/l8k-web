
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div id="contenido" >

    <figure>
        <img src="/l8k-web/resources/img/fondo.png" />
    </figure>

    <h1>Iniciar sesión en l8kstreet</h1>

    <form id="frmLogin" >
        <input type="text" id="txtUsuario" name="usuario" placeholder="Nombre de usuario" required="required" >
        <input type="password" id="txtContrasenha" name="contrasenha" placeholder="Contraseña" required="required" >
        <p id="msgError" class="errornone" >El usuario o la contraseña que ingresaste son incorrectos.</p>

        <input type="submit" id="btnLogin" value="Iniciar sesión" >
    </form>

    <p>¿Eres nuevo en l8kstreet? 
        <a href='<c:url value="/registrar.html" />' >Regístrate ahora</a>
    </p>
</div>
