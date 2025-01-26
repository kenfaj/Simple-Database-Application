package com.mycompany.simpledbapp.app;

import javax.swing.*;
import java.awt.*;
//import gridlayout

public class Login extends JFrame {

    private JPanel panel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {
        this.setTitle("Login");
        panel = new JPanel();
        userLabel = new JLabel("Enter Username");
        passwordLabel = new JLabel("Enter Password");
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        launch();
    }

    public void launch() {

        panel.setLayout(new GridLayout(2, 2));
        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        this.add(panel, BorderLayout.CENTER);
        this.add(loginButton, BorderLayout.SOUTH);
        this.setVisible(true);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Set up actionlistener for Login Button
    }

    public static void main(String[] args) {
        // Tester method
        new Login();
    }

}
