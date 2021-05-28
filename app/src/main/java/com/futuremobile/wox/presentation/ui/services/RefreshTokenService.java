package com.futuremobile.wox.presentation.ui.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import androidx.annotation.Nullable;

import com.futuremobile.wox.presentation.utiles.Constantes;

public class RefreshTokenService extends IntentService
         {





    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public RefreshTokenService() {
        super("RefreshTokenService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        refreshToken(Constantes.MINUTES_SERVICE_RUN.MINUTES_REFRESH_TOKEN);
    }

    private void refreshToken(int minutes) {
        Integer startEvery = 10000 * minutes;
        CountDownTimer newtimer = new CountDownTimer(1000000000, startEvery) {
            public void onTick(long millisUntilFinished) {
              //  loginPresenter.refreshToken(Metodos.getUserAppPreference(getApplicationContext()).getToken());
            }
            public void onFinish() {
            }
        };
        newtimer.start();
    }





    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        onHandleIntent(intent);
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }





}
