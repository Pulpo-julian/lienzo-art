package com.grupotres.app.modelos;

public class Usuario {

    private String docid;
    private String nombres;
    private String apellidos;
    private String correo;
    private String password;
    private String telefono;
    private String ciudad;
    private String codigoPostal;
    private String direccion;

    public Usuario() {



    }






    public Usuario(String docid, String nombres, String apellidos, String correo) {
        super();
        this.docid = docid;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
    }






    public Usuario(String docid, String nombres, String apellidos, String correo, String password, String telefono,
                   String ciudad, String codigoPostal, String direccion) {
        super();
        this.docid = docid;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.direccion = direccion;
    }



    //GET SET
    public String getDocid() {
        return docid;
    }

    public void setDocid(String cedula) {
        this.docid = cedula;
    }

    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public String getTelefono() {
        return telefono;
    }



    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    public String getCiudad() {
        return ciudad;
    }



    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }



    public String getCodigoPostal() {
        return codigoPostal;
    }



    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }



    public String getDireccion() {
        return direccion;
    }



    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }



    @Override
    public String toString() {
        return "Usuario [docid=" + docid +
                ", nombres=" + nombres +
                ", apellidos=" + apellidos +
                ", correo=" + correo +
                ", password=" + password +
                ", telefono=" + telefono +
                ", ciudad=" + ciudad +
                ", codigoPostal=" + codigoPostal +
                ", direccion=" + direccion + "]";
    }







}
