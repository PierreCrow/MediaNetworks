package com.futuremobile.wox.interactor.traza;

public interface TrazaCreateCallback {

    void onTrazasCreateSuccess(boolean created);
    void onTrazasCreateError(String message);
}
