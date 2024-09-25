package com.rafalopez.recuperatorio.entity;

import androidx.annotation.Nullable;

public class Inmueble {
    private String codigo;
    private String descripcion;
    private int cantidadAmbientes;
    private String direccion;
    private double precio;


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
}