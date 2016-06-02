package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.server;

import p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.properties.ResourceManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Comandlet {
    COMMAND_SIGN(ResourceManager.SERVER_COMMAND_CHARACTER),
    COMMAND_UNKNOWN(ResourceManager.SERVER_COMMAND_UNKNOWN),
    REGISTER(ResourceManager.SERVER_COMMAND_REGISTER),
    TO_RECIPIENT(ResourceManager.RECIPIENT_CHARACTER),
    TIME(ResourceManager.SERVER_COMMAND_TIME),
    HELP(ResourceManager.SERVER_COMMAND_HELP);

    private String value;

    private Comandlet(String value) {
        this.value = value;
    }

    /**
     * @param text
     * @return Map, where K - comandlet object, V - command arguments list
     */
    public static Map<Comandlet, List<String>> extractCommands(String text) {
        Map<Comandlet, List<String>> messageCommands = new HashMap<>();

        Pattern pattern = Pattern.compile("[" + TO_RECIPIENT.toString() + "|" + COMMAND_SIGN.toString() + "][a-zA-Z_0-9_:]+\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            // TODO: 02.06.2016 refactor!!!
            if (matcher.group().startsWith(TO_RECIPIENT.toString())) {
                List<String> list = messageCommands.get(TO_RECIPIENT);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(matcher.group().substring(1)); // remove '@' char
                messageCommands.put(TO_RECIPIENT, list);

            }

            if (matcher.group().startsWith(COMMAND_SIGN.toString())) {
                String[] registrationInfo = matcher.group().split(ResourceManager.SERVER_COMMAND_SEPARATOR, 2);

                if (getAvailableCommandsToString().contains(registrationInfo[0])) {
                    for(Comandlet command : Comandlet.values()) {
                        if (command.toString().equals(registrationInfo[0])) {

                            List<String> list = messageCommands.get(command);
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            if (registrationInfo.length > 1) {
                                list.add(registrationInfo[1]);
                            }
                            messageCommands.put(command, list);
                        }
                    }
                } else {
                    // TODO: 02.06.2016 move unknown command detection to server side
                    List<String> list = messageCommands.get(COMMAND_UNKNOWN);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(matcher.group());

                    messageCommands.put(COMMAND_UNKNOWN, list);
                }

            }
        }

        return messageCommands;
    }

    private static List<String> getAvailableCommandsToString() {
        final Comandlet[] commands = Comandlet.values();
        List<String> commandsToString = new ArrayList<>(commands.length);
        for(Comandlet command : commands) {
            commandsToString.add(command.toString());
        }
        return commandsToString;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
