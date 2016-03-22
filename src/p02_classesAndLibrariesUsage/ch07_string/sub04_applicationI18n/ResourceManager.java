package p02_classesAndLibrariesUsage.ch07_string.sub04_applicationI18n;

import java.util.Locale;
import java.util.ResourceBundle;

/* # 11 # Resource manager */

/**
 * To interact with properties files it is a good idea to create special class, which instance allow to extract
 * data based on key, change locale value, which makes it easy to use on application internationalization
 */
public enum ResourceManager {
    INSTANCE;
    private final String resourceName = "properties.text";
    private ResourceBundle resourceBundle;

    private ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    public void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}
