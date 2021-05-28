package com.futuremobile.wox.data.datasource.datastore;

import android.content.Context;

import com.futuremobile.wox.data.datasource.cloud.store.CloudSyncDataStore;
import com.futuremobile.wox.data.datasource.cloud.store.CloudWorkOrderDataStore;
import com.futuremobile.wox.data.datasource.db.store.DbSyncDataStore;
import com.futuremobile.wox.data.datasource.db.store.DbWorkOrderDataStore;
import com.futuremobile.wox.presentation.utiles.Constantes;

public class WorkOrderDataStoreFactory {

    private final Context context;

    public WorkOrderDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }


    public WorkOrderDataStore create(int dataSource) {
        WorkOrderDataStore assetDataStore = null;

        switch (dataSource) {
            case Constantes.STORE.CLOUD:
                assetDataStore = new CloudWorkOrderDataStore();
                break;
            case Constantes.STORE.DB:
                assetDataStore = new DbWorkOrderDataStore(context);
                break;
        }
        return assetDataStore;
    }

    private WorkOrderDataStore createCloudDataStore() {
        return new CloudWorkOrderDataStore();
    }
}
