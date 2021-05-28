package com.futuremobile.wox.data.datasource.cloud.model.asset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WsUpdateAsset {


    @SerializedName("id_categoria")
    @Expose
    private int id_categoria;
    @SerializedName("id_almacen")
    @Expose
    private int id_almacen;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("desc_corta")
    @Expose
    private String desc_corta;
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("codigo_barra")
    @Expose
    private String codigo_barra;
    @SerializedName("uni_medida")
    @Expose
    private String uni_medida;
    @SerializedName("cod_prod_sunat")
    @Expose
    private String cod_prod_sunat;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("valor_unitario")
    @Expose
    private String valor_unitario;
    @SerializedName("precio_unitario")
    @Expose
    private String precio_unitario;
    @SerializedName("inventariado")
    @Expose
    private int inventariado;
    @SerializedName("codigo_unico")
    @Expose
    private int codigo_unico;
    @SerializedName("estado")
    @Expose
    private int estado;


    /**
     * No args constructor for use in serialization
     *
     */
    public WsUpdateAsset() {
    }

    /**
     *
     * @param estado
     * @param descripcion
     * @param id_categoria
     * @param id_almacen
     * @param tipo
     * @param desc_corta
     * @param codigo
     * @param codigo_barra
     * @param uni_medida
     * @param cod_prod_sunat
     * @param stock
     * @param valor_unitario
     * @param precio_unitario
     * @param inventariado
     * @param codigo_unico
     */
    public WsUpdateAsset(int estado, String descripcion,
                         int id_categoria, int id_almacen,
                         String tipo, String desc_corta,
                         String codigo, String codigo_barra, String uni_medida, String cod_prod_sunat,
                         String stock, String valor_unitario, String precio_unitario ,
                         int inventariado, int codigo_unico) {
        //  super();
        this.estado = estado;
        this.descripcion = descripcion;
        this.id_categoria = id_categoria;
        this.id_almacen = id_almacen;
        this.tipo = tipo;
        this.desc_corta = desc_corta;
        this.codigo = codigo;
        this.codigo_barra = codigo_barra;
        this.uni_medida = uni_medida;
        this.cod_prod_sunat = cod_prod_sunat;
        this.stock = stock;
        this.valor_unitario = valor_unitario;
        this.precio_unitario = precio_unitario;
        this.inventariado=inventariado;
        this.codigo_unico=codigo_unico;

    }


    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDesc_corta() {
        return desc_corta;
    }

    public void setDesc_corta(String desc_corta) {
        this.desc_corta = desc_corta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public String getUni_medida() {
        return uni_medida;
    }

    public void setUni_medida(String uni_medida) {
        this.uni_medida = uni_medida;
    }

    public String getCod_prod_sunat() {
        return cod_prod_sunat;
    }

    public void setCod_prod_sunat(String cod_prod_sunat) {
        this.cod_prod_sunat = cod_prod_sunat;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(String valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getInventariado() {
        return inventariado;
    }

    public void setInventariado(int inventariado) {
        this.inventariado = inventariado;
    }

    public int getCodigo_unico() {
        return codigo_unico;
    }

    public void setCodigo_unico(int codigo_unico) {
        this.codigo_unico = codigo_unico;
    }
}
