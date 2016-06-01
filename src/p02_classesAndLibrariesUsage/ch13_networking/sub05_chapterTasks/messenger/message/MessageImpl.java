package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message;

import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.properties.ResourceManager;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server.SimpleClientThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageImpl implements SimpleMessage {
    private String from;
    private SimpleClientThread sender;
    private List<String> recipient;
    private String body;
    private Map<String, String> messageCommands; // command, argument

    public MessageImpl(SimpleClientThread sender, String body) {
        recipient = new ArrayList<>();
        messageCommands = new HashMap<>();
        this.sender = sender;
        this.body = body;
        extractCommands(body);
    }

    public MessageImpl() {
    }

    public SimpleClientThread getSender() {
        return sender;
    }

    @Override
    public String getFrom() {
        if (from == null) {
            return "";
        }
        return from;
    }

    @Override
    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public List<String> getRecipientList() {
        return new ArrayList<>(recipient);
    }

    @Override
    public void setRecipient(String recipient) {
        this.recipient.add(recipient);
    }

    @Override
    public String getBody() {
        if (body == null) {
            return "";
        }
        return body;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public Map<String, String> getMessageCommands() {
        return new HashMap<String, String>(messageCommands);
        //return messageCommands;
    }

    private void extractCommands(String body) {
        // TODO: 31.05.2016 move method to sender/parser
        // TODO: 31.05.2016 remove commands from body
        final String recipientCharacter = ResourceManager.RECIPIENT_CHARACTER;
        final String serverCommandCharacter = ResourceManager.SERVER_COMMAND_CHARACTER;
        final String serverCommandRegister = ResourceManager.SERVER_COMMAND_REGISTER;
        final String commandSeparator = ResourceManager.SERVER_COMMAND_SEPARATOR;
        Pattern pattern = Pattern.compile("[" + recipientCharacter + "|" + serverCommandCharacter + "][a-zA-Z_0-9_:]+\\b");
        Matcher matcher = pattern.matcher(body);

        while (matcher.find()) {
            if (matcher.group().startsWith(recipientCharacter)) {
                // parse recipients and put to array
                this.recipient.add(matcher.group().substring(1)); // remove '@' char
            }

            if (matcher.group().startsWith(serverCommandRegister)) {
                String[] registrationInfo = matcher.group().split(commandSeparator, 2);
                this.messageCommands.put(registrationInfo[0], registrationInfo[1]);
            }
        }
    }
}
