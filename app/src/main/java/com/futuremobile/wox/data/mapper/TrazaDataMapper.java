package com.futuremobile.wox.data.mapper;

import com.futuremobile.wox.data.datasource.cloud.model.sync.WsTrazabilidad;
import com.futuremobile.wox.data.datasource.cloud.model.sync.WsWorkOrder;
import com.futuremobile.wox.data.datasource.db.model.DbTraza;
import com.futuremobile.wox.data.datasource.db.model.DbWorkOrder;
import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.model.WorkOrder;

public class TrazaDataMapper {


    public TrazaDataMapper() {
    }

    public Traza transformCloudToModel(WsTrazabilidad wsTrazabilidad) {
        Traza traza = null;

        int id = wsTrazabilidad.getId();

        traza = new Traza(id);
        traza.setId(id);
        traza.setOrden_id(wsTrazabilidad.getOrden_id());
        traza.setComentario_1(wsTrazabilidad.getComentario_1());
        traza.setComentario_2(wsTrazabilidad.getComentario_2());
        traza.setComentario_3(wsTrazabilidad.getComentario_3());
        traza.setDescripcion(wsTrazabilidad.getDescripcion());
        traza.setEstado(wsTrazabilidad.getEstado());
        traza.setActivo(wsTrazabilidad.getActivo());
        traza.setUp(wsTrazabilidad.getUp());
        traza.setCreated_at(wsTrazabilidad.getCreated_at());
        traza.setUpdated_at(wsTrazabilidad.getUpdated_at());
        traza.setDeleted_at(wsTrazabilidad.getDeleted_at());
        traza.setCreated_by(wsTrazabilidad.getCreated_by());
        traza.setUpdated_by(wsTrazabilidad.getUpdated_by());
        traza.setDeleted_by(wsTrazabilidad.getDeleted_by());

     //   workOrder.setSync(dbWorkOrder.isSync());


        return traza;
    }

    public Traza transformDbToModel(DbTraza dbTraza) {
       Traza traza = null;


        int id = dbTraza.getId();

        traza = new Traza(id);
        traza.setId(id);
        traza.setOrden_id(dbTraza.getOrden_id());
        traza.setComentario_1(dbTraza.getComentario_1());
        traza.setComentario_2(dbTraza.getComentario_2());
        traza.setComentario_3(dbTraza.getComentario_3());
        traza.setDescripcion(dbTraza.getDescripcion());
        traza.setEstado(dbTraza.getEstado());
        traza.setActivo(dbTraza.getActivo());
        traza.setUp(dbTraza.getUp());
        traza.setCreated_at(dbTraza.getCreated_at());
        traza.setUpdated_at(dbTraza.getUpdated_at());
        traza.setDeleted_at(dbTraza.getDeleted_at());
        traza.setCreated_by(dbTraza.getCreated_by());
        traza.setUpdated_by(dbTraza.getUpdated_by());
        traza.setDeleted_by(dbTraza.getDeleted_by());



        return traza;
    }

    public WsWorkOrder transformModelToCloud(WorkOrder workOrder) {
        WsWorkOrder wsWorkOrder = null;

        int id = workOrder.getId();

        wsWorkOrder = new WsWorkOrder();
        wsWorkOrder.setId(id);

        return wsWorkOrder;
    }


    public DbTraza transformModelToDb(Traza traza) {
        DbTraza dbTraza = null;

        int id = traza.getId();

        dbTraza = new DbTraza(id);
        dbTraza.setId(id);
        dbTraza.setOrden_id(traza.getOrden_id());
        dbTraza.setComentario_1(traza.getComentario_1());
        dbTraza.setComentario_2(traza.getComentario_2());
        dbTraza.setComentario_3(traza.getComentario_3());
        dbTraza.setDescripcion(traza.getDescripcion());
        dbTraza.setEstado(traza.getEstado());
        dbTraza.setActivo(traza.getActivo());
        dbTraza.setUp(traza.getUp());
        dbTraza.setCreated_at(traza.getCreated_at());
        dbTraza.setUpdated_at(traza.getUpdated_at());
        dbTraza.setDeleted_at(traza.getDeleted_at());
        dbTraza.setCreated_by(traza.getCreated_by());
        dbTraza.setUpdated_by(traza.getUpdated_by());
        dbTraza.setDeleted_by(traza.getDeleted_by());
        return dbTraza;
    }

}
