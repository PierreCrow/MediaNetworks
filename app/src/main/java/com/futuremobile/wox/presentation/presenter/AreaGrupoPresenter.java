package com.futuremobile.wox.presentation.presenter;


import com.futuremobile.wox.data.datasource.datastore.AreaGrupoDataStoreFactory;
import com.futuremobile.wox.data.datasource.datastore.TrazaDataStoreFactory;
import com.futuremobile.wox.data.repository.AreaGrupoDataRepository;
import com.futuremobile.wox.data.repository.TrazaDataRepository;
import com.futuremobile.wox.domain.model.AreaGrupo;
import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.repository.AreaGrupoRepository;
import com.futuremobile.wox.domain.repository.TrazaRepository;
import com.futuremobile.wox.interactor.areagrupo.AreaGrupoCreateCallback;
import com.futuremobile.wox.interactor.areagrupo.AreaGrupoInteractor;
import com.futuremobile.wox.interactor.areagrupo.AreaGrupoListCallback;
import com.futuremobile.wox.interactor.traza.TrazaCreateCallback;
import com.futuremobile.wox.interactor.traza.TrazaInteractor;
import com.futuremobile.wox.interactor.traza.TrazaListCallback;
import com.futuremobile.wox.interactor.traza.TrazaUpdateCallback;
import com.futuremobile.wox.presentation.view.AreaGrupoView;

import java.util.ArrayList;
import java.util.List;

public class AreaGrupoPresenter implements Presenter<AreaGrupoView>,
        AreaGrupoListCallback, AreaGrupoCreateCallback {


    private AreaGrupoView areaGrupoView;
    private AreaGrupoInteractor areaGrupoInteractor;


    public void getAreaGrupos() {
        areaGrupoInteractor.getAreaGrupos(this);
    }


    public void createAreaGrupos(List<AreaGrupo> areaGrupos) {
        areaGrupoInteractor.createAreaGrupos(areaGrupos, this);
    }
    @Override
    public void addView(AreaGrupoView view) {
        this.areaGrupoView = view;
        AreaGrupoRepository areaGrupoRepository = new AreaGrupoDataRepository(new AreaGrupoDataStoreFactory(this.areaGrupoView.getContext()));
        areaGrupoInteractor = new AreaGrupoInteractor(areaGrupoRepository);
    }

    @Override
    public void removeView(AreaGrupoView view) {

    }


    @Override
    public void onAreaGruposCreateSuccess(boolean created) {
        areaGrupoView.areaGruposCreateSuccess(created);
    }

    @Override
    public void onAreaGruposCreateError(String message) {
        areaGrupoView.showErrorMessage(message);
    }

    @Override
    public void onAreaGrupoListSuccess(ArrayList<AreaGrupo> areaGrupos) {
        areaGrupoView.areaGrupoListSuccess(areaGrupos);
    }

    @Override
    public void onAreaGrupoListError(String message) {
        areaGrupoView.showErrorMessage(message);
    }
}
