package com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch17_sessionsEventsFilters.sub03_eventHandling;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // write to log file or smth. else
        System.out.println("added: " +
                event.getClass().getSimpleName() +
                " : " +
                event.getName() +
                " : " +
                event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // write to log file or smth. else
        System.out.println("replaced: " +
                event.getClass().getSimpleName() +
                " : " +
                event.getName() +
                " : " +
                event.getValue());
    }
}
