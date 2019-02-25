package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Flashcard;
import com.revature.services.FlashcardServices;
import com.revature.util.HtmlTemplate;

/**
 * Servlet implementation class ViewFlashcardsServlet
 */
public class ViewFlashcardsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewFlashcardsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Flashcard> fcs = null;
		fcs = new FlashcardServices().viewAllFlashcards();
		PrintWriter out = response.getWriter();

		out.println("<head>");
		out.println("<link rel='stylesheet' type='text/css' href='./resources/css/main.css' />");
		out.println("</head>");
		out.println("<div class='rsection'");
		out.println("<h1>Viewing All Flashcards!<h1>");
		if (!fcs.isEmpty()) {
			HtmlTemplate.printTableHeaders(out, "Question", "Answer", "Category");
			for (Flashcard fc : fcs) {
				out.println("<tr><td>");
				out.println(fc.getQuestion() + "</td><td>");
				out.println(fc.getAnswer() + "</td><td>");
				out.println(fc.getCate() + "</td>");
			}
			out.println("</tr></table>");
			out.println("</div>");
		}
		else {
			out.println("<h3>No Flashcards Founds!");
		}
		HtmlTemplate.goBack(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
