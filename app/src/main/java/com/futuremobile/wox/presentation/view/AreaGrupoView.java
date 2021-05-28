package com.futuremobile.wox.presentation.view;

import com.futuremobile.wox.domain.model.AreaGrupo;
import com.futuremobile.wox.domain.model.Traza;

import java.util.ArrayList;

public interface AreaGrupoView extends BaseView {

    void areaGrupoListSuccess(ArrayList<AreaGrupo> areaGrupos);
    void areaGruposCreateSuccess(boolean success);
    void showErrorMessage(String message);
}
