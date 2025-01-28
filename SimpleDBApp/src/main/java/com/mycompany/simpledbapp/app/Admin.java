package com.mycompany.simpledbapp.app;

import com.mycompany.simpledbapp.app.components.LogoutButton;
import com.mycompany.simpledbapp.model.JDBCStartup;

import java.awt.*;

import javax.swing.*;

public class Admin extends JPanel {
    private JTable table;
    private LogoutButton logoutButton;
    private Object[][] list;

    public Admin(JFrame frame) {
        list = JDBCStartup.getUsernameRoleArray(JDBCStartup.DEFAULT_DATABASE);
        String[] columnNames = { "Username", "Access Role" };
        table = new JTable(list, columnNames);
        logoutButton = new LogoutButton(frame);
    }

    /**
     * Launches the Admin interface.
     * Initializes the Admin panel with a JTable containing all usernames and their
     * roles
     * and a LogoutButton to exit the interface.
     *
     * @return Admin instance representing the initialized Admin panel
     */
    public Admin launch() {
        setLayout(new GridLayout(2, 1));
        setVisible(true);
        setSize(300, 200);
        add(table); // add the JTable containing all usernames and their roles
        add(logoutButton); // add the LogoutButton to exit the interface
        return this;
    }

    public static void main(String[] args) {
        // Tester method
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Admin(f).launch());
        f.pack();
        f.setVisible(true);
    }

    public LogoutButton getLogoutButton() {
        return logoutButton;
    }
}
