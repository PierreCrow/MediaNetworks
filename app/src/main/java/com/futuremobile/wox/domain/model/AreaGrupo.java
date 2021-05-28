package com.futuremobile.wox.domain.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AreaGrupo implements Serializable {


    @SerializedName("id")
    private int id;

    @SerializedName("tipo")
    private int tipo;

    @SerializedName("codigo")
    private String codigo;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("es_responsable")
    private int es_responsable;

    @SerializedName("es_ejecutor")
    private int es_ejecutor;

    @SerializedName("es_aprobador")
    private int es_aprobador;

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


    public AreaGrupo(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEs_responsable() {
        return es_responsable;
    }

    public void setEs_responsable(int es_responsable) {
        this.es_responsable = es_responsable;
    }

    public int getEs_ejecutor() {
        return es_ejecutor;
    }

    public void setEs_ejecutor(int es_ejecutor) {
        this.es_ejecutor = es_ejecutor;
    }

    public int getEs_aprobador() {
        return es_aprobador;
    }

    public void setEs_aprobador(int es_aprobador) {
        this.es_aprobador = es_aprobador;
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
