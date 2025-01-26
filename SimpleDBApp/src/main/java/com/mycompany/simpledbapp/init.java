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
        f.setTitle("Login");
        f.add(new Login().launch());
        f.pack();
        f.setVisible(true);
    }
}
