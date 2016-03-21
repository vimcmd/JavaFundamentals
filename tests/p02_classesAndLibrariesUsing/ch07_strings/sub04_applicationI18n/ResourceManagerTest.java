package p02_classesAndLibrariesUsing.ch07_strings.sub04_applicationI18n;

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