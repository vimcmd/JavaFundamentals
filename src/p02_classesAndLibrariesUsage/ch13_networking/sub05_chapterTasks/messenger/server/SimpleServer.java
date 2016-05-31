package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server;

import java.util.Map;

public interface SimpleServer {

    Map<String, SimpleClientThread> getUserNames();

    boolean isUserExists(String userName);

    SimpleClientThread getUser(String userName);

    void send(SimpleClientThread from, String messageBody);
}
