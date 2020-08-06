package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet({ "/RequestServlet", "/RequestServlet.*" })
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.log("執行doGet方法");
		this.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.log("執行doPost方法");
		this.execute(request, response);
	}

	@Override
	public long getLastModified(HttpServletRequest request) {
		this.log("執行getLastModified方法");
		return -1;
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String requestURI = request.getRequestURI();
		String method = request.getMethod();
		String param = request.getParameter("param");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD></HEAD>");
		out.println("<BODY>");

		out.println("以" + method + "方式存取該頁面，取到的參數為 " + param + "<br/>");
		out.println("<form actioin='" + requestURI + "' method='get'>"
				+ "<input type='text' name='param' value='param string'>" 
				+ "<input type='submit value='GET"+ requestURI + "'>" 
				+ "</form>");

		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();

	}
}
