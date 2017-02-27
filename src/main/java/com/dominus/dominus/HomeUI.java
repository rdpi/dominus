package com.dominus.dominus;

import javax.servlet.annotation.WebServlet; 
import java.io.*;
import java.security.NoSuchAlgorithmException;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.TextField;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class HomeUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        final HorizontalLayout searchbar = new HorizontalLayout();
      	final HorizontalLayout topbar = new HorizontalLayout();
        final HorizontalLayout bar2 = new HorizontalLayout();
      	Authorizer authorizer = new Authorizer();
      	
      	final TextField username = new TextField();
      	username.setInputPrompt("Username");
      	final PasswordField password = new PasswordField();
      	//password.setInputPrompt("Password");
      	
      	Button login = new Button("Login", event -> {
			try {
				authorizer.authorize(username.getValue(), password.getValue());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
      
      	//alignment of UI elements at the top of the page
        topbar.addComponents(username,password,login);
      	topbar.setComponentAlignment(login, Alignment.MIDDLE_RIGHT);
      	topbar.setComponentAlignment(password, Alignment.MIDDLE_RIGHT);
        topbar.setComponentAlignment(username, Alignment.MIDDLE_RIGHT);
        
        //search bar design
        final TextField search = new TextField();
        search.setWidth("500");
        search.setInputPrompt("Search Landlords");
        
        //search button
        Button button = new Button("Search");
        
        //add UI elemtns to layout objects
        searchbar.addComponents(search, button);
        layout.addComponents(topbar, searchbar);
      	layout.setComponentAlignment(topbar, Alignment.TOP_RIGHT);
        layout.setComponentAlignment(searchbar, Alignment.TOP_CENTER);        

        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setSizeFull();
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "HomeServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = HomeUI.class, productionMode = false)
    public static class HomeServlet extends VaadinServlet {
    }
}