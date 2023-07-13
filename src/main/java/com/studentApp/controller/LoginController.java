package com.studentApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentApp.model.DAOService;
import com.studentApp.model.DAOServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		DAOService service = new DAOServiceImpl();
		service.connectDB();
		boolean login1 = service.verifyCredential(email, password);
		
		if(login1==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newregistration.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("error", "Invalid Username/Password");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

}
