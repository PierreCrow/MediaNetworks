package com.futuremobile.wox.data.datasource.db.store;

import android.content.Context;

import com.futuremobile.wox.data.datasource.datastore.WorkOrderDataStore;
import com.futuremobile.wox.data.datasource.db.WoxDb;
import com.futuremobile.wox.data.datasource.db.dao.WorkOrderDAO;
import com.futuremobile.wox.data.datasource.db.model.DbWorkOrder;
import com.futuremobile.wox.data.mapper.WorkOrderDataMapper;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.presentation.utiles.Helperr;

import java.util.ArrayList;
import java.util.List;

public class DbWorkOrderDataStore implements WorkOrderDataStore {

    WoxDb db;
    WorkOrderDAO workOrderDAO;
    WorkOrderDataMapper workOrderDataMapper;

    public DbWorkOrderDataStore(Context context) {
        db = Helperr.Inicia_BBDD_LOCAL(context);

        workOrderDAO= WoxDb.getDatabase(context).workOrderDAO();
    }


    @Override
    public void getWorkOrders(RepositoryCallback repositoryCallback) {

        workOrderDataMapper= new WorkOrderDataMapper();

        try {
            List<DbWorkOrder> dbWorkOrders = workOrderDAO.GetAll();
            ArrayList<WorkOrder> workOrders = new ArrayList<>();

            for (DbWorkOrder dbWorkOrder : dbWorkOrders) {
                workOrders.add(workOrderDataMapper.transformDbToModel(dbWorkOrder));
            }
            repositoryCallback.onSuccess(workOrders);

        } catch (Exception ex) {
            repositoryCallback.onError("Error");
        }

    }

    @Override
    public void createWorkOrders(List<WorkOrder> workOrders, RepositoryCallback repositoryCallback) {

        workOrderDataMapper= new WorkOrderDataMapper();

        ArrayList<DbWorkOrder> dbWorkOrders = new ArrayList<>();

        for (WorkOrder workOrder : workOrders) {
            dbWorkOrders.add(workOrderDataMapper.transformModelToDb(workOrder));
        }

        if (dbWorkOrders.size() > 0) {
            try {
                workOrderDAO.InsertMultiple(dbWorkOrders);
                repositoryCallback.onSuccess("Success");

            } catch (Exception ex) {
                repositoryCallback.onError("Error");
            }
        }
    }

    @Override
    public void updateWorkOrder(WorkOrder workOrder, RepositoryCallback repositoryCallback) {

        try {
            workOrderDAO.Update(workOrderDataMapper.transformModelToDb(workOrder));
            repositoryCallback.onSuccess("Success");

        } catch (Exception ex) {
            repositoryCallback.onError("Error");
        }
    }
}
