package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub04_applicationI18n;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/* # 13 # Regional numbers format */

/**
 * To convert/extract information from data in specified regional format standard firstly need to create
 * current {@code Locale} instance and use it to create formatting object {@code NumberFormat}
 */
public class NumbersI18n {
    public static void main(String[] args) {
        NumberFormat nfGe = NumberFormat.getInstance(Locale.GERMAN);
        NumberFormat nfUs = NumberFormat.getInstance(Locale.US);
        NumberFormat nfFr = NumberFormat.getInstance(Locale.FRANCE);

        double doubleGe = 0, doubleUs = 0, doubleFr = 0;
        String num = "1.234,5";

        try {
            // parse number to german standard
            doubleGe = nfGe.parse(num).doubleValue();

            // parse number to american standard
            doubleUs = nfUs.parse(num).doubleValue();

            // parse number to french standard
            doubleFr = nfFr.parse(num).doubleValue();
        } catch (ParseException e) {
            System.err.println("Error at position: " + e.getErrorOffset());
        }

        System.out.printf("doubleGe: %f\ndoubleUs: %f\ndoubleFr: %f\n", doubleGe, doubleUs, doubleFr);

        // transform from german to american standard
        String stringUs = nfUs.format(doubleGe);

        // transform from german to french standard
        String stringFr = nfFr.format(doubleGe);

        System.out.printf("stringUs: " + stringUs + "\nstringFr: " + stringFr + "\n");

    }
}