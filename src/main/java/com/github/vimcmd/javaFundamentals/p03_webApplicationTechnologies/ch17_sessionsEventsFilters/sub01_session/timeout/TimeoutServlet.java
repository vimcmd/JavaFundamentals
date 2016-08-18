package com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch17_sessionsEventsFilters.sub01_session.timeout;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/timeoutservlet")
public class TimeoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = null;
        if (SessionLocator.flag) {
            // create session and set invalidation period
            session = req.getSession();
            int timeLive = 10; // 10 seconds!
            session.setMaxInactiveInterval(timeLive);
            SessionLocator.flag = false;
        } else {
            // if session not exists, it reference will not be obtained
            session = req.getSession();
            if (session == null) {
                SessionLocator.flag = true;
            }
        }
        req.setAttribute("messages", SessionLocator.addMessage(session));
        req.getRequestDispatcher("session/jsp/time.jsp").forward(req, resp);
    }

}
