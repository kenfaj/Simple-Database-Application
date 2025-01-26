package com.mycompany.simpledbapp;

import com.mycompany.simpledbapp.app.Login;
import com.mycompany.simpledbapp.model.JDBCStartup;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;

public class init {

    // stores current logged in user
    public static String username;
    public static JFrame frame;

    public static void main(String[] args) {
        // Dito tayo magiinitialize ng Application(open login frame)
        JFrame f = new JFrame();
        f.add(new Login().launch());
        f.pack();
        f.setVisible(true);

        // Test output for init file
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
