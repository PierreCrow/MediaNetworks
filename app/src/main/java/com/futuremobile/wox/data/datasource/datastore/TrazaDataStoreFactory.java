package com.futuremobile.wox.data.datasource.datastore;

import android.content.Context;

import com.futuremobile.wox.data.datasource.cloud.store.CloudTrazaDataStore;
import com.futuremobile.wox.data.datasource.cloud.store.CloudWorkOrderDataStore;
import com.futuremobile.wox.data.datasource.db.store.DbTrazaDataStore;
import com.futuremobile.wox.data.datasource.db.store.DbWorkOrderDataStore;
import com.futuremobile.wox.presentation.utiles.Constantes;

public class TrazaDataStoreFactory {

    private final Context context;

    public TrazaDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }


    public TrazaDataStore create(int dataSource) {
        TrazaDataStore assetDataStore = null;

        switch (dataSource) {
            case Constantes.STORE.CLOUD:
                assetDataStore = new CloudTrazaDataStore();
                break;
            case Constantes.STORE.DB:
                assetDataStore = new DbTrazaDataStore(context);
                break;
        }
        return assetDataStore;
    }

    private TrazaDataStore createCloudDataStore() {
        return new CloudTrazaDataStore();
    }
}
