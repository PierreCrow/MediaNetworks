package com.futuremobile.wox.data.datasource.datastore;

import android.content.Context;

import com.futuremobile.wox.data.datasource.cloud.store.CloudAreaGrupoDataStore;
import com.futuremobile.wox.data.datasource.cloud.store.CloudWorkOrderDataStore;
import com.futuremobile.wox.data.datasource.db.store.DbAreaGrupoDataStore;
import com.futuremobile.wox.data.datasource.db.store.DbWorkOrderDataStore;
import com.futuremobile.wox.presentation.utiles.Constantes;

public class AreaGrupoDataStoreFactory {

    private final Context context;

    public AreaGrupoDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }


    public AreaGrupoDataStore create(int dataSource) {
        AreaGrupoDataStore assetDataStore = null;

        switch (dataSource) {
            case Constantes.STORE.CLOUD:
                assetDataStore = new CloudAreaGrupoDataStore();
                break;
            case Constantes.STORE.DB:
                assetDataStore = new DbAreaGrupoDataStore(context);
                break;
        }
        return assetDataStore;
    }

    private AreaGrupoDataStore createCloudDataStore() {
        return new CloudAreaGrupoDataStore();
    }
}
