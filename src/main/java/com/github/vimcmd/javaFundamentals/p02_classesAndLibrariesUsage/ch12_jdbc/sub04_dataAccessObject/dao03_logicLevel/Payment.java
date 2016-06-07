package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao03_logicLevel;

import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Entity;

/* Payment is a entity-class, extended from Entity (like Abonent) */

public class Payment extends Entity {
    // some code goes here

    @Override
    public String toString() {
        return "Payment [id=" + getId() + "]";
    }
}
