package com.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


//strumenti sviluppatore negli strumenti di chrome
		//network aggiornando la pagina ho altre info

//tecnologia JNDI

@WebServlet(name = "Servlet1", urlPatterns="/simple")			//le annotazioni hanno la @. urlPatterns mappa la resourcename
public class Servlet1 extends HttpServlet {		
	
	
	public Servlet1(){		                                    //messo per vedere che tomcat istanzia la classe
		System.out.println("In Servlet1");
	}
	
	
	Connection connection=null;
	@Override
	public void init(ServletConfig config) throws ServletException {                //per parametrizzare il server
		super.init(config);
		System.out.println("In Init");
		
		Context context;
		try {
			context = new InitialContext();
			DataSource dataSource=(DataSource) context.lookup("java:comp/env/jdbc/testjdbc");    //controllo che sia un valore valido
			connection=dataSource.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}									//faccio una richiesta a tomcat per avere il nome di qualcosa che cerco						
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private static final long serialVersionUID = 1L;    //roba in più
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("In DoGet");
			
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		//get db connection
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {	
			Context context = new InitialContext();									//faccio una richiesta a tomcat per avere il nome di qualcosa che cerco						
			DataSource dataSource=(DataSource) context.lookup("java:comp/env/jdbc/testjdbc");    //controllo che sia un valore valido
			Connection connection=dataSource.getConnection();	
			
			
			PreparedStatement ps = connection.prepareStatement("select username,password from Customer where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();					
			
			if (!rs.next()) {
	                System.out.println("User not enabled!");
	                response.sendRedirect("logInHtml.html");
	            }

			else {
					response.sendRedirect("products"); 				
			}
			
			//chiudo la connessione
			System.out.println(connection);
			
			
		} catch (NamingException e) {			
			System.out.println(e.getMessage());
			
		} catch (SQLException e) {			
			System.out.println(e.getMessage());
		}     
		
		
		
		
		
		//if ("bad".equals(username))
		//	response.sendRedirect("logInHtml.html");           //redirezione
		
		//else {
		
		System.out.println("In DoPost");
		PrintWriter out = response.getWriter();    							
		out.println("Welcome" + request.getParameter("username"));	
		out.close();
		//}
		
	}

	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("In Destroy");
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
