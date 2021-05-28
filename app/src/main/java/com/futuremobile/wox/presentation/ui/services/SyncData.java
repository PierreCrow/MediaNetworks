package com.futuremobile.wox.presentation.ui.services;


import android.content.Context;

import com.futuremobile.wox.data.datasource.cloud.model.sync.WsAreaGrupo;
import com.futuremobile.wox.data.datasource.cloud.model.sync.WsLineaTiempo;
import com.futuremobile.wox.data.datasource.cloud.model.sync.WsSync;
import com.futuremobile.wox.data.datasource.cloud.model.sync.WsTrazabilidad;
import com.futuremobile.wox.data.datasource.cloud.model.sync.WsWorkOrder;
import com.futuremobile.wox.data.datasource.db.WoxDb;
import com.futuremobile.wox.data.mapper.AreaGrupoDataMapper;
import com.futuremobile.wox.data.mapper.LineaTiempoDataMapper;
import com.futuremobile.wox.data.mapper.TrazaDataMapper;
import com.futuremobile.wox.data.mapper.WorkOrderDataMapper;
import com.futuremobile.wox.domain.model.AreaGrupo;
import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.presentation.presenter.AreaGrupoPresenter;
import com.futuremobile.wox.presentation.presenter.LineaTiempoPresenter;
import com.futuremobile.wox.presentation.presenter.SyncPresenter;
import com.futuremobile.wox.presentation.presenter.TrazaPresenter;
import com.futuremobile.wox.presentation.presenter.WorkOrderPresenter;
import com.futuremobile.wox.presentation.utiles.Constantes;
import com.futuremobile.wox.presentation.view.AreaGrupoView;
import com.futuremobile.wox.presentation.view.LineaTiempoView;
import com.futuremobile.wox.presentation.view.SyncView;
import com.futuremobile.wox.presentation.view.TrazaView;
import com.futuremobile.wox.presentation.view.WorkOrderView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SyncData implements SyncView, WorkOrderView, LineaTiempoView, AreaGrupoView, TrazaView {

    Context context;
    String token;

    SyncPresenter syncPresenter;

    AreaGrupoPresenter areaGrupoPresenter;
    List<AreaGrupo> areaGrupos;
    List<AreaGrupo> cloudAreaGrupos;
    List<AreaGrupo> newAreaGrupos;

    TrazaPresenter trazaPresenter;
    List<Traza> trazas;
    List<Traza> cloudTrazas;
    List<Traza> newTrazas;

    WorkOrderPresenter workOrderPresenter;
    List<WorkOrder> workOrders;
    List<WorkOrder> cloudWorkOrders;
    List<WorkOrder> newWorkOrders;
    List<WorkOrder> toUpdate;


    LineaTiempoPresenter lineaTiempoPresenter;

    List<LineaTiempo> lineaTiempos;
    List<LineaTiempo> cloudLineaTiempos;
    List<LineaTiempo> newLineaTiempos;
    List<LineaTiempo> toUpdateLineaTiempo;


    public SyncData(Context context, WoxDb db, String token) {
        this.context = context;
        this.token = token;

    }


    public void syncNewAll() {
        workOrderPresenter = new WorkOrderPresenter();
        workOrderPresenter.addView(this);
        workOrderPresenter.getWorkOrders();
    }

    public void updateAllNew() {

        toUpdate = new ArrayList<>();

        for (WorkOrder workOrder : workOrders) {
            if (!workOrder.isSync()) {
                toUpdate.add(workOrder);
            }
        }

        if (toUpdate.size() > 0) {
            for (WorkOrder workOrder : toUpdate) {
                //   workOrderPresenter.updateWorkOrder(Constantes.STORE.DB, workOrder);
            }
        }

        //--------------------------------------------------------


        toUpdateLineaTiempo = new ArrayList<>();

        for (LineaTiempo lineaTiempo : lineaTiempos) {
            if (!lineaTiempo.isSync()) {
                toUpdateLineaTiempo.add(lineaTiempo);
            }
        }

        if(toUpdateLineaTiempo.size()>0)
        {
            for(LineaTiempo lineaTiempo:toUpdateLineaTiempo)
            {
                if(lineaTiempo.getFin()!=null)
                {
                    lineaTiempoPresenter.iniAccion(Constantes.STORE.CLOUD,lineaTiempo,lineaTiempo.getInicio());
                    lineaTiempoPresenter.finAccion(Constantes.STORE.CLOUD,lineaTiempo,lineaTiempo.getFin(),lineaTiempo.getObservacion());
                }
                else
                {
                    if(lineaTiempo.getInicio()!=null)
                    {
                        lineaTiempoPresenter.iniAccion(Constantes.STORE.CLOUD,lineaTiempo,lineaTiempo.getInicio());
                    }
                }
            }
        }


    }



    @Override
    public void syncSuccess(WsSync wsSync) {

        WorkOrderDataMapper workOrderDataMapper = new WorkOrderDataMapper();


        newWorkOrders = new ArrayList<>();
        cloudWorkOrders = new ArrayList<>();


        for (WsWorkOrder wsWorkOrder : wsSync.getWsWorkOrders()) {
            cloudWorkOrders.add(workOrderDataMapper.transformCloudToModel(wsWorkOrder));
        }


        if (workOrders.size() == 0) {
            for (WorkOrder workOrder : cloudWorkOrders) {
                newWorkOrders.add(workOrder);
            }
        } else {
            // si hay mas items en cloud entonces ingresar nuevos items a db
            if (cloudWorkOrders.size() > workOrders.size()) {
                for (int i = 0; i < cloudWorkOrders.size(); i++) {
                    for (int z = 0; z < workOrders.size(); z++) {
                        if (cloudWorkOrders.get(i).getId() != workOrders.get(z).getId()
                            //   && cloudWorkOrders.get(i).getEstado()==Constantes.ESTADO_WORK_ORDER.PLANEADO
                        ) {
                            newWorkOrders.add(cloudWorkOrders.get(i));
                        }
                    }
                }
            }
        }


        //si es que hay nuebos items , crear items en db
        if (newWorkOrders.size() > 0) {
            workOrderPresenter.createWorkOrders(newWorkOrders);
        } else {
            //  updateAllNew();
        }


        //------------ LINEA TIEMPO

        LineaTiempoDataMapper lineaTiempoDataMapper = new LineaTiempoDataMapper();
        cloudLineaTiempos = new ArrayList<>();
        newLineaTiempos = new ArrayList<>();

        for (WsLineaTiempo wsLineaTiempo : wsSync.getWsLineaTiempos()) {
            cloudLineaTiempos.add(lineaTiempoDataMapper.transformCloudToModel(wsLineaTiempo));
        }


        if (lineaTiempos.size() == 0) {
            for (LineaTiempo lineaTiempo : cloudLineaTiempos) {
                newLineaTiempos.add(lineaTiempo);
            }
        } else {
            // si hay mas items en cloud entonces ingresar nuevos items a db
            if (cloudLineaTiempos.size() > lineaTiempos.size()) {
                for (int i = 0; i < cloudLineaTiempos.size(); i++) {
                    for (int z = 0; z < lineaTiempos.size(); z++) {
                        if (cloudLineaTiempos.get(i).getId() != lineaTiempos.get(z).getId()) {
                            newLineaTiempos.add(cloudLineaTiempos.get(i));
                        }
                    }
                }
            }
        }

        if (newLineaTiempos.size() > 0) {
            lineaTiempoPresenter.createLineaTiempo(newLineaTiempos);
        } else {
            // updateAllNew();
        }


        //------------ AREA GRUPO

        AreaGrupoDataMapper areaGrupoDataMapper = new AreaGrupoDataMapper();
        cloudAreaGrupos = new ArrayList<>();
        newAreaGrupos = new ArrayList<>();

        for (WsAreaGrupo wsAreaGrupo : wsSync.getWsAreaGrupos()) {
            cloudAreaGrupos.add(areaGrupoDataMapper.transformCloudToModel(wsAreaGrupo));
        }

        if (areaGrupos.size() == 0) {
            for (AreaGrupo areaGrupo : cloudAreaGrupos) {
                newAreaGrupos.add(areaGrupo);
            }
        } else {
            // si hay mas items en cloud entonces ingresar nuevos items a db
            if (cloudAreaGrupos.size() > areaGrupos.size()) {
                for (int i = 0; i < cloudAreaGrupos.size(); i++) {
                    for (int z = 0; z < areaGrupos.size(); z++) {
                        if (cloudAreaGrupos.get(i).getId() != areaGrupos.get(z).getId()) {
                            newAreaGrupos.add(cloudAreaGrupos.get(i));
                        }
                    }
                }
            }
        }

        if (newAreaGrupos.size() > 0) {
            areaGrupoPresenter.createAreaGrupos(newAreaGrupos);
        } else {
            // updateAllNew();
        }



        //------------ TRAZA

        TrazaDataMapper trazaDataMapper = new TrazaDataMapper();
        cloudTrazas = new ArrayList<>();
        newTrazas = new ArrayList<>();

        for (WsTrazabilidad wsTrazabilidad : wsSync.getWsTrazabilidads()) {
            cloudTrazas.add(trazaDataMapper.transformCloudToModel(wsTrazabilidad));
        }


        if (trazas.size() == 0) {
            for (Traza traza : cloudTrazas) {
                newTrazas.add(traza);
            }
        } else {
            // si hay mas items en cloud entonces ingresar nuevos items a db
            if (cloudTrazas.size() > trazas.size()) {
                for (int i = 0; i < cloudTrazas.size(); i++) {
                    for (int z = 0; z < trazas.size(); z++) {
                        if (cloudTrazas.get(i).getId() != trazas.get(z).getId()) {
                            newTrazas.add(cloudTrazas.get(i));
                        }
                    }
                }
            }
        }

        if (newTrazas.size() > 0) {
            trazaPresenter.createTrazas(newTrazas);
        } else {
            // updateAllNew();
        }


    }

    @Override
    public void requestSyncSuccess(boolean sync) {

    }

    @Override
    public void workOrderListSuccess(ArrayList<WorkOrder> workOrders) {
        this.workOrders = workOrders;

        lineaTiempoPresenter = new LineaTiempoPresenter();
        lineaTiempoPresenter.addView(this);
        lineaTiempoPresenter.getLineaTiempos();


    }

    @Override
    public void workOrdersCreateSuccess(boolean success) {

        //   updateAllNew();
    }

    @Override
    public void workOrderUpdateSuccess(WorkOrder workOrder) {

        if (workOrder != null) {
            //   workOrderPresenter.updateWorkOrder(Constantes.STORE.DB, workOrder);
        }

    }

    @Override
    public void lineaTiempoListSuccess(ArrayList<LineaTiempo> lineaTiempos) {

        this.lineaTiempos = lineaTiempos;

        areaGrupoPresenter= new AreaGrupoPresenter();
        areaGrupoPresenter.addView(this);
        areaGrupoPresenter.getAreaGrupos();



    }

    @Override
    public void lineaTiemposCreateSuccess(boolean success) {

    }

    @Override
    public void lineaTiemposIniAccionSuccess(boolean success) {

        //actualizar campo sync
    }

    @Override
    public void lineaTiemposFinAccionSuccess(boolean success) {

        //actualizar campo sync
    }

    @Override
    public void lineaTiempoUpdateSuccess(LineaTiempo lineaTiempo) {

    }

    @Override
    public void areaGrupoListSuccess(ArrayList<AreaGrupo> areaGrupos) {

        this.areaGrupos=areaGrupos;

        trazaPresenter= new TrazaPresenter();
        trazaPresenter.addView(this);
        trazaPresenter.getTrazas();


    }

    @Override
    public void areaGruposCreateSuccess(boolean success) {

    }

    @Override
    public void trazaListSuccess(ArrayList<Traza> trazas) {

        this.trazas=trazas;

        syncPresenter = new SyncPresenter();
        syncPresenter.addView(this);
        syncPresenter.sync(token);
    }

    @Override
    public void trazasCreateSuccess(boolean success) {

    }

    @Override
    public void trazaUpdateSuccess(Traza traza) {

    }

    @Override
    public void showErrorMessage(String message) {
        String menaje = message;

    }

    @Override
    public Context getContext() {
        return context;
    }


}
