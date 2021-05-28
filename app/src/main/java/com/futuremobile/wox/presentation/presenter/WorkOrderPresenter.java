package com.futuremobile.wox.presentation.presenter;


import com.futuremobile.wox.data.datasource.datastore.WorkOrderDataStoreFactory;

import com.futuremobile.wox.data.repository.WorkOrderDataRepository;
import com.futuremobile.wox.domain.model.WorkOrder;

import com.futuremobile.wox.domain.repository.WorkOrderRepository;

import com.futuremobile.wox.interactor.workorder.WorkOrderCreateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderUpdateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderInteractor;
import com.futuremobile.wox.interactor.workorder.WorkOrderListCallback;

import com.futuremobile.wox.presentation.view.WorkOrderView;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderPresenter implements Presenter<WorkOrderView>,
        WorkOrderListCallback, WorkOrderUpdateCallback, WorkOrderCreateCallback {


    private WorkOrderView workOrderView;
    private WorkOrderInteractor workOrderInteractor;


    public void getWorkOrders() {
        workOrderInteractor.getWorkOrders(this);
    }


    public void updateWorkOrder(int store,WorkOrder workOrder) {
        workOrderInteractor.updateWorkOrder(store,workOrder, this);
    }

    public void createWorkOrders(List<WorkOrder> workOrders) {
        workOrderInteractor.createWorkOrders(workOrders, this);
    }


    @Override
    public void addView(WorkOrderView view) {
        this.workOrderView = view;
        WorkOrderRepository syncRepository = new WorkOrderDataRepository(new WorkOrderDataStoreFactory(this.workOrderView.getContext()));
        workOrderInteractor = new WorkOrderInteractor(syncRepository);
    }

    @Override
    public void removeView(WorkOrderView view) {

    }


    @Override
    public void onWorkOrderListSuccess(ArrayList<WorkOrder> workOrders) {
        workOrderView.workOrderListSuccess(workOrders);
    }

    @Override
    public void onWorkOrderListError(String message) {
        workOrderView.showErrorMessage(message);
    }


    @Override
    public void onWorkOrderUpdateSuccess(WorkOrder workOrder) {
        workOrderView.workOrderUpdateSuccess(workOrder);
    }

    @Override
    public void onWorkOrderUpdateError(String message) {
        workOrderView.showErrorMessage(message);
    }

    @Override
    public void onWorkOrdersCreateSuccess(boolean created) {
        workOrderView.workOrdersCreateSuccess(created);
    }

    @Override
    public void onWorkOrdersCreateError(String message) {
        workOrderView.showErrorMessage(message);
    }
}
