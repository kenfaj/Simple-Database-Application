package com.mycompany.simpledbapp.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mycompany.simpledbapp.SimpleDBApp;
import com.mycompany.simpledbapp.app.Login;

public class LogoutButtonController implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        SimpleDBApp.username = null;// set username to null
        SimpleDBApp.frame.setContentPane(new Login().launch());// switch to login
        SimpleDBApp.frame.revalidate();
        SimpleDBApp.frame.repaint();
    }
}
