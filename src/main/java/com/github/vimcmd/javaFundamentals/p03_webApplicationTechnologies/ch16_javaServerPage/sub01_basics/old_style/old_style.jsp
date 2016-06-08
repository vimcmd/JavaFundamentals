<%-- # 1 # jsp-page with undesirable tags --%>
<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>JSP-page</title></head>
<body>

<%!
    /* undesirable block nowdays */
    private int count = 0;
    String version = "1.2";

    private String getName() {
        return "Old style";
    }
%>
<%
    /* undesirable block nowdays */
    out.println("Count value: ");
%>

<%=
/* undesirable block nowdays */
        count++
%>
<br>

<%
    out.println("Count value after increment: " + count);
%>
<br>

<%
    out.println("Version value: ");
%>
<%= version %>
<br>

<%
    version = getName();
    out.println("Version value after update: " + version);
%>


</body>
</html>