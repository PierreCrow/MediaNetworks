package com.futuremobile.wox.presentation.presenter;

import com.futuremobile.wox.data.datasource.datastore.UserDataStoreFactory;
import com.futuremobile.wox.data.repository.UserDataRepository;
import com.futuremobile.wox.domain.repository.UserRepository;
import com.futuremobile.wox.interactor.asset.UserInteractor;
import com.futuremobile.wox.interactor.asset.UserLoginCallback;
import com.futuremobile.wox.presentation.view.UserView;

public class UserPresenter implements Presenter<UserView>,
        UserLoginCallback {


    private UserView userView;
    private UserInteractor userInteractor;


    public void login(String user,String pass) {
        userInteractor.login(user, pass, this);
    }

    @Override
    public void addView(UserView view) {
        this.userView = view;
        UserRepository userRepository = new UserDataRepository(new UserDataStoreFactory(this.userView.getContext()));
        userInteractor = new UserInteractor(userRepository);
    }

    @Override
    public void removeView(UserView view) {

    }



    @Override
    public void onUserLoginSuccess(String token) {
        userView.userLogged(token);
    }

    @Override
    public void onUserLoginError(String message) {
        userView.showErrorMessage(message);
    }
}
