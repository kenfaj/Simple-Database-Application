/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpledbapp.model;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ken
 */
public class JDBCStartup {
    private Connection conn;
    public static final String DEFAULT_DATABASE = "AccountsDB.db";

    public JDBCStartup(String database) {
        String connStr = "jdbc:sqlite:" + Paths.get("SimpleDBApp/src/main/resources").toAbsolutePath().toString()
                .replace("\\", "/").replaceFirst("/SimpleDBApp", "") + "/" + database;
        try {
            conn = DriverManager.getConnection(connStr);
            System.out.println("Successful connection");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to create connection\n" + e.getMessage());
            System.err.println(e.toString());
        }
    }

    /**
     * Retrieves all records in the Users table.
     * 
     * @return a ResultSet containing all records in the Users table
     * @throws SQLException if a database access error occurs
     */
    public ResultSet getAll() throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("select * from Users");
    }

    public static void main(String[] args) {
        // Tester method
        JDBCStartup jdbc = new JDBCStartup("AccountsDB.db");
        try {
            ResultSet rs = jdbc.getAll();
            while (rs.next()) {
                System.out.println(rs.getString("username") + rs.getString("password") + rs.getString("user_role"));
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }

    /**
     * Retrieves all records in the Users table as an array of String arrays.
     * The first element of each String array is the username, and the second
     * element is the user role.
     * 
     * @param database the name of the database file
     * @return an array of String arrays containing all records in the Users table
     */
    public static String[][] getUsernameRoleArray(String database) {
        JDBCStartup jdbc = new JDBCStartup(database);
        ArrayList<String[]> usernameRoleArray = new ArrayList<>();
        try {
            ResultSet rs = jdbc.getAll();

            while (rs.next()) {
                usernameRoleArray.add(new String[] { rs.getString("username"), rs.getString("user_role") });
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
            JOptionPane.showMessageDialog(null, "SQLException in JDBCStartup UsernameRoleArray");
        }

        // cast ArrayList<String[]> to String[][]
        return usernameRoleArray.toArray(new String[0][]);
    }
}
