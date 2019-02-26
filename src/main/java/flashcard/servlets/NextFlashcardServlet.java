package flashcard.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import flashcard.beans.Flashcard;
import flashcard.services.FlashcardService;

/**
 * Servlet implementation class NextFlashcardServlet
 */
public class NextFlashcardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlashcardService fcServ = new FlashcardService();
		Flashcard fc = fcServ.getRandomFlashcard();
		
		request.getSession().setAttribute("fc", fc);
		
		ObjectMapper om = new ObjectMapper();
		
		//Tell the client that it will be receiving JSON formatted data.
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		//Convert the collection into a JSON string representation.
		out.print(om.writeValueAsString(fc));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
