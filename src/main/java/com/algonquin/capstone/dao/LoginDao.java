package com.algonquin.capstone.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.algonquin.capstone.beans.LoginBean;
import com.algonquin.capstone.services.ApplicationService;
import com.algonquin.capstone.utils.Constant;

public class LoginDao implements ApplicationService {

    public LoginDao() {
    	
    	
    }
    public String authenticateUser(LoginBean loginBean)
    {
        String userName = loginBean.getUserName();
        String password = loginBean.getPassword();
     
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
     
        String userNameDB = "";
        String passwordDB = "";
        String roleDB = "";
     
        try
        {
            con = DBConnection.getConnectionToDatabase();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username,password,role from users");
     
            while(resultSet.next())
            {
                userNameDB = resultSet.getString("username");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getString("role");
     
                if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
                return Constant.ADMIN_ROLE;
                else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
                return Constant.USER_ROLE;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
}
