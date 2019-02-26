package com.revature.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestHelper {


	public static String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {

		case "/TRMSProject/html/Home.do":
			System.out.println("in Home.do case");
			return HomeController.Home(request);
			
		case "/TRMSProject/html/FlashcardJSON.do":
			System.out.println("in flashcardJSON.do");
			return HomeController.FlashcardJSON(request, response);
		
		default:
			return "/html/Home.html"; 
		}
	}
}
