package com.mycompany.simpledbapp.app;

import com.mycompany.simpledbapp.app.components.LogoutButton;

import javax.swing.*;

public class Admin extends JPanel {
    private JTable table;
    private LogoutButton logoutButton;

    public Admin() {
        logoutButton = new LogoutButton();
        ResultSet = 
    }

    public Guest launch() {
        setLayout(new GridLayout(2, 1));
        setVisible(true);
        setSize(300, 200);

        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        // setup actionlistener for logoutbutton

        add(welcomeLabel);
        add(logoutButton);

        return this;
    }

    public static void main(String[] args) {
        // Tester method
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Guest().launch());
        f.pack();
        f.setVisible(true);
    }

    public LogoutButton getLogoutButton() {
        return logoutButton;
    }
}
