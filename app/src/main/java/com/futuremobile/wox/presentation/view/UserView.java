package com.futuremobile.wox.presentation.view;

import com.futuremobile.wox.domain.model.Asset;

import java.util.ArrayList;

public interface UserView extends BaseView {

    void userLogged(String token);

    void showLoading();
    void hideLoading();
    void showErrorMessage(String message);
}
