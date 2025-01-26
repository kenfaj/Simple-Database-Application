package com.mycompany.simpledbapp.app;

import com.mycompany.simpledbapp.app.components.LogoutButton;
import com.mycompany.simpledbapp.model.JDBCStartup;
import com.mycompany.simpledbapp.service.LogoutButtonController;

import java.awt.*;

import javax.swing.*;

public class Admin extends JPanel {
    private JTable table;
    private LogoutButton logoutButton;
    private Object[][] list;

    public Admin() {
        list = JDBCStartup.getUsernameRoleArray();
        String[] columnNames = { "Username", "Access Role" };
        table = new JTable(list, columnNames);
        logoutButton = new LogoutButton();

    }

    public Admin launch() {
        setLayout(new GridLayout(2, 1));
        setVisible(true);
        setSize(300, 200);

        // setup actionlistener for logoutbutton
        logoutButton.addActionListener(new LogoutButtonController());

        add(table);
        add(logoutButton);

        return this;
    }

    public static void main(String[] args) {
        // Tester method
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Admin().launch());
        f.pack();
        f.setVisible(true);
    }

    public LogoutButton getLogoutButton() {
        return logoutButton;
    }
}
