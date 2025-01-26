package com.mycompany.simpledbapp.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mycompany.simpledbapp.init;
import com.mycompany.simpledbapp.app.Login;

public class LogoutButtonController implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        init.username = null;// set username to null
        init.frame.setContentPane(new Login().launch());// switch to login
        init.frame.revalidate();
        init.frame.repaint();
    }
}
