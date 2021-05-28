package com.futuremobile.wox.interactor.workorder;

import com.futuremobile.wox.domain.model.WorkOrder;

import java.util.ArrayList;

public interface WorkOrderUpdateCallback {

    void onWorkOrderUpdateSuccess(WorkOrder workOrder);
    void onWorkOrderUpdateError(String message);
}
