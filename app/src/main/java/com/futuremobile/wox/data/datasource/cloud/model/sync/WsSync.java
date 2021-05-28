package com.futuremobile.wox.data.datasource.cloud.model.sync;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WsSync {

    @SerializedName("ordenes")
    @Expose
    List<WsWorkOrder> wsWorkOrders= null;

    @SerializedName("linea_tiempo")
    @Expose
    List<WsLineaTiempo> wsLineaTiempos= null;


    @SerializedName("areas")
    @Expose
    List<WsAreaGrupo> wsAreaGrupos = null;


    @SerializedName("trazas")
    @Expose
    List<WsTrazabilidad> wsTrazabilidads= null;



    public List<WsWorkOrder> getWsWorkOrders() {
        return wsWorkOrders;
    }

    public void setWsWorkOrders(List<WsWorkOrder> wsWorkOrders) {
        this.wsWorkOrders = wsWorkOrders;
    }

    public List<WsLineaTiempo> getWsLineaTiempos() {
        return wsLineaTiempos;
    }

    public void setWsLineaTiempos(List<WsLineaTiempo> wsLineaTiempos) {
        this.wsLineaTiempos = wsLineaTiempos;
    }


    public List<WsAreaGrupo> getWsAreaGrupos() {
        return wsAreaGrupos;
    }

    public void setWsAreaGrupos(List<WsAreaGrupo> wsAreaGrupos) {
        this.wsAreaGrupos = wsAreaGrupos;
    }

    public List<WsTrazabilidad> getWsTrazabilidads() {
        return wsTrazabilidads;
    }

    public void setWsTrazabilidads(List<WsTrazabilidad> wsTrazabilidads) {
        this.wsTrazabilidads = wsTrazabilidads;
    }
}
