package com.futuremobile.wox.presentation.presenter;


import com.futuremobile.wox.data.datasource.datastore.LineaTiempoDataStoreFactory;
import com.futuremobile.wox.data.datasource.datastore.WorkOrderDataStoreFactory;
import com.futuremobile.wox.data.repository.LineaTiempoDataRepository;
import com.futuremobile.wox.data.repository.WorkOrderDataRepository;
import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.LineaTiempoRepository;
import com.futuremobile.wox.domain.repository.WorkOrderRepository;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoCreateCallback;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoFinAccionCallback;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoIniAccionCallback;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoInteractor;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoListCallback;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoUpdateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderInteractor;
import com.futuremobile.wox.presentation.view.LineaTiempoView;
import com.futuremobile.wox.presentation.view.WorkOrderView;

import java.util.ArrayList;
import java.util.List;

public class LineaTiempoPresenter implements Presenter<LineaTiempoView>,
        LineaTiempoListCallback, LineaTiempoUpdateCallback, LineaTiempoCreateCallback,LineaTiempoIniAccionCallback,LineaTiempoFinAccionCallback {


    private LineaTiempoView lineaTiempoView;
    private LineaTiempoInteractor lineaTiempoInteractor;


    public void getLineaTiempos() {
        lineaTiempoInteractor.getLineaTiempos(this);
    }


    public void updateLineaTiempo(int store, LineaTiempo lineaTiempo) {
        lineaTiempoInteractor.updateLineaTiempo(store,lineaTiempo, this);
    }

    public void createLineaTiempo(List<LineaTiempo> lineaTiempos) {
        lineaTiempoInteractor.createLineaTiempo(lineaTiempos, this);
    }


    public void iniAccion(int store,LineaTiempo lineaTiempo,String fecha) {
        lineaTiempoInteractor.iniAccion(store,lineaTiempo,fecha, this);
    }

    public void finAccion(int store,LineaTiempo lineaTiempo,String fecha,String comentario) {
        lineaTiempoInteractor.finAccion(store,lineaTiempo,fecha,comentario, this);
    }


    @Override
    public void addView(LineaTiempoView view) {
        this.lineaTiempoView = view;
        LineaTiempoRepository syncRepository = new LineaTiempoDataRepository(new LineaTiempoDataStoreFactory(this.lineaTiempoView.getContext()));
        lineaTiempoInteractor = new LineaTiempoInteractor(syncRepository);
    }

    @Override
    public void removeView(LineaTiempoView view) {

    }


    @Override
    public void onLineaTiemposCreateSuccess(boolean created) {
        lineaTiempoView.lineaTiemposCreateSuccess(created);
    }

    @Override
    public void onLineaTiemposCreateError(String message) {
        lineaTiempoView.showErrorMessage(message);
    }

    @Override
    public void onLineaTiempoListSuccess(ArrayList<LineaTiempo> lineaTiempos) {
        lineaTiempoView.lineaTiempoListSuccess(lineaTiempos);
    }

    @Override
    public void onLineaTiempoListError(String message) {
        lineaTiempoView.showErrorMessage(message);
    }

    @Override
    public void onLineaTiempoUpdateSuccess(LineaTiempo lineaTiempo) {
        lineaTiempoView.lineaTiempoUpdateSuccess(lineaTiempo);
    }

    @Override
    public void onLineaTiempoUpdateError(String message) {
        lineaTiempoView.showErrorMessage(message);
    }

    @Override
    public void onLineaTiempoFinAccionSuccess(boolean success) {
        lineaTiempoView.lineaTiemposFinAccionSuccess(success);
    }

    @Override
    public void onLineaTiempoFinAccionError(String message) {
        lineaTiempoView.showErrorMessage(message);
    }

    @Override
    public void onLineaTiempoIniAccionSuccess(boolean success) {
        lineaTiempoView.lineaTiemposIniAccionSuccess(success);
    }

    @Override
    public void onLineaTiempoIniAccionError(String message) {
        lineaTiempoView.showErrorMessage(message);
    }
}
