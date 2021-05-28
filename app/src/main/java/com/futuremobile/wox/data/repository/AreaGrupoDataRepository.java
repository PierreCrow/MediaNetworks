package com.futuremobile.wox.data.repository;

import com.futuremobile.wox.data.datasource.datastore.AreaGrupoDataStore;
import com.futuremobile.wox.data.datasource.datastore.AreaGrupoDataStoreFactory;
import com.futuremobile.wox.data.datasource.datastore.TrazaDataStore;
import com.futuremobile.wox.data.datasource.datastore.TrazaDataStoreFactory;
import com.futuremobile.wox.domain.model.AreaGrupo;
import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.repository.AreaGrupoRepository;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.interactor.areagrupo.AreaGrupoCreateCallback;
import com.futuremobile.wox.interactor.areagrupo.AreaGrupoListCallback;
import com.futuremobile.wox.interactor.traza.TrazaCreateCallback;
import com.futuremobile.wox.interactor.traza.TrazaListCallback;
import com.futuremobile.wox.interactor.traza.TrazaUpdateCallback;
import com.futuremobile.wox.presentation.utiles.Constantes;

import java.util.ArrayList;
import java.util.List;

public class AreaGrupoDataRepository implements AreaGrupoRepository {

    private final AreaGrupoDataStoreFactory areaGrupoDataStoreFactory;

    public AreaGrupoDataRepository(AreaGrupoDataStoreFactory areaGrupoDataStoreFactory) {
        this.areaGrupoDataStoreFactory = areaGrupoDataStoreFactory;
    }


    @Override
    public void getAreaGrupos(AreaGrupoListCallback areaGrupoListCallback) {
        final AreaGrupoDataStore trazaDataStore = areaGrupoDataStoreFactory.create(Constantes.STORE.DB);
        trazaDataStore.getAreaGrupos(new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                areaGrupoListCallback.onAreaGrupoListError(message);
            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<AreaGrupo> areaGrupos = (ArrayList<AreaGrupo>) object;
                areaGrupoListCallback.onAreaGrupoListSuccess(areaGrupos);
            }
        });
    }

    @Override
    public void createAreaGrupos(List<AreaGrupo> areaGrupos, AreaGrupoCreateCallback areaGrupoCreateCallback) {

        final AreaGrupoDataStore trazaDataStore = areaGrupoDataStoreFactory.create(Constantes.STORE.DB);
        trazaDataStore.createAreaGrupos(areaGrupos, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                areaGrupoCreateCallback.onAreaGruposCreateError(message);
            }

            @Override
            public void onSuccess(Object object) {
                boolean success = (boolean) object;
                areaGrupoCreateCallback.onAreaGruposCreateSuccess(success);
            }
        });
    }
}
