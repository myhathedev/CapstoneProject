package com.algonquin.capstone.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.algonquin.capstone.beans.questions;
import com.algonquin.capstone.dao.AdminDao;



public class CreateQuestionServlet extends HttpServlet {
	  /**
	 * 
	 */


	public CreateQuestionServlet() {
		super();
	}
	private static final long serialVersionUID = 1L;

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
	    		response.sendRedirect("http://localhost:8080/Capstone/QuestionManageServlet");
	    		
	    	}
	    }

}
