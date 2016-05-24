<%-- # 3 # simple jsp with servlet call --%>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<html>
    <head>
        <title>JSP Timing</title>
    </head>
    <body>
        <h5>Time counter from the application start till button click</h5>
        <jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>
        <form name="Simple" action="${pageContext.request.contextPath}/timeAction" method="POST">
            <input type="hidden" name="time" value="${calendar.timeInMillis}">
            <input type="submit" name="button" value="Count time">
        </form>
    </body>
</html>