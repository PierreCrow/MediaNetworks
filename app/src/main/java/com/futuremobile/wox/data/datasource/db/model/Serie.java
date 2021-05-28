package com.futuremobile.wox.data.datasource.db.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@Entity(tableName="Serie")
public class Serie implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private int id;
    @SerializedName("id_bbdd")
    private int id_bbdd;
    @SerializedName("id_empresa")
    private int id_empresa;
    @SerializedName("Tipo_Comprobante")
    private String Tipo_Comprobante;
    @SerializedName("Num_Serie")
    private String Num_Serie;
    @SerializedName("Sucursal")
    private String Sucursal;
    @SerializedName("Cod_Domicilio")
    private String Cod_Domicilio;
    @SerializedName("Formato_imp")
    private String Formato_imp;
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



    public Serie(int id_bbdd,int id_empresa, String Tipo_Comprobante,
                 String Num_Serie, String Sucursal, String Cod_Domicilio,
                 String Formato_imp, int Estado, String Created_at,
                 String Updated_at, String Deleted_at, String Created_by, String Updated_by,
                 String Deleted_by, Boolean Enviado_A_Servidor)
    {
        this.id_bbdd=id_bbdd;
        this.id_empresa=id_empresa;
        this.Tipo_Comprobante=Tipo_Comprobante;
        this.Num_Serie=Num_Serie;
        this.Sucursal = Sucursal;
        this.Cod_Domicilio=Cod_Domicilio;
        this.Formato_imp=Formato_imp;
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

        dest.writeInt(this.id);
        dest.writeInt(this.id_bbdd);
        dest.writeInt(this.id_empresa);
        dest.writeString(this.Tipo_Comprobante);
        dest.writeString(this.Num_Serie);
        dest.writeString(this.Sucursal);
        dest.writeString(this.Cod_Domicilio);
        dest.writeString(this.Formato_imp);
        dest.writeInt(this.Estado);
        dest.writeString(this.Created_at);
        dest.writeString(this.Updated_at);
        dest.writeString(this.Deleted_at);
        dest.writeString(this.Created_by);
        dest.writeString(this.Updated_by);
        dest.writeString(this.Deleted_by);
        dest.writeByte((byte) (Enviado_A_Servidor ? 1 : 0));
    }


    public Serie(Parcel in) {
        id = in.readInt();
        id_bbdd = in.readInt();
        id_empresa = in.readInt();
        Tipo_Comprobante = in.readString();
        Num_Serie = in.readString();
        Sucursal = in.readString();
        Cod_Domicilio =in.readString();
        Formato_imp=in.readString();
        Estado=in.readInt();
        Created_at = in.readString();
        Updated_at = in.readString();
        Deleted_at = in.readString();
        Created_by = in.readString();
        Updated_by = in.readString();
        Deleted_by = in.readString();
        Enviado_A_Servidor=in.readByte() != 0;
    }


    public static final Creator<Serie> CREATOR = new Creator<Serie>() {
        @Override
        public Serie createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public Serie[] newArray(int size) {
            return new Serie[size];
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

    public String getTipo_Comprobante() {
        return Tipo_Comprobante;
    }

    public void setTipo_Comprobante(String tipo_Comprobante) {
        Tipo_Comprobante = tipo_Comprobante;
    }

    public String getNum_Serie() {
        return Num_Serie;
    }

    public void setNum_Serie(String num_Serie) {
        Num_Serie = num_Serie;
    }

    public String getSucursal() {
        return Sucursal;
    }

    public void setSucursal(String sucursal) {
        Sucursal = sucursal;
    }

    public String getCod_Domicilio() {
        return Cod_Domicilio;
    }

    public void setCod_Domicilio(String cod_Domicilio) {
        Cod_Domicilio = cod_Domicilio;
    }

    public String getFormato_imp() {
        return Formato_imp;
    }

    public void setFormato_imp(String formato_imp) {
        Formato_imp = formato_imp;
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
}
