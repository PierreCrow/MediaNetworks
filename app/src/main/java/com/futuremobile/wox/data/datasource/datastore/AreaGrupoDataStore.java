package com.futuremobile.wox.data.datasource.datastore;


import com.futuremobile.wox.domain.model.AreaGrupo;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.interactor.areagrupo.AreaGrupoCreateCallback;
import com.futuremobile.wox.interactor.areagrupo.AreaGrupoListCallback;

import java.util.List;

public interface AreaGrupoDataStore {


    void getAreaGrupos(RepositoryCallback repositoryCallback);

    void createAreaGrupos(List<AreaGrupo> areaGrupos, RepositoryCallback repositoryCallback);




}
