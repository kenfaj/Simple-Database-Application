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
        userTextField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
    }

    /**
     * Launches the login interface.
     *
     * @return Login instance representing the initialized login panel
     */
    public Login launch() {
        frame.setTitle("Login Page");
        
        Color darkGray = new Color(40, 40, 40);
        Color lightGray = new Color(220, 220, 220);
        Color buttonColor = new Color(60, 60, 60);
        
        setBackground(darkGray);
        panel.setBackground(darkGray);
        userLabel.setForeground(lightGray);
        passwordLabel.setForeground(lightGray);
        userTextField.setBackground(buttonColor);
        userTextField.setForeground(lightGray);
        userTextField.setCaretColor(lightGray);
        passwordField.setBackground(buttonColor);
        passwordField.setForeground(lightGray);
        passwordField.setCaretColor(lightGray);
        loginButton.setBackground(buttonColor);
        loginButton.setForeground(lightGray);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(lightGray));
        
        panel.setLayout(new GridLayout(2, 1, 0, 10));
        

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(loginButton, BorderLayout.SOUTH);
        
        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        setVisible(true);
        setSize(500, 300);
        
        

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
        f.setResizable(false);
        f.setLocationRelativeTo(null);
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