package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub03_transactions;

import java.sql.SQLException;

/* # 6.1 # transaction runner */

public class TransactionRunner {
    public static void main(String[] args) {
        SingletonEngine runner = SingletonEngine.getInstance();
        try {
            runner.transfer("100");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
