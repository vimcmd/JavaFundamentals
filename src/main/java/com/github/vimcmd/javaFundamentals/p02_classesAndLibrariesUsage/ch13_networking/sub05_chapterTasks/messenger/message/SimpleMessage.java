package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message;

import java.util.List;

public interface SimpleMessage {
    void addRecipient(String recipient);

    void addRecipients(List<String> recipientList);

    String getFrom();

    void setFrom(String from);

    List<String> getRecipientList();

    String getBody();

    void setBody(String body);
}
