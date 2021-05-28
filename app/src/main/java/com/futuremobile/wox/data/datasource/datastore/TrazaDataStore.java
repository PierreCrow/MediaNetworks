package com.futuremobile.wox.data.datasource.datastore;


import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.repository.RepositoryCallback;

import java.util.List;

public interface TrazaDataStore {

    void getTrazas(RepositoryCallback repositoryCallback);

    void updateTraza(int store, Traza traza, RepositoryCallback repositoryCallback);

    void createTrazas(List<Traza> trazas, RepositoryCallback repositoryCallback);

}
