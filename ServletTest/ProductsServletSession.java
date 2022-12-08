package com.business.testjavaee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductsServlet", urlPatterns = "/products")
public class ProductsServletSession extends HttpServlet {

	
	ServletTestSession servletTestSession;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        // Using session
    	HttpSession session = req.getSession(); 
    	  
    	if(servletTestSession.LogOn()==true)
    	{
    		session.setAttribute("username","Utente Loggato");
			resp.sendRedirect("/products");
    	}
    	else {
    		resp.sendRedirect("login.html");
    		session.invalidate();
		}
      
    	
    }
}
