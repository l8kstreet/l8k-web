<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>--%>

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
        <link href="/l8k-web/resources/css/html5/normalize.css" rel="stylesheet" type='text/css' />
        
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
        
        <nav>
            
        </nav>
        
        <section>
            
        </section>
        
        <footer>
            
        </footer>
        
        
        <script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
        <script src="/l8k-web/resources/js/lib/prefixfree.js"></script>
        
        <script src="/l8k-web/resources/js/ui/general.js"></script>
        <script src="/l8k-web/resources/js/app/l8kstreet.js" ></script>
        <script src="/l8k-web/resources/js/app/service/service.js" ></script>
        <script src="/l8k-web/resources/js/app/service/usuario/usuario.js" ></script>
        
        <tiles:importAttribute name="pageJs" scope="page"/>
        <c:if test="${not empty pageJs}">
            <script src="<tiles:getAsString name="pageJs"/>"></script>
        </c:if>
    </body>
</html>
