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

    /************* ✨ Codeium Command ⭐ *************/
    /**
     * Set up and launch the Login window
     * 
     * Creates a panel with a GridLayout containing the user label, text field,
     * password label and field
     * Adds the panel to the center of the JFrame and the login button to the south
     * Sets the size, visible, default close operation, and location of the JFrame
     * Sets up an action listener for the login button
     */
    /****** 7b2d32f9-1be2-4ecf-bd50-5ef1bc562bfa *******/
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