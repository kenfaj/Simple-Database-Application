package com.mycompany.simpledbapp.app;

import javax.swing.*;

import com.mycompany.simpledbapp.app.components.LogoutButton;
import com.mycompany.simpledbapp.service.LogoutButtonController;

import java.awt.*;

public class Guest extends JPanel {
    private JLabel welcomeLabel;
    private LogoutButton logoutButton;

    public Guest() {
        welcomeLabel = new JLabel("Welcome Guest");
        logoutButton = new LogoutButton();

    }

    public Guest launch() {
        setLayout(new GridLayout(2, 1));
        setVisible(true);
        setSize(300, 200);

        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        // setup actionlistener for logoutbutton
        logoutButton.addActionListener(new LogoutButtonController());

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
