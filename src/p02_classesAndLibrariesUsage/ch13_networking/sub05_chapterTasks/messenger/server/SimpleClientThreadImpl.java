package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class SimpleClientThreadImpl implements Runnable, SimpleClientThread {
    private PrintStream printStream;
    private BufferedReader readerStream;
    private InetAddress inetAddress;
    private SimpleServer server;
    private Socket socket;

    public SimpleClientThreadImpl(SimpleServer server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        printStream = new PrintStream(socket.getOutputStream());
        readerStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        inetAddress = socket.getInetAddress();
        //userLoginName = readerStream.readLine(); // TODO: 26.05.2016 split, escape characters and use first word

        //while (true) {
        //    // TODO: 30.05.2016 remove
        //    if (server.registerUser(this)) {
        //        // TODO: 26.05.2016 register via socket, without using server in constructor
        //        break;
        //    } else {
        //        // FIXME: 26.05.2016 take only first word from next tries or register deny
        //        userLoginName = readerStream.readLine(); // request another name
        //    }
        //}
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
                // TODO: 30.05.2016 if message contains register data, set username, call register
                server.send(this, message);
            }
        } catch (SocketException e) {
            System.err.println("Connection ended: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private void disconnect() {

        //boolean unregistered = server.unregisterUser(this);

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
        //System.out.println(userLoginName + " disconnected: " + unregistered);
        // TODO: 26.05.2016 stop runnable
    }
}
