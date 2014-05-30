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
<!--        <meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="pragma" content="no-cache">-->
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

        <header>

        </header>

        <section>

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

        </section>

        <footer>
            <div>l8kstreet</div>
        </footer>

            
        <script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
        <script src="http://malsup.github.com/jquery.form.js"></script> 
        <script src="resources/js/lib/prefixfree.js"></script>

        <script src="resources/js/ui/general.js"></script>
        <script src="resources/js/app/l8kstreet.js" ></script>
        <script src="resources/js/app/service/service.js" ></script>
        <script src="resources/js/app/service/padre/padre.js" ></script>
        <script src="resources/js/app/service/seguridad/usuario.js" ></script>
        <script src="resources/js/app/service/mantenimiento/negocio.js" ></script>

        <tiles:importAttribute name="pageJs" scope="page"/>
        <c:if test="${not empty pageJs}">
            <script src="<tiles:getAsString name="pageJs"/>"></script>
        </c:if>
    </body>
</html>
