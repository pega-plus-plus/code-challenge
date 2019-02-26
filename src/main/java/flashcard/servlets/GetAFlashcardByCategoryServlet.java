package flashcard.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flashcard.beans.Category;
import flashcard.dao.CategoryDao;
import flashcard.dao.CategoryDaoImpl;

/**
 * Servlet implementation class GetAFlashcardByCategoryServlet
 */
public class GetAFlashcardByCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao catDao = new CategoryDaoImpl();
		
		List<Category> catList = catDao.getAllCategories();
		
		request.getSession().setAttribute("catList", catList);

		request.getRequestDispatcher("chooseCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
