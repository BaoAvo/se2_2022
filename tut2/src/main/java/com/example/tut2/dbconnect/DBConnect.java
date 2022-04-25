package com.example.tut2.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static final String  DB_URL = "jdbc:mysql://127.0.0.1:3306/bookdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Baohamhap297120@";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
