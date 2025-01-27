package com.mycompany.simpledbapp.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mycompany.simpledbapp.SimpleDBApp;
import com.mycompany.simpledbapp.app.Guest;
import com.mycompany.simpledbapp.app.Admin;

public class LoginButtonController implements ActionListener {

    private JFrame frame;
    private JTextField userTextField;
    private JPasswordField passwordField;

    private LoginButtonController(JFrame frame, JTextField userTextField, JPasswordField passwordField) {
        this.frame = frame;
        this.userTextField = userTextField;
        this.passwordField = passwordField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = userTextField.getText();
        char[] password = passwordField.getPassword();
        if (username.equals("admin") && password.equals("admin")) {
            frame.setContentPane(new Admin(frame).launch()); // switch to admin
        } else {
            frame.setContentPane(new Guest(frame).launch()); // switch to guest
        }
        frame.revalidate();
        frame.repaint();
    }

    public boolean isUser(String username, char[] password) {

    }

    public boolean isAdmin(String username, char[] password) {

    }
}
