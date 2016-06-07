package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch13_networking.sub01_internetSupport;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/* # 1 # Obtaining computer and internet-resource IP-address */

public class InetLogic {
    public static void main(String[] args) {
        final String remoteHost = "google.com";
        InetAddress currentIp = null;
        InetAddress remoteIp = null;
        InetAddress remoteIpList[] = null;

        try {
            currentIp = InetAddress.getLocalHost();
            System.out.println("current ip: " + currentIp);

            remoteIp = InetAddress.getByName(remoteHost);
            System.out.println("remote ip: " + remoteIp);

            remoteIpList = InetAddress.getAllByName(remoteHost);
            System.out.println("remote ip list: " + Arrays.asList(remoteIpList));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.err.println("Host not found: " + e);
        }
    }
}
