package com.futuremobile.wox.data.datasource.db.store;

import android.content.Context;


import com.futuremobile.wox.data.datasource.datastore.UserDataStore;
import com.futuremobile.wox.data.datasource.db.WoxDb;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.presentation.utiles.Helperr;

public class DbUserDataStore implements UserDataStore {

    WoxDb db;

    public DbUserDataStore(Context context) {
        db = Helperr.Inicia_BBDD_LOCAL(context);
    }



    @Override
    public void login(String user, String pass, RepositoryCallback repositoryCallback) {

    }
}
