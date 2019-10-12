package com.webonline.core.servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webonline.core.controller.CategoriaController;
import com.webonline.core.model.AccessToken;
import com.webonline.core.model.Categoria;
import javax.servlet.http.HttpSession;

public class ServletCategorias extends HttpServlet{
    public void doPost(HttpServletRequest peticion, 
            HttpServletResponse respuesta) 
                throws ServletException, IOException{
        RequestDispatcher despachador = null;
        HttpSession session = peticion.getSession();
        AccessToken token = (AccessToken)session.getAttribute("token");
        String url = this.getServletContext().getInitParameter("endPoint").concat("/categorias");
        List<Categoria> lista = new 
            CategoriaController(url,token.getAccessToken()).getCategorias();
        peticion.setAttribute("categorias",lista);
        despachador = peticion.getRequestDispatcher("categorias.jsp");
        despachador.forward(peticion, respuesta);
    }
    public void doGet(HttpServletRequest peticion, 
            HttpServletResponse respuesta) 
                throws ServletException, IOException{
        doPost(peticion,respuesta);
    }
}
