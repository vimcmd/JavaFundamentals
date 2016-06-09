<%-- # 3 # implicit objects in expression language --%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>EL for pageContext</title></head>
<body>

Context path: ${pageContext.request.contextPath} <br> <%-- returns "" if context path is '/' --%>
Host name: ${header["host"]} <br>
Content type and encoding: ${pageContext.response.contentType} <br>
Response encoding: ${pageContext.response.characterEncoding} <br>
Session ID: ${pageContext.request.session.id} <br>
Session creation time in ms: ${pageContext.request.session.creationTime} <br>
Session last access time in ms: ${pageContext.request.session.lastAccessedTime} <br>
Servlet name: ${pageContext.servletConfig.servletName}

</body>
</html>