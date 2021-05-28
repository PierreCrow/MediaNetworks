package com.futuremobile.wox.interactor.workorder;

import com.futuremobile.wox.domain.model.WorkOrder;

import java.util.ArrayList;

public interface WorkOrderListCallback {

    void onWorkOrderListSuccess(ArrayList<WorkOrder> workOrders);
    void onWorkOrderListError(String message);
}
