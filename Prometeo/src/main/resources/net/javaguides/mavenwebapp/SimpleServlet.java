package net.javaguides.mavenwebapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SimpleServlet", urlPatterns = {"/SimpleServlet"})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SimpleServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
          throws ServletException, IOException {
       resp.setContentType("application/json");
       resp.getWriter().write("{ nombre: 'Diego Paredes', carrera: 'Ingenieria Informatica' }");
    }

}
