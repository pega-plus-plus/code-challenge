package flashcard.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import flashcard.beans.Category;
import flashcard.dao.CategoryDao;
import flashcard.dao.CategoryDaoImpl;

/**
 * Servlet implementation class AddCategoryServlet
 */
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryDao catDao = new CategoryDaoImpl();
		List<Category> catList = catDao.getAllCategories();
		
		request.getSession().setAttribute("catList", catList);

		request.getRequestDispatcher("addCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName = request.getParameter("categoryName");
		
		Category cat = new Category(-1, categoryName);
		
		CategoryDao catDao = new CategoryDaoImpl();
		
		try {
			catDao.addCategory(cat);
			request.getSession().setAttribute("message", "Category successfully added");
			request.getSession().setAttribute("messageClass", "text-success");
		}catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("message", "There was a error while adding the category");
			request.getSession().setAttribute("messageClass", "text-danger");
		}
		
		List<Category> catList = catDao.getAllCategories();
		
		//Jackson mapper
		/*
		 * We will use this object to convert the java object into a JSON String representation of the
		 * data. This will make for handling any data passed from java to javascript significantly easier 
		 * to work with.
		 */
		ObjectMapper om = new ObjectMapper();
		
		//Tell the client that it will be receiving JSON formatted data.
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		//Convert the collection into a JSON string representation.
		out.print(om.writeValueAsString(catList));
	}

}
