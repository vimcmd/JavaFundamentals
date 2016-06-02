package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message;

import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.properties.ResourceManager;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server.SimpleClientThread;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server.SimpleServer;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class MessageSenderImpl implements SimpleSender {
    private SimpleServer server;


    public MessageSenderImpl(SimpleServer server) {
        this.server = server;
    }

    /**
     * Send message to all (including self)
     *
     * @param message
     */
    @Override
    public void sendBroadcast(SimpleMessage message) {
        String chatMessage = prepareOutgoingMessage(message);

        for(Map.Entry<String, SimpleClientThread> entry : server.getUserNames().entrySet()) {
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
    @Override
    public void sendPrivate(SimpleMessage message) {
        List<String> recipientList = message.getRecipientList();
        String sender = message.getFrom();
        for(String recipient : recipientList) {
            if (server.isUserExists(recipient)) {
                final PrintStream recipientPrintStream = server.getUser(recipient).getPrintStream();
                final PrintStream senderPrintStream = server.getUser(sender).getPrintStream();
                if (recipientPrintStream != null && senderPrintStream != null) {
                    recipientPrintStream.println(prepareOutgoingMessagePrivate(message));
                    recipientPrintStream.flush();
                    senderPrintStream.println(prepareOutgoingMessagePrivate(message));
                    senderPrintStream.flush();
                }
            } else {
                sendPrivateServerMessage(sender, String.format(ResourceManager.SERVER_USER_NOT_REGISTERED, recipient));
            }
        }

    }

    @Override
    public void sendBroadcastServerMessage(String message) {
        String serverMessage = prepareServerMessage(message);
        for(Map.Entry<String, SimpleClientThread> entry : server.getUserNames().entrySet()) {
            final PrintStream clientPrintStream = entry.getValue().getPrintStream();
            clientPrintStream.println(serverMessage);
            clientPrintStream.flush();
        }
    }

    @Override
    public void sendPrivateServerMessage(String recipient, String message) {
        if (server.isUserExists(recipient)) {
            final PrintStream recipientPrintStream = server.getUserNames().get(recipient).getPrintStream();
            recipientPrintStream.println(prepareServerMessage(message));
            recipientPrintStream.flush();
        }
    }

    @Override
    public void sendPrivateServerMessage(SimpleClientThread recipient, String message) {
        final PrintStream recipientPrintStreamPrintStream = recipient.getPrintStream();
        recipientPrintStreamPrintStream.println(prepareServerMessage(message));
        recipientPrintStreamPrintStream.flush();
    }

    private String prepareServerMessage(String message) {
        // TODO: 31.05.2016 format from properties
        return "SERVER: " + MessageParser.parseMessage(message);
    }

    /**
     * Format message as %SenderName%: %message%
     *
     * @param message
     * @return
     */
    private String prepareOutgoingMessage(SimpleMessage message) {
        // TODO: 31.05.2016 format from properties
        return message.getFrom() + ": " + message.getBody();
    }

    /**
     * Format message as %SenderName%: [private] %message%
     *
     * @param message
     * @return
     */
    private String prepareOutgoingMessagePrivate(SimpleMessage message) {
        // TODO: 31.05.2016 format from properties
        // TODO: 31.05.2016 display only one recipient, not array (or display few, not all / display [private])
        return message.getFrom() + " " + ResourceManager.RECIPIENT_CHARACTER + message.getRecipientList() + ": " + message
                .getBody();
    }
}
