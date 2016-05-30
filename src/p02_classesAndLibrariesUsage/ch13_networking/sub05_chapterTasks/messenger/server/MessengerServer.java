package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server;

import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message.MessageImpl;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message.SimpleMessage;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message.MessageParser;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.properties.ResourceManager;

import java.io.IOException;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MessengerServer implements SimpleServer {
    static final int MAX_LOGIN_LENGTH = 20;
    private Map<String, ClientSocketThread> userLoginNames = new HashMap<>();
    private final List<String> availableCommands = new ArrayList<String>(){
        {
            //this.add("rename");
            this.add("register");
            this.add("time");
        }
    };

    public List<String> getAvailableCommands() {
        return availableCommands;
    }

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

    public void send(SimpleMessage message) {
        // TODO: 30.05.2016 refactor
        if (message.getFrom() == null) {
            // TODO: 30.05.2016 deny message for anonymous user, ask for register
            return;
        }

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
    private void sendBroadcast(SimpleMessage message) {
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
    private void sendPrivate(SimpleMessage message) {
        List<String> recipientList = message.getRecipient();
        String sender = message.getFrom();
        for(String recipient : recipientList) {
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
    private String prepareOutgoingMessage(SimpleMessage message) {
        return message.getFrom() + ": " + message.getBody();
    }

    /**
     * Format message as %SenderName%: [private] %message%
     *
     * @param message
     * @return
     */
    private String prepareOutgoingMessagePrivate(SimpleMessage message) {
        return message.getFrom() + " " + ResourceManager.RECIPIENT_CHARACTER + message.getRecipient() + ": " + message.getBody();
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
