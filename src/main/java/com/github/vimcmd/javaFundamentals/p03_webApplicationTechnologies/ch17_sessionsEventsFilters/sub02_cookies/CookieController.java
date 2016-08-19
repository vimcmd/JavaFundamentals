package com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch17_sessionsEventsFilters.sub02_cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookiecontroller")
public class CookieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CookieAction.setCookie(resp); // add cookies
        // extract cookies and add information to request
        req.setAttribute("messages", CookieAction.addToRequest(req));
        req.getRequestDispatcher("cookies/jsp/maincookie.jsp").forward(req, resp); // ref to facet
    }
}
