package com.futuremobile.wox.interactor.lineatiempo;

import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.LineaTiempoRepository;
import com.futuremobile.wox.domain.repository.WorkOrderRepository;
import com.futuremobile.wox.interactor.workorder.WorkOrderCreateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderListCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderUpdateCallback;

import java.util.List;

public class LineaTiempoInteractor {

    private final LineaTiempoRepository lineaTiempoRepository;

    public LineaTiempoInteractor(LineaTiempoRepository lineaTiempoRepository) {
        this.lineaTiempoRepository = lineaTiempoRepository;
    }

    public void getLineaTiempos(LineaTiempoListCallback lineaTiempoListCallback) {
        lineaTiempoRepository.getLineaTiempos(lineaTiempoListCallback);
    }

    public void updateLineaTiempo(int store, LineaTiempo lineaTiempo, LineaTiempoUpdateCallback lineaTiempoUpdateCallback) {
        lineaTiempoRepository.updateLineaTiempo(store,lineaTiempo, lineaTiempoUpdateCallback);
    }

    public void createLineaTiempo(List<LineaTiempo> lineaTiempos, LineaTiempoCreateCallback lineaTiempoCreateCallback) {
        lineaTiempoRepository.createLineaTiempo(lineaTiempos, lineaTiempoCreateCallback);
    }

    public void iniAccion(int store,LineaTiempo lineaTiempo,String fecha, LineaTiempoIniAccionCallback lineaTiempoIniAccionCallback) {
        lineaTiempoRepository.iniAccion(store,lineaTiempo,fecha, lineaTiempoIniAccionCallback);
    }

    public void finAccion(int store,LineaTiempo lineaTiempo,String fecha,String comentario, LineaTiempoFinAccionCallback lineaTiempoFinAccionCallback) {
        lineaTiempoRepository.finAccion(store,lineaTiempo,fecha,comentario, lineaTiempoFinAccionCallback);
    }

}
