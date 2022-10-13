package com.grupotres.app.modelos;

public class TipoPago {
    private int codTipoPago;
    private String nombre;

    public TipoPago(int codTipoPago, String nombre) {
        this.codTipoPago = codTipoPago;
        this.nombre = nombre;
    }

    public int getCodTipoPago() {
        return codTipoPago;
    }

    public void setCodTipoPago(int codTipoPago) {
        this.codTipoPago = codTipoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
