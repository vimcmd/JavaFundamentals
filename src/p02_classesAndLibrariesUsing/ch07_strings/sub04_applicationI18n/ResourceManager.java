package p02_classesAndLibrariesUsing.ch07_strings.sub04_applicationI18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * TODO: add description
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
