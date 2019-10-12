package com.webonline.core.servlet;

import com.webonline.core.controller.CategoriaController;
import com.webonline.core.model.AccessToken;
import com.webonline.core.model.Categoria;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
public class ServletBuscarCategoria extends HttpServlet {
    public void doGet(HttpServletRequest peticion, 
            HttpServletResponse respuesta) throws IOException, ServletException{
        doPost(peticion,respuesta);        
    }
    public void doPost(HttpServletRequest peticion, 
            HttpServletResponse respuesta) throws IOException, ServletException{
        RequestDispatcher despachador = null;
        String codigoCategoria = peticion.getParameter("codigoCategoria");
        System.out.println(codigoCategoria);
        HttpSession sesion = peticion.getSession();
        AccessToken token = (AccessToken)sesion.getAttribute("token");
        String url = this.getServletContext().getInitParameter("endPoint")
                .concat("/categorias/").concat(codigoCategoria);
        CategoriaController controlador = 
                new CategoriaController(url,token.getAccessToken());
        Categoria categoria = controlador.search(Integer.parseInt(codigoCategoria));
        peticion.setAttribute("categoria",categoria);
        despachador = peticion.getRequestDispatcher("createCategoria.jsp");
        despachador.forward(peticion, respuesta);
        
    }
}
