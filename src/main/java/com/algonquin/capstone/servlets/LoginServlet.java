package com.algonquin.capstone.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algonquin.capstone.beans.LoginBean;
import com.algonquin.capstone.dao.LoginDao;
import com.algonquin.capstone.utils.Constant;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDao loginDao = new LoginDao();
		String password = request.getParameter("password");
		String userName = request.getParameter("username");
		LoginBean loginBean = new LoginBean();
		loginBean.setPassword(password);
		loginBean.setUserName(userName);

		try {
			String userValidate = loginDao.authenticateUser(loginBean);
			if (userValidate.equals(Constant.ADMIN_ROLE)) {
				HttpSession session = request.getSession(); // Creating a session
				session.setAttribute("Admin", userName); // setting session attribute
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("/JSP/Admin.jsp").forward(request, response);

			} else if (userValidate.equals(Constant.USER_ROLE)) {

				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(10 * 60);
				session.setAttribute("User", userName);
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("/JSP/User.jsp").forward(request, response);
			} else {
				request.setAttribute("errMessage", userValidate);

				request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	} 
}
