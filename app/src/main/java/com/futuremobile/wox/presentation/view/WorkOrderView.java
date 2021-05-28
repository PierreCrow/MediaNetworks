package com.futuremobile.wox.presentation.view;

import com.futuremobile.wox.data.datasource.cloud.model.sync.WsSync;
import com.futuremobile.wox.domain.model.WorkOrder;

import java.util.ArrayList;

public interface WorkOrderView extends BaseView {

    void workOrderListSuccess(ArrayList<WorkOrder> workOrders);
    void workOrdersCreateSuccess(boolean success);
    void workOrderUpdateSuccess(WorkOrder workOrder);
    void showErrorMessage(String message);
}
