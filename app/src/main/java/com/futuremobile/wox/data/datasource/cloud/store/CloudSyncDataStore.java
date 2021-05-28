package com.futuremobile.wox.data.datasource.cloud.store;

import com.futuremobile.wox.data.datasource.cloud.model.sync.WsSync;
import com.futuremobile.wox.data.datasource.cloud.model.sync.WsWorkOrder;
import com.futuremobile.wox.data.datasource.cloud.ro.RetrofitClient;
import com.futuremobile.wox.data.datasource.datastore.SyncDataStore;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.presentation.utiles.Constantes;
import com.google.firebase.inappmessaging.internal.ApiClient;

import java.util.ArrayList;

import butterknife.internal.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CloudSyncDataStore implements SyncDataStore {

    public CloudSyncDataStore() {
    }


    @Override
    public void sync(String token, RepositoryCallback repositoryCallback) {

        Call<WsSync> call = RetrofitClient.getApiClient(token).syncc();
        call.enqueue(new Callback<WsSync>() {
            @Override
            public void onResponse(Call<WsSync> call, Response<WsSync> response) {

                if (response.code() == Constantes.RESPONSE_CODES.SERVER_CONNECTION_SUCCESS) {
                    if (response.body() != null) {
                        WsSync wsResponseLoad = response.body();
                        repositoryCallback.onSuccess(wsResponseLoad);

                    } else {
                        repositoryCallback.onError(Constantes.RESPONSE_MESSAGES.ERROR);
                    }
                } else {
                    repositoryCallback.onError(Constantes.RESPONSE_MESSAGES.ERROR);
                }
            }

            @Override
            public void onFailure(Call<WsSync> call, Throwable t) {
                repositoryCallback.onError(t.getMessage());
            }
        });

    }
}
