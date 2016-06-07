package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub04_applicationI18n;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* # 14 # Regional representation of dates */

public class DatesI18n {

    public static final String DATE = "April 9, 1987";

    public static void main(String[] args) {
        dateExample();
        getDateInAllLocales();
    }

    public static void dateExample() {

        Date d = null;
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);

        String str = DATE;
        try {
            d = df.parse(str);
            System.out.println(d);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.err.println("Error at: " + e.getErrorOffset());
        }

        df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("ru", "RU"));
        System.out.println(df.format(d));

        df = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMAN);
        System.out.println(df.format(d));
    }

    public static void getDateInAllLocales() {

        Date d = new Date();
        Locale[] locales = DateFormat.getAvailableLocales();

        for ( Locale locale : locales ) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);

            try {
                d = df.parse(DATE);
            } catch (ParseException e) {
                System.err.println("Error at: " + e.getErrorOffset());
            }

            System.out.println(locale.toString() + ": " + df.format(d));
        }
    }
}
