package com.algonquin.loggy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.loggy.beans.Log;
import com.algonquin.loggy.dao.ApplicationDao;

/**
 * Servlet implementation class LogsServlet
 */
@WebServlet("/LogsServlet")
public class LogsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogsServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        String paramName = request.getParameter("name");
        
        ApplicationDao dao = new ApplicationDao();
        List <Log> logs = dao.getAllLogs();
        
        String htmlResponse = String.format("<html><head><title>Example</title></head><body>Hello from a Java Servlet123 <b>%s</b>.</p></body></html>", paramName);        
        PrintWriter writer = response.getWriter();
        writer.write(htmlResponse);
    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
