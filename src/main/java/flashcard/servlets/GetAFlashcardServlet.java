package flashcard.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flashcard.beans.Flashcard;
import flashcard.services.FlashcardService;

/**
 * Servlet implementation class GetAFlashcardServlet
 */
public class GetAFlashcardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlashcardService fcServ = new FlashcardService();
		Flashcard fc = fcServ.getRandomFlashcard();
		
		request.getSession().setAttribute("fc", fc);
		
		request.getRequestDispatcher("allCategories.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
