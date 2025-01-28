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

    /**
     * Launches the login interface.
     *
     * @return Login instance representing the initialized login panel
     */
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

        // Set up action listener for Login Button
        LoginButtonController loginButtonController = new LoginButtonController(frame, userTextField, passwordField);
        loginButton.addActionListener(loginButtonController);

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

    /**
     * Returns the value in the username text field.
     *
     * @return the value in the username text field
     */
    public String getUser() {
        return userTextField.getText();
    }

    /**
     * Returns the password entered in the password field.
     *
     * @return a character array containing the password
     */
    public char[] getPassword() {
        // Retrieve the password as a character array from the password field
        return passwordField.getPassword();
    }

}