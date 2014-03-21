
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<%-- 
    Document   : registrar
    Created on : 12/03/2014, 02:54:10 PM
    Author     : jaquise
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>l8kstreet</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1"/>
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
            <div>
                <h1>Bienvenido a l8kstreet.</h1>

                <c:if test="${tipo == 1}" >
                    <p>
                        Se ha creado su cuenta con el usuario '${objUsuario.usuario}'.
                        Para continuar ingrese a su cuenta de correo('${objUsuario.correo}') para confirmar su registro y activar su cuenta en l8kstreet.
                    </p>
                </c:if>
                <c:if test="${tipo == 0}" >
                    <p>
                        Su cuenta en l8kstreet aún no ha sido activado, por favor revise su cuenta de correo('${objUsuario.correo}') para confirmar su registro y activar su cuenta en l8kstreet.
                    </p>
                </c:if>
            </div>
        </section>

        <footer>

        </footer>
    </body>
</html>
