package p02_classesAndLibrariesUsing.ch07_strings.sub02_stringBuilderAndStringBufferClass;

/* # 7 # Comparing StringBuffer objects and their hash-codes */

/**
 * <p>
 * For classes {@link StringBuffer} and {@link StringBuilder} are not overrided methods {@code equals(), hasCode()} of
 * parent {@link Object} class, so it can not be possible to compare two objects based on content. On equivalent content
 * of two instances they can have different buffer size, so comparing objects are ambiguous.
 * </p>
 * <p>
 * Comparing two instances possible by using {@code sb1.toString().contentEquals(sb2)}
 * </p>
 */
public class StringBufferEquality {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer(48);

        sb1.append("Java");
        sb2.append("Java");

        System.out.println(sb1.equals(sb2)); //false
        System.out.println(sb1.hashCode() == sb2.hashCode()); //false
        System.out.println(sb1.toString().contentEquals(sb2)); //true
    }
}
