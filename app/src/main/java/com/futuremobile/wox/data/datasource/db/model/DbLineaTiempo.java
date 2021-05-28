package com.futuremobile.wox.data.datasource.db.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName="DbLineaTiempo")
public class DbLineaTiempo implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("idDb")
    private int idDb;
    @SerializedName("id")
    private int id;


    @SerializedName("orden_id")
    private int orden_id;

    @SerializedName("tabla_ref")
    private String tabla_ref;

    @SerializedName("adicional_ref")
    private String adicional_ref;

    @SerializedName("referencia_id")
    private int referencia_id;

    @SerializedName("condicion")
    private int condicion;

    @SerializedName("orden")
    private int orden;


    @SerializedName("cod_condicion")
    private String cod_condicion;


    @SerializedName("tipo")
    private String tipo;

    @SerializedName("cod_tipo")
    private String cod_tipo;

    @SerializedName("hora")
    private String hora;

    @SerializedName("duracion")
    private int duracion;

    @SerializedName("accion")
    private String accion;

    @SerializedName("area_id")
    private int area_id;

    @SerializedName("desc_area")
    private String desc_area;

    @SerializedName("tarea_rel")
    private int tarea_rel;


    @SerializedName("desc_tarea_rel")
    private String desc_tarea_rel;

    @SerializedName("user_ini_id")
    private int user_ini_id;

    @SerializedName("inicio")
    private String inicio;


    @SerializedName("user_fin_id")
    private int user_fin_id;

    @SerializedName("fin")
    private String fin;

    @SerializedName("observacion")
    private String observacion;

    @SerializedName("estado")
    private int estado;

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


    public DbLineaTiempo(int id) {
        this.id = id;
    }


    public int getOrden_id() {
        return orden_id;
    }

    public void setOrden_id(int orden_id) {
        this.orden_id = orden_id;
    }

    public String getTabla_ref() {
        return tabla_ref;
    }

    public void setTabla_ref(String tabla_ref) {
        this.tabla_ref = tabla_ref;
    }

    public String getAdicional_ref() {
        return adicional_ref;
    }

    public void setAdicional_ref(String adicional_ref) {
        this.adicional_ref = adicional_ref;
    }

    public int getReferencia_id() {
        return referencia_id;
    }

    public void setReferencia_id(int referencia_id) {
        this.referencia_id = referencia_id;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getCod_condicion() {
        return cod_condicion;
    }

    public void setCod_condicion(String cod_condicion) {
        this.cod_condicion = cod_condicion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCod_tipo() {
        return cod_tipo;
    }

    public void setCod_tipo(String cod_tipo) {
        this.cod_tipo = cod_tipo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getDesc_area() {
        return desc_area;
    }

    public void setDesc_area(String desc_area) {
        this.desc_area = desc_area;
    }

    public int getTarea_rel() {
        return tarea_rel;
    }

    public void setTarea_rel(int tarea_rel) {
        this.tarea_rel = tarea_rel;
    }

    public String getDesc_tarea_rel() {
        return desc_tarea_rel;
    }

    public void setDesc_tarea_rel(String desc_tarea_rel) {
        this.desc_tarea_rel = desc_tarea_rel;
    }

    public int getUser_ini_id() {
        return user_ini_id;
    }

    public void setUser_ini_id(int user_ini_id) {
        this.user_ini_id = user_ini_id;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public int getUser_fin_id() {
        return user_fin_id;
    }

    public void setUser_fin_id(int user_fin_id) {
        this.user_fin_id = user_fin_id;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }
}
