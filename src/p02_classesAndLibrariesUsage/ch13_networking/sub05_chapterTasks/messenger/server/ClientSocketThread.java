package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class ClientSocketThread implements Runnable {
    private PrintStream printStream;
    private BufferedReader readerStream;
    private InetAddress inetAddress;
    private String userLoginName;
    private MessengerServer server;
    private Socket socket;

    public ClientSocketThread(MessengerServer server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
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
        try {
            while (true) {
                String message = readerStream.readLine();
                // FIXME: 28.05.2016 possible bug: send message as another user
                server.send(this, message);
            }
        } catch (SocketException e) {
            System.err.println("Connection ended with " + userLoginName + ": " + e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private void disconnect() {

        boolean unregistered = server.unregisterUser(this);

        if (printStream != null) {
            printStream.close();
        }
        if (readerStream != null) {
            try {
                readerStream.close();
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
        System.out.println(userLoginName + " disconnected: " + unregistered);
        // TODO: 26.05.2016 stop runnable
    }
}
