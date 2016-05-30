package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server;

import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message.Message;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message.MessageParser;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.properties.ResourceManager;

import java.io.IOException;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MessengerServer {
    static final int MAX_LOGIN_LENGTH = 20;
    private Map<String, ClientSocketThread> userLoginNames = new HashMap<>();

    public MessengerServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println(String.format(ResourceManager.SERVER_STATUS_INITIALIZED, port));

            while (true) {
                System.out.println(ResourceManager.SERVER_STATUS_WAITING_CLIENTS);
                Socket socket = serverSocket.accept();
                System.out.println(String.format(ResourceManager.SERVER_USER_CONNECTED, socket.getInetAddress()
                                                                                              .getHostName()));
                new Thread(new ClientSocketThread(this, socket)).start();
            }

        } catch (BindException e) {
            System.err.println(ResourceManager.SERVER_STATUS_ADDRESS_RESERVATION_ERROR + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MessengerServer server = new MessengerServer(54321);
    }

    public Map<String, ClientSocketThread> getUserLoginNames() {
        return userLoginNames;
    }

    public void send(Message message) {
        if (message.getRecipient() == null) {
            sendBroadcast(message);
        } else {
            sendPrivate(message);
        }
    }

    /**
     * Send message to all (including self)
     *
     * @param message
     */
    private void sendBroadcast(Message message) {
        String chatMessage = prepareOutgoingMessage(message);

        for(Map.Entry<String, ClientSocketThread> entry : getUserLoginNames().entrySet()) {
            final PrintStream clientPrintStream = entry.getValue().getPrintStream();
            clientPrintStream.println(chatMessage);
            clientPrintStream.flush();
        }
    }

    /**
     * Send message privately to recipient
     *
     * @param message must be started with recipient login begins with '@' sign.
     *                For ex.: if you want send message to Luke, send "@Luke hello!"
     */
    private void sendPrivate(Message message) {
        String recipient = message.getRecipient();
        String sender = message.getFrom();
        if (recipient != null && isUserExists(recipient)) {
            final PrintStream recipientPrintStream = getUser(recipient).getPrintStream();
            final PrintStream senderPrintStream = getUser(sender).getPrintStream();
            if (recipientPrintStream != null && senderPrintStream != null) {
                recipientPrintStream.println(prepareOutgoingMessagePrivate(message));
                recipientPrintStream.flush();
                senderPrintStream.println(prepareOutgoingMessagePrivate(message));
                senderPrintStream.flush();
            }
        } else {
            sendServerMessage(sender, String.format(ResourceManager.SERVER_USER_NOT_REGISTERED, recipient));
        }
    }

    private void sendServerMessage(String message) {
        String serverMessage = prepareServerMessage(message);
        for(Map.Entry<String, ClientSocketThread> entry : getUserLoginNames().entrySet()) {
            final PrintStream clientPrintStream = entry.getValue().getPrintStream();
            clientPrintStream.println(serverMessage);
            clientPrintStream.flush();
        }
    }

    private void sendServerMessage(String recipient, String message) {
        if (isUserExists(recipient)) {
            final PrintStream recipientPrintStream = getUserLoginNames().get(recipient).getPrintStream();
            recipientPrintStream.println(prepareServerMessage(message));
            recipientPrintStream.flush();
        }
    }

    private String prepareServerMessage(String message) {
        return "SERVER: " + MessageParser.parseMessage(message);
    }


    /**
     * Format message as %SenderName%: %message%
     *
     * @param message
     * @return
     */
    private String prepareOutgoingMessage(Message message) {
        return message.getFrom() + ": " + message.getBody();
    }

    /**
     * Format message as %SenderName%: [private] %message%
     *
     * @param message
     * @return
     */
    private String prepareOutgoingMessagePrivate(Message message) {
        return message.getFrom() + " " + ResourceManager.COMMAND_CHARACTER + message.getRecipient() + ": " + message.getBody();
    }


    public boolean registerUser(ClientSocketThread client) {
        boolean isFree = false;
        boolean isCorrect = false;
        String loginName = client.getUserLoginName();

        if (userLoginNames.get(loginName) == null) {
            isFree = true;
        } else {
            client.getPrintStream().println(String.format(ResourceManager.SERVER_USER_EXISTS, loginName));
        }

        if (isUserNameCorrect(loginName)) {
            isCorrect = true;
        } else {
            client.getPrintStream().println(String.format(ResourceManager.SERVER_USER_NAME_INCORRECT, loginName));
        }

        if (isFree && isCorrect) {
            userLoginNames.put(loginName, client);
            sendSuccessRegistrationMessage(loginName);
            return true;
        }
        return false;
    }

    public boolean unregisterUser(ClientSocketThread client) {
        String userLoginName = client.getUserLoginName();
        if (userLoginNames.get(userLoginName) != null) {
            userLoginNames.remove(userLoginName);
            sendServerMessage(String.format(ResourceManager.SERVER_USER_DISCONNECTED, userLoginName));
            return true;
        }
        return false;
    }

    private void sendSuccessRegistrationMessage(String loginName) {
        sendServerMessage(String.format(ResourceManager.SERVER_USER_SUCCESSFULLY_REGISTERED, loginName));
        System.out.println(loginName + " registered");
        sendServerMessage(loginName, String.format(ResourceManager.SERVER_USER_WELCOME_MESSAGE, loginName));
        sendServerMessage(loginName, ResourceManager.SERVER_TIPS_PRIVATE);
    }

    private boolean isUserNameCorrect(String loginName) {
        if (loginName.length() > MAX_LOGIN_LENGTH || loginName.contains(" ")) {
            return false;
        }
        return true;
    }

    public boolean isUserExists(String userLoginName) {
        if (userLoginNames.containsKey(userLoginName)) {
            return true;
        }
        return false;
    }

    public ClientSocketThread getUser(String userLoginName) {
        if (isUserExists(userLoginName)) {
            return userLoginNames.get(userLoginName);
        }
        //throw new Exception("no such registered users: " + userLoginName);
        // FIXME: 30.05.2016 nullPointerException
        return null;
    }
}
