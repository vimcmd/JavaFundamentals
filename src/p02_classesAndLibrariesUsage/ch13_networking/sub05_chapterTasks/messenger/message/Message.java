package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message;

public interface Message {
    void setFrom(String from);

    void setRecipient(String recipient);

    void setBody(String body);

    String getFrom();

    String getRecipient();

    String getBody();
}
