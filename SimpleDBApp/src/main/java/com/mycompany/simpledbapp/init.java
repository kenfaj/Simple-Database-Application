package com.mycompany.simpledbapp;

import com.mycompany.simpledbapp.model.JDBCStartup;
import java.sql.ResultSet;
import java.sql.SQLException;

public class init {
    public static void main(String[] args) {
        //Dito tayo magiinitialize ng Application(open login frame)
        
        //Test output for init file
        JDBCStartup jdbc = new JDBCStartup("root", "root", "AccountsDB.db");
        try {
            ResultSet rs = jdbc.getAll();
            while (rs.next()) {
                System.out.println(rs.getString("username") + rs.getString("password") + rs.getString("user_role"));
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }
}
