package p02_classesAndLibrariesUsing.ch07_strings.sub04_applicationI18n;

import java.util.Locale;

/**
 * Class instance may be created only once, and whole application can use its features
 */
public class ResourceManagerRun {
    public static void main(String[] args) {
        ResourceManager manager = ResourceManager.INSTANCE;

        System.out.println(manager.getString("str1"));

        manager.changeResource(new Locale("be", "BY"));
        System.out.println(manager.getString("str1"));

        manager.changeResource(new Locale("", ""));
        System.out.println(manager.getString("str1"));
    }
}
