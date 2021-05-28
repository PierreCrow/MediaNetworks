package com.futuremobile.wox.interactor.lineatiempo;

import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.model.WorkOrder;

public interface LineaTiempoUpdateCallback {

    void onLineaTiempoUpdateSuccess(LineaTiempo lineaTiempo);
    void onLineaTiempoUpdateError(String message);
}
