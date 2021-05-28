package com.futuremobile.wox.data.datasource.cloud.store;

import com.futuremobile.wox.data.datasource.cloud.model.asset.WsAssetList;

import com.futuremobile.wox.data.datasource.cloud.model.sync.WsSync;
import com.futuremobile.wox.data.datasource.cloud.model.user.parameter.WsParameterLogin;
import com.futuremobile.wox.data.datasource.cloud.model.user.response.WsResponseLogin;
import com.futuremobile.wox.data.datasource.cloud.ro.RetrofitClient;
import com.futuremobile.wox.data.datasource.datastore.UserDataStore;
import com.futuremobile.wox.data.mapper.AssetDataMapper;
import com.futuremobile.wox.domain.model.Asset;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.presentation.utiles.Constantes;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CloudUserDataStore implements UserDataStore {

    public CloudUserDataStore() {
    }


    @Override
    public void login(String user, String pass, RepositoryCallback repositoryCallback) {

        WsParameterLogin wsParameterLogin= new WsParameterLogin();
        wsParameterLogin.setEmail(user);
        wsParameterLogin.setPassword(pass);

        Call<WsResponseLogin> call = RetrofitClient.getApiClient("").login(wsParameterLogin);
        call.enqueue(new Callback<WsResponseLogin>() {
            @Override
            public void onResponse(Call<WsResponseLogin> call, Response<WsResponseLogin> response) {

                if (response.code() == Constantes.RESPONSE_CODES.SERVER_CONNECTION_SUCCESS) {
                    if (response.body() != null) {
                        WsResponseLogin wsResponseLoad = response.body();
                        repositoryCallback.onSuccess(wsResponseLoad.getToken());

                    } else {
                        repositoryCallback.onError(Constantes.RESPONSE_MESSAGES.ERROR);
                    }
                } else {
                    repositoryCallback.onError(Constantes.RESPONSE_MESSAGES.ERROR);
                }
            }

            @Override
            public void onFailure(Call<WsResponseLogin> call, Throwable t) {
                repositoryCallback.onError(t.getMessage());
            }
        });


    }
}
