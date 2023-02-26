package com.algonquin.capstone.servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ielts_db", "username", "password");         
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM exams");
            ResultSet rs = stmt.executeQuery();          
            request.setAttribute("exams", rs);          
            request.getRequestDispatcher("User.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {           
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/IELTS_DB", "username", "password");
            
            int examId = Integer.parseInt(request.getParameter("examId"));
           
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM questions WHERE exam_id = ?");
            stmt.setInt(1, examId);
            ResultSet rs = stmt.executeQuery();
            
            request.setAttribute("questions", rs);
            request.getRequestDispatcher("Exam.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
