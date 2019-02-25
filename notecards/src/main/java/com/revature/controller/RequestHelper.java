package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestHelper {

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("In Request Helper");
		// TODO Auto-generated method stub
		switch(request.getRequestURI()){
		case "/notecards/html/CreateFlashcard.do" :
			return NoteCardController.Add(request);
		default:
			return "/notecards/html/home.html";
		}
	}

}
