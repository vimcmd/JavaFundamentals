package p02_classesAndLibrariesUsing.ch07_strings.sub04_applicationI18n;

import java.util.Locale;
import java.util.ResourceBundle;

/* # 10 # Different language support */

public class HamletI18n {
    public static void main(String[] args) {
        for(int i = 3; i > 0; i--) {
            System.out.println("1 - english \n2 - belorussian \n3 - russian");

            String country = "";
            String language = "";

            switch (i) {
                case 1:
                    country = "US";
                    language = "EN";
                    break;
                case 2:
                    country = "BY";
                    language = "BE";
                    break;
            }

            // NOTE: properties must be in ISO 8859-1 encoding
            // (for ex. in IDE must be enabled transparent native-to-ascii conversion, which stores characters as escape
            // sequences - \u0411 etc.)
            Locale current = new Locale(language, country);
            ResourceBundle rb = ResourceBundle.getBundle("properties/text", current);

            String s1 = rb.getString("str1");
            System.out.println(s1);

            String s2 = rb.getString("str2");
            System.out.println(s2);

            System.out.println(System.lineSeparator());
        }
    }
}
