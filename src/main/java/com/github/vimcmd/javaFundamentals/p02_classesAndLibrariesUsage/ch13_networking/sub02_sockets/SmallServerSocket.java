package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch13_networking.sub02_sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/* # 6 # sending a string to client */

public class SmallServerSocket {
    public static void main(String[] args) {
        Socket s = null;
        PrintStream ps = null;
        BufferedReader br = null;
        try { // send string to client
            // create object and assign port number
            ServerSocket server = new ServerSocket(56789);
            s = server.accept(); // waiting for connection
            ps = new PrintStream(s.getOutputStream());
            // put string "hello" to buffer
            ps.println("Server welcome message!");
            // send buffer content to client
            ps.flush();

            // take client response
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String response = br.readLine();
            System.out.println(response);

        } catch (IOException e) {
            System.err.println("Stream connection error: " + e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
