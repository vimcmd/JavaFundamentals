package p03_webApplicationTechnologies.ch15_servlets.sub01_basics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        resp.getWriter().print("This is " + this.getClass().getName() + ", using the GET method.");
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
