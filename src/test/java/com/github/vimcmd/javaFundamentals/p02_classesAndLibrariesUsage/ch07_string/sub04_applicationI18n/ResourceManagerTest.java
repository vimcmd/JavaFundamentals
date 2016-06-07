package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub04_applicationI18n;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class ResourceManagerTest {
    
    @Test
    public void testResourceManager() throws Exception {
        ResourceManager resourceManager = ResourceManager.INSTANCE;
        resourceManager.changeResource(new Locale("be", "BY"));
        String resultString = resourceManager.getString("str1");
        assertEquals("Быць або не быць?", resultString);
    }
}