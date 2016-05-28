package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MessengerClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader reader = null;
        PrintStream printStream = null;

        try {
            socket = new Socket(InetAddress.getLocalHost(), 54321);
            printStream = new PrintStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //printStream.println("Luke");
            //printStream.println("here i am");

            printStream.println("DarthWader");
            printStream.println("psshhhht... psshhhht... psshhhht...");
            printStream.println("@Luke Luke, im your father!");
            printStream.println("@PrincessLea Im your father too, btw");

            while (true) {
                System.out.println(reader.readLine());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            System.err.println("Connection ended with server: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
