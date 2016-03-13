package Core.javaLang.p01_Classes;

public class ClassString {
    private static long startTime;
    private static long endTime;
    private static int iterations = 10_000;

    public static void main(String[] args) {
        stringExample();
        stringBuilderAndBufferExample();
    }

    /**
     * {@link String}
     * <ul>
     *     <li>Automatically created with double quotes</li>
     *     <li>Pooled (interned) to save memory</li>
     *     <li>Immutable - once created cannot change</li>
     *     <li>Concatenated using the expensive {@code +} operator</li>
     *     <li>Many methods for string manipulation/searching</li>
     * </ul>
     */
    public static void stringExample() {
        startTime = System.currentTimeMillis();
        String s = "";
        for(int i = 0; i < iterations; i++) {
            s += ".";
        }
        endTime = System.currentTimeMillis();
        System.out.println("String concatenation: " + (endTime - startTime) + " ms");
    }

    /**
     * {@link StringBuilder}, {@link StringBuffer}
     * <ul>
     *     <li>Mutable - can quickly grow and shrink as needed</li>
     *     <li>Few methods modifying buffer: {@code append(), insert(), delete(), replace()}</li>
     *     <li>Use {@code toString()} if you needed to get a String representation of object content</li>
     *     <li>StringBuffer is synchronized for thread-safe access in multithreaded applications</li>
     *     <li>Use {@code StringBuilder} for better performance unless you plan to access the object from multiple threads</li>
     *     <li>In single-threaded context {@code StringBuilder} is faster than {@code StringBuffer}. But both are
     *     1000+ times faster than repeated {@code String} concatenation</li>
     * </ul>
     */
    public static void stringBuilderAndBufferExample() {
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < iterations; i++) {
            sb.append(".");
        }
        sb.trimToSize();
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder appending: " + (endTime - startTime) + " ms");
    }

}
