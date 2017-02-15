package com.dominus.dominus;

import javax.servlet.annotation.WebServlet;
import java.io.*; 
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
import com.vaadin.ui.TextField;
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
        final HorizontalLayout layout = new HorizontalLayout();
        final HorizontalLayout searchbar = new HorizontalLayout();
        
        final TextField search = new TextField();
        search.setWidth("500");
        search.setInputPrompt("Seach Landlords");
        
        Button button = new Button("Search");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks " + search.getValue() 
                    + ", it works!"));
        });
        
        ThemeResource doormatresource = new ThemeResource("img/doormat.png");
        Image doormat = new Image("doormat", doormatresource);
       
        
        searchbar.addComponents(search, button, doormat);
        layout.addComponent(searchbar);
        layout.setComponentAlignment(searchbar, Alignment.MIDDLE_CENTER);        

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
