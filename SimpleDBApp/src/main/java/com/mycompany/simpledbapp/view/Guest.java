package com.mycompany.simpledbapp.view;

import javax.swing.*;
import java.awt.*;

public class Guest extends JFrame {
    private JPanel panel;
    private JLabel welcomeLabel;
    private JButton logoutButton;

    public Guest() {
        this.setTitle("Guest");
        this.setVisible(true);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }

    public void launch() {

    }

    public static void main(String[] args) {
        new Guest();
    }
}
