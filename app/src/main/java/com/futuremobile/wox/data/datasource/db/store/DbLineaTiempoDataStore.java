package com.futuremobile.wox.data.datasource.db.store;

import android.content.Context;

import com.futuremobile.wox.data.datasource.datastore.LineaTiempoDataStore;
import com.futuremobile.wox.data.datasource.db.WoxDb;
import com.futuremobile.wox.data.datasource.db.dao.LineaTiempoDAO;
import com.futuremobile.wox.data.datasource.db.model.DbLineaTiempo;
import com.futuremobile.wox.data.mapper.LineaTiempoDataMapper;
import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.presentation.utiles.Helperr;

import java.util.ArrayList;
import java.util.List;

public class DbLineaTiempoDataStore implements LineaTiempoDataStore {

    WoxDb db;

    LineaTiempoDAO lineaTiempoDAO;
    LineaTiempoDataMapper lineaTiempoDataMapper;

    public DbLineaTiempoDataStore(Context context) {
        db = Helperr.Inicia_BBDD_LOCAL(context);

        lineaTiempoDAO = WoxDb.getDatabase(context).lineaTiempoDAO();
    }


    @Override
    public void getLineaTiempos(RepositoryCallback repositoryCallback) {


        lineaTiempoDataMapper = new LineaTiempoDataMapper();

        try {
            List<DbLineaTiempo> dbLineaTiempos = lineaTiempoDAO.GetAll();
            ArrayList<LineaTiempo> lineaTiempos = new ArrayList<>();

            for (DbLineaTiempo dbLineaTiempo : dbLineaTiempos) {
                lineaTiempos.add(lineaTiempoDataMapper.transformDbToModel(dbLineaTiempo));
            }
            repositoryCallback.onSuccess(lineaTiempos);

        } catch (Exception ex) {
            repositoryCallback.onError("Error");
        }


    }

    @Override
    public void createLineaTiempos(List<LineaTiempo> lineaTiempos, RepositoryCallback repositoryCallback) {

        lineaTiempoDataMapper = new LineaTiempoDataMapper();

        ArrayList<DbLineaTiempo> dbLineaTiempos = new ArrayList<>();

        for (LineaTiempo lineaTiempo : lineaTiempos) {
            dbLineaTiempos.add(lineaTiempoDataMapper.transformModelToDb(lineaTiempo));
        }

        if (dbLineaTiempos.size() > 0) {
            try {
                lineaTiempoDAO.InsertMultiple(dbLineaTiempos);
                repositoryCallback.onSuccess("Success");

            } catch (Exception ex) {
                repositoryCallback.onError("Error");
            }
        }

    }

    @Override
    public void updateLineaTiempo(LineaTiempo lineaTiempo, RepositoryCallback repositoryCallback) {

        try {
            lineaTiempoDAO.Update(lineaTiempoDataMapper.transformModelToDb(lineaTiempo));
            repositoryCallback.onSuccess("Success");

        } catch (Exception ex) {
            repositoryCallback.onError("Error");
        }

    }

    @Override
    public void iniAccion(LineaTiempo lineaTiempo, String fecha, RepositoryCallback repositoryCallback) {

        try {
            Boolean synccc=false;
            lineaTiempoDAO.UpdateIni(lineaTiempo.getId(),fecha,synccc);
            repositoryCallback.onSuccess("Success");

        } catch (Exception ex) {
            repositoryCallback.onError("Error");
        }
    }

    @Override
    public void finAccion(LineaTiempo lineaTiempo, String fecha, String comentario, RepositoryCallback repositoryCallback) {

        try {
            lineaTiempoDAO.UpdateFin(lineaTiempo.getId(),fecha,comentario,false);
            repositoryCallback.onSuccess("Success");

        } catch (Exception ex) {
            repositoryCallback.onError("Error");
        }
    }
}
