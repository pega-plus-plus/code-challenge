package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {

		switch (request.getRequestURI()) {
		
		case "/NewFlashCard/html/FlashCardPage.do":
				return FlashCardController.FlashCard(request);
			
		default:
			return "/html/FlashCardPage.html";
		}
	}

}
