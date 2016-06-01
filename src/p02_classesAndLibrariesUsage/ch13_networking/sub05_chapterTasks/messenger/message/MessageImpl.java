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

    public MessageImpl(SimpleClientThread sender, String body) {
        recipient = new ArrayList<>();
        this.sender = sender;
        this.body = body;
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
    public void addRecipient(String recipient) {
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
}
