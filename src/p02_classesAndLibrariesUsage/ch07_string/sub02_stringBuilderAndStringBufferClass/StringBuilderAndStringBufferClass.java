package p02_classesAndLibrariesUsage.ch07_string.sub02_stringBuilderAndStringBufferClass;

/* # 5 # StringBuffer object properties */

/**
 * <p>
 * {@link StringBuilder} and {@link StringBuffer} are mostly equal and very close to {@link String} class, but main
 * feature - they are mutable. Any changes in them are not creates new object as it is in case of using {@code String}.
 * In this case both of them are many times (1000+) faster than string concatenation etc.
 * </p>
 * <p>
 * Main difference between those two classes - {@code StringBuffer} are thread safe. In this case {@code StringBuilder}
 * are faster, but it should be used, if there no probability to access object in concurrent threads.
 * </p>
 */
public class StringBuilderAndStringBufferClass {

    public static class StringBufferExample {
        public static void main(String[] args) {
            // on initialization allocates memory (16 symbols). That makes easier changing value remaining in allocated
            // memory.
            StringBuffer sb = new StringBuffer();
            System.out.println("length  : " + sb.length());
            System.out.println("capacity: " + sb.capacity());
            // sb = "Java"; // causes error, only for String class
            sb.append("Java");
            System.out.println("string  : " + sb);
            System.out.println("length  : " + sb.length());
            System.out.println("capacity: " + sb.capacity());

            // if length of string after changing larger than allocated size, object size automatically increases keeping
            // small reserve for further changing.
            sb.append("Internationalization");
            System.out.println("string  : " + sb);
            System.out.println("length  : " + sb.length());
            System.out.println("capacity: " + sb.capacity());

            System.out.println("reverse : " + sb.reverse());
        }

    }
}
