package p02_classesAndLibrariesUsage.ch13_networking.sub03_multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/* # 9 # send and receive messages in client thread */

/**
 * Firstly, server must be initialized
 */
public class NetClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;

        try {
            socket = new Socket(InetAddress.getLocalHost(), 54321);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            for(int i = 1; i <= 10; i++) {
                ps.println("PING");
                System.out.println(br.readLine());
                Thread.sleep(200);
            }
        } catch (UnknownHostException e) {
            System.err.println("host unreachable: " + e);
        } catch (IOException e) {
            System.err.println("I/O exception: " + e);
        } catch (InterruptedException e) {
            System.err.println("Thread exception: " + e);
        } finally {
            if (br != null) {
                try {
                    br.close();
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
