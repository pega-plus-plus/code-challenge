package com.revature.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestHelper {


	public static String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println(request.getRequestURI());
//		switch(request.getRequestURI()) {
//		
//		case "/TRMSProject/html/Login.do": 
//			return LoginController.Login(request);
//			
//		case "/TRMSProject/html/Home.do":
//			return HomeController.Home(request);
//			
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
//		default:
			return "/html/home.html"; 
//		}
	}
}
