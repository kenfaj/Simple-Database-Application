package com.mycompany.simpledbapp.app.components;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.mycompany.simpledbapp.service.LogoutButtonController;
import java.awt.Color;

public class LogoutButton extends JButton {
    public LogoutButton(JFrame frame) {
        //set UI
        Color darkGray = new Color(40, 40, 40);
        Color lightGray = new Color(220, 220, 220);
        Color buttonColor = new Color(60, 60, 60);
        
        setBackground(darkGray);
        setForeground(lightGray);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setText("Logout");
        addActionListener(new LogoutButtonController(frame));
    }
}
