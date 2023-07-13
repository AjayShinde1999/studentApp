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

@WebServlet("/newreg")
public class NewRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewRegistration() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newregistration.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session.getAttribute("email") != null) {
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");

			DAOService service = new DAOServiceImpl();
			service.connectDB();
			service.newRegistration(name, city, email, mobile);

			request.setAttribute("msg", "Record As Saved");

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newregistration.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

}
