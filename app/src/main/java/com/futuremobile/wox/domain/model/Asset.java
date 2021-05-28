package com.futuremobile.wox.domain.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName="Asset")
public class Asset implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("idDb")
    private int idDb;

    @SerializedName("id")
    private int id;
    @SerializedName("id_categoria")
    private int id_categoria;
    @SerializedName("codigo")
    private String codigo;
    @SerializedName("codigo_barra")
    private String codigo_barra;
    @SerializedName("descripcion")
    private String descripcion;
    @SerializedName("uni_medida")
    private String uni_medida;
    @SerializedName("cod_prod_sunat")
    private String cod_prod_sunat;
    @SerializedName("valor_unitario")
    private String valor_unitario;
    @SerializedName("precio_unitario")
    private String precio_unitario;
    @SerializedName("estado")
    private int estado;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("idCategory")
    private int Category;
    @SerializedName("nameCategory")
    private String nameCategory;
    @SerializedName("tipo")
    private String tipo;
    @SerializedName("descripcion_corta")
    private String descripcion_corta;
    @SerializedName("tipo_afec_igv")
    private String tipo_afec_igv;
    @SerializedName("inventariado")
    private int inventariado;
    @SerializedName("id_almacen")
    private int id_almacen;
    @SerializedName("stock")
    private String stock;
    @SerializedName("codigo_unico")
    private int codigo_unico;


    public Asset() {
    }


    public Asset(int id, int id_categoria, String codigo, String codigo_barra, String descripcion,
                   String uni_medida, String cod_prod_sunat, String valor_unitario, String precio_unitario,
                   int estado, String created_at,int Category,String nameCategory
            ,String tipo,String descripcion_corta,String tipo_afec_igv,
                 int inventariado,int id_almacen,String stock,int codigo_unico) {
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
        this.Category = Category;
        this.nameCategory = nameCategory;
        this.tipo=tipo;
        this.descripcion_corta=descripcion_corta;
        this.tipo_afec_igv=tipo_afec_igv;
        this.inventariado=inventariado;
        this.id_almacen=id_almacen;
        this.stock=stock;
        this.codigo_unico=codigo_unico;
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

    public int getIdDb() {
        return idDb;
    }

    public void setIdDb(int idDb) {
        this.idDb = idDb;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion_corta() {
        return descripcion_corta;
    }

    public void setDescripcion_corta(String descripcion_corta) {
        this.descripcion_corta = descripcion_corta;
    }

    public String getTipo_afec_igv() {
        return tipo_afec_igv;
    }

    public void setTipo_afec_igv(String tipo_afec_igv) {
        this.tipo_afec_igv = tipo_afec_igv;
    }

    public int getInventariado() {
        return inventariado;
    }

    public void setInventariado(int inventariado) {
        this.inventariado = inventariado;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getCodigo_unico() {
        return codigo_unico;
    }

    public void setCodigo_unico(int codigo_unico) {
        this.codigo_unico = codigo_unico;
    }
}
