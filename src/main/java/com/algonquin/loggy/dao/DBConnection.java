package com.algonquin.loggy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Database Schema
    // CREATE DATABASE loggy DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
    // CREATE TABLE logs (uuid CHAR(40) NOT NULL PRIMARY KEY, title CHAR(128),
    // content TEXT, createTimestamp Date);

    private static final String dbUser = "root";
    private static final String dbPassword = "";

    public static Connection getConnectionToDatabase() {
        Connection connection = null;

        try {
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loggy", "root","root");
        } catch (ClassNotFoundException e) {
        	System.out.println(" Where is your Mysql JDBC Driver?");
        	e.printStackTrace();
        } catch (SQLException e) {
        	System.out.println("Connection Failed! Check output console");
        	e.printStackTrace();
        } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (connection != null) {
        	
        }
        return connection;
    }

}
