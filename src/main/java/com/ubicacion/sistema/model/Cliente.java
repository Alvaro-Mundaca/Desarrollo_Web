package com.ubicacion.sistema.model;


public class Cliente extends Persona{

    private String razonSocial;
    private String ruc;

    
    public Cliente(Long id, String nombres, String apellidos, String dni, String telefono, String email, String estado,
            String razonSocial, String ruc) {
        super(id, nombres, apellidos, dni, telefono, email, estado);
        this.razonSocial = razonSocial;
        this.ruc = ruc;
    }


    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

}
