package com.futuremobile.wox.data.datasource.db.store;

import android.content.Context;

import com.futuremobile.wox.data.datasource.datastore.AreaGrupoDataStore;
import com.futuremobile.wox.data.datasource.db.WoxDb;
import com.futuremobile.wox.data.datasource.db.dao.AreaGrupoDAO;
import com.futuremobile.wox.data.datasource.db.model.DbAreaGrupo;
import com.futuremobile.wox.data.datasource.db.model.DbTraza;
import com.futuremobile.wox.data.mapper.AreaGrupoDataMapper;
import com.futuremobile.wox.data.mapper.TrazaDataMapper;
import com.futuremobile.wox.domain.model.AreaGrupo;
import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.presentation.utiles.Helperr;

import java.util.ArrayList;
import java.util.List;

public class DbAreaGrupoDataStore implements AreaGrupoDataStore {

    WoxDb db;
    AreaGrupoDAO areaGrupoDAO;
    AreaGrupoDataMapper areaGrupoDataMapper;

    public DbAreaGrupoDataStore(Context context) {
        db = Helperr.Inicia_BBDD_LOCAL(context);
        areaGrupoDAO = WoxDb.getDatabase(context).areaGrupoDAO();
    }


    @Override
    public void getAreaGrupos(RepositoryCallback repositoryCallback) {
        areaGrupoDataMapper = new AreaGrupoDataMapper();

        try {
            List<DbAreaGrupo> dbAreaGrupos = areaGrupoDAO.GetAll();
            ArrayList<AreaGrupo> areaGrupos = new ArrayList<>();

            for (DbAreaGrupo dbAreaGrupo : dbAreaGrupos) {
                areaGrupos.add(areaGrupoDataMapper.transformDbToModel(dbAreaGrupo));
            }
            repositoryCallback.onSuccess(areaGrupos);

        } catch (Exception ex) {
            repositoryCallback.onError("Error");
        }
    }

    @Override
    public void createAreaGrupos(List<AreaGrupo> areaGrupos, RepositoryCallback repositoryCallback) {
        areaGrupoDataMapper = new AreaGrupoDataMapper();

        ArrayList<DbAreaGrupo> dbAreaGrupos = new ArrayList<>();

        for (AreaGrupo areaGrupo : areaGrupos) {
            dbAreaGrupos.add(areaGrupoDataMapper.transformModelToDb(areaGrupo));
        }

        if (dbAreaGrupos.size() > 0) {
            try {
                areaGrupoDAO.InsertMultiple(dbAreaGrupos);
                repositoryCallback.onSuccess("Success");

            } catch (Exception ex) {
                repositoryCallback.onError("Error");
            }
        }
    }
}
