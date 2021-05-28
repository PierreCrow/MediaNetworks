package com.futuremobile.wox.data.datasource.datastore;


import com.futuremobile.wox.domain.repository.RepositoryCallback;

public interface SyncDataStore {

    void sync(String token, RepositoryCallback repositoryCallback);

}
