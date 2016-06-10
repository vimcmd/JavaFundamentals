<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Default Action Tags in JSP</title></head>
<body>

<jsp:useBean id="defaultMsg" scope="request"
             class="com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch16_javaServerPage.sub04_defaultActionTags.Message"/>

<jsp:useBean id="msg" scope="request"
             class="com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch16_javaServerPage.sub04_defaultActionTags.Message">
    <jsp:setProperty name="msg" property="id" value="1623"/>
    <jsp:setProperty name="msg" property="text" value="JSP action tags in action!"/>
</jsp:useBean>

<span style="font-size: large;">

    Default Bean: <br>
    &nbsp; id: <jsp:getProperty name="defaultMsg" property="id"/> <br>
    &nbsp; text: <jsp:getProperty name="defaultMsg" property="text"/> <br>
    &nbsp; class: <jsp:getProperty name="defaultMsg" property="class"/> <br>

    Bean created in jsp: <br>
    &nbsp; id: <jsp:getProperty name="msg" property="id"/> <br>
    &nbsp; text: <jsp:getProperty name="msg" property="text"/> <br>
    &nbsp; class: <jsp:getProperty name="msg" property="class"/> <br>

</span>

</body>
</html>