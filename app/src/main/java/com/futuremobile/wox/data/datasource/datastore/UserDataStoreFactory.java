package com.futuremobile.wox.data.datasource.datastore;

import android.content.Context;

import com.futuremobile.wox.data.datasource.cloud.store.CloudUserDataStore;
import com.futuremobile.wox.data.datasource.db.store.DbUserDataStore;
import com.futuremobile.wox.presentation.utiles.Constantes;

public class UserDataStoreFactory {

    private final Context context;

    public UserDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }


    public UserDataStore create(int dataSource) {
        UserDataStore userDataStore = null;

        switch (dataSource) {
            case Constantes.STORE.CLOUD:
                userDataStore = new CloudUserDataStore();
                break;
            case Constantes.STORE.DB:
                userDataStore = new DbUserDataStore(context);
                break;
        }
        return userDataStore;
    }

    private UserDataStore createCloudDataStore() {
        return new CloudUserDataStore();
    }
}
