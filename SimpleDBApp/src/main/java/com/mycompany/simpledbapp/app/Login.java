package com.mycompany.simpledbapp.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mycompany.simpledbapp.service.LoginButtonController;

public class Login extends JPanel {

    private JFrame frame;

    private JPanel panel;
    private JPanel outerPanel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login(JFrame frame) {
        this.frame = frame;

        // Create the outer container panel
        outerPanel = new JPanel(new GridBagLayout()); // Centering layout
        panel = new JPanel(new GridBagLayout()); // Form layout

        userLabel = new JLabel("Enter Username:");
        passwordLabel = new JLabel("Enter Password:");
        userTextField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        // Set panel colors
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
        loginButton.setPreferredSize(new Dimension(100, 30));

        setupLayout();

        // Add action listener for login button
        LoginButtonController loginButtonController = new LoginButtonController(frame, userTextField, passwordField);
        loginButton.addActionListener(loginButtonController);
    }

    /**
     * Properly sets up the layout using GridBagConstraints.
     */
    private void setupLayout() {
        frame.setSize(400, 200);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        // Row 0: Username Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(userLabel, gbc);

        // Row 0: Username Field
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(userTextField, gbc);

        // Row 1: Password Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(passwordLabel, gbc);

        // Row 1: Password Field
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(passwordField, gbc);

        // Row 2: Login Button (Centered)
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Span across both columns
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        // Add the panel to outerPanel
        outerPanel.add(panel, new GridBagConstraints());
        add(outerPanel);
    }

    /**
     * Launches the login interface.
     */
    public Login launch() {
        frame.setTitle("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        //frame.setContentPane(outerPanel); // Use outerPanel as content
        frame.revalidate();
        frame.repaint();

        return this;
    }

    public static void main(String[] args) {
        // Tester method
        JFrame f = new JFrame();
        f.add(new Login(f).launch());
        f.setVisible(true);
    }

    public String getUser() {
        return userTextField.getText();
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }
}
