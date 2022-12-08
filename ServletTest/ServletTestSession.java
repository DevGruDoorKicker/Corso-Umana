package com.business.testjavaee;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Controller
@WebServlet(name = "Servlet1", urlPatterns = "/simple")
public class ServletTestSession extends HttpServlet {

	 boolean loggedOn;
	
	
	 public boolean LogOn() {
			return loggedOn;		
    }
	
	
	
    public ServletTestSession() {
        System.out.println("in Servlet1");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("in init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
  	    	
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
        System.out.println("in doPost");


        
        
        // Get database connection
        try { 

            Context ctx = new InitialContext();                                     
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/testjdbc"); 
            Connection c = ds.getConnection();										


            PreparedStatement ps = c.prepareStatement("select * from ECommerceUsers where username=? and password=?");  
            String username = req.getParameter("username"); 
       		String password = req.getParameter("password");
            ps.setString(1, username); 
            ps.setString(2, password);
            
            
            
            
            if (!ps.executeQuery().next()) {                
            	
                System.out.println("User NOT enabled!");	
                resp.sendRedirect("login.html");
                loggedOn=false;
            } else {
            	
                System.out.println("User enabled!");
                resp.sendRedirect("products");
                loggedOn=true;
             
              
                
            }
                
                
                
                
                
                

            c.close();

        } catch (NamingException ne) {                          
            System.out.println(ne.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("in destroy");
    }
}











