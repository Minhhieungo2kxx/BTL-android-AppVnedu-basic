package com.example.btl_qlsv.DB;

public class DBConfig {
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "std_manager";

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

    public static String getDatabaseName() {
        return DATABASE_NAME;
    }
}
