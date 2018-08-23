package com.epam.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.service.Validation;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Validate() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");
		try {
		int username = Integer.parseInt(request.getParameter("userName"));
		String pwd = request.getParameter("password");
			if(Validation.login(username, pwd).equals("park")) {
				response.sendRedirect("ReloadFile.jsp");
			} else if(Validation.login(username, pwd).equals("unpark")) {
				request.setAttribute("val","unpark");
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			} else if(Validation.login(username, pwd).equals("display")) {
				request.setAttribute("val","display");
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			} else {
				response.sendRedirect("Invalid.html");
			}
		} catch (Exception e) {
			response.sendRedirect("Invalid.html");
		}
	}

}
