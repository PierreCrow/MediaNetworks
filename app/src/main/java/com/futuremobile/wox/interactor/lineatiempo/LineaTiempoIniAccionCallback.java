package com.futuremobile.wox.interactor.lineatiempo;

import com.futuremobile.wox.domain.model.LineaTiempo;

public interface LineaTiempoIniAccionCallback {

    void onLineaTiempoIniAccionSuccess(boolean success);
    void onLineaTiempoIniAccionError(String message);
}
