<%-- # 2 # information about session --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session Attribute</title>
</head>
<body>
    Role: ${role}
    <br/>
    <hr/>
    MaxInactiveInterval: ${pageContext.session.maxInactiveInterval}
    <br>
    IdSession: ${pageContext.session.id}
    <br>
    Lifecycle: ${lifecycle}
</body>
</html>
