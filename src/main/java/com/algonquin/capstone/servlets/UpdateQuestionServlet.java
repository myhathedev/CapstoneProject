package com.algonquin.capstone.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.algonquin.capstone.beans.questions;
import com.algonquin.capstone.dao.AdminDao;

public class UpdateQuestionServlet extends HttpServlet {

	/**
	 * 
	 */
	public UpdateQuestionServlet() {
	}
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		AdminDao dao = new AdminDao();
		try {
			questions thequestion = dao.getRow(id);
			request.setAttribute("id",thequestion.getId());
			request.setAttribute("question",thequestion.getQuestion());
			request.setAttribute("option1",thequestion.getOption1());
			request.setAttribute("option2",thequestion.getOption2());
			request.setAttribute("option3",thequestion.getOption3());
			request.setAttribute("option4",thequestion.getOption4());
			request.setAttribute("answer",thequestion.getAnswer());
			request.setAttribute("topic",thequestion.getTopic());
			request.getRequestDispatcher("/JSP/UpdateQuestion.jsp").forward(request, response);
			System.out.println("updated");
			}
		catch (SQLException  e) {
			System.out.println(e.toString());			
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao dao = new AdminDao();
		String id = request.getParameter("id"); 
		String question = request.getParameter("question");
    	String option1 = request.getParameter("option1");
    	String option2 = request.getParameter("option2");
    	String option3 = request.getParameter("option3");
    	String option4 = request.getParameter("option4");	
    	String answer =request.getParameter("answer") ;
		int rows = dao.updateQuestion(id,question,option1,option2,option3,option4,answer);
		if (rows == 0) {
			System.out.println("Update Failed");
    	} else {
    		System.out.println("Update Successful");
    	}
		response.sendRedirect("http://localhost:8080/Capstone/QuestionManageServlet");
	}
}

