package com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch17_sessionsEventsFilters.sub01_session.timeout;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

public class SessionLocator {
    private static final String BR = "<br/><hr/>";
    public static boolean flag = true;

    public static ArrayList<String> addMessage(HttpSession session) {
        ArrayList<String> messages = new ArrayList<>();
        if (session != null) {
            messages.add("Creation Time : " + new Date(session.getCreationTime()) + BR);
            messages.add("Session id : " + session.getId() + BR);
            messages.add("Session alive!" + BR);
        } else {
            messages.add("Session disabled!" + BR);
        }
        return messages;
    }
}
