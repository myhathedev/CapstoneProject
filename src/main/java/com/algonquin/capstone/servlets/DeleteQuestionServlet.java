package com.algonquin.capstone.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.capstone.dao.AdminDao;

public class DeleteQuestionServlet extends HttpServlet {
	public DeleteQuestionServlet() {
	}

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao dao = new AdminDao();
		String id = request.getParameter("id"); 
		int rows = dao.deleteQuestion(id);
		if (rows == 0) {
			System.out.println("Delete Successful");
    	} else {
    		System.out.println("Delete Failed");
	}
		response.sendRedirect("http://localhost:8080/Capstone/QuestionManageServlet");
	}
}
