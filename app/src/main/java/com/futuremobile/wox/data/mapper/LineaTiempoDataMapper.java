package com.futuremobile.wox.data.mapper;

import com.futuremobile.wox.data.datasource.cloud.model.sync.WsLineaTiempo;
import com.futuremobile.wox.data.datasource.cloud.model.sync.WsWorkOrder;
import com.futuremobile.wox.data.datasource.db.model.DbLineaTiempo;
import com.futuremobile.wox.data.datasource.db.model.DbWorkOrder;
import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.model.WorkOrder;

public class LineaTiempoDataMapper {


    public LineaTiempoDataMapper() {
    }

    public LineaTiempo transformCloudToModel(WsLineaTiempo wsLineaTiempo) {
        LineaTiempo lineaTiempo = null;

        int id = wsLineaTiempo.getId();

        lineaTiempo = new LineaTiempo(id);
        lineaTiempo.setId(wsLineaTiempo.getId());

        lineaTiempo.setOrden_id(wsLineaTiempo.getOrden_id());
        lineaTiempo.setTabla_ref(wsLineaTiempo.getTabla_ref());
        lineaTiempo.setAdicional_ref(wsLineaTiempo.getAdicional_ref());
        lineaTiempo.setReferencia_id(wsLineaTiempo.getReferencia_id());
        lineaTiempo.setCondicion(wsLineaTiempo.getCondicion());
        lineaTiempo.setOrden(wsLineaTiempo.getOrden());
        lineaTiempo.setCod_condicion(wsLineaTiempo.getCod_condicion());
        lineaTiempo.setTipo(wsLineaTiempo.getTipo());
        lineaTiempo.setCod_tipo(wsLineaTiempo.getCod_tipo());
        lineaTiempo.setHora(wsLineaTiempo.getHora());
        lineaTiempo.setDuracion(wsLineaTiempo.getDuracion());
        lineaTiempo.setAccion(wsLineaTiempo.getAccion());
        lineaTiempo.setArea_id(wsLineaTiempo.getArea_id());
        lineaTiempo.setDesc_area(wsLineaTiempo.getDesc_area());
        lineaTiempo.setTarea_rel(wsLineaTiempo.getTarea_rel());
        lineaTiempo.setDesc_tarea_rel(wsLineaTiempo.getDesc_tarea_rel());
        lineaTiempo.setUser_ini_id(wsLineaTiempo.getUser_ini_id());
        lineaTiempo.setInicio(wsLineaTiempo.getInicio());
        lineaTiempo.setUser_fin_id(wsLineaTiempo.getUser_fin_id());
        lineaTiempo.setFin(wsLineaTiempo.getFin());
        lineaTiempo.setObservacion(wsLineaTiempo.getObservacion());
        lineaTiempo.setEstado(wsLineaTiempo.getEstado());
        lineaTiempo.setActivo(wsLineaTiempo.getActivo());
        lineaTiempo.setUp(wsLineaTiempo.getUp());
        lineaTiempo.setCreated_at(wsLineaTiempo.getCreated_at());
        lineaTiempo.setUpdated_at(wsLineaTiempo.getUpdated_at());
        lineaTiempo.setDeleted_at(wsLineaTiempo.getDeleted_at());
        lineaTiempo.setCreated_by(wsLineaTiempo.getCreated_by());
        lineaTiempo.setUpdated_by(wsLineaTiempo.getUpdated_by());
        lineaTiempo.setDeleted_by(wsLineaTiempo.getDeleted_by());

        return lineaTiempo;
    }

    public LineaTiempo transformDbToModel(DbLineaTiempo dbLineaTiempo) {
        LineaTiempo lineaTiempo = null;


        int id = dbLineaTiempo.getId();

        lineaTiempo = new LineaTiempo(id);
        lineaTiempo.setId(id);

        lineaTiempo.setOrden_id(dbLineaTiempo.getOrden_id());
        lineaTiempo.setTabla_ref(dbLineaTiempo.getTabla_ref());
        lineaTiempo.setAdicional_ref(dbLineaTiempo.getAdicional_ref());
        lineaTiempo.setReferencia_id(dbLineaTiempo.getReferencia_id());
        lineaTiempo.setCondicion(dbLineaTiempo.getCondicion());
        lineaTiempo.setOrden(dbLineaTiempo.getOrden());
        lineaTiempo.setCod_condicion(dbLineaTiempo.getCod_condicion());
        lineaTiempo.setTipo(dbLineaTiempo.getTipo());
        lineaTiempo.setCod_tipo(dbLineaTiempo.getCod_tipo());
        lineaTiempo.setHora(dbLineaTiempo.getHora());
        lineaTiempo.setDuracion(dbLineaTiempo.getDuracion());
        lineaTiempo.setAccion(dbLineaTiempo.getAccion());
        lineaTiempo.setArea_id(dbLineaTiempo.getArea_id());
        lineaTiempo.setDesc_area(dbLineaTiempo.getDesc_area());
        lineaTiempo.setTarea_rel(dbLineaTiempo.getTarea_rel());
        lineaTiempo.setDesc_tarea_rel(dbLineaTiempo.getDesc_tarea_rel());
        lineaTiempo.setUser_ini_id(dbLineaTiempo.getUser_ini_id());
        lineaTiempo.setInicio(dbLineaTiempo.getInicio());
        lineaTiempo.setUser_fin_id(dbLineaTiempo.getUser_fin_id());
        lineaTiempo.setFin(dbLineaTiempo.getFin());
        lineaTiempo.setObservacion(dbLineaTiempo.getObservacion());
        lineaTiempo.setEstado(dbLineaTiempo.getEstado());
        lineaTiempo.setActivo(dbLineaTiempo.getActivo());
        lineaTiempo.setUp(dbLineaTiempo.getUp());
        lineaTiempo.setCreated_at(dbLineaTiempo.getCreated_at());
        lineaTiempo.setUpdated_at(dbLineaTiempo.getUpdated_at());
        lineaTiempo.setDeleted_at(dbLineaTiempo.getDeleted_at());
        lineaTiempo.setCreated_by(dbLineaTiempo.getCreated_by());
        lineaTiempo.setUpdated_by(dbLineaTiempo.getUpdated_by());
        lineaTiempo.setDeleted_by(dbLineaTiempo.getDeleted_by());


        return lineaTiempo;
    }

    public WsLineaTiempo transformModelToCloud(WorkOrder workOrder) {
        WsLineaTiempo wsWorkOrder = null;

        int id = workOrder.getId();

        wsWorkOrder = new WsLineaTiempo();
        wsWorkOrder.setId(id);

        return wsWorkOrder;
    }


    public DbLineaTiempo transformModelToDb(LineaTiempo lineaTiempo) {
        DbLineaTiempo dbLineaTiempo = null;

        int id = lineaTiempo.getId();

        dbLineaTiempo = new DbLineaTiempo(id);
        dbLineaTiempo.setId(id);

        dbLineaTiempo.setOrden_id(lineaTiempo.getOrden_id());
        dbLineaTiempo.setTabla_ref(lineaTiempo.getTabla_ref());
        dbLineaTiempo.setAdicional_ref(lineaTiempo.getAdicional_ref());
        dbLineaTiempo.setReferencia_id(lineaTiempo.getReferencia_id());
        dbLineaTiempo.setCondicion(lineaTiempo.getCondicion());
        dbLineaTiempo.setOrden(lineaTiempo.getOrden());
        dbLineaTiempo.setCod_condicion(lineaTiempo.getCod_condicion());
        dbLineaTiempo.setTipo(lineaTiempo.getTipo());
        dbLineaTiempo.setCod_tipo(lineaTiempo.getCod_tipo());
        dbLineaTiempo.setHora(lineaTiempo.getHora());
        dbLineaTiempo.setDuracion(lineaTiempo.getDuracion());
        dbLineaTiempo.setAccion(lineaTiempo.getAccion());
        dbLineaTiempo.setArea_id(lineaTiempo.getArea_id());
        dbLineaTiempo.setDesc_area(lineaTiempo.getDesc_area());
        dbLineaTiempo.setTarea_rel(lineaTiempo.getTarea_rel());
        dbLineaTiempo.setDesc_tarea_rel(lineaTiempo.getDesc_tarea_rel());
        dbLineaTiempo.setUser_ini_id(lineaTiempo.getUser_ini_id());
        dbLineaTiempo.setInicio(lineaTiempo.getInicio());
        dbLineaTiempo.setUser_fin_id(lineaTiempo.getUser_fin_id());
        dbLineaTiempo.setFin(lineaTiempo.getFin());
        dbLineaTiempo.setObservacion(lineaTiempo.getObservacion());
        dbLineaTiempo.setEstado(lineaTiempo.getEstado());
        dbLineaTiempo.setActivo(lineaTiempo.getActivo());
        dbLineaTiempo.setUp(lineaTiempo.getUp());
        dbLineaTiempo.setCreated_at(lineaTiempo.getCreated_at());
        dbLineaTiempo.setUpdated_at(lineaTiempo.getUpdated_at());
        dbLineaTiempo.setDeleted_at(lineaTiempo.getDeleted_at());
        dbLineaTiempo.setCreated_by(lineaTiempo.getCreated_by());
        dbLineaTiempo.setUpdated_by(lineaTiempo.getUpdated_by());
        dbLineaTiempo.setDeleted_by(lineaTiempo.getDeleted_by());
       // dbLineaTiempo.setSync(null);

        return dbLineaTiempo;
    }

}
