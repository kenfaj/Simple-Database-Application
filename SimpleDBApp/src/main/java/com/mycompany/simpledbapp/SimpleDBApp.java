package com.mycompany.simpledbapp;

import com.mycompany.simpledbapp.app.Login;
import javax.swing.JFrame;

public class SimpleDBApp {

    // stores current logged in user
    public static String username = null;
    public static JFrame frame = new JFrame();

    public static void main(String[] args) {
        // Dito tayo magiinitialize ng Application(open login frame)
        frame.add(new Login().launch());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
