package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server;

import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.properties.ResourceManager;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum CommandList {
    REGISTER(ResourceManager.SERVER_COMMAND_REGISTER),
    TO_RECIPIENT(ResourceManager.RECIPIENT_CHARACTER),
    COMMAND_SIGN(ResourceManager.SERVER_COMMAND_CHARACTER),
    COMMAND_SEPARATOR(ResourceManager.SERVER_COMMAND_SEPARATOR),
    ;

    private String value;

    private CommandList(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    /**
     *
     * @param text
     * @return Map, where K - command from enum, V - command arguments (empty if no arguments)
     */
    public static Map<CommandList, String> extractCommands(String text) {
        Map<CommandList, String> messageCommands = new HashMap<>();

        Pattern pattern = Pattern.compile("[" + TO_RECIPIENT.toString() + "|" + COMMAND_SIGN.toString() + "][a-zA-Z_0-9_:]+\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            if (matcher.group().startsWith(TO_RECIPIENT.toString())) {
                messageCommands.put(TO_RECIPIENT, matcher.group().substring(1)); // remove '@' char
            }

            if (matcher.group().startsWith(COMMAND_SIGN.toString())) {
                String[] registrationInfo = matcher.group().split(COMMAND_SEPARATOR.toString(), 2);
                for(CommandList command : CommandList.values()) {
                    if (command.toString().equals(registrationInfo[0])) {
                        messageCommands.put(command, registrationInfo[1]);
                    }
                }
            }
        }

        return messageCommands;
    }
}
