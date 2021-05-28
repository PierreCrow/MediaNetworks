package com.futuremobile.wox.data.datasource.cloud.model.asset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WsAssetByUniqueCode {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("id_empresa")
    @Expose
    private int id_empresa;
    @SerializedName("id_categoria")
    @Expose
    private int id_categoria;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("inventariado")
    @Expose
    private int inventariado;
    @SerializedName("cod_interno")
    @Expose
    private int cod_interno;
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("codigo_barra")
    @Expose
    private String codigo_barra;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("desc_corta")
    @Expose
    private String desc_corta;
    @SerializedName("uni_medida")
    @Expose
    private String uni_medida;
    @SerializedName("tipo_afec_igv")
    @Expose
    private String tipo_afec_igv;
    @SerializedName("cod_prod_sunat")
    @Expose
    private String cod_prod_sunat;
    @SerializedName("valor_unitario")
    @Expose
    private String valor_unitario;
    @SerializedName("precio_unitario")
    @Expose
    private String precio_unitario;
    @SerializedName("estado")
    @Expose
    private int estado;
    @SerializedName("created_at")
    @Expose
    private String created_at;
    @SerializedName("id_producto_unico")
    @Expose
    private int id_producto_unico;
    @SerializedName("id_almacen_producto")
    @Expose
    private int id_almacen_producto;


    public WsAssetByUniqueCode() {
    }

    /**
     *  @param id
     *  @param id_empresa
     * @param id_categoria
     * @param tipo
     * @param inventariado
     * @param cod_interno
     * @param codigo
     * @param codigo_barra
     * @param descripcion
     * @param desc_corta
     * @param uni_medida
     * @param tipo_afec_igv
     * @param cod_prod_sunat
     * @param valor_unitario
     * @param precio_unitario
     * @param estado
     * @param created_at
     * @param id_producto_unico
     * @param id_almacen_producto
     */
    public WsAssetByUniqueCode(int id,int id_empresa, int id_categoria,String tipo,int inventariado,
                               int cod_interno,String codigo, String codigo_barra, String descripcion,
                               String desc_corta,String uni_medida,String tipo_afec_igv, String cod_prod_sunat,
                               String valor_unitario, String precio_unitario, int estado, String created_at,
                               int id_producto_unico, int id_almacen_producto) {
       // super();
        this.id = id;
        this.id_empresa = id_empresa;
        this.id_categoria = id_categoria;
        this.tipo=tipo;
        this.inventariado=inventariado;
        this.cod_interno=cod_interno;
        this.codigo = codigo;
        this.codigo_barra = codigo_barra;
        this.descripcion = descripcion;
        this.desc_corta = desc_corta;
        this.uni_medida = uni_medida;
        this.tipo_afec_igv = tipo_afec_igv;
        this.cod_prod_sunat = cod_prod_sunat;
        this.valor_unitario = valor_unitario;
        this.precio_unitario = precio_unitario;
        this.estado = estado;
        this.created_at = created_at;
        this.id_producto_unico = id_producto_unico;
        this.id_almacen_producto = id_almacen_producto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getInventariado() {
        return inventariado;
    }

    public void setInventariado(int inventariado) {
        this.inventariado = inventariado;
    }

    public int getCod_interno() {
        return cod_interno;
    }

    public void setCod_interno(int cod_interno) {
        this.cod_interno = cod_interno;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDesc_corta() {
        return desc_corta;
    }

    public void setDesc_corta(String desc_corta) {
        this.desc_corta = desc_corta;
    }

    public String getUni_medida() {
        return uni_medida;
    }

    public void setUni_medida(String uni_medida) {
        this.uni_medida = uni_medida;
    }

    public String getTipo_afec_igv() {
        return tipo_afec_igv;
    }

    public void setTipo_afec_igv(String tipo_afec_igv) {
        this.tipo_afec_igv = tipo_afec_igv;
    }

    public String getCod_prod_sunat() {
        return cod_prod_sunat;
    }

    public void setCod_prod_sunat(String cod_prod_sunat) {
        this.cod_prod_sunat = cod_prod_sunat;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getId_producto_unico() {
        return id_producto_unico;
    }

    public void setId_producto_unico(int id_producto_unico) {
        this.id_producto_unico = id_producto_unico;
    }

    public int getId_almacen_producto() {
        return id_almacen_producto;
    }

    public void setId_almacen_producto(int id_almacen_producto) {
        this.id_almacen_producto = id_almacen_producto;
    }
}
