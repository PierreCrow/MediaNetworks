package com.futuremobile.wox.data.repository;

import com.futuremobile.wox.data.datasource.datastore.TrazaDataStore;
import com.futuremobile.wox.data.datasource.datastore.TrazaDataStoreFactory;
import com.futuremobile.wox.data.datasource.datastore.WorkOrderDataStore;
import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.domain.repository.TrazaRepository;
import com.futuremobile.wox.interactor.traza.TrazaCreateCallback;
import com.futuremobile.wox.interactor.traza.TrazaListCallback;
import com.futuremobile.wox.interactor.traza.TrazaUpdateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderCreateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderListCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderUpdateCallback;
import com.futuremobile.wox.presentation.utiles.Constantes;

import java.util.ArrayList;
import java.util.List;

public class TrazaDataRepository implements TrazaRepository {

    private final TrazaDataStoreFactory trazaDataStoreFactory;

    public TrazaDataRepository(TrazaDataStoreFactory trazaDataStoreFactory) {
        this.trazaDataStoreFactory = trazaDataStoreFactory;
    }

    @Override
    public void getTrazas(TrazaListCallback trazaListCallback) {
        final TrazaDataStore trazaDataStore = trazaDataStoreFactory.create(Constantes.STORE.DB);
        trazaDataStore.getTrazas(new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                trazaListCallback.onTrazaListError(message);
            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<Traza> trazas = (ArrayList<Traza>) object;
                trazaListCallback.onTrazaListSuccess(trazas);
            }
        });
    }

    @Override
    public void updateTraza(int store, Traza traza, TrazaUpdateCallback trazaUpdateCallback) {
        final TrazaDataStore trazaDataStore = trazaDataStoreFactory.create(store);
        trazaDataStore.updateTraza(store, traza, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                trazaUpdateCallback.onWorkOrderUpdateError(message);
            }

            @Override
            public void onSuccess(Object object) {
                Traza traza1 = (Traza) object;
                trazaUpdateCallback.onTrazaUpdateSuccess(traza1);
            }
        });
    }

    @Override
    public void createTrazas(List<Traza> trazas, TrazaCreateCallback trazaCreateCallback) {

        final TrazaDataStore trazaDataStore = trazaDataStoreFactory.create(Constantes.STORE.DB);
        trazaDataStore.createTrazas(trazas, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                trazaCreateCallback.onTrazasCreateError(message);
            }

            @Override
            public void onSuccess(Object object) {
                boolean success = (boolean) object;
                trazaCreateCallback.onTrazasCreateSuccess(success);
            }
        });


    }
}
