package com.futuremobile.wox.domain.repository;

import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.interactor.workorder.WorkOrderCreateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderListCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderUpdateCallback;

import java.util.List;

public interface WorkOrderRepository {

    void getWorkOrders(WorkOrderListCallback workOrderListCallback);

    void updateWorkOrder(int store,WorkOrder workOrder, WorkOrderUpdateCallback workOrderUpdateCallback);

    void createWorkOrders(List<WorkOrder> workOrders, WorkOrderCreateCallback workOrderCreateCallback);

}
