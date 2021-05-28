package com.futuremobile.wox.data.mapper;

import com.futuremobile.wox.data.datasource.cloud.model.sync.WsAreaGrupo;
import com.futuremobile.wox.data.datasource.cloud.model.sync.WsWorkOrder;
import com.futuremobile.wox.data.datasource.db.model.DbAreaGrupo;
import com.futuremobile.wox.data.datasource.db.model.DbWorkOrder;
import com.futuremobile.wox.domain.model.AreaGrupo;
import com.futuremobile.wox.domain.model.WorkOrder;

public class AreaGrupoDataMapper {


    public AreaGrupoDataMapper() {
    }

    public AreaGrupo transformCloudToModel(WsAreaGrupo wsAreaGrupo) {
        AreaGrupo areaGrupo = null;

        int id = wsAreaGrupo.getId();

        areaGrupo = new AreaGrupo(id);
        areaGrupo.setId(id);
        areaGrupo.setTipo(wsAreaGrupo.getTipo());
        areaGrupo.setCodigo(wsAreaGrupo.getCodigo());
        areaGrupo.setNombre(wsAreaGrupo.getNombre());
        areaGrupo.setEs_responsable(wsAreaGrupo.getEs_responsable());
        areaGrupo.setEs_ejecutor(wsAreaGrupo.getEs_ejecutor());
        areaGrupo.setEs_aprobador(wsAreaGrupo.getEs_aprobador());
        areaGrupo.setActivo(wsAreaGrupo.getActivo());
        areaGrupo.setUp(wsAreaGrupo.getUp());
        areaGrupo.setCreated_at(wsAreaGrupo.getCreated_at());
        areaGrupo.setUpdated_at(wsAreaGrupo.getUpdated_at());
        areaGrupo.setDeleted_at(wsAreaGrupo.getDeleted_at());
        areaGrupo.setCreated_by(wsAreaGrupo.getCreated_by());
        areaGrupo.setUpdated_by(wsAreaGrupo.getUpdated_by());
        areaGrupo.setDeleted_by(wsAreaGrupo.getDeleted_by());
     //   workOrder.setSync(dbWorkOrder.isSync());

        return areaGrupo;
    }

    public AreaGrupo transformDbToModel(DbAreaGrupo wsAreaGrupo) {
        AreaGrupo areaGrupo = null;

        int id = wsAreaGrupo.getId();

        areaGrupo = new AreaGrupo(id);
        areaGrupo.setId(id);
        areaGrupo.setTipo(wsAreaGrupo.getTipo());
        areaGrupo.setCodigo(wsAreaGrupo.getCodigo());
        areaGrupo.setNombre(wsAreaGrupo.getNombre());
        areaGrupo.setEs_responsable(wsAreaGrupo.getEs_responsable());
        areaGrupo.setEs_ejecutor(wsAreaGrupo.getEs_ejecutor());
        areaGrupo.setEs_aprobador(wsAreaGrupo.getEs_aprobador());
        areaGrupo.setActivo(wsAreaGrupo.getActivo());
        areaGrupo.setUp(wsAreaGrupo.getUp());
        areaGrupo.setCreated_at(wsAreaGrupo.getCreated_at());
        areaGrupo.setUpdated_at(wsAreaGrupo.getUpdated_at());
        areaGrupo.setDeleted_at(wsAreaGrupo.getDeleted_at());
        areaGrupo.setCreated_by(wsAreaGrupo.getCreated_by());
        areaGrupo.setUpdated_by(wsAreaGrupo.getUpdated_by());
        areaGrupo.setDeleted_by(wsAreaGrupo.getDeleted_by());

        return areaGrupo;
    }

    public WsWorkOrder transformModelToCloud(WorkOrder workOrder) {
        WsWorkOrder wsWorkOrder = null;

        int id = workOrder.getId();

        wsWorkOrder = new WsWorkOrder();
        wsWorkOrder.setId(id);

        return wsWorkOrder;
    }


    public DbAreaGrupo transformModelToDb(AreaGrupo wsAreaGrupo) {
        DbAreaGrupo dbAreaGrupo = null;

        int id = wsAreaGrupo.getId();

        dbAreaGrupo = new DbAreaGrupo(id);
        dbAreaGrupo.setId(id);
        dbAreaGrupo.setTipo(wsAreaGrupo.getTipo());
        dbAreaGrupo.setCodigo(wsAreaGrupo.getCodigo());
        dbAreaGrupo.setNombre(wsAreaGrupo.getNombre());
        dbAreaGrupo.setEs_responsable(wsAreaGrupo.getEs_responsable());
        dbAreaGrupo.setEs_ejecutor(wsAreaGrupo.getEs_ejecutor());
        dbAreaGrupo.setEs_aprobador(wsAreaGrupo.getEs_aprobador());
        dbAreaGrupo.setActivo(wsAreaGrupo.getActivo());
        dbAreaGrupo.setUp(wsAreaGrupo.getUp());
        dbAreaGrupo.setCreated_at(wsAreaGrupo.getCreated_at());
        dbAreaGrupo.setUpdated_at(wsAreaGrupo.getUpdated_at());
        dbAreaGrupo.setDeleted_at(wsAreaGrupo.getDeleted_at());
        dbAreaGrupo.setCreated_by(wsAreaGrupo.getCreated_by());
        dbAreaGrupo.setUpdated_by(wsAreaGrupo.getUpdated_by());
        dbAreaGrupo.setDeleted_by(wsAreaGrupo.getDeleted_by());
        dbAreaGrupo.setSync(true);
        return dbAreaGrupo;
    }

}
