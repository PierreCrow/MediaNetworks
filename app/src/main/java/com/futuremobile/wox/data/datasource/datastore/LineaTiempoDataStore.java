package com.futuremobile.wox.data.datasource.datastore;


import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.RepositoryCallback;

import java.util.List;

public interface LineaTiempoDataStore {

    void getLineaTiempos(RepositoryCallback repositoryCallback);

    void createLineaTiempos(List<LineaTiempo> lineaTiempos, RepositoryCallback repositoryCallback);

    void updateLineaTiempo(LineaTiempo lineaTiempo, RepositoryCallback repositoryCallback);


    void iniAccion(LineaTiempo lineaTiempo, String fecha,RepositoryCallback repositoryCallback);

    void finAccion(LineaTiempo lineaTiempo, String fecha,String comentario,RepositoryCallback repositoryCallback);



}
