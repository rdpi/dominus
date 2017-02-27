package com.dominus.dominus;

import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

public class Authorizer 
{
	 public Authorizer()
	 {
	 }
	  
	 
	 public boolean authorize(String username, String password) throws NoSuchAlgorithmException
	 {
		 Pattern pattern = Pattern.compile("\\b[a-zA-Z][a-zA-Z0-9\\-._]{7,}\\b");
		 Matcher unamematcher = pattern.matcher(username);
		 Matcher pwdmatcher = pattern.matcher(password);
		 
		 
		 //Displays success message if there are no errors
		 try
		 {
			 if(!unamematcher.find() || !pwdmatcher.find()){
					throw new InvalidInputException();
			 }
			//hash password
			//check username and hashed password against database
			//if they match, login (bool?)	
			 String hashedpass;
			 hashedpass = hashIt(password);
			 login(username, hashedpass);
			 //Returns true if login is good
			 return true;
			 
		 }
		 catch(InvalidInputException ex)
		 {
			 loginError("Invalid username or password");
			 //Returns false if there was an error
			 return false;
		 }
		 
		 
		 
	 }
	 
	 //displays error message when invalid input is entered
	 public void loginError(String errorMessage)
	 {
		 Notification notif = new Notification(
				    "Login Error",
				    errorMessage,
				    Notification.Type.ERROR_MESSAGE);
		 notif.setDelayMsec(2000);
		 //position message in the top left corner
		 notif.setPosition(Position.TOP_LEFT);
		 notif.show(Page.getCurrent());
	 }
	 

	 //password hasher method
	 public String hashIt(String b) throws NoSuchAlgorithmException{
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256"); 
			//one-way encryption for database
			messageDigest.update(b.getBytes());
			String encryptedString = new String(messageDigest.digest());
			return encryptedString;
		}
	

	 
	 
	 public void login(String username, String password)
	 {
		 //dummy database
		 try {
			String hashedpass = hashIt("test12345");
			if(username.equals("username123") && password.equals(hashedpass)){
				VaadinSession.getCurrent().setAttribute("user", username);
				Notification notif = new Notification(
					    "Login",
					    "Login was Successful",
					    Notification.Type.HUMANIZED_MESSAGE);
				notif.setDelayMsec(2000);
				notif.setPosition(Position.TOP_LEFT);
				notif.show(Page.getCurrent());
			}
			else
				loginError("Username and Password do not match");
		 }
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	 }
}

