package com.futuremobile.wox.data.datasource.db.store;

import android.content.Context;

import com.futuremobile.wox.data.datasource.datastore.TrazaDataStore;
import com.futuremobile.wox.data.datasource.db.WoxDb;
import com.futuremobile.wox.data.datasource.db.dao.TrazaDAO;
import com.futuremobile.wox.data.datasource.db.model.DbTraza;
import com.futuremobile.wox.data.mapper.TrazaDataMapper;
import com.futuremobile.wox.data.mapper.WorkOrderDataMapper;
import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.presentation.utiles.Helperr;

import java.util.ArrayList;
import java.util.List;

public class DbTrazaDataStore implements TrazaDataStore {

    WoxDb db;
    TrazaDAO trazaDAO;
    TrazaDataMapper trazaDataMapper;

    public DbTrazaDataStore(Context context) {
        db = Helperr.Inicia_BBDD_LOCAL(context);
        trazaDAO = WoxDb.getDatabase(context).trazaDAO();
    }


    @Override
    public void getTrazas(RepositoryCallback repositoryCallback) {

        trazaDataMapper = new TrazaDataMapper();

        try {
            List<DbTraza> dbTrazas = trazaDAO.GetAll();
            ArrayList<Traza> trazas = new ArrayList<>();

            for (DbTraza dbWorkOrder : dbTrazas) {
                trazas.add(trazaDataMapper.transformDbToModel(dbWorkOrder));
            }
            repositoryCallback.onSuccess(trazas);

        } catch (Exception ex) {
            repositoryCallback.onError("Error");
        }
    }

    @Override
    public void updateTraza(int store, Traza traza, RepositoryCallback repositoryCallback) {

        try {
            trazaDataMapper = new TrazaDataMapper();
            trazaDAO.Update(trazaDataMapper.transformModelToDb(traza));
            repositoryCallback.onSuccess("Success");

        } catch (Exception ex) {
            repositoryCallback.onError("Error");
        }
    }

    @Override
    public void createTrazas(List<Traza> trazas, RepositoryCallback repositoryCallback) {

        trazaDataMapper = new TrazaDataMapper();

        ArrayList<DbTraza> dbTrazas = new ArrayList<>();

        for (Traza traza : trazas) {
            dbTrazas.add(trazaDataMapper.transformModelToDb(traza));
        }

        if (dbTrazas.size() > 0) {
            try {
                trazaDAO.InsertMultiple(dbTrazas);
                repositoryCallback.onSuccess("Success");

            } catch (Exception ex) {
                repositoryCallback.onError("Error");
            }
        }
    }
}
