package com.ubicacion.sistema.model;


public class Cliente extends Persona{

    private String razonSocial;
    private String ruc;

    public Cliente(String razonSocial, String ruc, Long id, String nombres, String apellidos, String dni, String telefono, String estado) {
        super(id, nombres, apellidos, dni, telefono, estado);
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
