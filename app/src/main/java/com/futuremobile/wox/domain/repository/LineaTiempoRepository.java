package com.futuremobile.wox.domain.repository;

import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoCreateCallback;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoFinAccionCallback;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoIniAccionCallback;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoListCallback;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoUpdateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderCreateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderListCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderUpdateCallback;

import java.util.List;

public interface LineaTiempoRepository {

    void getLineaTiempos(LineaTiempoListCallback lineaTiempoListCallback);

    void updateLineaTiempo(int store, LineaTiempo lineaTiempo, LineaTiempoUpdateCallback lineaTiempoUpdateCallback);

    void createLineaTiempo(List<LineaTiempo> lineaTiempos, LineaTiempoCreateCallback lineaTiempoCreateCallback);

    void iniAccion(int store,LineaTiempo lineaTiempo, String fecha, LineaTiempoIniAccionCallback lineaTiempoIniAccionCallback);

    void finAccion(int store,LineaTiempo lineaTiempo, String fecha, String comentario, LineaTiempoFinAccionCallback lineaTiempoFinAccionCallback);

}
