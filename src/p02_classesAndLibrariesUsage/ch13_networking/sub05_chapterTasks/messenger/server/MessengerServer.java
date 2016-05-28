package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MessengerServer {
    static Map<String, ClientSocketThread> userLoginNames = new HashMap<>();

    public MessengerServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Messenger server initialized at port " + port);

            while (true) {
                System.out.println("waiting for clients...");
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostName() + " connected");
                new Thread(new ClientSocketThread(this, socket)).start();
            }

        } catch (BindException e) {
            System.err.println("Can not reserve address: " + e);
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
            sendServerMessage(loginName + " successfully registered");
            System.out.println(loginName + " registered");
            sendServerMessage(loginName, "Welcome, " + loginName + "!");
            sendServerMessage(loginName, "Tip of the day: begin typing message with username starting with '@' sign, to send private message.");
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

    private void sendServerMessage(String message) {
        String serverMessage = prepareServerMessage(message);
        for(Map.Entry<String, ClientSocketThread> entry : userLoginNames.entrySet()) {
            final PrintStream clientPrintStream = entry.getValue().getPrintStream();
            clientPrintStream.println(serverMessage);
            clientPrintStream.flush();
        }
    }

    private void sendServerMessage(String recipient, String message) {
        if (isUserExists(recipient)) {
            final PrintStream recipientPrintStream = userLoginNames.get(recipient).getPrintStream();
            recipientPrintStream.println(prepareServerMessage(message));
            recipientPrintStream.flush();
        }
    }

    /**
     * Send message to all (including self)
     *
     * @param sender
     * @param message
     */
    private void sendBroadcast(ClientSocketThread sender, String message) {
        String chatMessage = prepareOutgoingMessage(sender, message);

        for(Map.Entry<String, ClientSocketThread> entry : userLoginNames.entrySet()) {
            final PrintStream clientPrintStream = entry.getValue().getPrintStream();
            clientPrintStream.println(chatMessage);
            clientPrintStream.flush();
        }
    }

    /**
     * Send message privately to recipient
     *
     * @param sender
     * @param message must be started with recipient login begins with '@' sign.
     *                For ex.: if you want send message to Luke, send "@Luke hello!"
     */
    private void sendPrivate(ClientSocketThread sender, String message) {
        String privateMessage[] = message.split(" ", 2);
        String recipientLoginName = privateMessage[0].substring(1);
        String msg = privateMessage[1];

        if (isUserExists(recipientLoginName)) {
            ClientSocketThread recipient = userLoginNames.get(recipientLoginName);
            recipient.getPrintStream().println(prepareOutgoingMessagePrivate(sender, recipient, msg));
            recipient.getPrintStream().flush();
            sender.getPrintStream().println(prepareOutgoingMessagePrivate(sender, recipient, msg));
            sender.getPrintStream().flush();
        } else {
            sendServerMessage(sender.getUserLoginName(), "User '" + recipientLoginName + "' not registered");
        }
    }

    private boolean isUserExists(String userLoginName) {
        if (userLoginNames.containsKey(userLoginName)) {
            return true;
        }
        return false;
    }

    private String prepareServerMessage(String message) {
        return "SERVER: " + parseMessage(message);
    }

    /**
     * Format message as %SenderName%: %message%
     *
     * @param sender
     * @param message
     * @return
     */
    private String prepareOutgoingMessage(ClientSocketThread sender, String message) {
        return sender.getUserLoginName() + ": " + parseMessage(message);
    }

    /**
     * Format message as %SenderName%: [private] %message%
     *
     * @param sender
     * @param message
     * @return
     */
    private String prepareOutgoingMessagePrivate(ClientSocketThread sender, ClientSocketThread recipient, String message) {
        return sender.getUserLoginName() + " @" + recipient.getUserLoginName() + ": " + parseMessage(message);
    }

    /**
     * Remove all illegal characters, etc.
     *
     * @param message
     * @return
     */
    private String parseMessage(String message) {
        // TODO: 27.05.2016 implement method - escape illegal char, etc.
        return message;
    }

    private ClientSocketThread getUser(String userLoginName) {
        if (isUserExists(userLoginName)) {
            return userLoginNames.get(userLoginName);
        }
        //throw new Exception("no such registered users: " + userLoginName);
        return null;
    }
}
