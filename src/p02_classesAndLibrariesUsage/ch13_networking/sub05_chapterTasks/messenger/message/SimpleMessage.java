package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message;

import java.util.List;
import java.util.Map;

public interface SimpleMessage {
    void setFrom(String from);

    void addRecipient(String recipient);

    void setBody(String body);

    String getFrom();

    List<String> getRecipientList();

    String getBody();
}
