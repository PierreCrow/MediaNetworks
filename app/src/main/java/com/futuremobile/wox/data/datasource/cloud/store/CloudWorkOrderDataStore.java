package com.futuremobile.wox.data.datasource.cloud.store;

import com.futuremobile.wox.data.datasource.datastore.WorkOrderDataStore;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.RepositoryCallback;

import java.util.List;

public class CloudWorkOrderDataStore implements WorkOrderDataStore {


    public CloudWorkOrderDataStore() {
    }

    @Override
    public void getWorkOrders(RepositoryCallback repositoryCallback) {
        // NO SE USARA
    }

    @Override
    public void createWorkOrders(List<WorkOrder> workOrders, RepositoryCallback repositoryCallback) {
        // NO SE USARA
    }

    @Override
    public void updateWorkOrder(WorkOrder workOrder, RepositoryCallback repositoryCallback) {

    }
}
