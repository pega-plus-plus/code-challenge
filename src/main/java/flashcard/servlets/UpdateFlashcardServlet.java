package flashcard.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flashcard.beans.Category;
import flashcard.beans.Flashcard;
import flashcard.dao.CategoryDao;
import flashcard.dao.CategoryDaoImpl;
import flashcard.dao.FlashcardDao;
import flashcard.dao.FlashcardDaoImpl;

/**
 * Servlet implementation class UpdateFlashcardServlet
 */
public class UpdateFlashcardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fcId = Integer.parseInt(request.getParameter("flashcardId"));
		
		FlashcardDao fcDao = new FlashcardDaoImpl();
		CategoryDao catDao = new CategoryDaoImpl();
		
		Flashcard fc = fcDao.getFlashcard(fcId);
		List<Category> catList = catDao.getAllCategories();
		
		request.getSession().setAttribute("fc", fc);
		request.getSession().setAttribute("catList", catList);

		request.getRequestDispatcher("updateFlashcard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlashcardDao fcDao = new FlashcardDaoImpl();
		CategoryDao catDao = new CategoryDaoImpl();

		int fcId = Integer.parseInt(request.getParameter("flashcardId"));
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = catDao.getCategoryName(categoryId);
		
		Flashcard fc = fcDao.getFlashcard(fcId);

		fc.setQuestion(question);
		fc.setAnswer(answer);
		fc.setCategoryId(categoryId);
		fc.setCategoryName(categoryName);
		
		fcDao.updateFlashcard(fc);
		
		response.sendRedirect(request.getContextPath() + "/AddFlashcardServlet");
	}

}
