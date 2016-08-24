package com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch17_sessionsEventsFilters.sub03_eventHandling;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class SimpleRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request destroyed: " + sre.getServletRequest().getAttribute("lifecycle"));
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // will be used to obtain information about request
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();

        String uri = "Request initialized for: " + request.getRequestURI();
        String id = "Request initialized with ID: " + request.getRequestedSessionId();

        System.out.println(uri + "\n" + id);
        ServletContext servletContext = sre.getServletContext();

        // created request counter
        Integer counter = (Integer) request.getSession().getAttribute("counter");

        if (counter == null) {
            counter = 0;
        }

        servletContext.log(uri + "\n" + id + "\nRequest count: " + counter);
    }
}
