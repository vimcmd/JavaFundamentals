package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MessengerServer {
    static Map<String, SocketThread> userLoginNames = new HashMap<>();

    public MessengerServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.err.println("Messenger server initialized at port " + port);

            while (true) {
                System.err.println("waiting for clients...");
                Socket socket = serverSocket.accept();
                System.err.println(socket.getInetAddress().getHostName() + " connected");
                new Thread(new SocketThread(this, socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MessengerServer server = new MessengerServer(54321);
    }

    public boolean registerUser(SocketThread client) {
        String loginName = client.getUserLoginName();
        if (userLoginNames.get(loginName) == null) {
            userLoginNames.put(loginName, client);
            client.getPrintStream().println(loginName + " successfully registered");
            return true;
        } else {
            client.getPrintStream().println("User with login name '" + loginName + "' already exists");
            return false;
        }
    }
}
