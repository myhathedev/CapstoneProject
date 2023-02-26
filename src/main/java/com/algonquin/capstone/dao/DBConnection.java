package com.algonquin.capstone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


	private static final String dbUrl = "jdbc:mysql://localhost:3306/ielts_db";
    private static final String dbUser = "root";
    private static final String dbPassword = "MyNewPass";

    public static Connection getConnectionToDatabase() {
        Connection connection = null;

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	System.out.println("MySQL JDBC Driver Register!");	
        	connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
        } catch (ClassNotFoundException e) {
        	System.out.println(" Where is your Mysql JDBC Driver?");
        	e.printStackTrace();
        } catch (SQLException e) {
        	System.out.println("Connection Failed! Check output console");
        	e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (connection != null) {
        	
        }
        return connection;
    }

}
