package p03_webApplicationTechnologies.ch15_servlets.sub02_servletAndJspInteraction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

// # 4 # simple controller

// When you need to expand the functionality of the system should not be
// create additional servlets. The servlet in the application must be one.

@WebServlet(name = "JSP Timing", urlPatterns = {"/timeAction"})
public class ServletTiming extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        String timeJsp = req.getParameter("time");
        float delta = (float) ( gregorianCalendar.getTimeInMillis() - Long.parseLong(timeJsp) ) / 1_000;
        req.setAttribute("res", delta);
        req.getRequestDispatcher("/secondProject/result.jsp").forward(req, resp);
    }
}
