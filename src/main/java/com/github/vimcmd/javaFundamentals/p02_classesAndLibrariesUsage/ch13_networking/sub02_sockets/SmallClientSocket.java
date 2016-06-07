package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch13_networking.sub02_sockets;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/* # 7 # retrieving string by client */

public class SmallClientSocket {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // retrieve string from server
            socket = new Socket(InetAddress.getLocalHost(), 56789); // host name where server-socket running
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = br.readLine();
            System.out.println(message);

            // send response
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("Client response message");
            bw.flush();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("error: " + e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
