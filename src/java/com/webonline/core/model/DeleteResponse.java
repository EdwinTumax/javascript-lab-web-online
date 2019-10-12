package com.webonline.core.model;
public class DeleteResponse {
    private String mensaje;

    public DeleteResponse() {
    }

    public DeleteResponse(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
