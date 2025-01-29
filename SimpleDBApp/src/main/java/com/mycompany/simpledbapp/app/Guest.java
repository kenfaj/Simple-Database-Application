package com.mycompany.simpledbapp.app;

import javax.swing.*;

import com.mycompany.simpledbapp.app.components.LogoutButton;

import java.awt.*;

public class Guest extends JPanel {
    private JLabel welcomeLabel;
    private LogoutButton logoutButton;

    public Guest(JFrame frame) {
        welcomeLabel = new JLabel("Welcome Guest");
        logoutButton = new LogoutButton(frame);
    }

    public Guest launch() {
        
        Color darkGray = new Color(40, 40, 40);
        Color lightGray = new Color(220, 220, 220);
        
        setLayout(new GridLayout(2, 1));
        setVisible(true);
        setSize(300, 200);
        setBackground(darkGray);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(lightGray);
        
        add(welcomeLabel);
        add(logoutButton);
        return this;
    }

    public static void main(String[] args) {
        // Tester method
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Guest(f).launch());
        f.pack();
        f.setVisible(true);
    }

    public LogoutButton getLogoutButton() {
        return logoutButton;
    }
}
