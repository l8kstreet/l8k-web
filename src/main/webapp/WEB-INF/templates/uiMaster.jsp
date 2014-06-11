<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <fmt:setBundle basename="etiquetas"/>

        <c:set var="req" value="${pageContext.request}" />
        <c:set var="uri" value="${req.requestURI}" />
        <base href="${fn:replace(req.requestURL, fn:substring(uri, 0, fn:length(uri)), req.contextPath)}/">

        <title><tiles:getAsString name="title" /></title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1" />
        <meta http-equiv="pragma" content="no-cache"/>
        <meta http-equiv="cache-control" content="no-cache"/>
        <meta http-equiv="expires" content="0"/>
        <link href="resources/css/html5/normalize.css" rel="stylesheet" type='text/css' />
        <link href="resources/css/master.css" rel="stylesheet" type='text/css' />
        <link href="resources/css/css-ids.css" rel="stylesheet" type='text/css' />
        <link href="resources/css/global.css" rel="stylesheet" type='text/css' />

        <!--[if lt IE 9]>
            <script type="text/javascript">
                //Redirect IE6, IE7 and IE8
                window.location = 'notsupported.html';
            </script>
        <![endif]-->

    </head>
    <body>

        <noscript>
            <h1>Comprobando si javascript está habilitado</h1>
            <div>
                Javascript está deshabilitado en su navegador web.<br />
                Por favor, para ver correctamente este sitio,<br />
                <b><i>habilite javascript</i></b>.
                <br />
                <br />
                Para ver las instrucciones para habilitar javascript<br />
                en su navegador, haga click 
                <a href="http://www.enable-javascript.com/es/" target="_blank">aquí</a>.
            </div>
        </noscript>

        <header class="visible-none">

        </header>

        <section class="visible-none">

            <div id="contenPanel">
                <tiles:insertAttribute name="body" />
            </div>

            <nav>
                <ul>
                    <li id="nav_li_menu"><a>Menú</a></li>
                    <li><a href="mantenimietno/negocio_listar.html">Negocios</a></li>
                    <li><a>Eventos</a></li>
                    <li><a>CSS3</a></li>
                    <li><a>Django</a></li>
                    <li><a>Publicar</a></li>
                </ul>
            </nav>

            <div id="div_menu" class="visible-none">
                <ul>
                    <li><a href="mantenimietno/negocio_listar.html">Negocios</a></li>
                    <li><a>Eventos</a></li>
                    <li><a>CSS3</a></li>
                    <li><a>Django</a></li>
                    <li><a>Publicar</a></li>
                </ul>
            </div>

        </section>

        <footer>
            <div>l8kstreet</div>
        </footer>

        <tiles:importAttribute name="pageMapJs" scope="page"/>
        <c:if test="${pageMapJs == 'true'}">
            <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
        </c:if>

        <script src="resources/js/lib/jquery-2.0.3.min.js"></script>
        <script src="resources/js/lib/jquery-ui.min.js"></script>
        <script src="resources/js/lib/jquery.form.js"></script>
        <script src="resources/js/lib/prefixfree.js"></script>

        <script src="resources/js/ui/jsGeneral.js"></script>
        <script src="resources/js/app/l8kstreet.js" ></script>
        <script src="resources/js/app/service/service.js" ></script>
        <script src="resources/js/app/service/padre/padreService.js" ></script>
        <script src="resources/js/app/service/seguridad/usuarioService.js" ></script>
        <script src="resources/js/app/service/mantenimiento/negocioService.js" ></script>

        <tiles:importAttribute name="pageJs" scope="page"/>
        <c:if test="${not empty pageJs}">
            <script src="<tiles:getAsString name="pageJs"/>"></script>
        </c:if>
    </body>
</html>
