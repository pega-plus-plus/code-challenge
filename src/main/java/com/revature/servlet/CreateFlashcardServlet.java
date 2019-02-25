package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Flashcard;
import com.revature.services.FlashcardServices;
import com.revature.util.HtmlTemplate;

/**
 * Servlet implementation class CreateFlashcardServlet
 */
public class CreateFlashcardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFlashcardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Flashcard fc = new Flashcard();
		fc.setQuestion(request.getParameter("question"));
		fc.setAnswer(request.getParameter("answer"));
		fc.setCate(Integer.parseInt(request.getParameter("category")));
		PrintWriter out = response.getWriter();
		
		out.println("<head>");
		out.println("<link rel='stylesheet' type='text/css' href='./resources/css/main.css' />");
		out.println("</head>");
		out.println("<div class='rsection'");
		if (new FlashcardServices().insertFlashcard(fc)) {
			response.sendRedirect("http://localhost:8085/code-challenge/createflashcard.html");
		}
		else {
			out.println("<h1>Flashcard was not Inserted!<h1>");
			out.print("</div>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
