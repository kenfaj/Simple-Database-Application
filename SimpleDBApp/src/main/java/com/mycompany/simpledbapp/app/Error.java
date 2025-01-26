package com.mycompany.simpledbapp.app;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class Error extends JDialog {
    private JLabel errorLabel;

    public Error() {
        errorLabel = new JLabel("Consecutive login attempts failed. Please try again later.");
    }

    public Error launch() {
        setTitle("Application closed");
        add(errorLabel);
        setSize(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        return this;
    }

    public static void main(String[] args) {
        // Tester method
        new Error().launch();
    }
}
