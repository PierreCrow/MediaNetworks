package com.futuremobile.wox.interactor.asset;

import com.futuremobile.wox.domain.repository.UserRepository;

public class UserInteractor {

    private final UserRepository userRepository;

    public UserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void login(String user,String pass, UserLoginCallback userLoginCallback) {
        userRepository.login(user, pass, userLoginCallback);
    }

}
