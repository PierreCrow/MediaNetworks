package com.futuremobile.wox.interactor.traza;

import com.futuremobile.wox.domain.model.Traza;

public interface TrazaUpdateCallback {

    void onTrazaUpdateSuccess(Traza traza);
    void onWorkOrderUpdateError(String message);
}
