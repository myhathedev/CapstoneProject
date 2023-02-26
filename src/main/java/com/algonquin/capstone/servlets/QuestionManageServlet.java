package com.algonquin.capstone.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.capstone.beans.questions;
import com.algonquin.capstone.dao.AdminDao;


public class QuestionManageServlet extends HttpServlet {
	ArrayList<questions> list = new ArrayList<>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public QuestionManageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
	    writer.write("<html><head><title>Example</title></head><body> <h1>List of Questions</h1>");
	    writer.write("<a href=\"/Capstone/JSP/Admin.jsp\"><button>Back to home page</button></a>");
    	AdminDao dao = new AdminDao();
    	if (list !=null) {
    		list.clear();
    	}
    	list = dao.getQuestionList();
    	for (int i=0;i<list.size();i++) {
    		writer.write("<p>Question: "+list.get(i).getQuestion()+"</p>");
    		writer.write("<p>1. "+list.get(i).getOption1()+"</p>");
    		writer.write("<p>2. "+list.get(i).getOption2()+"</p>");
    		writer.write("<p>3. "+list.get(i).getOption3()+"</p>");
    		writer.write("<p>4. "+list.get(i).getOption4()+"</p>");
    		writer.write("<p>Answer: "+list.get(i).getAnswer()+"</p>");
    		writer.write("<p>Topic: "+list.get(i).getTopic()+"</p>");
    		writer.write("<p>Date: "+list.get(i).getDate()+"</p> <br/>");
    		//Delete
    		writer.write("<form action=\"DeleteQuestionServlet\" method=\"post\">");       		
    		writer.write("<input type=\"hidden\" name=\"id\" value="+list.get(i).getId().toString()+"></input>");
        	writer.write("<input type=\"submit\" value=\"Delete\"></input></form>");
        	//Update
        	writer.write("<form action=\"UpdateQuestionServlet\" method=\"get\">");   
    		writer.write("<input type=\"hidden\" name=\"id\" value="+list.get(i).getId().toString()+"></input>");
        	writer.write("<input type=\"submit\" value=\"Update\"></input></form>");  		
    	}
    	
    	writer.write("</body></html>");
    }
	
	
	
	
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	
	    	String question = request.getParameter("question");
	    	String option1 = request.getParameter("option1");
	    	String option2 = request.getParameter("option2");
	    	String option3 = request.getParameter("option3");
	    	String option4 = request.getParameter("option4");	
	    	String answer =request.getParameter("answer") ;
	    	String topic = request.getParameter("topic");
	    	questions newquestion = new questions(question, option1, option2,option3,option4, answer,topic);
	    	AdminDao dao = new AdminDao();
	    	int rows = dao.createQuestion(newquestion);   		
	    	if (rows==0) {
	    		System.out.println("Create error");
	    	} else {
	    		System.out.println("New question created!");
	    	}
	    }
}
