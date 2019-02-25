package com.abc.servlets;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FlashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static Logger log = Logger.getLogger(FlashServlet.class);

	public FlashServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		RequestDispatcher rd = null;

		boolean isValidEmployee = new UserService().confirmLogin(username, password); //

		// checking if the user is in db
		if (isValidEmployee) {
			log.info("You have successfully logged in!");
			
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			
			 emp = new FlashCarDaoImpl().getEmployeeByUsername(username);
			
			//check the title property and dispatch to accordingly
			String title = emp.getTitle();
			if(emp != null) {
				if (title.equals("employee")) {
					rd = req.getRequestDispatcher("./html/menuemp.html");
				} else {
					rd = req.getRequestDispatcher("./html/menubenco.html");
				}
				rd.forward(req, resp);
			}
		} else {
			resp.getWriter().append("LoginFail ").append(req.getContextPath());
			resp.getWriter().write("loginFail");
			rd = req.getRequestDispatcher("./html/login.html");
			rd.forward(req, resp);
		}
	}
}