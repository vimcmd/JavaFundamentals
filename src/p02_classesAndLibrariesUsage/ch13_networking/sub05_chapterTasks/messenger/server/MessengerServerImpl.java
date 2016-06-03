package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server;

import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message.MessageImpl;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message.MessageSenderImpl;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message.SimpleMessage;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message.SimpleSender;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.properties.ResourceManager;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class MessengerServerImpl implements SimpleServer {
    static final int MAX_LOGIN_LENGTH = 20;
    private final Set<Comandlet> supportedCommands = new HashSet<Comandlet>() {
        {
            this.add(Comandlet.REGISTER);
            this.add(Comandlet.TIME);
            this.add(Comandlet.TO_RECIPIENT);

        }
    };
    private Map<String, SimpleClientThread> userLoginNames = new HashMap<>(); // Name, ClientThread
    private SimpleSender sender;

    public MessengerServerImpl(int port) {
        try {
            sender = new MessageSenderImpl(this);
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println(String.format(ResourceManager.SERVER_STATUS_INITIALIZED, port));

            while (true) {
                System.out.println(ResourceManager.SERVER_STATUS_WAITING_CLIENTS);
                Socket socket = serverSocket.accept();
                System.out.println(String.format(ResourceManager.SERVER_USER_CONNECTED, socket.getInetAddress()
                                                                                              .getHostName()));
                new Thread(new SimpleClientThreadImpl(this, socket)).start();
            }

        } catch (BindException e) {
            System.err.println(ResourceManager.SERVER_STATUS_ADDRESS_RESERVATION_ERROR + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MessengerServerImpl server = new MessengerServerImpl(54321);
    }

    private Set<Comandlet> getSupportedCommands() {
        return supportedCommands;
    }

    @Override
    public Map<String, SimpleClientThread> getUserNames() {
        return userLoginNames;
    }

    @Override
    public void send(SimpleClientThread from, String messageBody) {
        SimpleMessage message = new MessageImpl(from, messageBody);
        Map<Comandlet, List<String>> messageCommands = Comandlet.extractCommands(messageBody);

        updateFromFieldIfUserExists(from, message);

        processCommands(from, message, messageCommands);

        if (message.getFrom().isEmpty() && messageCommands.isEmpty()) {
            sender.sendPrivateServerMessage(from, String.format(ResourceManager.SERVER_USER_MUST_REGISTER, Comandlet.REGISTER
                    .toString()));
        } else {
            if (message.getRecipientList().size() <= 0) {
                sender.sendBroadcast(message);
            } else {
                sender.sendPrivate(message);
            }
        }

    }

    private void updateFromFieldIfUserExists(SimpleClientThread from, SimpleMessage message) {
        for(Map.Entry<String, SimpleClientThread> clientEntry : userLoginNames.entrySet()) {
            if (from.equals(clientEntry.getValue())) {
                message.setFrom(clientEntry.getKey());
            }
        }
    }

    private void processCommands(SimpleClientThread from, SimpleMessage message, Map<Comandlet, List<String>> messageCommands) {
        List<String> unknownCommands = new ArrayList<>();
        // TODO: 02.06.2016 refactor
        for(Map.Entry<Comandlet, List<String>> messageCommand : messageCommands.entrySet()) {
            if (supportedCommands.contains(messageCommand.getKey())) {
                if (messageCommand.getKey().equals(Comandlet.REGISTER)) {
                    if (messageCommand.getValue().get(0) != null || !messageCommand.getValue().get(0).isEmpty()) {
                        // check if user exists
                        // TODO: 02.06.2016 register only with first command
                        registerUser(from, messageCommand.getValue().get(0));
                        message.setFrom(messageCommand.getValue().get(0));
                    }
                }

                if (messageCommand.getKey().equals(Comandlet.TO_RECIPIENT)) {
                    message.addRecipients(messageCommand.getValue());
                }

                if (messageCommand.getKey().equals(Comandlet.TIME)) {
                    sender.sendPrivateServerMessage(from, new Date().toString());
                }

            } else {
                unknownCommands.addAll(messageCommand.getValue());
            }
        }

        if (!unknownCommands.isEmpty()) {
            sender.sendPrivateServerMessage(from, String.format(ResourceManager.SERVER_COMMAND_UNKNOWN_MESSAGE, unknownCommands));
        }

    }


    private boolean registerUser(SimpleClientThread client, String name) {
        boolean isFree = false;
        boolean isCorrect = false;
        //String loginName = client.getUserName();

        if (userLoginNames.get(name) == null) {
            isFree = true;
        } else {
            client.getPrintStream().println(String.format(ResourceManager.SERVER_USER_EXISTS, name));
        }

        if (isUserNameCorrect(name)) {
            isCorrect = true;
        } else {
            client.getPrintStream().println(String.format(ResourceManager.SERVER_USER_NAME_INCORRECT, name));
        }

        if (isFree && isCorrect) {
            userLoginNames.put(name, client);
            sendSuccessRegistrationMessage(name);
            return true;
        }
        return false;
    }

    // TODO: 31.05.2016 implement unregister
    //private boolean unregisterUser(SimpleClientThreadImpl client) {
    //    String userLoginName = client.getUserName();
    //    if (userLoginNames.get(userLoginName) != null) {
    //        userLoginNames.remove(userLoginName);
    //        sender.sendBroadcastServerMessage(String.format(ResourceManager.SERVER_USER_DISCONNECTED, userLoginName));
    //        return true;
    //    }
    //    return false;
    //}

    // TODO: 31.05.2016 implement getMyName()

    private void sendSuccessRegistrationMessage(String loginName) {
        sender.sendBroadcastServerMessage(String.format(ResourceManager.SERVER_USER_SUCCESSFULLY_REGISTERED, loginName));
        System.out.println(loginName + " registered");
        sender.sendPrivateServerMessage(loginName, String.format(ResourceManager.SERVER_USER_WELCOME_MESSAGE, loginName));
        sender.sendPrivateServerMessage(loginName, ResourceManager.SERVER_TIPS_PRIVATE);
    }

    private boolean isUserNameCorrect(String loginName) {
        if (loginName.length() > MAX_LOGIN_LENGTH || loginName.contains(" ")) {
            return false;
        }
        return true;
    }

    public boolean isUserExists(String userName) {
        return userLoginNames.containsKey(userName);
    }

    public boolean isUserExists(SimpleClientThread client) {
        return userLoginNames.containsValue(client);
    }

    public SimpleClientThread getUser(String userLoginName) {
        if (isUserExists(userLoginName)) {
            return userLoginNames.get(userLoginName);
        }
        //throw new Exception("no such registered users: " + userLoginName);
        // FIXME: 30.05.2016 nullPointerException
        return null;
    }
}
