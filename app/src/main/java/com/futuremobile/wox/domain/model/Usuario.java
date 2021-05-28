package com.futuremobile.wox.domain.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@Entity(tableName="Usuario")
public class Usuario implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private int id;
    @SerializedName("id_bbdd")
    private int id_bbdd;
    @SerializedName("id_persona")
    private int id_persona;
    @SerializedName("id_rol")
    private int id_rol;
    @SerializedName("id_empresa")
    private int id_empresa;
    @SerializedName("Usuario")
    private String Usuario;
    @SerializedName("Password")
    private String Password;
    @SerializedName("Estado")
    private int Estado;
    @SerializedName("RememberToken")
    private String RememberToken;


    @SerializedName("Tipo_Cuenta")
    private String Tipo_Cuenta;
    @SerializedName("Cuenta_Prueba_Vencida")
    private Boolean Cuenta_Prueba_Vencida;
    @SerializedName("URL_Foto_Empresa")
    private String URL_Foto_Empresa;

    @SerializedName("Nombre_User")
    private String Nombre_User;






    public Usuario(int id_bbdd,int id_persona,int id_rol,
                   String Usuario, String Password, int Estado, String RememberToken,
                   String Tipo_Cuenta, Boolean Cuenta_Prueba_Vencida,String URL_Foto_Empresa,String Nombre_User)
    {
       // this.id=id;
        this.id_bbdd=id_bbdd;
        this.id_persona=id_persona;
        this.id_rol=id_rol;
        this.Usuario=Usuario;
        this.Password = Password;
        this.Estado=Estado;
        this.RememberToken=RememberToken;

        this.Tipo_Cuenta=Tipo_Cuenta;
        this.Cuenta_Prueba_Vencida=Cuenta_Prueba_Vencida;
        this.URL_Foto_Empresa=URL_Foto_Empresa;
        this.Nombre_User=Nombre_User;

    }


    @Override
    public int describeContents() {
        return 0;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(this.id);
        dest.writeInt(this.id_bbdd);
        dest.writeInt(this.id_persona);
        dest.writeInt(this.id_rol);
        dest.writeString(this.Usuario);
        dest.writeString(this.Password);
        dest.writeInt(this.Estado);
        dest.writeString(this.RememberToken);

        dest.writeByte((byte) (Cuenta_Prueba_Vencida ? 1 : 0));
        dest.writeString(this.Tipo_Cuenta);
        dest.writeString(this.URL_Foto_Empresa);
        dest.writeString(this.Nombre_User);

    }


    public Usuario(Parcel in) {
        id = in.readInt();
        id_bbdd = in.readInt();
        id_persona = in.readInt();
        id_rol = in.readInt();
        Usuario = in.readString();
        Password = in.readString();
        Estado = in.readInt();
        RememberToken=in.readString();

        Cuenta_Prueba_Vencida=in.readByte() != 0;
        Tipo_Cuenta = in.readString();
        URL_Foto_Empresa = in.readString();
        Nombre_User = in.readString();

    }


    public static final Creator<com.futuremobile.wox.domain.model.Usuario> CREATOR = new Creator<com.futuremobile.wox.domain.model.Usuario>() {
        @Override
        public com.futuremobile.wox.domain.model.Usuario createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public com.futuremobile.wox.domain.model.Usuario[] newArray(int size) {
            return new Usuario[size];
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

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }

    public String getRememberToken() {
        return RememberToken;
    }

    public void setRememberToken(String rememberToken) {
        RememberToken = rememberToken;
    }

    public String getTipo_Cuenta() {
        return Tipo_Cuenta;
    }

    public void setTipo_Cuenta(String tipo_Cuenta) {
        Tipo_Cuenta = tipo_Cuenta;
    }

    public Boolean getCuenta_Prueba_Vencida() {
        return Cuenta_Prueba_Vencida;
    }

    public void setCuenta_Prueba_Vencida(Boolean cuenta_Prueba_Vencida) {
        Cuenta_Prueba_Vencida = cuenta_Prueba_Vencida;
    }

    public String getURL_Foto_Empresa() {
        return URL_Foto_Empresa;
    }

    public void setURL_Foto_Empresa(String URL_Foto_Empresa) {
        this.URL_Foto_Empresa = URL_Foto_Empresa;
    }

    public String getNombre_User() {
        return Nombre_User;
    }

    public void setNombre_User(String nombre_User) {
        Nombre_User = nombre_User;
    }
}
