package com.dominus.dominus;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

public class Authorizer 
{
	 public Authorizer()
	 {
	 }
	  
	 
	 public void authorize(String username, String password)
	 {
		 		 
		 //System.out.println("Username: " + username.getValue());
		 //System.out.println("Password: " + password.getValue());
		 
		 //String errorMessage = "";
		 //boolean error = false;
		 
		 //Checks if value is null or empty, returns error notification
		 // "",null and empty are different things apparenly 
		 /*if(username.getValue() == "" || username.getValue()==null || username.isEmpty() || password.getValue() == "" || password.getValue()==null || password.isEmpty())
		 {
			 error = true;
			 errorMessage = "Please make sure to fill out all of the fields";
			 loginError(errorMessage);
		 }*/
		 Pattern pattern = Pattern.compile("\\b[a-zA-Z][a-zA-Z0-9\\-._]{8,}\\b");
		 Matcher unamematcher = pattern.matcher(username);
		 Matcher pwdmatcher = pattern.matcher(password);
		 
		 //Displays success message if there are no errors
		 try
		 {
			 if(!unamematcher.find() || !pwdmatcher.find()){
					throw new InvalidInputException();
		}
		loginSuccess();
			//hash password
			//check username and hashed password against database
			//if they match, login (bool?)
		 }
		 catch(InvalidInputException ex)
		 {
			 loginError("Invalid username or password");
		 }		  
	 }
	 
	 
	 public void loginError(String errorMessage)
	 {
		 Notification notif = new Notification(
				    "Login Error",
				    errorMessage,
				    Notification.Type.ERROR_MESSAGE);
		 notif.setDelayMsec(2000);
		 notif.setPosition(Position.TOP_LEFT);
		 notif.show(Page.getCurrent());
	 }
	 
	 public void loginSuccess()
	 {
		 Notification notif = new Notification(
				    "Login",
				    "Login was Successful",
				    Notification.Type.HUMANIZED_MESSAGE);
		 notif.setDelayMsec(2000);
		 notif.setPosition(Position.TOP_LEFT);
		 notif.show(Page.getCurrent());
	 }
}
