package com.example.sd20102sof203.buoi13.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static Connection conn;

    public static Connection getConnection()
    {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "sa", dbPass = "123456",
                        dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=SD20102;encrypt=true;trustServerCertificate=true;";

                conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Kết nối thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) {
        System.out.println(DbConnection.getConnection());
    }
}
