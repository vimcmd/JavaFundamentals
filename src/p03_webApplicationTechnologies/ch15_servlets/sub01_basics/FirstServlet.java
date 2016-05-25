package p03_webApplicationTechnologies.ch15_servlets.sub01_basics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/* # 1 # simple servlet */

//@WebServlet("/FirstServletTest") // since Servlet API 3.0 registration in descriptor web.xml not necessary (extended annotation)
@WebServlet(name = "FirstServletName", urlPatterns = {"/FirstServletTest"})
public class FirstServlet extends HttpServlet {

    public FirstServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<div style='white-space: pre;'>"); // just separate lines in html

        out.println("--- REQUEST ---");
        out.println("This is " + this.getClass().getName() + ", using the GET method.");
        out.println("method: " + req.getMethod());
        out.println("request url: " + req.getRequestURL());
        out.println("request uri: " + req.getRequestURI());
        out.println("protocol: " + req.getProtocol());
        out.println("remote address: " + req.getRemoteAddr());
        out.println("remote user: " + req.getRemoteUser());
        out.println("context path: " + req.getContextPath());
        out.println("scheme: " + req.getScheme());

        out.println("--- HEADERS ---");
        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String name = headers.nextElement();
            String value = req.getHeader(name);
            out.println(name + ": " + value);
        }
        out.println("</div>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().print("This is " + this.getClass().getName() + ", using the POST method.");
    }

    @Override
    public void destroy() {
        super.destroy(); // just puts "destroy" string in log
    }
}
