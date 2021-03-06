package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub04_applicationI18n;

import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub04_applicationI18n.ResourceManager;

import java.util.Locale;

/* # 12 # Extract information from data source and change locale */

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
