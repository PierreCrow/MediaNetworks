package com.futuremobile.wox.data.repository;

import com.futuremobile.wox.data.datasource.datastore.WorkOrderDataStore;
import com.futuremobile.wox.data.datasource.datastore.WorkOrderDataStoreFactory;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.domain.repository.WorkOrderRepository;
import com.futuremobile.wox.interactor.workorder.WorkOrderCreateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderListCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderUpdateCallback;
import com.futuremobile.wox.presentation.utiles.Constantes;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderDataRepository implements WorkOrderRepository {

    private final WorkOrderDataStoreFactory workOrderDataStoreFactory;

    public WorkOrderDataRepository(WorkOrderDataStoreFactory workOrderDataStoreFactory) {
        this.workOrderDataStoreFactory = workOrderDataStoreFactory;
    }


    @Override
    public void getWorkOrders( WorkOrderListCallback workOrderListCallback) {
        final WorkOrderDataStore workOrderDataStore = workOrderDataStoreFactory.create(Constantes.STORE.DB);
        workOrderDataStore.getWorkOrders(new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                workOrderListCallback.onWorkOrderListError(message);
            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<WorkOrder> workOrders= (ArrayList<WorkOrder>) object;
                workOrderListCallback.onWorkOrderListSuccess(workOrders);
            }
        });
    }

    @Override
    public void createWorkOrders(List<WorkOrder> workOrders, WorkOrderCreateCallback workOrderCreateCallback) {
        final WorkOrderDataStore workOrderDataStore = workOrderDataStoreFactory.create(Constantes.STORE.DB);
        workOrderDataStore.createWorkOrders(workOrders,new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                workOrderCreateCallback.onWorkOrdersCreateError(message);
            }

            @Override
            public void onSuccess(Object object) {
                boolean success= (boolean) object;
                workOrderCreateCallback.onWorkOrdersCreateSuccess(success);
            }
        });
    }

    @Override
    public void updateWorkOrder(int store,WorkOrder workOrder, WorkOrderUpdateCallback workOrderUpdateCallback) {
        final WorkOrderDataStore workOrderDataStore = workOrderDataStoreFactory.create(store);
        workOrderDataStore.updateWorkOrder(workOrder,new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                workOrderUpdateCallback.onWorkOrderUpdateError(message);
            }

            @Override
            public void onSuccess(Object object) {
                WorkOrder workOrder1= (WorkOrder) object;
                workOrderUpdateCallback.onWorkOrderUpdateSuccess(workOrder);
            }
        });
    }


}
