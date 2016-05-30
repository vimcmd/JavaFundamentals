package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message;

import java.util.List;

public interface SimpleMessage {
    void setFrom(String from);

    void setRecipient(String recipient);

    void setBody(String body);

    String getFrom();

    List<String> getRecipient();

    String getBody();
}
