package com.futuremobile.wox.data.datasource.datastore;

import android.content.Context;

import com.futuremobile.wox.data.datasource.cloud.store.CloudSyncDataStore;
import com.futuremobile.wox.data.datasource.db.store.DbSyncDataStore;
import com.futuremobile.wox.presentation.utiles.Constantes;

public class SyncDataStoreFactory {

    private final Context context;

    public SyncDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }


    public SyncDataStore create(int dataSource) {
        SyncDataStore assetDataStore = null;

        switch (dataSource) {
            case Constantes.STORE.CLOUD:
                assetDataStore = new CloudSyncDataStore();
                break;
            case Constantes.STORE.DB:
                assetDataStore = new DbSyncDataStore(context);
                break;
        }
        return assetDataStore;
    }

    private SyncDataStore createCloudDataStore() {
        return new CloudSyncDataStore();
    }
}
