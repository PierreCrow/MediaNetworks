package com.futuremobile.wox.interactor.areagrupo;

import com.futuremobile.wox.domain.model.AreaGrupo;
import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.repository.AreaGrupoRepository;
import com.futuremobile.wox.domain.repository.TrazaRepository;
import com.futuremobile.wox.interactor.traza.TrazaCreateCallback;
import com.futuremobile.wox.interactor.traza.TrazaListCallback;
import com.futuremobile.wox.interactor.traza.TrazaUpdateCallback;

import java.util.List;

public class AreaGrupoInteractor {

    private final AreaGrupoRepository areaGrupoRepository;

    public AreaGrupoInteractor(AreaGrupoRepository areaGrupoRepository) {
        this.areaGrupoRepository = areaGrupoRepository;
    }

    public void getAreaGrupos(AreaGrupoListCallback areaGrupoListCallback) {
        areaGrupoRepository.getAreaGrupos(areaGrupoListCallback);
    }


    public void createAreaGrupos(List<AreaGrupo> areaGrupos, AreaGrupoCreateCallback areaGrupoCreateCallback) {
        areaGrupoRepository.createAreaGrupos(areaGrupos, areaGrupoCreateCallback);
    }

}
