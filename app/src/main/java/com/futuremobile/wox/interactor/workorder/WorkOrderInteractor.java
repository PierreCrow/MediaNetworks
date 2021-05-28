package com.futuremobile.wox.interactor.workorder;

import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.WorkOrderRepository;

import java.util.List;

public class WorkOrderInteractor {

    private final WorkOrderRepository workOrderRepository;

    public WorkOrderInteractor(WorkOrderRepository workOrderRepository) {
        this.workOrderRepository = workOrderRepository;
    }

    public void getWorkOrders(WorkOrderListCallback workOrderListCallback) {
        workOrderRepository.getWorkOrders(workOrderListCallback);
    }

    public void updateWorkOrder(int store,WorkOrder workOrder, WorkOrderUpdateCallback workOrderUpdateCallback) {
        workOrderRepository.updateWorkOrder(store,workOrder, workOrderUpdateCallback);
    }

    public void createWorkOrders(List<WorkOrder> workOrders, WorkOrderCreateCallback workOrderCreateCallback) {
        workOrderRepository.createWorkOrders(workOrders, workOrderCreateCallback);
    }

}
