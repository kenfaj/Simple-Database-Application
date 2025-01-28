package com.mycompany.simpledbapp.app.components;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.mycompany.simpledbapp.service.LogoutButtonController;

public class LogoutButton extends JButton {
    public LogoutButton(JFrame frame) {
        setText("Logout");
        setPreferredSize(new java.awt.Dimension(100, 30));
        addActionListener(new LogoutButtonController(frame));
    }
}
