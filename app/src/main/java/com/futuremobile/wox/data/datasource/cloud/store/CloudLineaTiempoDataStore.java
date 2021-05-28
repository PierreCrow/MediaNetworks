package com.futuremobile.wox.data.datasource.cloud.store;

import com.futuremobile.wox.data.datasource.datastore.LineaTiempoDataStore;
import com.futuremobile.wox.data.datasource.datastore.WorkOrderDataStore;
import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.RepositoryCallback;

import java.util.List;

public class CloudLineaTiempoDataStore implements LineaTiempoDataStore {


    public CloudLineaTiempoDataStore() {
    }


    @Override
    public void getLineaTiempos(RepositoryCallback repositoryCallback) {

    }

    @Override
    public void createLineaTiempos(List<LineaTiempo> lineaTiempos, RepositoryCallback repositoryCallback) {

    }

    @Override
    public void updateLineaTiempo(LineaTiempo lineaTiempo, RepositoryCallback repositoryCallback) {

    }

    @Override
    public void iniAccion(LineaTiempo lineaTiempo, String fecha, RepositoryCallback repositoryCallback) {

    }

    @Override
    public void finAccion(LineaTiempo lineaTiempo, String fecha, String comentario, RepositoryCallback repositoryCallback) {

    }
}
