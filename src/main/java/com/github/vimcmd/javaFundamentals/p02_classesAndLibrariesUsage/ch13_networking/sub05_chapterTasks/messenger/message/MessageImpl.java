package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message;

import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server.SimpleClientThread;

import java.util.ArrayList;
import java.util.List;

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
    public void addRecipients(List<String> recipientList) {
        this.recipient.addAll(recipientList);
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
