package com.algonquin.loggy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.algonquin.loggy.beans.Log;
import com.algonquin.loggy.beans.TextLog;
import com.algonquin.loggy.services.ApplicationService;

public class ApplicationDao implements ApplicationService {

    public ApplicationDao() {
    	
    	
    }
    public List<Log> getAllLogs() {
    	Log log = null;
    	List<Log> logs = new ArrayList<> ();
    	try {

        	Connection connection = DBConnection.getConnectionToDatabase();
        	
        	String sql = "select * from logs";
    		
        	
    		Statement statement = connection.createStatement();
    		
    		ResultSet set = statement.executeQuery(sql);
    		
    		while(set.next()) {
    			log = new TextLog();
//    			log.setId(set.getObject("uuid", java.util.UUID.class));
    			log.setTitle(set.getString("title"));
    			log.setContent(set.getString("content"));
    			log.setCreateTimestamp(set.getTimestamp("creatTimestamp"));
    			logs.add(log);
    		}	
    	} catch(SQLException exception) {
    		exception.printStackTrace();
    	}
		return logs;
    }
}
