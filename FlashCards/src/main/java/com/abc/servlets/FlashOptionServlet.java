package com.abc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FlashOptionServlet
 */
public class FlashOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flashoption = request.getParameter("flashcard_option");
		if (flashoption.equals("flashcard")) {
			request.getRequestDispatcher("./html/flashcards.html").forward(request, response);
			;
		} else if (flashoption.equals("flashcard_category")) {
			request.getRequestDispatcher("./html/flashcardcategory.html").forward(request, response);
		} else if (flashoption.equals("create_flashcard")) {
			request.getRequestDispatcher("./html/create.html").forward(request, response);
		} else if (flashoption.equals("update_flashcard")) {
			request.getRequestDispatcher("./html/update.html").forward(request, response);
		} else if (flashoption.equals("delete_flashcard")) {
			request.getRequestDispatcher("./html/delete.html").forward(request, response);
		} else {
			request.getRequestDispatcher("index.html").forward(request, response);
		}
		// doGet(request, response);
	}
}
