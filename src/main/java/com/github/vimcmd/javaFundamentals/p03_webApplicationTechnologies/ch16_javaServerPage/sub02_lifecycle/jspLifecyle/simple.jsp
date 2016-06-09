<%-- # 2 # simple jsp page --%>
<%--

lifecycle:

- request from browser to jsp page
- jsp-engine analyzes jsp page content ang generates servelet and:
  - translates static content to out methods and puts them into _jspService() method
  - translates dynamic content to java code
- servlet code compiles into *.class and loaded to container - servlet installed and ready for work
- init() servlet method executed
- invoked jspService() method and servlet logically executed - response instance formed
- combination of static HTML and graphics with result of execution dynamic elements defined in
  original jsp send to browser via input stream of HttpServletResponse

  following requests to jsp file just invoke servlet _jspService() method. Servlet will be used
  untill server shutdown or servlet will be unloaded from container.

--%>
<html><head>
<title>Simple</title>
</head>
<body>
<jsp:text>Hello, Bender</jsp:text>
</body></html>