package com.futuremobile.wox.data.datasource.cloud.model.sync;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WsWorkOrder {

    @SerializedName("id")
    @Expose
    private int id;


    @SerializedName("proyecto_id")
    @Expose
    private int proyecto_id;

    @SerializedName("asunto")
    @Expose
    private String asunto;

    @SerializedName("ticket")
    @Expose
    private String ticket;


    @SerializedName("tipo")
    @Expose
    private int tipo;


    @SerializedName("plataforma")
    @Expose
    private String plataforma = null;


    @SerializedName("tipo_solicitud")
    @Expose
    private int tipo_solicitud;

    @SerializedName("tipo_servicio")
    @Expose
    private int tipo_servicio;

    @SerializedName("etapa")
    @Expose
    private int etapa;

    @SerializedName("tipo_orden")
    @Expose
    private int tipo_orden;

    @SerializedName("es_emergencia")
    @Expose
    private int es_emergencia;

    @SerializedName("severidad")
    @Expose
    private int severidad;

    @SerializedName("ini_plan")
    @Expose
    private String ini_plan;

    @SerializedName("fin_plan")
    @Expose
    private String fin_plan;


    /*   @SerializedName("servicios_afectados")
       @Expose
       private List<Integer> servicios_afectados = null;
   */
    @SerializedName("campo_objetivo")
    @Expose
    private String campo_objetivo;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("impacto")
    @Expose
    private int impacto;

    /*
    @SerializedName("obs_afectadas")
    @Expose
    private List<Integer> obs_afectadas = null;
*/

    @SerializedName("area_id")
    @Expose
    private int area_id;

    @SerializedName("persona_id")
    @Expose
    private int persona_id;

    @SerializedName("task_wo")
    @Expose
    private int task_wo;

    @SerializedName("tiene_ventana")
    @Expose
    private int tiene_ventana;

    @SerializedName("ini_guarda")
    @Expose
    private String ini_guarda;

    @SerializedName("fin_guarda")
    @Expose
    private String fin_guarda;

    @SerializedName("tiene_trabajo_rel")
    @Expose
    private int tiene_trabajo_rel;

    @SerializedName("tiene_act_registros")
    @Expose
    private int tiene_act_registros;

    /*   @SerializedName("reg_registros")
       @Expose
       private int reg_registros;
   */
  /*  @SerializedName("reg_grupo")
    @Expose
    private int reg_grupo;
*/
    @SerializedName("reg_actualizador")
    @Expose
    private String reg_actualizador;

    @SerializedName("tiene_act_herramientas_mon")
    @Expose
    private int tiene_act_herramientas_mon;

    @SerializedName("mon_con_ventana")
    @Expose
    private int mon_con_ventana;

    @SerializedName("mon_con_ven_descripcion")
    @Expose
    private String mon_con_ven_descripcion;

    @SerializedName("mon_sin_ventana")
    @Expose
    private int mon_sin_ventana;

    @SerializedName("mon_sin_ven_descripcion")
    @Expose
    private String mon_sin_ven_descripcion;
    /*
        @SerializedName("mon_area")
        @Expose
        private int mon_area;
    */
    @SerializedName("tiene_plan_mantenimiento")
    @Expose
    private int tiene_plan_mantenimiento;

 /*   @SerializedName("man_areas")
    @Expose
    private int man_areas;
*/

    @SerializedName("man_etapas")
    @Expose
    private String man_etapas;

    @SerializedName("man_detalle")
    @Expose
    private String man_detalle;

    @SerializedName("imp_comentario")
    @Expose
    private String imp_comentario;

    @SerializedName("imp_tiempo")
    @Expose
    private String imp_tiempo;

    @SerializedName("tiene_sol_acceso")
    @Expose
    private int tiene_sol_acceso;

    @SerializedName("tiene_validaciones")
    @Expose
    private int tiene_validaciones;

    @SerializedName("tiene_monitoreo")
    @Expose
    private int tiene_monitoreo;


    @SerializedName("estado")
    @Expose
    private int estado;

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


    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }


    public int getTipo_solicitud() {
        return tipo_solicitud;
    }

    public void setTipo_solicitud(int tipo_solicitud) {
        this.tipo_solicitud = tipo_solicitud;
    }

    public int getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(int tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public int getEtapa() {
        return etapa;
    }

    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }

    public int getTipo_orden() {
        return tipo_orden;
    }

    public void setTipo_orden(int tipo_orden) {
        this.tipo_orden = tipo_orden;
    }

    public int getEs_emergencia() {
        return es_emergencia;
    }

    public void setEs_emergencia(int es_emergencia) {
        this.es_emergencia = es_emergencia;
    }

    public int getSeveridad() {
        return severidad;
    }

    public void setSeveridad(int severidad) {
        this.severidad = severidad;
    }

    public String getIni_plan() {
        return ini_plan;
    }

    public void setIni_plan(String ini_plan) {
        this.ini_plan = ini_plan;
    }

    public String getFin_plan() {
        return fin_plan;
    }

    public void setFin_plan(String fin_plan) {
        this.fin_plan = fin_plan;
    }


    public String getCampo_objetivo() {
        return campo_objetivo;
    }

    public void setCampo_objetivo(String campo_objetivo) {
        this.campo_objetivo = campo_objetivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImpacto() {
        return impacto;
    }

    public void setImpacto(int impacto) {
        this.impacto = impacto;
    }


    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getTask_wo() {
        return task_wo;
    }

    public void setTask_wo(int task_wo) {
        this.task_wo = task_wo;
    }

    public int getTiene_ventana() {
        return tiene_ventana;
    }

    public void setTiene_ventana(int tiene_ventana) {
        this.tiene_ventana = tiene_ventana;
    }

    public String getIni_guarda() {
        return ini_guarda;
    }

    public void setIni_guarda(String ini_guarda) {
        this.ini_guarda = ini_guarda;
    }

    public String getFin_guarda() {
        return fin_guarda;
    }

    public void setFin_guarda(String fin_guarda) {
        this.fin_guarda = fin_guarda;
    }

    public int getTiene_trabajo_rel() {
        return tiene_trabajo_rel;
    }

    public void setTiene_trabajo_rel(int tiene_trabajo_rel) {
        this.tiene_trabajo_rel = tiene_trabajo_rel;
    }

    public int getTiene_act_registros() {
        return tiene_act_registros;
    }

    public void setTiene_act_registros(int tiene_act_registros) {
        this.tiene_act_registros = tiene_act_registros;
    }


    public String getReg_actualizador() {
        return reg_actualizador;
    }

    public void setReg_actualizador(String reg_actualizador) {
        this.reg_actualizador = reg_actualizador;
    }

    public int getTiene_act_herramientas_mon() {
        return tiene_act_herramientas_mon;
    }

    public void setTiene_act_herramientas_mon(int tiene_act_herramientas_mon) {
        this.tiene_act_herramientas_mon = tiene_act_herramientas_mon;
    }

    public int getMon_con_ventana() {
        return mon_con_ventana;
    }

    public void setMon_con_ventana(int mon_con_ventana) {
        this.mon_con_ventana = mon_con_ventana;
    }

    public String getMon_con_ven_descripcion() {
        return mon_con_ven_descripcion;
    }

    public void setMon_con_ven_descripcion(String mon_con_ven_descripcion) {
        this.mon_con_ven_descripcion = mon_con_ven_descripcion;
    }

    public int getMon_sin_ventana() {
        return mon_sin_ventana;
    }

    public void setMon_sin_ventana(int mon_sin_ventana) {
        this.mon_sin_ventana = mon_sin_ventana;
    }

    public String getMon_sin_ven_descripcion() {
        return mon_sin_ven_descripcion;
    }

    public void setMon_sin_ven_descripcion(String mon_sin_ven_descripcion) {
        this.mon_sin_ven_descripcion = mon_sin_ven_descripcion;
    }


    public int getTiene_plan_mantenimiento() {
        return tiene_plan_mantenimiento;
    }

    public void setTiene_plan_mantenimiento(int tiene_plan_mantenimiento) {
        this.tiene_plan_mantenimiento = tiene_plan_mantenimiento;
    }


    public String getMan_etapas() {
        return man_etapas;
    }

    public void setMan_etapas(String man_etapas) {
        this.man_etapas = man_etapas;
    }

    public String getMan_detalle() {
        return man_detalle;
    }

    public void setMan_detalle(String man_detalle) {
        this.man_detalle = man_detalle;
    }

    public String getImp_comentario() {
        return imp_comentario;
    }

    public void setImp_comentario(String imp_comentario) {
        this.imp_comentario = imp_comentario;
    }

    public String getImp_tiempo() {
        return imp_tiempo;
    }

    public void setImp_tiempo(String imp_tiempo) {
        this.imp_tiempo = imp_tiempo;
    }

    public int getTiene_sol_acceso() {
        return tiene_sol_acceso;
    }

    public void setTiene_sol_acceso(int tiene_sol_acceso) {
        this.tiene_sol_acceso = tiene_sol_acceso;
    }

    public int getTiene_validaciones() {
        return tiene_validaciones;
    }

    public void setTiene_validaciones(int tiene_validaciones) {
        this.tiene_validaciones = tiene_validaciones;
    }

    public int getTiene_monitoreo() {
        return tiene_monitoreo;
    }

    public void setTiene_monitoreo(int tiene_monitoreo) {
        this.tiene_monitoreo = tiene_monitoreo;
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

    public int getProyecto_id() {
        return proyecto_id;
    }

    public void setProyecto_id(int proyecto_id) {
        this.proyecto_id = proyecto_id;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}
