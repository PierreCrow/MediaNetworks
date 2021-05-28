package com.futuremobile.wox.domain.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@Entity(tableName="Persona")
public class Persona implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private int id;
    @SerializedName("id_bbdd")
    private int id_bbdd;
    @SerializedName("Tipo_Documento_Identidad")
    private String Tipo_Documento_Identidad;
    @SerializedName("Nro_Documento_Identidad")
    private String Nro_Documento_Identidad;
    @SerializedName("Nombres")
    private String Nombres;
    @SerializedName("Direccion")
    private String Direccion;
    @SerializedName("Telefono")
    private String Telefono;
    @SerializedName("Email")
    private String Email;
    @SerializedName("Fecha_Nacimiento")
    private String Fecha_Nacimiento;
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



    public Persona(int id_bbdd, String Tipo_Documento_Identidad,
                   String Nro_Documento_Identidad, String Nombres,String Direccion,
                   String Telefono, String Email,String Fecha_Nacimiento, String Created_at,
                   String Updated_at, String Deleted_at, String Created_by, String Updated_by,
                   String Deleted_by, Boolean Enviado_A_Servidor)
    {
        this.id_bbdd=id_bbdd;
        this.Tipo_Documento_Identidad=Tipo_Documento_Identidad;
        this.Nro_Documento_Identidad=Nro_Documento_Identidad;
        this.Nombres=Nombres;
        this.Direccion = Direccion;
        this.Telefono=Telefono;
        this.Email=Email;
        this.Fecha_Nacimiento=Fecha_Nacimiento;
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
        dest.writeString(this.Tipo_Documento_Identidad);
        dest.writeString(this.Nro_Documento_Identidad);
        dest.writeString(this.Nombres);
        dest.writeString(this.Direccion);
        dest.writeString(this.Telefono);
        dest.writeString(this.Email);
        dest.writeString(this.Fecha_Nacimiento);
        dest.writeString(this.Created_at);
        dest.writeString(this.Updated_at);
        dest.writeString(this.Deleted_at);
        dest.writeString(this.Created_by);
        dest.writeString(this.Updated_by);
        dest.writeString(this.Deleted_by);
        dest.writeByte((byte) (Enviado_A_Servidor ? 1 : 0));
    }


    public Persona(Parcel in) {
        id = in.readInt();
        id_bbdd = in.readInt();
        Tipo_Documento_Identidad = in.readString();
        Nro_Documento_Identidad = in.readString();
        Nombres = in.readString();
        Direccion =in.readString();
        Telefono=in.readString();
        Email=in.readString();
        Fecha_Nacimiento=in.readString();
        Created_at = in.readString();
        Updated_at = in.readString();
        Deleted_at = in.readString();
        Created_by = in.readString();
        Updated_by = in.readString();
        Deleted_by = in.readString();
        Enviado_A_Servidor=in.readByte() != 0;
    }


    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
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

    public String getTipo_Documento_Identidad() {
        return Tipo_Documento_Identidad;
    }

    public void setTipo_Documento_Identidad(String tipo_Documento_Identidad) {
        Tipo_Documento_Identidad = tipo_Documento_Identidad;
    }

    public String getNro_Documento_Identidad() {
        return Nro_Documento_Identidad;
    }

    public void setNro_Documento_Identidad(String nro_Documento_Identidad) {
        Nro_Documento_Identidad = nro_Documento_Identidad;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        Fecha_Nacimiento = fecha_Nacimiento;
    }
}
