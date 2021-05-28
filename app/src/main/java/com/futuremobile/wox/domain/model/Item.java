package com.futuremobile.wox.domain.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@Entity(tableName="Item")
public class Item implements Parcelable { //extends Warehouse

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private int id;
    @SerializedName("id_bbdd")
    private int id_bbdd;
    @SerializedName("id_empresa")
    private int id_empresa;
    @SerializedName("id_almacen")
    private int id_almacen;
    @SerializedName("id_categoria")
    private Integer id_categoria;
    @SerializedName("Codigo")
    private String Codigo;
    @SerializedName("Codigo_Barra")
    private String Codigo_Barra;
    @SerializedName("Tipo_Item")
    private String Tipo_Item;
    @SerializedName("Descripcion")
    private String Descripcion;
    @SerializedName("Descripcion_Corta")
    private String Descripcion_Corta;
    @SerializedName("Stock")
    private String Stock;
    @SerializedName("Unidad_Medida")
    private String Unidad_Medida;
    @SerializedName("Tipo_Afectacion_IGV")
    private String Tipo_Afectacion_IGV;
    @SerializedName("Cod_Prod_Sunat")
    private String Cod_Prod_Sunat;
    @SerializedName("Codigo_Tributo")
    private String Codigo_Tributo;
    @SerializedName("Valor_Unitario")
    private String Valor_Unitario;
    @SerializedName("Precio_Unitario")
    private String Precio_Unitario;
    @SerializedName("Estado")
    private int Estado;
    @SerializedName("Created_at")
    private String Created_at;
    @SerializedName("Updated_at")
    private String Updated_at;
    @SerializedName("Deleted_at")
    private String Deleted_at;
    @SerializedName("Created_by")
    private String Created_by;
    @SerializedName("Updated_by")
    private String Updated_by;
    @SerializedName("Deleted_by")
    private String Deleted_by;
    @SerializedName("Enviado_A_Servidor")
    private Boolean Enviado_A_Servidor;



    public Item(int id_bbdd,int id_empresa,int id_almacen, int id_categoria, String Codigo,String Codigo_Barra,
                String Tipo_Item, String Descripcion,String Descripcion_Corta,String Stock, String Unidad_Medida,
                 String Tipo_Afectacion_IGV, String Cod_Prod_Sunat, String Codigo_Tributo, String Valor_Unitario
            , String Precio_Unitario, int Estado, String Created_at,
                String Updated_at, String Deleted_at, String Created_by, String Updated_by,
                String Deleted_by, Boolean Enviado_A_Servidor)
    {
        this.id_bbdd=id_bbdd;
        this.id_empresa=id_empresa;
        this.id_almacen=id_almacen;
        this.id_categoria=id_categoria;
        this.Tipo_Item=Tipo_Item;
        this.Descripcion=Descripcion;
        this.Unidad_Medida=Unidad_Medida;
        this.Tipo_Afectacion_IGV = Tipo_Afectacion_IGV;
        this.Codigo_Tributo=Codigo_Tributo;
        this.Valor_Unitario=Valor_Unitario;
        this.Precio_Unitario=Precio_Unitario;
        this.Codigo_Barra=Codigo_Barra;
        this.Descripcion_Corta=Descripcion_Corta;
        this.Stock=Stock;
        this.Cod_Prod_Sunat=Cod_Prod_Sunat;
        this.Codigo=Codigo;
        this.Estado=Estado;
        this.Created_at=Created_at;
        this.Updated_at=Updated_at;
        this.Deleted_at=Deleted_at;
        this.Created_by=Created_by;
        this.Updated_by=Updated_by;
        this.Deleted_by=Deleted_by;
        this.Enviado_A_Servidor = Enviado_A_Servidor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(this.id_bbdd);
        dest.writeInt(this.id_empresa);
        dest.writeInt(this.id_almacen);
        dest.writeInt(this.id_categoria);
        dest.writeString(this.Tipo_Item);
        dest.writeString(this.Descripcion);
        dest.writeString(this.Unidad_Medida);
        dest.writeString(this.Tipo_Afectacion_IGV);
        dest.writeString(this.Codigo_Tributo);
        dest.writeString(this.Valor_Unitario);
        dest.writeString(this.Precio_Unitario);
        dest.writeString(this.Codigo_Barra);
        dest.writeString(this.Descripcion_Corta);
        dest.writeString(this.Stock);
        dest.writeString(this.Cod_Prod_Sunat);
        dest.writeString(this.Codigo);
        dest.writeInt(this.Estado);
        dest.writeString(this.Created_at);
        dest.writeString(this.Updated_at);
        dest.writeString(this.Deleted_at);
        dest.writeString(this.Created_by);
        dest.writeString(this.Updated_by);
        dest.writeString(this.Deleted_by);
        dest.writeByte((byte) (Enviado_A_Servidor ? 1 : 0));


    }


    public Item(Parcel in) {
        id_bbdd = in.readInt();
        id_empresa = in.readInt();
        id_almacen = in.readInt();
        id_categoria = in.readInt();
        Tipo_Item = in.readString();
        Descripcion = in.readString();
        Unidad_Medida = in.readString();
        Tipo_Afectacion_IGV = in.readString();
        Codigo_Tributo = in.readString();
        Valor_Unitario = in.readString();
        Precio_Unitario = in.readString();
        Codigo_Barra = in.readString();
        Descripcion_Corta = in.readString();
        Stock = in.readString();
        Cod_Prod_Sunat = in.readString();
        Codigo = in.readString();
        Estado = in.readInt();
        Created_at = in.readString();
        Updated_at = in.readString();
        Deleted_at = in.readString();
        Created_by = in.readString();
        Updated_by = in.readString();
        Deleted_by = in.readString();
        Enviado_A_Servidor=in.readByte() != 0;

    }


    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_bbdd() {
        return id_bbdd;
    }

    public void setId_bbdd(int id_bbdd) {
        this.id_bbdd = id_bbdd;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getCodigo_Barra() {
        return Codigo_Barra;
    }

    public void setCodigo_Barra(String codigo_Barra) {
        Codigo_Barra = codigo_Barra;
    }

    public String getTipo_Item() {
        return Tipo_Item;
    }

    public void setTipo_Item(String tipo_Item) {
        Tipo_Item = tipo_Item;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getDescripcion_Corta() {
        return Descripcion_Corta;
    }

    public void setDescripcion_Corta(String descripcion_Corta) {
        Descripcion_Corta = descripcion_Corta;
    }

    public String getUnidad_Medida() {
        return Unidad_Medida;
    }

    public void setUnidad_Medida(String unidad_Medida) {
        Unidad_Medida = unidad_Medida;
    }

    public String getTipo_Afectacion_IGV() {
        return Tipo_Afectacion_IGV;
    }

    public void setTipo_Afectacion_IGV(String tipo_Afectacion_IGV) {
        Tipo_Afectacion_IGV = tipo_Afectacion_IGV;
    }

    public String getCod_Prod_Sunat() {
        return Cod_Prod_Sunat;
    }

    public void setCod_Prod_Sunat(String cod_Prod_Sunat) {
        Cod_Prod_Sunat = cod_Prod_Sunat;
    }

    public String getCodigo_Tributo() {
        return Codigo_Tributo;
    }

    public void setCodigo_Tributo(String codigo_Tributo) {
        Codigo_Tributo = codigo_Tributo;
    }

    public String getValor_Unitario() {
        return Valor_Unitario;
    }

    public void setValor_Unitario(String valor_Unitario) {
        Valor_Unitario = valor_Unitario;
    }

    public String getPrecio_Unitario() {
        return Precio_Unitario;
    }

    public void setPrecio_Unitario(String precio_Unitario) {
        Precio_Unitario = precio_Unitario;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }

    public String getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(String created_at) {
        Created_at = created_at;
    }

    public String getUpdated_at() {
        return Updated_at;
    }

    public void setUpdated_at(String updated_at) {
        Updated_at = updated_at;
    }

    public String getDeleted_at() {
        return Deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        Deleted_at = deleted_at;
    }

    public String getCreated_by() {
        return Created_by;
    }

    public void setCreated_by(String created_by) {
        Created_by = created_by;
    }

    public String getUpdated_by() {
        return Updated_by;
    }

    public void setUpdated_by(String updated_by) {
        Updated_by = updated_by;
    }

    public String getDeleted_by() {
        return Deleted_by;
    }

    public void setDeleted_by(String deleted_by) {
        Deleted_by = deleted_by;
    }

    public Boolean getEnviado_A_Servidor() {
        return Enviado_A_Servidor;
    }

    public void setEnviado_A_Servidor(Boolean enviado_A_Servidor) {
        Enviado_A_Servidor = enviado_A_Servidor;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }


    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }
}
