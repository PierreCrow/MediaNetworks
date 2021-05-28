package com.futuremobile.wox.domain.repository;

import com.futuremobile.wox.domain.model.AreaGrupo;
import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.interactor.areagrupo.AreaGrupoCreateCallback;
import com.futuremobile.wox.interactor.areagrupo.AreaGrupoListCallback;
import com.futuremobile.wox.interactor.traza.TrazaCreateCallback;
import com.futuremobile.wox.interactor.traza.TrazaListCallback;
import com.futuremobile.wox.interactor.traza.TrazaUpdateCallback;

import java.util.List;

public interface AreaGrupoRepository {

    void getAreaGrupos(AreaGrupoListCallback trazaListCallback);

    void createAreaGrupos(List<AreaGrupo> areaGrupos, AreaGrupoCreateCallback trazaCreateCallback);

}
