package com.futuremobile.wox.domain.repository;

import com.futuremobile.wox.interactor.asset.UserLoginCallback;

public interface UserRepository {

    void login(String user, String pass, UserLoginCallback userLoginCallback);

}
