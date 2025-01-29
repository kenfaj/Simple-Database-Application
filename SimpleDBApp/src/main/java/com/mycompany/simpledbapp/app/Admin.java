package com.mycompany.simpledbapp.app;

import com.mycompany.simpledbapp.app.components.LogoutButton;
import com.mycompany.simpledbapp.model.JDBCStartup;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class Admin extends JPanel {
    private JTable table;
    private LogoutButton logoutButton;
    private Object[][] list;

    public Admin(JFrame frame) {
        list = new JDBCStartup(JDBCStartup.DEFAULT_DATABASE).getUsernameRoleArray(JDBCStartup.DEFAULT_DATABASE);
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
        Color darkGray = new Color(40, 40, 40);
        Color lightGray = new Color(220, 220, 220);
        Color headerBackground = new Color(60, 60, 60);
        Color headerForeground = lightGray;
        
        table.setBackground(darkGray);
        table.setForeground(lightGray);
        table.setGridColor(lightGray);
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);
        
        Font tableFont = new Font("Verdana", Font.PLAIN, 16);
        table.setFont(tableFont);
        
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(headerBackground);
        tableHeader.setForeground(headerForeground);
        tableHeader.setFont(new Font("Verdana", Font.BOLD, 18));
        
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(150);
        
        table.setPreferredScrollableViewportSize(new Dimension(600, 400));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(darkGray);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(darkGray);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
        buttonPanel.add(logoutButton);
        logoutButton.setPreferredSize(new Dimension(150, 40));
        logoutButton.setFont(new Font("Verdana", Font.BOLD, 18));
        logoutButton.setBorder(new LineBorder(Color.white, 3));
        
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        setBackground(darkGray);
        setLayout(new GridLayout(2,1));
        setVisible(true);
        setSize(600, 500);
        
        return this;
    }

    public static void main(String[] args) {
        // Tester method
        JFrame f = new JFrame("Admin");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Admin(f).launch());
        f.setSize(600, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public LogoutButton getLogoutButton() {
        return logoutButton;
    }
}
