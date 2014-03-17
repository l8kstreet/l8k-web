<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<%-- 
    Document   : login
    Created on : 11/03/2014, 05:05:38 PM
    Author     : jaquise
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>l8kstreet</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1" />
        <link href="/l8k-web/resources/css/html5/normalize.css" rel="stylesheet" type='text/css' />
        <link href="/l8k-web/resources/css/login.css" rel="stylesheet" type='text/css' />
    </head>
    <body>
        <header>
            <figure id="logo" >
                <img src="/l8k-web/resources/img/logo.png" />
            </figure>
            <p>l8kstreet</p>
        </header>

        <section>
            <div id="contenido" >
                
                <figure>
                    <img src="/l8k-web/resources/img/fondo.png" />
                </figure>
                
                <h1>Iniciar sesión en l8kstreet</h1>

                <form id="frmLogin" method="post" >
                    <input id="hidenAcceso" type="hidden" value="${acceso}" />                    
                    <input type="text" id="txtUsuario" name="usuario" placeholder="Nombre de usuario" required="required" >
                    <input type="password" id="txtContrasenha" name="contrasenha" placeholder="Contraseña" required="required" >
                    <p id="msgError" class="error" >El usuario o la contraseña que ingresaste son incorrectos.</p>
                    
                    <input type="submit" value="Iniciar sesión" >
                </form>
                
                <p>¿Eres nuevo en l8kstreet? 
                    <a href="login/registrar" >Regístrate ahora</a>
                </p>
            </div>
        </section>

        <footer>

        </footer>
        
<!--        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>-->
        <script src="/l8k-web/resources/js/login.js"></script>
    </body>
</html>
