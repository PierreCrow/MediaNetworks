package com.futuremobile.wox.data.datasource.db.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@Entity(tableName="Rol")
public class Rol implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    //@ColumnInfo(name="id")
    @SerializedName("id")
    private int id;
    @SerializedName("id_bbdd")
    private int id_bbdd;
    @SerializedName("Nombre")
    private String Nombre;
    @SerializedName("Descripcion")
    private String Descripcion;
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


    public Rol(int id_bbdd,String Nombre, String Descripcion, int Estado, String Created_at,
               String Updated_at,String Deleted_at,String Created_by,String Updated_by,
               String Deleted_by,Boolean Enviado_A_Servidor)
    {
        this.id_bbdd=id_bbdd;
        this.Nombre=Nombre;
        this.Descripcion=Descripcion;
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
        dest.writeString(this.Nombre);
        dest.writeString(this.Descripcion);
        dest.writeInt(this.Estado);
        dest.writeString(this.Created_at);
        dest.writeString(this.Updated_at);
        dest.writeString(this.Deleted_at);
        dest.writeString(this.Created_by);
        dest.writeString(this.Updated_by);
        dest.writeString(this.Deleted_by);
        dest.writeByte((byte) (Enviado_A_Servidor ? 1 : 0));

    }


    public Rol(Parcel in) {
        id = in.readInt();
        id_bbdd = in.readInt();
        Nombre = in.readString();
        Descripcion = in.readString();
        Estado = in.readInt();
        Created_at = in.readString();
        Updated_at = in.readString();
        Deleted_at = in.readString();
        Created_by = in.readString();
        Updated_by = in.readString();
        Deleted_by = in.readString();
        Enviado_A_Servidor=in.readByte() != 0;

    }


    public static final Creator<Rol> CREATOR = new Creator<Rol>() {
        @Override
        public Rol createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public Rol[] newArray(int size) {
            return new Rol[size];
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
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
