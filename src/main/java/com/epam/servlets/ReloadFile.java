package com.epam.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.autoparking.AutoParking;

/**
 * Servlet implementation class ReloadFile
 */
public class ReloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReloadFile() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String value = request.getParameter("option");
		AutoParking park = new AutoParking();
		if(value.equals("1")) {
			try {
				park.fileInit(value, 0);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if(value.equals("2")){
			int slotSize = Integer.parseInt(request.getParameter("size"));
			try {
				park.fileInit(value, slotSize);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("val","park");
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
