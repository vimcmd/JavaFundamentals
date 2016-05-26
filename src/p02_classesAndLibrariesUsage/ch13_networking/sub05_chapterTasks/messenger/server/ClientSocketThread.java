package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocketThread implements Runnable {
    private PrintStream printStream;
    private BufferedReader readerStream;
    private InetAddress inetAddress;
    private String userLoginName;
    private MessengerServer server;

    public ClientSocketThread(MessengerServer server, Socket socket) throws IOException {
        this.server = server;
        printStream = new PrintStream(socket.getOutputStream());
        readerStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        inetAddress = socket.getInetAddress();
        userLoginName = readerStream.readLine(); // TODO: 26.05.2016 split, escape characters and use first word

        while (true) {
            if (server.registerUser(this)) {
                // TODO: 26.05.2016 register via socket, without using server in constructor
                break;
            } else {
                // FIXME: 26.05.2016 take only first word from next tries or register deny
                userLoginName = readerStream.readLine(); // request another name
            }
        }
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public PrintStream getPrintStream() {
        return printStream;
    }

    public BufferedReader getReaderStream() {
        return readerStream;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    @Override
    public void run() {
        printStream.println("WELCOME, " + userLoginName);
        while (true) {
            try {
                String message = readerStream.readLine();
                server.send(this, message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // send messages
    }

    private void disconnect() {
        try {
            if (printStream != null) {
                printStream.close();
            }
            if (readerStream != null) {
                readerStream.close();
            }
            System.out.println(userLoginName + " disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // TODO: 26.05.2016 stop runnable
        }
    }
}
