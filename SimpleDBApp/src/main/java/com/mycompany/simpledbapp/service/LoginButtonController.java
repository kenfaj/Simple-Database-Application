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
import com.mycompany.simpledbapp.app.Guest;
import com.mycompany.simpledbapp.model.JDBCStartup;
import com.mycompany.simpledbapp.app.Admin;

public class LoginButtonController implements ActionListener {

    private JFrame frame;
    private JTextField userTextField;
    private JPasswordField passwordField;

    public LoginButtonController(JFrame frame, JTextField userTextField, JPasswordField passwordField) {
        this.frame = frame;
        this.userTextField = userTextField;
        this.passwordField = passwordField;

        jdbc = new JDBCStartup("AccountsDB.db");
        try {
            rs = jdbc.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = userTextField.getText();
        char[] password = passwordField.getPassword();

        if (!isUser(username, password)) {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password");
        } else {
            SimpleDBApp.username = username;
            if (isAdmin(username, password)) {
                frame.setContentPane(new Admin(frame).launch());
            } else {
                frame.setContentPane(new Guest(frame).launch());
            }
        }
         

        frame.repaint();
    }

    private JDBCStartup jdbc;
    private ResultSet rs;

    public boolean isUser(String username, char[] password) {
        try {
            while (rs.next()) {
                if (rs.getString("username").equals(username) &&
                        rs.getString("password").equals(new String(password))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isAdmin(String username, char[] password) {
        try {
            while (rs.next()) {
                if (rs.getString("username").equals(username) &&
                        rs.getString("password").equals(new String(password)) &&
                        rs.getString("access_role").equals("admin")) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
