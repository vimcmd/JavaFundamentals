package com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch17_sessionsEventsFilters.sub02_cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CookieAction {
    private static int number = 1;

    public static void setCookie(HttpServletResponse resp) {
        String name = "JamesBond";
        String role = "00" + number++;
        Cookie cookie = new Cookie(name, role);
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);

        String locale = resp.getLocale().toString();
        Cookie location = new Cookie("locale", locale);
        resp.addCookie(location);

    }

    public static ArrayList<String> addToRequest(HttpServletRequest req) {
        ArrayList<String> messages = new ArrayList<>();
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            messages.add("Number cookies: " + cookies.length);
            for(Cookie cookie : cookies) {
                messages.add(cookie.getName() + " = " + cookie.getValue());
            }
        }
        return messages;
    }
}
