package com.futuremobile.wox.interactor.areagrupo;

import com.futuremobile.wox.domain.model.AreaGrupo;
import com.futuremobile.wox.domain.model.Traza;

import java.util.ArrayList;

public interface AreaGrupoListCallback {

    void onAreaGrupoListSuccess(ArrayList<AreaGrupo> areaGrupos);
    void onAreaGrupoListError(String message);
}
