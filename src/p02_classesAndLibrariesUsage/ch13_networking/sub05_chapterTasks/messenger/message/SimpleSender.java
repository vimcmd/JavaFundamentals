package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message;

import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server.SimpleClientThread;

public interface SimpleSender {
    void sendBroadcast(SimpleMessage message);

    void sendPrivate(SimpleMessage message);

    void sendPrivateServerMessage(String recipient, String message);

    void sendPrivateServerMessage(SimpleClientThread recipient, String message);

    void sendBroadcastServerMessage(String message);
}
