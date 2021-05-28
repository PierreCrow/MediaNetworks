package com.futuremobile.wox.data.datasource.cloud.ro;


import com.futuremobile.wox.data.datasource.cloud.model.sync.WsSync;
import com.futuremobile.wox.data.datasource.cloud.model.sync.WsWorkOrder;
import com.futuremobile.wox.data.datasource.cloud.model.user.parameter.WsParameterLogin;
import com.futuremobile.wox.data.datasource.cloud.model.user.response.WsResponseLogin;
import com.futuremobile.wox.presentation.utiles.Constantes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {


    @GET(Constantes.URLS.SYNC)
    Call<WsSync> syncc();

    @POST(Constantes.URLS.LOGIN)
    Call<WsResponseLogin> login(@Body WsParameterLogin wsParameterLogin);




}
