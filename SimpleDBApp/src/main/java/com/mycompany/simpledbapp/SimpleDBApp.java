package com.mycompany.simpledbapp;

import com.mycompany.simpledbapp.app.Login;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

public class SimpleDBApp {

    // stores current logged in user
    public static String username = null;

    public static void main(String[] args) {
        // Dito tayo magiinitialize ng Application(open login frame)
        JFrame frame = new JFrame();
        
        frame.add(new Login(frame).launch());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(40, 40, 40));
        
        frame.setVisible(true);
    }
}
