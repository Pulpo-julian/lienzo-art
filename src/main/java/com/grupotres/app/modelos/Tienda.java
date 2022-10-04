package com.grupotres.app.modelos;

public class Tienda {
    private int codigo;
    private String nombre;
    private String direccion;
    private String usuario;
    private String descripcion;

    public Tienda() {
    }

    public Tienda(int codigo, String nombre, String direccion, String usuario, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.usuario = usuario;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
