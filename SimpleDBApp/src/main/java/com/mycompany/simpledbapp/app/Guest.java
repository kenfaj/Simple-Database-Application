package com.mycompany.simpledbapp.app;

import javax.swing.*;

import com.mycompany.simpledbapp.app.components.LogoutButton;

import java.awt.*;

public class Guest extends JPanel {
    private JLabel welcomeLabel;
    private LogoutButton logoutButton;
    private JPanel container;

    public Guest(JFrame frame) {
        welcomeLabel = new JLabel("Welcome Guest");
        logoutButton = new LogoutButton(frame);
        container = new JPanel();
    }

    public Guest launch() {
        
        Color darkGray = new Color(40, 40, 40);
        Color lightGray = new Color(220, 220, 220);
        
        container.setLayout(new GridLayout(2, 1));
        setVisible(true);
        setSize(300, 200);
        setBackground(darkGray);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(lightGray);
        
        container.setBackground(darkGray);
        
        container.add(welcomeLabel);
        container.add(logoutButton);
        add(container);
        
        return this;
    }

    public static void main(String[] args) {
        // Tester method
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Guest(f).launch());
        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        f.setSize(400, 200);
        f.getContentPane().setBackground(new Color(40, 40, 40));
        f.setVisible(true);
    }

    public LogoutButton getLogoutButton() {
        return logoutButton;
    }
}
