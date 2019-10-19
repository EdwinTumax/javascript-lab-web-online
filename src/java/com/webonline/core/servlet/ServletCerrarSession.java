package com.webonline.core.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletCerrarSession extends HttpServlet {
    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws IOException,ServletException{
        doPost(peticion,respuesta);
    }
    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws IOException,ServletException{
        HttpSession session = peticion.getSession(false);
        if(session != null){
           session.invalidate();            
        }
        respuesta.sendRedirect("login.jsp");
    }
}
