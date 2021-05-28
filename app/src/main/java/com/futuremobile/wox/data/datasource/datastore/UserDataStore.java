package com.futuremobile.wox.data.datasource.datastore;


import com.futuremobile.wox.domain.repository.RepositoryCallback;

public interface UserDataStore {

    void login(String user,String pass, RepositoryCallback repositoryCallback);

}
