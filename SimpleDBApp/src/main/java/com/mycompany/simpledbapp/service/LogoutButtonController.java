package com.mycompany.simpledbapp.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.mycompany.simpledbapp.SimpleDBApp;
import com.mycompany.simpledbapp.app.Login;

public class LogoutButtonController implements ActionListener {
    private JFrame frame;

    public LogoutButtonController(JFrame frame) {
        this.frame = frame;
    }

    /**
     * Handles the action event triggered by the logout button.
     * Resets the username to null and switches the interface to the login screen.
     *
     * @param e the ActionEvent triggered by the logout button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        SimpleDBApp.username = null; // set username to null
        frame.setContentPane(new Login(frame).launch()); // switch to login
        frame.revalidate();
        frame.repaint();
    }
}
