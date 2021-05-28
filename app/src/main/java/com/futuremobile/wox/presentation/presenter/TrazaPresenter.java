package com.futuremobile.wox.presentation.presenter;


import com.futuremobile.wox.data.datasource.datastore.TrazaDataStoreFactory;
import com.futuremobile.wox.data.datasource.datastore.WorkOrderDataStoreFactory;
import com.futuremobile.wox.data.repository.TrazaDataRepository;
import com.futuremobile.wox.data.repository.WorkOrderDataRepository;
import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.TrazaRepository;
import com.futuremobile.wox.domain.repository.WorkOrderRepository;
import com.futuremobile.wox.interactor.traza.TrazaCreateCallback;
import com.futuremobile.wox.interactor.traza.TrazaInteractor;
import com.futuremobile.wox.interactor.traza.TrazaListCallback;
import com.futuremobile.wox.interactor.traza.TrazaUpdateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderInteractor;
import com.futuremobile.wox.presentation.view.TrazaView;
import com.futuremobile.wox.presentation.view.WorkOrderView;

import java.util.ArrayList;
import java.util.List;

public class TrazaPresenter implements Presenter<TrazaView>,
        TrazaListCallback, TrazaUpdateCallback, TrazaCreateCallback {


    private TrazaView trazaView;
    private TrazaInteractor trazaInteractor;


    public void getTrazas() {
        trazaInteractor.getTrazas(this);
    }

    public void updateTraza(int store, Traza traza) {
        trazaInteractor.updateTraza(store,traza, this);
    }

    public void createTrazas(List<Traza> trazas) {
        trazaInteractor.createTrazas(trazas, this);
    }

    @Override
    public void addView(TrazaView view) {
        this.trazaView = view;
        TrazaRepository trazaRepository = new TrazaDataRepository(new TrazaDataStoreFactory(this.trazaView.getContext()));
        trazaInteractor = new TrazaInteractor(trazaRepository);
    }

    @Override
    public void removeView(TrazaView view) {

    }


    @Override
    public void onTrazasCreateSuccess(boolean created) {
        trazaView.trazasCreateSuccess(created);
    }

    @Override
    public void onTrazasCreateError(String message) {
        trazaView.showErrorMessage(message);
    }

    @Override
    public void onTrazaListSuccess(ArrayList<Traza> trazas) {
        trazaView.trazaListSuccess(trazas);
    }

    @Override
    public void onTrazaListError(String message) {
        trazaView.showErrorMessage(message);
    }

    @Override
    public void onTrazaUpdateSuccess(Traza traza) {
        trazaView.trazaUpdateSuccess(traza);
    }

    @Override
    public void onWorkOrderUpdateError(String message) {
        trazaView.showErrorMessage(message);
    }
}
