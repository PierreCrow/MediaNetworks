package com.futuremobile.wox.data.repository;


import com.futuremobile.wox.data.datasource.datastore.UserDataStore;
import com.futuremobile.wox.data.datasource.datastore.UserDataStoreFactory;
import com.futuremobile.wox.domain.repository.UserRepository;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.interactor.asset.UserLoginCallback;
import com.futuremobile.wox.presentation.utiles.Constantes;

public class UserDataRepository implements UserRepository {

    private final UserDataStoreFactory userDataStoreFactory;

    public UserDataRepository(UserDataStoreFactory userDataStoreFactory) {
        this.userDataStoreFactory = userDataStoreFactory;
    }



    @Override
    public void login(String user, String pass, UserLoginCallback userLoginCallback) {
        final UserDataStore userDataStore = userDataStoreFactory.create(Constantes.STORE.CLOUD);
        userDataStore.login(user,pass, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                userLoginCallback.onUserLoginError(message);
            }

            @Override
            public void onSuccess(Object object) {
                String tokenn= (String) object;
                userLoginCallback.onUserLoginSuccess(tokenn);
            }
        });
    }
}
