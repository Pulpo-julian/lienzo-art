package com.grupotres.app.modelos;

public class ItemProducto {
    private int codProducto;
    private int codCarro;
    private int cantProducto;
    private int valorProducto;

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getCodCarro() {
        return codCarro;
    }

    public void setCodCarro(int codCarro) {
        this.codCarro = codCarro;
    }

    public int getCantProducto() {
        return cantProducto;
    }

    public void setCantProducto(int cantProducto) {
        this.cantProducto = cantProducto;
    }

    public int getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
    }

    public ItemProducto() {
    }

    public ItemProducto(int codProducto, int codCarro, int cantProducto, int valorProducto) {
        this.codProducto = codProducto;
        this.codCarro = codCarro;
        this.cantProducto = cantProducto;
        this.valorProducto = valorProducto;
    }
}
