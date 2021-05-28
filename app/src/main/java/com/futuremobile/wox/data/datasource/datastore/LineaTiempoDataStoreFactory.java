package com.futuremobile.wox.data.datasource.datastore;

import android.content.Context;

import com.futuremobile.wox.data.datasource.cloud.store.CloudLineaTiempoDataStore;
import com.futuremobile.wox.data.datasource.cloud.store.CloudWorkOrderDataStore;
import com.futuremobile.wox.data.datasource.db.store.DbLineaTiempoDataStore;
import com.futuremobile.wox.data.datasource.db.store.DbWorkOrderDataStore;
import com.futuremobile.wox.presentation.utiles.Constantes;

public class LineaTiempoDataStoreFactory {

    private final Context context;

    public LineaTiempoDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }


    public LineaTiempoDataStore create(int dataSource) {
        LineaTiempoDataStore assetDataStore = null;

        switch (dataSource) {
            case Constantes.STORE.CLOUD:
                assetDataStore = new CloudLineaTiempoDataStore();
                break;
            case Constantes.STORE.DB:
                assetDataStore = new DbLineaTiempoDataStore(context);
                break;
        }
        return assetDataStore;
    }

    private LineaTiempoDataStore createCloudDataStore() {
        return new CloudLineaTiempoDataStore();
    }
}
