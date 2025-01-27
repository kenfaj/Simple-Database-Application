package com.mycompany.simpledbapp.app;

import com.mycompany.simpledbapp.service.LoginButtonController;
import javax.swing.*;

import java.awt.*;
//import gridlayout

public class Login extends JPanel {

    private JFrame frame;

    private JPanel panel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login(JFrame frame) {
        this.frame = frame;

        panel = new JPanel();
        userLabel = new JLabel("Enter Username");
        passwordLabel = new JLabel("Enter Password");
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
    }

    public Login launch() {
        frame.setTitle("Login Page");

        panel.setLayout(new GridLayout(2, 2));
        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        add(panel, BorderLayout.CENTER);
        add(loginButton, BorderLayout.SOUTH);
        setVisible(true);
        setSize(300, 200);

        // Set up actionlistener for Login Button
        loginButton.addActionListener(new LoginButtonController(frame, userTextField, passwordField));
        
        //user: ken, password: vince
        //user: kkkkkkkkkkkkkkkkkkkkkkkkkkkkkk, password: vince
        return this;
    }

    public static void main(String[] args) {
        // Tester method
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Login(f).launch());
        f.pack();
        f.setVisible(true);
    }

    public String getUser() {
        return userTextField.getText();
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }

}