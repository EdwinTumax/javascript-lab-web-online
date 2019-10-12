package com.webonline.core.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webonline.core.model.Categoria;
import com.webonline.core.model.CreatedResponse;
import com.webonline.core.model.DeleteResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CategoriaController {

    private final String CONTENT_TYPE = "application/json";
    private final String AUTHORIZATION = "Bearer ";
    private final String ERROR_EXCEPTION = "Failed: HTTP 1.1 Error code ";
    private String endPoint;
    private String token;

    public CategoriaController(String endPoint, String token) {
        this.endPoint = endPoint;
        this.token = token;
    }

    public List<Categoria> getCategorias() throws MalformedURLException,
            IOException {
        List<Categoria> listaCategoria = null;
        URL url = new URL(this.endPoint);
        HttpURLConnection conexion = this.getConexion(url, "GET");
        if (conexion.getResponseCode() != 200) {
            throw new RuntimeException(this.ERROR_EXCEPTION
                    .concat(String.valueOf(conexion.getResponseCode())));
        } else {
            InputStreamReader in = new InputStreamReader(conexion.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String salida;
            Gson gson = new Gson();
            Type tipoCategorias = new TypeToken<List<Categoria>>() {
            }.getType();
            while ((salida = br.readLine()) != null) {
                listaCategoria = gson.fromJson(salida, tipoCategorias);
            }
            conexion.disconnect();
        }
        return listaCategoria;
    }

    public DeleteResponse delete() throws MalformedURLException,
            IOException {
        DeleteResponse response = null;
        URL url = new URL(this.endPoint);
        HttpURLConnection conexion = this.getConexion(url, "DELETE");
        if (conexion.getResponseCode() != 200) {
            throw new RuntimeException(this.ERROR_EXCEPTION
                    .concat(String.valueOf(conexion.getResponseCode())));
        } else {
            response = (DeleteResponse)this.unmarshalling(conexion,DeleteResponse.class);
            conexion.disconnect();
        }
        return response;
    }

    public CreatedResponse post(Categoria categoria) throws MalformedURLException,
            IOException {
        CreatedResponse response = null;
        URL url = new URL(this.endPoint);
        HttpURLConnection conexion = this.getConexion(url, "POST");
        conexion.setRequestProperty("Content-Type",this.CONTENT_TYPE);
        conexion.setDoOutput(true);
        try(OutputStream os = conexion.getOutputStream()) {
            byte[] input = new Gson().toJson(categoria).getBytes("utf-8");
            os.write(input, 0, input.length);           
        }
        if (conexion.getResponseCode() != 201) {
            System.out.println(conexion.getResponseMessage());
            throw new RuntimeException(this.ERROR_EXCEPTION
                    .concat(String.valueOf(conexion.getResponseCode())));
        } else {
            response = (CreatedResponse)this.unmarshalling(conexion,CreatedResponse.class);
        }
        return response;
    }

    public CreatedResponse put(Categoria categoria) throws MalformedURLException,
            IOException {
        CreatedResponse response = null;
        URL url = new URL(this.endPoint.concat("/")
                .concat(String.valueOf(categoria.getCodigoCategoria())));        
        HttpURLConnection conexion = this.getConexion(url, "PUT");        
        conexion.setRequestProperty("Content-Type",this.CONTENT_TYPE);
        conexion.setDoOutput(true);
        try(OutputStream os = conexion.getOutputStream()){
            byte[] input = new Gson().toJson(categoria).getBytes("utf-8");
            os.write(input,0,input.length);
        }
        if (conexion.getResponseCode() != 201) {
            throw new RuntimeException(this.ERROR_EXCEPTION
                    .concat(String.valueOf(conexion.getResponseCode())));
        } else {
            response = (CreatedResponse)this.unmarshalling(conexion, CreatedResponse.class);
            conexion.disconnect();
        }
        return response;
    }

    public Categoria search(int id) throws MalformedURLException,
            IOException {
        Categoria categoria = null;
        URL url = new URL(this.endPoint);
        HttpURLConnection conexion = this.getConexion(url, "GET");
        if (conexion.getResponseCode() != 200) {
            throw new RuntimeException(this.ERROR_EXCEPTION
                    .concat(String.valueOf(conexion.getResponseCode())));
        } else {
            categoria = (Categoria)this.unmarshalling(conexion,Categoria.class);
            conexion.disconnect();
        }
        return categoria;
    }

    public Object unmarshalling(HttpURLConnection conexion, Class clase) 
            throws MalformedURLException, IOException{        
        String nombreClase = 
                clase.getName().substring(clase.getName().lastIndexOf(".") + 1,
                        clase.getName().length());
        Object respuesta = null;
        String salida = "";
        InputStreamReader in = new InputStreamReader(conexion.getInputStream());
        BufferedReader br = new BufferedReader(in);
        while ((salida = br.readLine()) != null) {
            switch (nombreClase) {
                case "Categoria":
                    respuesta = new Gson().fromJson(salida, Categoria.class);
                    break;
                case "CreatedResponse":
                    respuesta = new Gson().fromJson(salida, CreatedResponse.class);
                    break;
                case "DeleteResponse":
                    respuesta = new Gson().fromJson(salida, DeleteResponse.class);
                    break;
                default:
                    break;
            }
        }
        return respuesta;
    }

    public HttpURLConnection getConexion(URL url, String method) throws MalformedURLException,
            IOException {
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod(method);
        conexion.setRequestProperty("Accept", this.CONTENT_TYPE);
        conexion.setRequestProperty("Authorization", this.AUTHORIZATION.concat(token));
        return conexion;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
