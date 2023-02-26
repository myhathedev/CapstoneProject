package com.algonquin.capstone.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import com.algonquin.capstone.beans.questions;

public class AdminDao {
	   public int createQuestion(questions question) {
	    	int rowsAffected =0;
			try {
				Connection connection = DBConnection.getConnectionToDatabase();
				
				String insertQuery = "insert into questions values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement statement = connection.prepareStatement(insertQuery);
				statement.setString(1,question.getId());
				statement.setString(2,question.getQuestion());
				statement.setString(3,question.getOption1());
				statement.setString(4,question.getOption2());
				statement.setString(5,question.getOption3());
				statement.setString(6,question.getOption4());
				statement.setString(7,question.getAnswer());
				statement.setString(8,question.getTopic());
				statement.setString(9,question.getDate().toString());
				
				rowsAffected = statement.executeUpdate();
				
			} catch (SQLException e){
				e.printStackTrace();
			}
			
			return rowsAffected ;
		}
	   
	   public int deleteQuestion(String id) {
	    	int rowsAffected =0;
			try {
				Connection connection = DBConnection.getConnectionToDatabase();
				
				String insertQuery = "delete from questions where id=?;";
				PreparedStatement statement = connection.prepareStatement(insertQuery);
				statement.setString(1,id);
				rowsAffected = statement.executeUpdate();
				
			} catch (SQLException e){
				e.printStackTrace();
			}
			
			return rowsAffected ;
		}
	    
	    public int updateQuestion(String id,String question,String option1,String option2,String option3,String option4,String answer) {
	    	int rowsAffected =0;
			try {
				Connection connection = DBConnection.getConnectionToDatabase();
				
				String insertQuery = "update questions set question=?, option1=?,option2=?,option3=?,option4=?, answer=? where id=?;";
				
				PreparedStatement statement = connection.prepareStatement(insertQuery);
				statement.setString(1,question);
				statement.setString(2,option1);
				statement.setString(3,option2);
				statement.setString(4,option3);
				statement.setString(5,option4);
				statement.setString(6,answer);
				statement.setString(7,id);
				rowsAffected = statement.executeUpdate();
				
			} catch (SQLException e){
				e.printStackTrace();
			}
			
			return rowsAffected ;
		}
	    
	    public ArrayList<questions> getQuestionList() {
	    	ArrayList<questions> list = new ArrayList<>();
	    	try {
			Connection conn = DBConnection.getConnectionToDatabase();
	    	Statement stmt = conn.createStatement();
	    	
	    	
	    	String query = " Select * from questions;"; 
	    	ResultSet set = stmt.executeQuery(query);	
	
	    	while (set.next()) {
				UUID id = UUID.fromString(set.getString("id"));
				String question = set.getString("question");
				String option1 = set.getString("option1");
				String option2 = set.getString("option2");
				String option3 = set.getString("option3");
				String option4 = set.getString("option4");
				String answer = set.getString("answer");
				String topic = set.getString("topic");		
				Date date = set.getDate("datecreated");
				questions newquestion = new questions(id,question,option1,option2,option3,option4,answer,topic,date);
				list.add(newquestion);	
	    	}
			set.close();
			stmt.close();
			conn.close();}
	    	catch (SQLException e){
				e.printStackTrace();
			}
			return list;
	    }
	    
	    public questions getRow(String id) throws SQLException {
			Connection conn = DBConnection.getConnectionToDatabase();
	    	Statement stmt = conn.createStatement();
	    	System.out.println(stmt.toString());
	    	String query = " Select * from questions where id='"+id+"';"; 
	    	ResultSet set = stmt.executeQuery(query);
	    	
	    	
	    	questions newquestion =null;
	    	while (set.next()) {
				UUID newid = UUID.fromString(set.getString("id"));
				String question= set.getString("question");
				String getoption1 = set.getString("option1");
				String getoption2 = set.getString("option2");
				String getoption3 = set.getString("option3");
				String getoption4 = set.getString("option4");
				String getanswer = set.getString("answer"); 
				String gettopic = set.getString("topic");
				Date getdate = set.getDate("datecreated");
				newquestion = new questions(newid,question,getoption1,getoption2,getoption3,getoption4,getanswer,gettopic,getdate);	
	    	}
			
			set.close();
			stmt.close();
			conn.close();
			
			return newquestion;
			
		}
}