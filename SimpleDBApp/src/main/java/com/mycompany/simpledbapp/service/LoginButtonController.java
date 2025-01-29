package com.mycompany.simpledbapp.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mycompany.simpledbapp.SimpleDBApp;
import com.mycompany.simpledbapp.app.Admin;
import com.mycompany.simpledbapp.app.Error;
import com.mycompany.simpledbapp.app.Guest;
import com.mycompany.simpledbapp.model.JDBCStartup;

public class LoginButtonController implements ActionListener {

    private final JFrame frame;
    private final JTextField userTextField;
    private final JPasswordField passwordField;

    private final JDBCStartup jdbc;
    private int loginCtr = 0;

    public LoginButtonController(JFrame frame, JTextField userTextField, JPasswordField passwordField) {
        this.frame = frame;
        this.userTextField = userTextField;
        this.passwordField = passwordField;
        jdbc = new JDBCStartup(JDBCStartup.DEFAULT_DATABASE);
    }

    /**
     * Handles the action event triggered by the login button.
     * Validates user credentials and launches the appropriate interface.
     * 
     * @param event the ActionEvent triggered by the login button
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        // Retrieve the username and password from the text fields
        String username = userTextField.getText();
        String password = new String(passwordField.getPassword());

        // Check if the user credentials are valid
        if (!isUser(username, password)) {
            // If not, display an error message and reset the text fields
            if (++loginCtr == 3) {
                // If the login counter reaches 3, launch the error dialog
                new Error().launch();
                loginCtr = 0;
                return;
            }

            JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            userTextField.setText("");
            passwordField.setText("");
        } else {
            // If the user credentials are valid, set the username
            // and launch the appropriate interface
            SimpleDBApp.username = username;
            if (isAdmin(username, password)) {
                frame.setContentPane(new Admin(frame).launch());
            } else {
                frame.setContentPane(new Guest(frame).launch());
            }
            loginCtr = 0;
        }
        // Update the frame
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }

    /**
     * Checks if the given username and password matches a
     * user in the database.
     * 
     * @param username the username to check
     * @param password the password to check
     * @return true if the user is a user, false if not
     */
    public boolean isUser(String username, String password) {
        try (ResultSet rs = jdbc.getAll()) {
            // Iterate through the records in the database
            while (rs.next()) {
                // Check if the current record matches the given username and password
                if (rs.getString("username").equals(username)
                        && rs.getString("password").equals(password)) {
                    // If a match is found, return true
                    return true;
                }
            }
        } catch (SQLException e) {
            // If an SQLException occurs, print the stack trace
            e.printStackTrace();
        }
        // If no match is found, return false
        return false;
    }

    /**
     * Checks if the given username and password matches an
     * admin-level user in the database.
     * 
     * @param username the username to check
     * @param password the password to check
     * @return true if the user is an admin-level user, false if not
     */
    public boolean isAdmin(String username, String password) {
        try (ResultSet rs = jdbc.getAll()) {
            while (rs.next()) {
                if (rs.getString("username").equals(username)
                        && rs.getString("password").equals(password)
                        && rs.getString("user_role").equals("admin")) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
