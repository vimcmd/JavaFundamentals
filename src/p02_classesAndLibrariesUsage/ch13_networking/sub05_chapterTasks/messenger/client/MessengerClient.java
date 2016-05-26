package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MessengerClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader reader = null;

        try {
            socket = new Socket(InetAddress.getLocalHost(), 54321);
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            printStream.println("User1");
            //printStream.println("hello everyone!");

            while (true) {
                System.out.println(reader.readLine());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
