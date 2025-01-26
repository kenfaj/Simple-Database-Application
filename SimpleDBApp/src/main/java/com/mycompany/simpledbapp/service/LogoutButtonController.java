package com.mycompany.simpledbapp.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.mycompany.simpledbapp.app.Login;
import com.mycompany.simpledbapp.model.LogoutModel;

public class LogoutButtonController implements ActionListener {

    private LogoutModel model;
    private JFrame view;

    public LogoutButtonController(LogoutModel model, JFrame view) {
        this.model = model;
        this.view = view;
    }

    // Method to attach the listener to a button
    // public void attachListener(LogoutButton logoutButton) {

    // }

    
    public void actionPerformed(ActionEvent e) {
        model.logout();
        view.setNewContent(new Login().launch());
    }
}
