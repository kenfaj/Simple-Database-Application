/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpledbapp.model;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
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
    private static final String DB_FOLDER = System.getProperty("user.home") + "\\SimpleDBApp_temp\\";
    private static final String DB_PATH = DB_FOLDER + DEFAULT_DATABASE;
    private static final String DB_URL = "jdbc:sqlite:" + DB_PATH;

    /**
     * Constructs a JDBCStartup object with the given database file. Creates a
     * temporary folder for the database and copies the database file from the
     * classpath to the folder if it doesn't already exist.
     *
     * @param database the name of the database file in the classpath
     */
    /**
     * Constructs a JDBCStartup object with the given database file. Creates a
     * temporary folder for the database and copies the database file from the
     * classpath to the folder if it doesn't already exist.
     *
     * @param database the name of the database file in the classpath
     */
    public JDBCStartup(String database) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();  // Close the connection first
                    System.out.println("Database connection closed.");
                }
                Files.deleteIfExists(Paths.get(DB_PATH));
                Files.deleteIfExists(Paths.get(DB_FOLDER));
                System.out.println("Deleted database folder: " + DB_FOLDER);
            } catch (IOException | SQLException e) {
                System.err.println("Error during shutdown: " + e.toString());
            }
        }));
        // extract database
        try {
            // Ensure folder exists
            Files.createDirectories(Paths.get(DB_FOLDER));
            try {
                // Copy database from classpath to temporary folder
                Files.copy(getClass().getResourceAsStream("/" + database), Paths.get(DB_PATH));
                System.out.println("Database extracted to: " + DB_PATH);
            } catch (FileAlreadyExistsException e) {
                // If database already exists, do nothing
                System.out.println("Database already exists at: " + DB_PATH);
            }
            // Establish connection to database
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Database connected at: " + DB_PATH);
        } catch (IOException | SQLException e) {
            // Handle exceptions
            System.err.println(e.toString());
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
     * @return an array of String arrays containing all records in the Users
     * table
     */
    public String[][] getUsernameRoleArray(String database) {
        JDBCStartup jdbc = new JDBCStartup(database);
        ArrayList<String[]> usernameRoleArray = new ArrayList<>();
        try {
            ResultSet rs = jdbc.getAll();

            while (rs.next()) {
                usernameRoleArray.add(new String[]{rs.getString("username"), rs.getString("user_role")});
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
            JOptionPane.showMessageDialog(null, "SQLException in JDBCStartup UsernameRoleArray");
        }

        // cast ArrayList<String[]> to String[][]
        return usernameRoleArray.toArray(new String[0][]);
    }
}
