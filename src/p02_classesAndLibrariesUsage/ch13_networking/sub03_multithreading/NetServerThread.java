package p02_classesAndLibrariesUsage.ch13_networking.sub03_multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/* # 8 # server for multiple clients */

public class NetServerThread {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(54321);
            System.out.println("initialized at port: " + serverSocket.getLocalPort());

            while (true) {
                // waiting for client
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostName() + " connected");
                // create new thread for data exchange
                ServerThread serverThread = new ServerThread(socket);
                // start thread
                serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private PrintStream outStream; // sender
    private BufferedReader inStream; // receiver
    private InetAddress inetAddress; // client address

    public ServerThread(Socket socket) throws IOException {
        outStream = new PrintStream(socket.getOutputStream());
        inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        inetAddress = socket.getInetAddress();
    }

    public void run() {
        int i = 0;
        String str;
        try {
            while (( str = inStream.readLine() ) != null) {
                if ("PING".equals(str)) {
                    outStream.println("PONG" + ++i);
                }
                System.out.println("PING-PONG " + i + " with address " + inetAddress.getHostName());
            }
        } catch (IOException e) {
            System.err.println("DISCONNECT");
            //e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private void disconnect() {
        try {
            if (outStream != null) {
                outStream.close();
            }
            if (inStream != null) {
                inStream.close();
            }
            System.out.println(inetAddress.getHostName() + " disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }
}