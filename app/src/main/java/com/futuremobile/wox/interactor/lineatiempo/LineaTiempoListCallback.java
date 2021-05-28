package com.futuremobile.wox.interactor.lineatiempo;

import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.model.WorkOrder;

import java.util.ArrayList;

public interface LineaTiempoListCallback {

    void onLineaTiempoListSuccess(ArrayList<LineaTiempo> lineaTiempos);
    void onLineaTiempoListError(String message);
}
