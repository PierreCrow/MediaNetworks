package com.futuremobile.wox.data.datasource.datastore;


import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.RepositoryCallback;

import java.util.List;

public interface WorkOrderDataStore {

    void getWorkOrders(RepositoryCallback repositoryCallback);

    void createWorkOrders(List <WorkOrder> workOrders, RepositoryCallback repositoryCallback);

    void updateWorkOrder(WorkOrder workOrder, RepositoryCallback repositoryCallback);



}
