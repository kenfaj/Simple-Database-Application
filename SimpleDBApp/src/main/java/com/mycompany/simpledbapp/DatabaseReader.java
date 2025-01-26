package com.mycompany.simpledbapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseReader {

    private static String username = null;
    private static String password = null;
    private static String database = "Accounts.db";
    private static String table = "Users";

    private Connection conn;

    public static void main(String[] args) {
        JDBCStartup jdbc = new JDBCStartup(username, password, database);
        try {
            ResultSet rs = jdbc.getAll();
            while (rs.next()) {
                System.out.println(rs.getString("username") + rs.getString("password") + rs.getString("user_role"));
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }
    //GITHUB MAINBRANCH CANT SEE THIS sana?
}