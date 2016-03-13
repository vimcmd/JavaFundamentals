package Core.javaLang.p01_Classes;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * The {@link java.lang.System} class comes with many static methods and mainly intended to
 * communicate with the underlying systems. Using these methods, it is possible to take keyboard
 * input (using {@code System.in}), knowing system time (using {@code currentTimeMillis()}),
 * copying an array elements into another (using {@code arrayCopy()}, method illustrated in
 * {@code arrays} topic), to advise to go for garbage collection (using {@code gc()}) and finally
 * to know the system properties etc.
 * <p>
 * <p>
 * Following is the class signature:
 * </p>
 * <p><b>public final class System extends Object</b></p>
 * <p>
 * The {@code System} class is declared as <b>final</b> and thereby no class is allowed to inherit. The class
 * contains three static final instance variables.
 * </p>
 * <ul>
 * <li><p><b>public final InputStream in</b></p></li>
 * <li><p><b>public final InputStream out</b></p></li>
 * <li><p><b>public final PrintStream err</b></p></li>
 * </ul>
 * <p>
 * The <b>in</b> variable represents an object of {@link java.io.InputStream} and <b>out</b> and
 * <b>err</b> variables represent and object of {@link java.io.PrintStream} and their usage is discussed
 * more in I/O streams.
 * </p>
 * <p>
 * Following program illustrates the usage of {@code currentTimeMills()} and {@code getProperties()}
 * methods.
 * </p>
 */
public class ClassSystem {

    final static String SEPARATOR = "===============================================";

    public static void main(String[] args) {
        timeExecutingWhileLoop();
        System.out.println(SEPARATOR);
        getOsPropertiesForEach();
        //getOsPropertiesWhileLoop();
        System.out.println(SEPARATOR);
        getEnvironmentVariables();
    }

    /**
     * {@code currentTimeMillis()} static method returns the system time in milliseconds (this method
     * also used to know the file copying time in I\O topic). It should be noted that JDK1.5 adds one
     * more method {@code nanoTime()} that returns the time in nano seconds. In the above statement,
     * the time is read before loop iterations starts. Similarly, the time is taken after loop, and
     * difference gives you the time taken for iterations.
     */
    private static void timeExecutingWhileLoop() {
        long startTime = System.currentTimeMillis();
        int x = 1;
        while (x <= 10_000_000) {
            x++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("while loop took " + ( endTime - startTime ) + "ms for " + x + " iterations");
    }

    /**
     * The {@code getProperties()} static method of System class returns an object of
     * {@link java.util.Properties}. {@code Properties} is data structure that stores the data in
     * key/value pairs. The method returns the properties like Java vendor and path separator etc.
     */
    private static void getOsPropertiesForEach() {
        System.out.println("System properties are:");
        Properties props = System.getProperties();

        for(Map.Entry<?, ?> elem : props.entrySet()) {
            System.out.println(elem.getKey() + ": " + elem.getValue());
        }
    }

    /**
     * just another example of {@link #getOsPropertiesForEach()}
     * <p>
     * The {@code propertyNames()} method of Properties returns {@link Enumeration} object. Using
     * {@code Enumeration} object we can extract all the property names and their corresponding values in
     * a loop. For example, the property name is {@code user.country} and its value printed is
     * {@code US}.
     * </p>
     * </p>
     */
    private static void getOsPropertiesWhileLoop() {
        System.out.println("System properties are:");
        Properties props = System.getProperties();
        Enumeration e = props.propertyNames();

        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = props.getProperty(key);
            System.out.println(key + ": " + value);
        }
    }

    /**
     * The static method {@code getenv()} returns the path and classpath etc. as an object of
     * {@link java.util.Map} interface.
     */
    private static void getEnvironmentVariables() {
        System.out.println("Following are system environment variables:");
        Map<?, ?> variables = System.getenv();

        for(Map.Entry<?, ?> elem : variables.entrySet()) {
            System.out.println(elem.getKey() + ": " + elem.getValue());
        }
    }


}
