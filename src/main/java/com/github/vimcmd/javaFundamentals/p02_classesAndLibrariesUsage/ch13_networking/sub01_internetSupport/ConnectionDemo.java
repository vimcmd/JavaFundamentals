package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch13_networking.sub01_internetSupport;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* # 5 # information about internet-resource */

public class ConnectionDemo {
    public static void main(String[] args) {
        String urlName = "http://srv-nas-01:8080";
        int timeout = 10_000_000;
        URL url;
        try {
            url = new URL(urlName);
            final URLConnection connection = url.openConnection();
            // set timeout for connection
            connection.setConnectTimeout(timeout);
            System.out.println(urlName + " content type: " + connection.getContentType());

            // continue extraction data from connection
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            for(String key : headerFields.keySet()) {
                System.out.println(key + ": " + headerFields.get(key));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
