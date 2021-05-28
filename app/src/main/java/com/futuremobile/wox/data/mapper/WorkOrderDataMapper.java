package com.futuremobile.wox.data.mapper;

import com.futuremobile.wox.data.datasource.cloud.model.sync.WsWorkOrder;
import com.futuremobile.wox.data.datasource.db.model.DbWorkOrder;
import com.futuremobile.wox.domain.model.WorkOrder;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderDataMapper {


    public WorkOrderDataMapper() {
    }

    public WorkOrder transformCloudToModel(WsWorkOrder dbWorkOrder) {
        WorkOrder workOrder = null;

        int id = dbWorkOrder.getId();

        workOrder = new WorkOrder(id);
        workOrder.setId(id);
  //      workOrder.setProyecto_id(dbWorkOrder.getProyecto_id());
        workOrder.setAsunto(dbWorkOrder.getAsunto());
  //      workOrder.setTipo(dbWorkOrder.getTipo());
  //      workOrder.setPlataforma(dbWorkOrder.getPlataforma());
        workOrder.setTipo_solicitud(dbWorkOrder.getTipo_solicitud());
        workOrder.setTipo_servicio(dbWorkOrder.getTipo_servicio());
        workOrder.setEtapa(dbWorkOrder.getEtapa());
        workOrder.setTipo_orden(dbWorkOrder.getTipo_orden());
        workOrder.setEs_emergencia(dbWorkOrder.getEs_emergencia());
        workOrder.setSeveridad(dbWorkOrder.getSeveridad());
        workOrder.setIni_plan(dbWorkOrder.getIni_plan());
        workOrder.setFin_plan(dbWorkOrder.getFin_plan());
        workOrder.setCampo_objetivo(dbWorkOrder.getCampo_objetivo());
        workOrder.setDescripcion(dbWorkOrder.getDescripcion());
        workOrder.setImpacto(dbWorkOrder.getImpacto());
        workOrder.setArea_id(dbWorkOrder.getArea_id());
        workOrder.setPersona_id(dbWorkOrder.getPersona_id());
        workOrder.setTask_wo(dbWorkOrder.getTask_wo());
        workOrder.setTiene_ventana(dbWorkOrder.getTiene_ventana());
        workOrder.setIni_guarda(dbWorkOrder.getIni_guarda());
        workOrder.setFin_guarda(dbWorkOrder.getFin_guarda());
        workOrder.setTiene_trabajo_rel(dbWorkOrder.getTiene_trabajo_rel());
        workOrder.setTiene_act_registros(dbWorkOrder.getTiene_act_registros());
        workOrder.setReg_actualizador(dbWorkOrder.getReg_actualizador());
        workOrder.setTiene_act_herramientas_mon(dbWorkOrder.getTiene_act_herramientas_mon());
        workOrder.setMon_con_ventana(dbWorkOrder.getMon_con_ventana());
        workOrder.setMon_con_ven_descripcion(dbWorkOrder.getMon_con_ven_descripcion());
        workOrder.setMon_sin_ventana(dbWorkOrder.getMon_sin_ventana());
        workOrder.setMon_sin_ven_descripcion(dbWorkOrder.getMon_sin_ven_descripcion());
        workOrder.setTiene_plan_mantenimiento(dbWorkOrder.getTiene_plan_mantenimiento());
        workOrder.setMan_etapas(dbWorkOrder.getMan_etapas());
        workOrder.setMan_detalle(dbWorkOrder.getMan_detalle());
        workOrder.setImp_comentario(dbWorkOrder.getImp_comentario());
        workOrder.setImp_tiempo(dbWorkOrder.getImp_tiempo());
        workOrder.setTiene_sol_acceso(dbWorkOrder.getTiene_sol_acceso());
        workOrder.setTiene_validaciones(dbWorkOrder.getTiene_validaciones());
        workOrder.setTiene_monitoreo(dbWorkOrder.getTiene_monitoreo());
        workOrder.setEstado(dbWorkOrder.getEstado());
        workOrder.setActivo(dbWorkOrder.getActivo());
        workOrder.setUp(dbWorkOrder.getUp());
        workOrder.setCreated_at(dbWorkOrder.getCreated_at());
        workOrder.setUpdated_at(dbWorkOrder.getUpdated_at());
        workOrder.setDeleted_at(dbWorkOrder.getDeleted_at());
        workOrder.setCreated_by(dbWorkOrder.getCreated_by());
        workOrder.setUpdated_by(dbWorkOrder.getUpdated_by());
        workOrder.setDeleted_by(dbWorkOrder.getDeleted_by());
        workOrder.setTicket(dbWorkOrder.getTicket());
     //   workOrder.setSync(dbWorkOrder.isSync());


        return workOrder;
    }

    public WorkOrder transformDbToModel(DbWorkOrder dbWorkOrder) {
       WorkOrder workOrder = null;


        int id = dbWorkOrder.getId();

        workOrder = new WorkOrder(id);
        workOrder.setId(id);
        workOrder.setProyecto_id(dbWorkOrder.getProyecto_id());
        workOrder.setAsunto(dbWorkOrder.getAsunto());
        workOrder.setTipo(dbWorkOrder.getTipo());
        workOrder.setPlataforma(dbWorkOrder.getPlataforma());
        workOrder.setTipo_solicitud(dbWorkOrder.getTipo_solicitud());
        workOrder.setTipo_servicio(dbWorkOrder.getTipo_servicio());
        workOrder.setEtapa(dbWorkOrder.getEtapa());
        workOrder.setTipo_orden(dbWorkOrder.getTipo_orden());
        workOrder.setEs_emergencia(dbWorkOrder.getEs_emergencia());
        workOrder.setSeveridad(dbWorkOrder.getSeveridad());
        workOrder.setIni_plan(dbWorkOrder.getIni_plan());
        workOrder.setFin_plan(dbWorkOrder.getFin_plan());
        workOrder.setCampo_objetivo(dbWorkOrder.getCampo_objetivo());
        workOrder.setDescripcion(dbWorkOrder.getDescripcion());
        workOrder.setImpacto(dbWorkOrder.getImpacto());
        workOrder.setArea_id(dbWorkOrder.getArea_id());
        workOrder.setPersona_id(dbWorkOrder.getPersona_id());
        workOrder.setTask_wo(dbWorkOrder.getTask_wo());
        workOrder.setTiene_ventana(dbWorkOrder.getTiene_ventana());
        workOrder.setIni_guarda(dbWorkOrder.getIni_guarda());
        workOrder.setFin_guarda(dbWorkOrder.getFin_guarda());
        workOrder.setTiene_trabajo_rel(dbWorkOrder.getTiene_trabajo_rel());
        workOrder.setTiene_act_registros(dbWorkOrder.getTiene_act_registros());
        workOrder.setReg_actualizador(dbWorkOrder.getReg_actualizador());
        workOrder.setTiene_act_herramientas_mon(dbWorkOrder.getTiene_act_herramientas_mon());
        workOrder.setMon_con_ventana(dbWorkOrder.getMon_con_ventana());
        workOrder.setMon_con_ven_descripcion(dbWorkOrder.getMon_con_ven_descripcion());
        workOrder.setMon_sin_ventana(dbWorkOrder.getMon_sin_ventana());
        workOrder.setMon_sin_ven_descripcion(dbWorkOrder.getMon_sin_ven_descripcion());
        workOrder.setTiene_plan_mantenimiento(dbWorkOrder.getTiene_plan_mantenimiento());
        workOrder.setMan_etapas(dbWorkOrder.getMan_etapas());
        workOrder.setMan_detalle(dbWorkOrder.getMan_detalle());
        workOrder.setImp_comentario(dbWorkOrder.getImp_comentario());
        workOrder.setImp_tiempo(dbWorkOrder.getImp_tiempo());
        workOrder.setTiene_sol_acceso(dbWorkOrder.getTiene_sol_acceso());
        workOrder.setTiene_validaciones(dbWorkOrder.getTiene_validaciones());
        workOrder.setTiene_monitoreo(dbWorkOrder.getTiene_monitoreo());
        workOrder.setEstado(dbWorkOrder.getEstado());
        workOrder.setActivo(dbWorkOrder.getActivo());
        workOrder.setUp(dbWorkOrder.getUp());
        workOrder.setCreated_at(dbWorkOrder.getCreated_at());
        workOrder.setUpdated_at(dbWorkOrder.getUpdated_at());
        workOrder.setDeleted_at(dbWorkOrder.getDeleted_at());
        workOrder.setCreated_by(dbWorkOrder.getCreated_by());
        workOrder.setUpdated_by(dbWorkOrder.getUpdated_by());
        workOrder.setDeleted_by(dbWorkOrder.getDeleted_by());
        workOrder.setSync(dbWorkOrder.isSync());
        workOrder.setTicket(dbWorkOrder.getTicket());


        return workOrder;
    }

    public WsWorkOrder transformModelToCloud(WorkOrder workOrder) {
        WsWorkOrder wsWorkOrder = null;

        int id = workOrder.getId();

        wsWorkOrder = new WsWorkOrder();
        wsWorkOrder.setId(id);

        return wsWorkOrder;
    }


    public DbWorkOrder transformModelToDb(WorkOrder workOrder) {
        DbWorkOrder dbWorkOrder = null;

        int id = workOrder.getId();

        dbWorkOrder = new DbWorkOrder(id);
        dbWorkOrder.setId(id);
        dbWorkOrder.setProyecto_id(workOrder.getProyecto_id());
        dbWorkOrder.setAsunto(workOrder.getAsunto());
        dbWorkOrder.setTipo(workOrder.getTipo());
        dbWorkOrder.setPlataforma(workOrder.getPlataforma());
        dbWorkOrder.setTipo_solicitud(workOrder.getTipo_solicitud());
        dbWorkOrder.setTipo_servicio(workOrder.getTipo_servicio());
        dbWorkOrder.setEtapa(workOrder.getEtapa());
        dbWorkOrder.setTipo_orden(workOrder.getTipo_orden());
        dbWorkOrder.setEs_emergencia(workOrder.getEs_emergencia());
        dbWorkOrder.setSeveridad(workOrder.getSeveridad());
        dbWorkOrder.setIni_plan(workOrder.getIni_plan());
        dbWorkOrder.setFin_plan(workOrder.getFin_plan());
        dbWorkOrder.setCampo_objetivo(workOrder.getCampo_objetivo());
        dbWorkOrder.setDescripcion(workOrder.getDescripcion());
        dbWorkOrder.setImpacto(workOrder.getImpacto());
        dbWorkOrder.setArea_id(workOrder.getArea_id());
        dbWorkOrder.setPersona_id(workOrder.getPersona_id());
        dbWorkOrder.setTask_wo(workOrder.getTask_wo());
        dbWorkOrder.setTiene_ventana(workOrder.getTiene_ventana());
        dbWorkOrder.setIni_guarda(workOrder.getIni_guarda());
        dbWorkOrder.setFin_guarda(workOrder.getFin_guarda());
        dbWorkOrder.setTiene_trabajo_rel(workOrder.getTiene_trabajo_rel());
        dbWorkOrder.setTiene_act_registros(workOrder.getTiene_act_registros());
        dbWorkOrder.setReg_actualizador(workOrder.getReg_actualizador());
        dbWorkOrder.setTiene_act_herramientas_mon(workOrder.getTiene_act_herramientas_mon());
        dbWorkOrder.setMon_con_ventana(workOrder.getMon_con_ventana());
        dbWorkOrder.setMon_con_ven_descripcion(workOrder.getMon_con_ven_descripcion());
        dbWorkOrder.setMon_sin_ventana(workOrder.getMon_sin_ventana());
        dbWorkOrder.setMon_sin_ven_descripcion(workOrder.getMon_sin_ven_descripcion());
        dbWorkOrder.setTiene_plan_mantenimiento(workOrder.getTiene_plan_mantenimiento());
        dbWorkOrder.setMan_etapas(workOrder.getMan_etapas());
        dbWorkOrder.setMan_detalle(workOrder.getMan_detalle());
        dbWorkOrder.setImp_comentario(workOrder.getImp_comentario());
        dbWorkOrder.setImp_tiempo(workOrder.getImp_tiempo());
        dbWorkOrder.setTiene_sol_acceso(workOrder.getTiene_sol_acceso());
        dbWorkOrder.setTiene_validaciones(workOrder.getTiene_validaciones());
        dbWorkOrder.setTiene_monitoreo(workOrder.getTiene_monitoreo());
        dbWorkOrder.setEstado(workOrder.getEstado());
        dbWorkOrder.setActivo(workOrder.getActivo());
        dbWorkOrder.setUp(workOrder.getUp());
        dbWorkOrder.setCreated_at(workOrder.getCreated_at());
        dbWorkOrder.setUpdated_at(workOrder.getUpdated_at());
        dbWorkOrder.setDeleted_at(workOrder.getDeleted_at());
        dbWorkOrder.setCreated_by(workOrder.getCreated_by());
        dbWorkOrder.setUpdated_by(workOrder.getUpdated_by());
        dbWorkOrder.setDeleted_by(workOrder.getDeleted_by());
        dbWorkOrder.setSync(workOrder.isSync());

        dbWorkOrder.setTicket(workOrder.getTicket());
        return dbWorkOrder;
    }

}
