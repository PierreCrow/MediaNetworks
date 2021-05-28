package com.futuremobile.wox.interactor.asset;

public interface UserLoginCallback {

    void onUserLoginSuccess(String token);
    void onUserLoginError(String message);

}
