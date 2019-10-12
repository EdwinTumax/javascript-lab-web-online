package com.webonline.core.model;
import java.io.Serializable;
public class CreatedResponse implements Serializable {
    private Object objeto;
    private String mensaje;

    public CreatedResponse() {
    }

    public CreatedResponse(Object objeto, String mensaje) {
        this.objeto = objeto;
        this.mensaje = mensaje;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
