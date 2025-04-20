package com.ubicacion.sistema.model;


public class Copiadora {

    private Long id;
    private String modelo;
    private String tipo;
    private String estado;

    
    
    public Copiadora() {
    }

    
    
    public Copiadora(Long id, String modelo, String tipo, String estado) {
        this.id = id;
        this.modelo = modelo;
        this.tipo = tipo;
        this.estado = estado;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
