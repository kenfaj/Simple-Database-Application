package com.mycompany.simpledbapp.app;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

    /**
     * Launches the error dialog with a message and an exit button.
     *
     * @return Error instance representing the initialized error dialog
     */
    public Error launch() {
        // Set the layout to FlowLayout
        setLayout(new FlowLayout());

        // Set the title of the error dialog
        setTitle("Application closed");

        // Add the label and button to the error dialog
        add(errorLabel);
        add(exitButton);

        // Set the size of the error dialog
        setSize(400, 100);

        // Add an action listener to the exit button to close the application when
        // clicked
        exitButton.addActionListener(e -> System.exit(0));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Show the error dialog
        setVisible(true);

        // Return the Error instance
        return this;
    }

    /****** fb52bf05-aab6-4094-a1f4-d0fc6239427e *******/

    public static void main(String[] args) {
        // Tester method
        new Error().launch();
    }
}
