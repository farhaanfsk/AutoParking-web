package com.epam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.autoparking.AutoParking;
import com.epam.exception.InvalidInputException;
import com.epam.service.Task;

/**.
 * Servlet implementation class Menu
 */
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AutoParking autoparking = new AutoParking();
       


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/text");
		String option = request.getParameter("menu");
		String carNo = "";
		String output = "";
		PrintWriter out =response.getWriter();
		
			carNo = request.getParameter("carNo");
			try {
				output = autoparking.menu(option, carNo);
			} catch (InvalidInputException e) {
				output = e + "";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.write(output);
	}

}
