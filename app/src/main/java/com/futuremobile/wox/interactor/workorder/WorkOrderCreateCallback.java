package com.futuremobile.wox.interactor.workorder;

public interface WorkOrderCreateCallback {

    void onWorkOrdersCreateSuccess(boolean created);
    void onWorkOrdersCreateError(String message);
}
