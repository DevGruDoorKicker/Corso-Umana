package com.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;




/*12. Implementare la funzionalità di login nell'applicazione di e-commerce costruita attraverso Servlets, permettendo l'accesso
 *  solo ad utenti autorizzati presenti nella tabella ECommerceUsers.

TABLE ECommerceUsers
	id (pk)
	username
	password (tipicamente hashed - lasciare in chiaro per ora)

A credenziali corrette, stampare sulla console il messaggio di "User enabled!" e redirigere il controllo verso
 una nuova servlet mappata sull'url "products". In caso contrario stampare il messaggio di "User not enabled!" e redirigere
  il controllo alla view login.html.

Implementare il model (M dell'MVC) attraverso la dichiarazione e la valorizzazione della classe Login.

Login
	username
	password */



@WebServlet(name = "ProductsServlet", urlPatterns="/products")
public class Products extends HttpServlet {
	

	private static final long serialVersionUID = 1L;    //roba in più
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("In DoGet");

}
}

