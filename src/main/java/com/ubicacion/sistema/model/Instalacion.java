package com.ubicacion.sistema.model;


public class Instalacion {

    private Long id;
    private String cliente;
    private String copiadora;
    private String condicion;
    private boolean usa220V;
    private boolean tieneEstabilizador;
    private String direccion;
    private String coordenadas;
    private String estado;

    public Instalacion(Long id, String cliente, String copiadora, String condicion, boolean usa220V, boolean tieneEstabilizador, String direccion, String coordenadas, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.copiadora = copiadora;
        this.condicion = condicion;
        this.usa220V = usa220V;
        this.tieneEstabilizador = tieneEstabilizador;
        this.direccion = direccion;
        this.coordenadas = coordenadas;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCopiadora() {
        return copiadora;
    }

    public void setCopiadora(String copiadora) {
        this.copiadora = copiadora;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public boolean isUsa220V() {
        return usa220V;
    }

    public void setUsa220V(boolean usa220V) {
        this.usa220V = usa220V;
    }

    public boolean isTieneEstabilizador() {
        return tieneEstabilizador;
    }

    public void setTieneEstabilizador(boolean tieneEstabilizador) {
        this.tieneEstabilizador = tieneEstabilizador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
