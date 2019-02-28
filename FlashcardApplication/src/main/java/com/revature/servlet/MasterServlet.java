package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.RequestHelper;


public class MasterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {	
		try {
			String jsonStuff = RequestHelper.process(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		String targetURL = null;
			try {
				targetURL = RequestHelper.process(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		request.getRequestDispatcher(targetURL).forward(request, response);
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("In doDelete");
		String targetURL = null;
		try {
			targetURL = RequestHelper.process(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(request.getParameter("id"));

		request.getRequestDispatcher(targetURL).forward(request,response);
	}
	
	
}

