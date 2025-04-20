package com.ubicacion.sistema.model;


public class Usuario extends Persona{

    private String tipo;
    private String clave;
    private String direccion;


    public Usuario(Long id, String nombres, String apellidos, String dni, String telefono, String email, String estado,
            String tipo, String clave, String direccion) {
        super(id, nombres, apellidos, dni, telefono, email, estado);
        this.tipo = tipo;
        this.clave = clave;
        this.direccion = direccion;
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
