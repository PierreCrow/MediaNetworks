package com.futuremobile.wox.presentation.view;



public interface LoginView extends BaseView {


    void tokenRefreshed(String token);
    void showLoading();
    void hideLoading();
    void showErrorMessage(String message);
}
