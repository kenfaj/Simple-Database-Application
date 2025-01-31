package com.mycompany.simpledbapp;

import com.mycompany.simpledbapp.app.Login;
import java.awt.Color;
import javax.swing.JFrame;

public class SimpleDBApp {

    // stores current logged in user
    public static String username = null;

    public static void main(String[] args) {
        // Dito tayo magiinitialize ng Application(open login frame)
        JFrame frame = new JFrame();
        
        frame.add(new Login(frame).launch());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(40, 40, 40));
        
        frame.setVisible(true);
    }
}
