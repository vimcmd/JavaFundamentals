package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MessengerServer {
    static Map<String, ClientSocketThread> userLoginNames = new HashMap<>();

    public MessengerServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.err.println("Messenger server initialized at port " + port);

            while (true) {
                System.err.println("waiting for clients...");
                Socket socket = serverSocket.accept();
                System.err.println(socket.getInetAddress().getHostName() + " connected");
                new Thread(new ClientSocketThread(this, socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MessengerServer server = new MessengerServer(54321);
    }

    public boolean registerUser(ClientSocketThread client) {
        String loginName = client.getUserLoginName();
        if (userLoginNames.get(loginName) == null) {
            userLoginNames.put(loginName, client);
            client.getPrintStream().println(loginName + " successfully registered");
            //send registration info broadcast
            return true;
        } else {
            client.getPrintStream().println("User with login name '" + loginName + "' already exists");
            return false;
        }
    }

    public void send(ClientSocketThread sender, String message) {
        if (message.charAt(0) == '@') {
            sendPrivate(sender, message);
        } else {
            sendBroadcast(sender, message);
        }
    }

    private void sendBroadcast(ClientSocketThread sender, String message) {
        ClientSocketThread recipient = null;
        String chatMessage = prepareOutgoingMessage(sender, message);

        for(Map.Entry<String, ClientSocketThread> entry : userLoginNames.entrySet()) {
            recipient = entry.getValue();
            if (recipient.getUserLoginName() != sender.getUserLoginName()) {
                sender.getPrintStream().println(chatMessage);
                sender.getPrintStream().flush();
            }
        }
        if (recipient != null) {
            recipient.getPrintStream().println(chatMessage);
            recipient.getPrintStream().flush();
        }
    }

    private void sendPrivate(ClientSocketThread sender, String message) {
        String privateMessage[] = message.split(" ", 2);
        String recipientLoginName = privateMessage[0].substring(1);
        String msg = privateMessage[1];

        if (userLoginNames.containsKey(recipientLoginName)) {
            ClientSocketThread recipient = userLoginNames.get(recipientLoginName);
            recipient.getPrintStream().println(prepareOutgoingMessagePrivate(sender, msg));
            recipient.getPrintStream().flush();
            sender.getPrintStream().println(prepareOutgoingMessagePrivate(sender, msg));
            sender.getPrintStream().flush();
        } else {
            sender.getPrintStream().println("SERVER: User '" + recipientLoginName + "' not registered");
        }
    }

    private void checkUserLoginName(String userLoginName) {
        // TODO: 26.05.2016 implement
    }

    private String prepareOutgoingMessage(ClientSocketThread sender, String message) {
        // TODO: 26.05.2016 escape special characters
        return sender.getUserLoginName() + ": " + message;
    }

    private String prepareOutgoingMessagePrivate(ClientSocketThread sender, String message) {
        return sender.getUserLoginName() + ": [private] " + message;
    }
}
