package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub05_stringFormatting;

import java.util.*;

/* # 17 # Format time and date */

/*
%tH Hour (00-23)
%tI Hour (1-12)
%tM minutes as a decimal integer (00-59)
%ts second as a decimal integer (00-59)
%tL Milliseconds (000-999)
%tY year in four digits
%ty year in two-digit format (00-99)
%tB Full name of the month ( "January")
%tb Or %th short name of the month ( "Jan")
%tm month in two-digit format (1-12)
%tA Full weekday name ( "Friday")
%ta Short weekday name ( "Fri")
%td Day in two-digit format (1-31)
%tR Same as "%tH:%tM"
%tT Same as "% tH:% tM:% tS"
%tr Same as "%tI:%tM:%tS%Tp" where %Tp = (AM or PM)
%tD same as the "%tm/%td/%ty"
%tF same as the "%tY-%tm-%td"
%tc Same as "%ta%tb%td%tT%tZ%tY"
 */

public class FormatterTimeAndDate {
    public static void main(String[] args) {
        Formatter f = new Formatter();
        Calendar cal = Calendar.getInstance();

        // output time in 12-hour time format
        f.format("%tr", cal);
        System.out.println(f);

        // output time in full format
        f = new Formatter();
        f.format("%tc", cal);
        System.out.println(f);

        // out current hours and minutes
        f = new Formatter();
        f.format("%tI:%tM", cal, cal);
        System.out.println(f);

        // out all month formats
        f = new Formatter();
        f.format("%tB %tb %tm", cal, cal, cal);
        System.out.println(f);
    }
}
