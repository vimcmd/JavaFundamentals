package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.properties;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceManager {
    private static final ResourceBundle serverMessagesResource = ResourceBundle.getBundle("p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.properties.serverMessages", Locale
            .getDefault());
    public static final String RECIPIENT_CHARACTER = serverMessagesResource.getString("server.commands.recipientCharacter");
    public static final String SERVER_COMMAND_CHARACTER = serverMessagesResource.getString("server.commands.commandCharacter");
    public static final String SERVER_COMMAND_REGISTER = serverMessagesResource.getString("server.commands.register");
    public static final String SERVER_COMMAND_UNKNOWN = serverMessagesResource.getString("server.commands.unknown");
    public static final String SERVER_STATUS_ADDRESS_RESERVATION_ERROR = serverMessagesResource.getString("server.status.error.address.reserveError");
    public static final String SERVER_STATUS_INITIALIZED = serverMessagesResource.getString("server.status.initialized");
    public static final String SERVER_STATUS_WAITING_CLIENTS = serverMessagesResource.getString("server.status.waiting");
    public static final String SERVER_TIPS_PRIVATE = serverMessagesResource.getString("server.tips.privateMessage");
    public static final String SERVER_USER_CONNECTED = serverMessagesResource.getString("server.user.status.connected");
    public static final String SERVER_USER_DISCONNECTED = serverMessagesResource.getString("server.user.disconnected");
    public static final String SERVER_USER_EXISTS = serverMessagesResource.getString("server.user.name.exists");
    public static final String SERVER_USER_MUST_REGISTER = serverMessagesResource.getString("server.user.mustRegisterFirst");
    public static final String SERVER_USER_NAME_INCORRECT = serverMessagesResource.getString("server.user.name.incorrect");
    public static final String SERVER_USER_NOT_REGISTERED = serverMessagesResource.getString("server.user.notRegistered");
    public static final String SERVER_USER_SUCCESSFULLY_REGISTERED = serverMessagesResource.getString("server.user.registered");
    public static final String SERVER_USER_WELCOME_MESSAGE = serverMessagesResource.getString("server.user.welcomeMessage");
    public static final String SERVER_COMMAND_SEPARATOR = serverMessagesResource.getString("server.commands.separator");

    private ResourceManager() {
    }
}
