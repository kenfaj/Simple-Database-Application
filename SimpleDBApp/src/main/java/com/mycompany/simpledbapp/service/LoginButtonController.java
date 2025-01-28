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
import com.mycompany.simpledbapp.app.Error;


public class LoginButtonController implements ActionListener {

    private JFrame frame;
    private JTextField userTextField;
    private JPasswordField passwordField;
    
    private JDBCStartup jdbc;
    private int loginCtr = 0;

    public LoginButtonController(JFrame frame, JTextField userTextField, JPasswordField passwordField) {
        this.frame = frame;
        this.userTextField = userTextField;
        this.passwordField = passwordField;

        jdbc = new JDBCStartup(JDBCStartup.DEFAULT_DATABASE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = userTextField.getText();
        String password = new String(passwordField.getPassword());

        if (!isUser(username, password)) {
            
            if (++loginCtr == 3) {
                new Error().launch();
                loginCtr = 0;
                return;
            }
            
            JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            userTextField.setText("");
            passwordField.setText("");
        } else {
            SimpleDBApp.username = username;
            if (isAdmin(username, password)) {
                frame.setContentPane(new Admin(frame).launch());
            } else {
                frame.setContentPane(new Guest(frame).launch());
            }
            loginCtr = 0;
        }
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }

    public boolean isUser(String username, String password) {
        ResultSet rs = null;
        try {
            rs = jdbc.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //tester
        System.out.println("isUser Method Running.. with rs:" + rs);
        try {
            while (rs.next()) {
                //Tester
                System.out.println("Username:" + rs.getString("username") + " compares to " + username);
                System.out.println("Password:" + rs.getString("password") + " compares to " + password);

                if (rs.getString("username").equals(username)
                        && rs.getString("password").equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //tester
            System.out.println("Caught error: " + e.getMessage());
        }
        return false;
    }

    public boolean isAdmin(String username, String password) {
        
        ResultSet rs = null;
        try {
            rs = jdbc.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //tester
        System.out.println("isAdmin method Runinng..");
        try {
            while (rs.next()) {
                if (rs.getString("username").equals(username)
                        && rs.getString("password").equals(password)
                        && rs.getString("user_role").equals("admin")) {
                    //tester
                    System.out.println("he is admin:" + username);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
