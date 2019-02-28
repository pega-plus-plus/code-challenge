package com.revature.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestHelper {


	public static String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
		
		case "/FlashcardApplication/html/SubmitCard.do":
			return CardController.SubmitCard(request,response);
			
		case "/FlashcardApplication/html/CardTable.do":
			return CardController.CardTableJSON(request, response);
//		case "/TRMSProject/html/Home.do":
//			return HomeController.Home(request);

		case "/FlashcardApplication/html/DeleteCard.do":
			System.out.println("Request Helper delete card path");
			return CardController.DeleteCard(request,response);
//		case "/TRMSProject/html/Register.do":
//			return RegisterController.Register(request);
//			
//		case "/TRMSProject/html/FormTableJSON.do":
//			return FormController.FormTableJSON(request,response);
//		
//		case "/TRMSProject/html/EmployeeJSON.do":
//			return HomeController.EmployeeJSON(request, response);
//		
//		case "/TRMSProject/html/FormJSON.do":
//			return FormController.FormJSON(request, response);
//			
//		case "/TRMSProject/html/SubmitForm.do":
//			return FormController.SubmitForm(request,response);
//		
//		case "/TRMSProject/html/ApproveTableJSON.do":
//			return FormController.ApproveForms(request,response);
//			
		default:
			return "/html/home.html"; 
		}
	}
}
