package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message;

import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.properties.ResourceManager;

public class MessageParser {

    private MessageParser() {
    }

    public static Message prepareMessage(String from, String message) {
        Message msg = new MessageImpl();
        msg.setFrom(from);

        if (message.startsWith(ResourceManager.COMMAND_CHARACTER)) {
            String privateMessage[] = message.split(" ", 2);
            String recipientLoginName = privateMessage[0].substring(1);
            String msgBody = privateMessage[1];

            msg.setRecipient(recipientLoginName);
            msg.setBody(parseMessage(msgBody));
        } else {
            msg.setBody(message);
        }
        return msg;
    }

    /**
     * Remove all illegal characters, etc.
     *
     * @param body
     * @return
     */
    public static String parseMessage(String body) {
        // TODO: 30.05.2016 remove illegal chars from body
        return body;
    }
}
