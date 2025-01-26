/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpledbapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ken
 */
public class JDBCStartup {
    private class User {
        String username;
        String password;
        String accessRole;

        public User(String username, String password, String accessRole) {
            this.username = username;
            this.password = password;
            this.accessRole = accessRole;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAccessRole() {
            return accessRole;
        }

        public void setAccessRole(String accessRole) {
            this.accessRole = accessRole;
        }
    }

    private Connection conn;

    public JDBCStartup(String database) {
        String connStr = "jdbc:sqlite:SimpleDBApp/src/main/resources/" + database;
        try {
            conn = DriverManager.getConnection(connStr);
            System.out.println("Successful connection");
        } catch (SQLException e) {
            System.err.println("Failed to create connection");
            System.err.println(e.toString());
        }
    }

    public ResultSet getAll() throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("select * from Users");
    }

    public User getUser(String username, String password, String accessRole) throws SQLException {
        Statement stmt = conn.createStatement();
        String sqlStr = "select * from users a "
                + "where a.username=" + username + " "
                + "& a.password=" + password
                + "& a.user_role=" + accessRole;
        ResultSet rs = stmt.executeQuery(sqlStr);
        if (rs.next())
            return new User(rs.getString("username"), rs.getString("password"),
                    rs.getString("access_role"));
        else
            return null;
    }

    public User getUserByUserName(String username) throws SQLException {
        Statement stmt = conn.createStatement();
        String sqlStr = "select * from users a "
                + "where a.username=" + username;
        ResultSet rs = stmt.executeQuery(sqlStr);
        if (rs.next())
            return new User(rs.getString("username"), rs.getString("password"),
                    rs.getString("access_role"));
        else
            return null;
    }

    public static void main(String[] args) {
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
}
