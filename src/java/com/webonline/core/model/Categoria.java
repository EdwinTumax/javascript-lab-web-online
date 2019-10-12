package com.webonline.core.model;
import java.io.Serializable;
public class Categoria implements Serializable {
    private int codigoCategoria;
    private String descripcion;

    public Categoria() {
    }

    public Categoria(int codigoCategoria, String descripcion) {
        this.codigoCategoria = codigoCategoria;
        this.descripcion = descripcion;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
