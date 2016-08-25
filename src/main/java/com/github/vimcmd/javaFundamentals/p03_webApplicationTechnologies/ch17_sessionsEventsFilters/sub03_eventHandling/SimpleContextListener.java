package com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch17_sessionsEventsFilters.sub03_eventHandling;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SimpleContextListener implements ServletContextListener {

    /**
     * Initialization parameters in <b>web.xml</b>:
     * <br>
     * <pre>
     * &lt;context-param&gt;
     *   &lt;param-name&gt;feedback&lt;/param-name&gt;
     *   &lt;param-value&gt;blinov@gmail.com&lt;/param-value&gt;
     * &lt;/context-param&gt;
     * </pre>
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String mailFeedback = context.getInitParameter("feedback");
        context.log("Context initialized with parameter: " + mailFeedback);
        System.out.println("Context initialized with parameter: " + mailFeedback);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
