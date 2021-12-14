package com.controller;

import javax.servlet.http.HttpSession;

public class LoginValidationController {

	public static boolean isValidUser(HttpSession session) {
		
		if(session.getAttribute("email")==null)
		{
			System.out.println("not valid user.....");
			return false;
		}
		return true;
	}
}
