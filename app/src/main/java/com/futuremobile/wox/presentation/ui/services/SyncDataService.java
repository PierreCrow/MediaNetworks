package com.futuremobile.wox.presentation.ui.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;

import com.futuremobile.wox.data.datasource.db.WoxDb;
import com.futuremobile.wox.presentation.utiles.Helperr;

public class SyncDataService extends IntentService {

    WoxDb db;
    String token;

    public SyncDataService() {
        super("SyncDataService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        db = Helperr.Inicia_BBDD_LOCAL(getApplication());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        syncAllData(5);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        onHandleIntent(intent);
        return Service.START_STICKY;
    }


    private void syncAllData(int minutes) {
        Integer startEvery = 10000 * minutes;
        CountDownTimer newtimer = new CountDownTimer(1000000000, startEvery) {
            public void onTick(long millisUntilFinished) {
             //   SyncData syncData = new SyncData(getApplicationContext(), db, token);
             //   syncData.syncAllData();
            }

            public void onFinish() {
            }
        };
        newtimer.start();
    }


}