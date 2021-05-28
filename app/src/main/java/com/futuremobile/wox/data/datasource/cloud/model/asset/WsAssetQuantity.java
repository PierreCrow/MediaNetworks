package com.futuremobile.wox.data.datasource.cloud.model.asset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WsAssetQuantity {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("id_producto")
    @Expose
    private int id_producto;
    @SerializedName("id_almacen")
    @Expose
    private int id_almacen;
    @SerializedName("cantidad")
    @Expose
    private String cantidad;
    @SerializedName("minimo")
    @Expose
    private String minimo;


    public WsAssetQuantity() {
    }

    /**
     *  @param id
     * @param id_producto
     * @param id_almacen
     * @param cantidad
     * @param minimo
     */
    public WsAssetQuantity(int id, int id_producto, int id_almacen, String cantidad, String minimo) {
       // super();
        this.id = id;
        this.id_producto = id_producto;
        this.id_almacen = id_almacen;
        this.cantidad = cantidad;
        this.minimo = minimo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getMinimo() {
        return minimo;
    }

    public void setMinimo(String minimo) {
        this.minimo = minimo;
    }
}
