package com.grupotres.app.modelos;

public class Producto {

    private int codigo;
    private String nombre;
    private String fechaPublicacion;
    private String descripcion;
    private int precio;
    private int existencia;
    private String estado;
    private String categoria;
    private String tienda;
    private String urlImagen;


    //constructors
    public Producto(int codigo, String nombre, String fechaPublicacion, String descripcion, int precio, int existencia,
                    String estado, String categoria, String tienda, String imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
        this.estado = estado;
        this.categoria = categoria;
        this.tienda = tienda;
        this.urlImagen = imagen;
    }



    //get set
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
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getExistencia() {
        return existencia;
    }
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getTienda() {
        return tienda;
    }
    public void setTienda(String tienda) {
        this.tienda = tienda;
    }
    public String getUrlImagen() {
        return urlImagen;
    }
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }



    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", fechaPublicacion=" + fechaPublicacion
                + ", descripcion=" + descripcion + ", precio=" + precio + ", existencia=" + existencia + ", estado="
                + estado + ", categoria=" + categoria + ", tienda=" + tienda + ", urlImagen=" + urlImagen + "]";
    }








}