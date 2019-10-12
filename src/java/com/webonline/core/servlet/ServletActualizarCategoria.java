package com.webonline.core.servlet;

import com.webonline.core.controller.CategoriaController;
import com.webonline.core.model.AccessToken;
import com.webonline.core.model.Categoria;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletActualizarCategoria extends HttpServlet {
    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws IOException, ServletException {
        doPost(peticion,respuesta);
    }
    
    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws IOException, ServletException {
        RequestDispatcher despachador = null;
        String codigoCategoria = peticion.getParameter("codigoCategoria");
        String descripcion = peticion.getParameter("descripcion");
        Categoria categoria = new Categoria();
        categoria.setCodigoCategoria(Integer.parseInt(codigoCategoria));
        categoria.setDescripcion(descripcion);
        HttpSession sesion = peticion.getSession();
        AccessToken token = (AccessToken)sesion.getAttribute("token");
        String url = this.getServletContext().getInitParameter("endPoint")
                .concat("/categorias");
        CategoriaController controlador = 
                new CategoriaController(url,token.getAccessToken());
        controlador.put(categoria);
        peticion.setAttribute("categorias",controlador.getCategorias());
        despachador = peticion.getRequestDispatcher("categorias.jsp");
        despachador.forward(peticion, respuesta);        
    }
}
