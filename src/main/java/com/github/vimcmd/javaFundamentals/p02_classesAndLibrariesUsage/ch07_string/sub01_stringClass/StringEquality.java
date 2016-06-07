package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub01_stringClass;

/* # 3 # Compare references and objects */

public class StringEquality {
    public static void main(String[] args) {
        String s1 = "Java";

        // On creating s2 object first, create reference, and then setting object according that ref. In this case, s2
        // associates with already created literal, because s1 already makes reference to literal.
        String s2 = "Java";

        // On creating s3 we calling constructor, and memory allocates before initialization. In this case new object
        // created in heap. For memory optimization look at String.intern() example.
        String s3 = new String("Java");

        String s4 = new String(s1);

        System.out.println(s1 + "==" + s2 + " : " + ( s1 == s2 )); //true
        System.out.println(s3 + "==" + s4 + " : " + ( s3 == s4 )); //false
        System.out.println(s1 + "==" + s3 + " : " + ( s1 == s3 )); //false

        System.out.println(s1 + " equals " + s2 + " : " + ( s1.equals(s2) )); //true
        System.out.println(s1 + " equals " + s3 + " : " + ( s1.equals(s3) )); //true
    }
}
