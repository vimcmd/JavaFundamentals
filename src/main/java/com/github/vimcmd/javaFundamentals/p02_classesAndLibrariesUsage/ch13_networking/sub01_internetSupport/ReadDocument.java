package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch13_networking.sub01_internetSupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/* # 4 # read document from internet */

public class ReadDocument {
    public static void main(String[] args) {
        URL url = null;
        String urlName = "http://srv-nas-01:8080"; // just local service
        try {
            url = new URL(urlName);
        } catch (MalformedURLException e) {
            // Incorrect protocol, domain name or file path
            e.printStackTrace();
        }

        if (url == null) {
            throw new RuntimeException();
        }

        try (BufferedReader b = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line = "";
            while (( line = b.readLine() ) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
