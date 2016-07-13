package com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch17_sessionsEventsFilters.sub01_session;

// # 1 # add information to session

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sesionservlet")
public class SessionControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        if (session.getAttribute("role") == null) {
            session.setAttribute("role", "moderator");
        }

        // request count
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            session.setAttribute("counter", 1);
        } else {
            counter++;
            session.setAttribute("counter", counter);
        }

        req.setAttribute("lifecycle", "CONTROL request LIFECYCLE");
        req.getRequestDispatcher("/jsp/sessionattr.jsp").forward(req, resp);
    }

}
