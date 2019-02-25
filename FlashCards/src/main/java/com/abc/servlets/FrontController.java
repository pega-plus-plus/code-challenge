package com.abc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] tokens = request.getRequestURI().split("/");

		String action = (tokens[tokens.length - 1]);

		action = action.substring(0, action.length() - 3).toLowerCase();

		switch (action) {
		
		case "flashservlet":
			request.getRequestDispatcher("FlashServlet").forward(request, response);
			break;
		case "logoutservlet":
			if (request.getSession(false) != null) {
				request.getRequestDispatcher("LogoutServlet").forward(request, response);
			} else {
				response.sendError(403);
			}
			break;
		case "requestservlet":
			request.getRequestDispatcher("RequestServlet").forward(request, response);
			break;

		default:
			response.sendError(404);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
