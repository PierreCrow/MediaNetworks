package com.futuremobile.wox.data.datasource.cloud.model.asset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WsAsset {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("id_categoria")
    @Expose
    private int id_categoria;
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("codigo_barra")
    @Expose
    private String codigo_barra;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("uni_medida")
    @Expose
    private String uni_medida;
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
    @SerializedName("categoria")
    @Expose
    private WsAssetCategory wsAssetCategory;
    @SerializedName("inventariado")
    @Expose
    private int inventariado;
    @SerializedName("codigo_unico")
    @Expose
    private int codigo_unico;

    @SerializedName("tipo")
    @Expose
    private String tipo;

    @SerializedName("desc_corta")
    @Expose
    private String desc_corta;

    @SerializedName("tipo_afec_igv")
    @Expose
    private String tipo_afec_igv;


    public WsAsset() {
    }

    /**
     * @param id
     * @param id_categoria
     * @param codigo
     * @param codigo_barra
     * @param descripcion
     * @param uni_medida
     * @param cod_prod_sunat
     * @param valor_unitario
     * @param precio_unitario
     * @param estado
     * @param created_at
     * @param wsAssetCategory
     * @param inventariado
     * @param codigo_unico
     * @param tipo
     * @param desc_corta
     * @param tipo_afec_igv
     */
    public WsAsset(int id, int id_categoria, String codigo, String codigo_barra, String descripcion,
                   String uni_medida, String cod_prod_sunat, String valor_unitario, String precio_unitario,
                   int estado, String created_at, WsAssetCategory wsAssetCategory,
                   int inventariado, int codigo_unico,String tipo,String desc_corta,String tipo_afec_igv) {
        // super();
        this.id = id;
        this.id_categoria = id_categoria;
        this.codigo = codigo;
        this.codigo_barra = codigo_barra;
        this.descripcion = descripcion;
        this.uni_medida = uni_medida;
        this.cod_prod_sunat = cod_prod_sunat;
        this.valor_unitario = valor_unitario;
        this.precio_unitario = precio_unitario;
        this.estado = estado;
        this.created_at = created_at;
        this.wsAssetCategory = wsAssetCategory;
        this.inventariado = inventariado;
        this.codigo_unico = codigo_unico;
        this.tipo = tipo;
        this.desc_corta = desc_corta;
        this.tipo_afec_igv = tipo_afec_igv;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
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

    public WsAssetCategory getWsAssetCategory() {
        return wsAssetCategory;
    }

    public void setWsAssetCategory(WsAssetCategory wsAssetCategory) {
        this.wsAssetCategory = wsAssetCategory;
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

    public String getTipo_afec_igv() {
        return tipo_afec_igv;
    }

    public void setTipo_afec_igv(String tipo_afec_igv) {
        this.tipo_afec_igv = tipo_afec_igv;
    }
}
