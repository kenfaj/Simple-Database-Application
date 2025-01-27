package com.mycompany.simpledbapp.app;


import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Error extends JDialog {
    private JLabel errorLabel;
    private JButton exitButton;

    public Error() {
        errorLabel = new JLabel("Consecutive login attempts failed. Please try again later.");
        exitButton = new JButton("Close");
    }

    public Error launch() {
        setLayout(new FlowLayout());
        setTitle("Application closed");
        add(errorLabel);
        add(exitButton);
        setSize(400, 100);
        exitButton.addActionListener(e -> this.dispose());
        
        setVisible(true);
        return this;
    }

    public static void main(String[] args) {
        // Tester method
        new Error().launch();
    }
}
