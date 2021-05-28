package com.futuremobile.wox.data.datasource.db.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName="DbTraza")
public class DbTraza implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("idDb")
    private int idDb;

    @SerializedName("id")
    private int id;

    @SerializedName("orden_id")
    private int orden_id;

    @SerializedName("estado")
    private int estado;


    @SerializedName("descripcion")
    private String descripcion;

    @SerializedName("comentario_1")
    private String comentario_1;

    @SerializedName("comentario_2")
    private String comentario_2;

    @SerializedName("comentario_3")
    private String comentario_3;

    @SerializedName("activo")
    private int activo;


    @SerializedName("up")
    private int up;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("deleted_at")
    private String deleted_at;


    @SerializedName("created_by")
    private int created_by;

    @SerializedName("updated_by")
    private int updated_by;

    @SerializedName("deleted_by")
    private String deleted_by;

    @SerializedName("sync")
    private boolean sync;


    public DbTraza(int id) {
        this.id = id;
    }

    public int getIdDb() {
        return idDb;
    }

    public void setIdDb(int idDb) {
        this.idDb = idDb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrden_id() {
        return orden_id;
    }

    public void setOrden_id(int orden_id) {
        this.orden_id = orden_id;
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

    public String getComentario_1() {
        return comentario_1;
    }

    public void setComentario_1(String comentario_1) {
        this.comentario_1 = comentario_1;
    }

    public String getComentario_2() {
        return comentario_2;
    }

    public void setComentario_2(String comentario_2) {
        this.comentario_2 = comentario_2;
    }

    public String getComentario_3() {
        return comentario_3;
    }

    public void setComentario_3(String comentario_3) {
        this.comentario_3 = comentario_3;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

    public String getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(String deleted_by) {
        this.deleted_by = deleted_by;
    }

    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }
}
