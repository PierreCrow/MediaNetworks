package com.futuremobile.wox.data.datasource.cloud.model.sync;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WsTrazabilidad {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("orden_id")
    @Expose
    private int orden_id;

    @SerializedName("estado")
    @Expose
    private int estado;


    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("comentario_1")
    @Expose
    private String comentario_1;

    @SerializedName("comentario_2")
    @Expose
    private String comentario_2;

    @SerializedName("comentario_3")
    @Expose
    private String comentario_3;

    @SerializedName("activo")
    @Expose
    private int activo;


    @SerializedName("up")
    @Expose
    private int up;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("updated_at")
    @Expose
    private String updated_at;

    @SerializedName("deleted_at")
    @Expose
    private String deleted_at;


    @SerializedName("created_by")
    @Expose
    private int created_by;

    @SerializedName("updated_by")
    @Expose
    private int updated_by;

    @SerializedName("deleted_by")
    @Expose
    private String deleted_by;


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
}
