package com.futuremobile.wox.data.datasource.cloud.ro;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.futuremobile.wox.presentation.utiles.BasicAuthInterceptor;
import com.futuremobile.wox.presentation.utiles.Constantes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static ApiInterface retro;

    public static ApiInterface getService(String Token, boolean vouchers) {


        //  TokenAuthenticator tokenAuthenticator = new TokenAuthenticator();

        String url;

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(1);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new BasicAuthInterceptor(Token))
                .addNetworkInterceptor(new StethoInterceptor())
                //     .authenticator(tokenAuthenticator)
                .build();

      //  okHttpClient.interceptors().add(interceptor);

        //  if(retrofit == null){

    /*    if (vouchers) {
            url = Constantes.URLS.URL_BASE_VOUCHERS;
        } else {
            url = Constantes.URLS.URL_BASE;
        }
*/
        url = Constantes.URLS.URL_BASE;
       // Gson gson = new GsonBuilder().serializeNulls().create();
        Gson gson = new GsonBuilder()
               // .setLenient()
               // .serializeNulls()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //   }
        return retrofit.create(ApiInterface.class);
    }




    private static OkHttpClient getClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES)
                .readTimeout(10, TimeUnit.MINUTES)
                .addInterceptor(logging)
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        return client;
    }


    public static ApiInterface getApiClient(String token) {

        //  TokenAuthenticator tokenAuthenticator = new TokenAuthenticator();

        String url;

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(1);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new BasicAuthInterceptor(token))
                .addNetworkInterceptor(new StethoInterceptor())
                //     .authenticator(tokenAuthenticator)
                .build();

        //  okHttpClient.interceptors().add(interceptor);

        //  if(retrofit == null){

    /*    if (vouchers) {
            url = Constantes.URLS.URL_BASE_VOUCHERS;
        } else {
            url = Constantes.URLS.URL_BASE;
        }
*/
        url = Constantes.URLS.URL_BASE;
        // Gson gson = new GsonBuilder().serializeNulls().create();
        Gson gson = new GsonBuilder()
                // .setLenient()
                // .serializeNulls()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //   }
        return retrofit.create(ApiInterface.class);
    }

}
