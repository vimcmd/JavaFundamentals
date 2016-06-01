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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MessengerServerImpl implements SimpleServer {
    static final int MAX_LOGIN_LENGTH = 20;
    private final Set<CommandList> availableCommands = new HashSet<CommandList>() {
        {
            //this.put(CommandList.TIME, "#time");
            this.add(CommandList.REGISTER);
            this.add(CommandList.TO_RECIPIENT);

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

    private Set<CommandList> getAvailableCommands() {
        return availableCommands;
    }

    @Override
    public Map<String, SimpleClientThread> getUserNames() {
        return userLoginNames;
    }

    @Override
    public void send(SimpleClientThread from, String messageBody) {
        SimpleMessage message = new MessageImpl(from, messageBody);
        Map<CommandList, String> messageCommands = CommandList.extractCommands(messageBody);

        // TODO: 01.06.2016 check if sender already registered
        for(Map.Entry<String, SimpleClientThread> clientEntry : userLoginNames.entrySet()) {
            if (from.equals(clientEntry.getValue())) {
                message.setFrom(clientEntry.getKey());
            }
        }

        for(Map.Entry<CommandList, String> messageCommand : messageCommands.entrySet()) {
            // TODO: 01.06.2016 move to processCommands() method
            if (availableCommands.contains(messageCommand.getKey())) {
                if (messageCommand.getKey().equals(CommandList.REGISTER)) {
                    // TODO: 01.06.2016 check if already registered
                    if (messageCommand.getValue() != null || !messageCommand.getValue().isEmpty()) {
                        registerUser(from, messageCommand.getValue());
                        message.setFrom(messageCommand.getValue());
                    }
                }

                if (messageCommand.getKey().equals(CommandList.TO_RECIPIENT)) {
                    message.addRecipient(messageCommand.getValue());
                }
            } else {
                sender.sendPrivateServerMessage(from, String.format(ResourceManager.SERVER_COMMAND_UNKNOWN, messageCommand.getKey()));
            }
        }

        if (message.getFrom().isEmpty() && messageCommands.isEmpty()) {
            sender.sendPrivateServerMessage(from, String.format(ResourceManager.SERVER_USER_MUST_REGISTER, CommandList.REGISTER
                    .toString()));
        } else {
            if (message.getRecipientList().size() <= 0) {
                sender.sendBroadcast(message);
            } else {
                sender.sendPrivate(message);
            }
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
