package com.futuremobile.wox.data.datasource.db.store;

import android.content.Context;

import com.futuremobile.wox.data.datasource.datastore.SyncDataStore;
import com.futuremobile.wox.data.datasource.db.WoxDb;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.presentation.utiles.Helperr;

public class DbSyncDataStore implements SyncDataStore {

    WoxDb db;

    public DbSyncDataStore(Context context) {
        db = Helperr.Inicia_BBDD_LOCAL(context);
    }


    @Override
    public void sync(String token, RepositoryCallback repositoryCallback) {

    }
}
