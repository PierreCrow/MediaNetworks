package com.futuremobile.wox.data.repository;

import com.futuremobile.wox.data.datasource.datastore.LineaTiempoDataStore;
import com.futuremobile.wox.data.datasource.datastore.LineaTiempoDataStoreFactory;
import com.futuremobile.wox.data.datasource.datastore.WorkOrderDataStore;
import com.futuremobile.wox.data.datasource.datastore.WorkOrderDataStoreFactory;
import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.LineaTiempoRepository;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.domain.repository.WorkOrderRepository;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoCreateCallback;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoFinAccionCallback;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoIniAccionCallback;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoListCallback;
import com.futuremobile.wox.interactor.lineatiempo.LineaTiempoUpdateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderCreateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderListCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderUpdateCallback;
import com.futuremobile.wox.presentation.utiles.Constantes;

import java.util.ArrayList;
import java.util.List;

public class LineaTiempoDataRepository implements LineaTiempoRepository {

    private final LineaTiempoDataStoreFactory lineaTiempoDataStoreFactory;

    public LineaTiempoDataRepository(LineaTiempoDataStoreFactory lineaTiempoDataStoreFactory) {
        this.lineaTiempoDataStoreFactory = lineaTiempoDataStoreFactory;
    }



    @Override
    public void getLineaTiempos(LineaTiempoListCallback lineaTiempoListCallback) {
        final LineaTiempoDataStore lineaTiempoDataStore = lineaTiempoDataStoreFactory.create(Constantes.STORE.DB);
        lineaTiempoDataStore.getLineaTiempos(new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                lineaTiempoListCallback.onLineaTiempoListError(message);
            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<LineaTiempo> lineaTiempos= (ArrayList<LineaTiempo>) object;
                lineaTiempoListCallback.onLineaTiempoListSuccess(lineaTiempos);
            }
        });
    }

    @Override
    public void updateLineaTiempo(int store, LineaTiempo lineaTiempo, LineaTiempoUpdateCallback lineaTiempoUpdateCallback) {
        final LineaTiempoDataStore lineaTiempoDataStore = lineaTiempoDataStoreFactory.create(store);
        lineaTiempoDataStore.updateLineaTiempo(lineaTiempo,new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                lineaTiempoUpdateCallback.onLineaTiempoUpdateError(message);
            }

            @Override
            public void onSuccess(Object object) {
                LineaTiempo lineaTiempo= (LineaTiempo) object;
                lineaTiempoUpdateCallback.onLineaTiempoUpdateSuccess(lineaTiempo);
            }
        });
    }

    @Override
    public void createLineaTiempo(List<LineaTiempo> lineaTiempos, LineaTiempoCreateCallback lineaTiempoCreateCallback) {

        final LineaTiempoDataStore lineaTiempoDataStore = lineaTiempoDataStoreFactory.create(Constantes.STORE.DB);
        lineaTiempoDataStore.createLineaTiempos(lineaTiempos,new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                lineaTiempoCreateCallback.onLineaTiemposCreateError(message);
            }

            @Override
            public void onSuccess(Object object) {
                boolean success= (boolean) object;
                lineaTiempoCreateCallback.onLineaTiemposCreateSuccess(success);
            }
        });


    }

    @Override
    public void iniAccion(int store,LineaTiempo lineaTiempo, String fecha, LineaTiempoIniAccionCallback lineaTiempoIniAccionCallback) {

        final LineaTiempoDataStore lineaTiempoDataStore = lineaTiempoDataStoreFactory.create(store);
        lineaTiempoDataStore.iniAccion(lineaTiempo,fecha,new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                lineaTiempoIniAccionCallback.onLineaTiempoIniAccionError(message);
            }

            @Override
            public void onSuccess(Object object) {
                boolean success= (boolean) object;
                lineaTiempoIniAccionCallback.onLineaTiempoIniAccionSuccess(success);
            }
        });
    }

    @Override
    public void finAccion(int store,LineaTiempo lineaTiempo, String fecha, String comentario, LineaTiempoFinAccionCallback lineaTiempoFinAccionCallback) {

        final LineaTiempoDataStore lineaTiempoDataStore = lineaTiempoDataStoreFactory.create(store);
        lineaTiempoDataStore.finAccion(lineaTiempo,fecha,comentario,new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                lineaTiempoFinAccionCallback.onLineaTiempoFinAccionError(message);
            }

            @Override
            public void onSuccess(Object object) {
                boolean success= (boolean) object;
                lineaTiempoFinAccionCallback.onLineaTiempoFinAccionSuccess(success);
            }
        });

    }
}
