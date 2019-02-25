package com.revature.flashcards.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.flashcards.controller.RequestHelper;


/**
 * Main entry servlet to the application. Routes incoming GET and POST HTTP requests to the request helper. Following the Front Controller Design Pattern 
 * @author karan
 *
 */
@MultipartConfig
public class MasterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String targetUrl = RequestHelper.process(req, resp);
		if(targetUrl!= null) {
			req.getRequestDispatcher(targetUrl).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String targetUrl = RequestHelper.process(req, resp);
		if(targetUrl!=null) {
			req.getRequestDispatcher(targetUrl).forward(req, resp);
		}
	}
	
	
}