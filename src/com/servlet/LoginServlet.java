package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get user's input
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		// get default id and password in servlet config
		String defaultId = getServletConfig().getInitParameter("userId");
		String defaultPassword = getServletConfig().getInitParameter("password");

		// check if id & password is correct?
		if ((userId != null) && (password != null) // prevent NullPointerException
				&& (userId.equals(defaultId)) && (password.equals(defaultPassword))) { // correct
			request.setAttribute("userId", userId); // add an attribute to request
			request.getRequestDispatcher("index.jsp").forward(request, response); // pass request to "index.jsp"
			return;
		} else { // go to wrong page
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			return;
		}
		
	}

}
