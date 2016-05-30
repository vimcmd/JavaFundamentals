package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message;

import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.properties.ResourceManager;
import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server.ClientSocketThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

public class MessageImpl implements SimpleMessage {
    private String from;
    private ClientSocketThread sender;
    private List<String> recipient;
    private String body;
    private Map<String, String> messageCommands;

    public MessageImpl(String from, String body) {
        this.from = from;
        this.body = body;
        extractCommands(body);
    }

    public MessageImpl(ClientSocketThread from, String body) {
        this(from.getUserLoginName(), body);
        this.sender = from;
    }

    public ClientSocketThread getSender() {
        return sender;
    }

    public MessageImpl() {
    }

    @Override
    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public void setRecipient(String recipient) {
        this.recipient.add(recipient);
    }

    @Override
    public void setBody(String body) {
        // FIXME: 30.05.2016 return clone to prevent modification
        this.body = body;
    }

    @Override
    public String getFrom() {
        // FIXME: 30.05.2016 return clone to prevent modification
        return from;
    }

    @Override
    public List<String> getRecipient() {
        return new ArrayList<>(recipient);
    }

    @Override
    public String getBody() {
        // FIXME: 30.05.2016 return clone to prevent modification
        return body;
    }

    public Map<String, String> getMessageCommands() {
        return new HashMap<String, String>(messageCommands);
    }

    private void extractCommands(String body) {
        final String recipientCharacter = ResourceManager.RECIPIENT_CHARACTER;
        final String serverCommandCharacter = ResourceManager.SERVER_COMMAND_CHARACTER;
        Pattern pattern = Pattern.compile("[" + recipientCharacter + "|" + serverCommandCharacter + "]\\w+\\b");
        Matcher matcher = pattern.matcher(body);

        while (matcher.find()) {
            if (matcher.group().startsWith(recipientCharacter)) {
                this.recipient.add(matcher.group());
            }

            if (matcher.group().startsWith(serverCommandCharacter)) {
                // TODO: 30.05.2016 implement
                //this.messageCommands.put(matcher.group());
            }
        }
    }
}
