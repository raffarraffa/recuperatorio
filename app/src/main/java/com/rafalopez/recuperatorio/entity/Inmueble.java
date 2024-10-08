package com.rafalopez.recuperatorio.entity;

import androidx.annotation.Nullable;

public class Inmueble {
    private String codigo;
    private String descripcion;
    private int cantidadAmbientes;
    private String direccion;
    private double precio;


    public Inmueble(){}
    public Inmueble(String codigo, String descripcion, int cantidadAmbientes, String direccion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidadAmbientes = cantidadAmbientes;
        this.direccion = direccion;
        this.precio = precio;
    }


    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getCantidadAmbientes() { return cantidadAmbientes; }
    public void setCantidadAmbientes(int cantidadAmbientes) { this.cantidadAmbientes = cantidadAmbientes; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Inmueble\n" +
                "___________________________\n"+
                " Codigo " + codigo +
                "\n Descripcion " + descripcion  +
                "\n Cantidad Ambientes " + cantidadAmbientes +
                "\n Direccion " + direccion +
                "\n Precio " + precio ;

    }

    /**
     * Verifica igualdad de entidad
     * @param obj
     * @return
     */
    @Override
    public boolean equals(@Nullable Object obj  ) {
        Inmueble inmueble = (Inmueble) obj;
        return codigo.equalsIgnoreCase(inmueble.codigo);
    }
    public int isValid(){
        if(this.codigo == null) return 1;
        if(this.descripcion == null) return 2;
        if(this.cantidadAmbientes == 0) return 3;
        if(this.direccion == null) return 4;
        if(this.precio==0) return 5;
        return 0;
    }
}