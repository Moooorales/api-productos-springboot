package com.espe.productos_api.exception;

public class ErrorResponse {
    private String mensaje;
    private int codigoEstado;

    public ErrorResponse(String mensaje, int codigoEstado) {
        this.mensaje = mensaje;
        this.codigoEstado = codigoEstado;
    }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public int getCodigoEstado() { return codigoEstado; }
    public void setCodigoEstado(int codigoEstado) { this.codigoEstado = codigoEstado; }
}