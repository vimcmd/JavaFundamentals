package p02_classesAndLibrariesUsing.ch07_strings.sub01_stringClass;

/* # 4 # Inclusion in literal pool */

public class StringIntern {
    public static void main(String[] args) {

        // Reference s1 initialises with literal, having all object properties.
        String s1 = "Java";
        String s2 = new String("Java");

        System.out.println(s1 == s2); //false

        // Method intern() invoking organizes search in "literal pool" based on s2 value, and on positive search returns
        // reference to found literal, else includes s2 to literal pool and returns reference.
        s2 = s2.intern();
        System.out.println(s1 == s2); //true
    }
}
