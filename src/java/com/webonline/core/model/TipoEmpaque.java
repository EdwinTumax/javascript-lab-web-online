package com.webonline.core.model;
import java.io.Serializable;

public class TipoEmpaque implements Serializable {
    private int codigoEmpaque;
    private String descripcion;

    public TipoEmpaque() {
    }

    public TipoEmpaque(int codigoEmpaque, String descripcion) {
        this.codigoEmpaque = codigoEmpaque;
        this.descripcion = descripcion;
    }

    public int getCodigoEmpaque() {
        return codigoEmpaque;
    }

    public void setCodigoEmpaque(int codigoEmpaque) {
        this.codigoEmpaque = codigoEmpaque;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
