package com.futuremobile.wox.presentation.ui.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.StatFs;

import androidx.annotation.Nullable;

import com.futuremobile.wox.data.datasource.cloud.model.sync.WsSync;
import com.futuremobile.wox.domain.model.UserPreference;
import com.futuremobile.wox.presentation.presenter.SyncPresenter;
import com.futuremobile.wox.presentation.utiles.Constantes;
import com.futuremobile.wox.presentation.utiles.Helperr;
import com.futuremobile.wox.presentation.view.SyncView;

import java.io.File;

public class NetworkValidationIntentService extends IntentService implements SyncView {
    Boolean connectedToNetwork = null;
    Boolean lastConectionToNetwork = null;
    boolean changeNetworkState;
    String freeSpace, totalSpace;
    int connectionType;

    SyncPresenter syncPresenter;
    SyncData syncData;

    UserPreference userPreference ;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public NetworkValidationIntentService() {
        super("NetworkValidationIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        userPreference = Helperr.getUserAppPreference(getContext());
        netValidation(Constantes.MINUTES_SERVICE_RUN.SECONDS_NETWORK_VALIDATION);

    }


    private void netValidation(int seconds) {
        int tiempo = seconds * 1000;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (userPreference.isLogged()) {
                    validatee();
                }

                handler.postDelayed(this, tiempo);
            }
        };
        handler.postDelayed(runnable, 0);
    }

    void validatee() {

        String mitoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMDdmNmNhZGIwODYxMDBjZjZlMmFhNzExOTM0M2JiNzAyZjFhNzQxNDczZWQ2ZmVlZmYzN2E3YWYyMTlkMGM2ZDhiNDgwNjk4NzU3ZDA1MmYiLCJpYXQiOiIxNjEzNTM2NDY1LjQ3OTM2NyIsIm5iZiI6IjE2MTM1MzY0NjUuNDc5MzcyIiwiZXhwIjoiMTY0NTA3MjQ2NS40NzUwMzUiLCJzdWIiOiIyIiwic2NvcGVzIjpbXX0.TibIyOMZc5ydb4KCVhvWqBqSVCThy8eq-aADirOAjqrMEBlgx72R1OvCaM1oVDFx9_SI7azm12QPmXG3AGLlaBfE_r9KjGFVXjW3BkJBoQpUF995hFVtZKr7WCUVy063MjsBY_BKX4FLugIaG3Rmahm4UtuUAdmVKlRMD4Vq_hOFEBeP8SlKPz_26d2rBF-JLqxGhHgfUtYO6tMSdi-nAtEl57qvnJHcxl7PJzbQ1njAwjqL5PEwoTidH0bXpBFV9fXItmAJH-X0n-PKUMuEzlYUQy3Hsk0lmowuFs20rR1LptewKwZT-T7x_lqN2futUA72MW4W2rmbqpLBhoxlXBwXoL1upZWoKG4ZXlKXV3k1VzG16BGnafs5nPc6dGhBfVmk9_QIJ4B1QlWLxV9DNgODnWV0uL0kyD8K6daDnX-xPztUhd9rii0-7-iHNPQJsoRZTxNz6FigAYgTm-R3bgpkXCSnV1s7PqjW-u7IPyKZgl7BF4bmS2Uks_X0JbFhn590kBaPjHBIcViS7XHSevTbDvU_4Um4RAZ1JCBzsHA-R9g6D6SLIZKszrjn5qujotyj7961vm8eEyqRgl6ohA6XCBh6laMiVmQzj_FXNWGjKYSh54r3n2eGVm1bvkiJ4LfXsb1rR_iL0JfNFaDanZQuHUfwKm439oJGjPPHkE0";
        syncData = new SyncData(getApplicationContext(), null, userPreference.getToken());
        syncPresenter = new SyncPresenter();
        syncPresenter.addView(this);


        connectedToNetwork = isConnectedToInternet(getApplicationContext());
        if (connectedToNetwork) {
            syncData.syncNewAll();
            //  syncPresenter.requestSync("");
        }
    }

    private boolean isConnectedToInternet(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Boolean conectado = null;
        if (connectivity != null) {
            NetworkInfo activeNetwork = connectivity.getActiveNetworkInfo();
            if (activeNetwork != null && activeNetwork.isConnectedOrConnecting())
                conectado = true;
            else {
                conectado = false;
            }
        } else {
            conectado = false;
        }
        return conectado;
    }


    void deviceSpace() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long blockCount = stat.getBlockCount();
        long availableBlocks = stat.getAvailableBlocks();


    }


    void sendBoradcast() {
        Intent intent1 = new Intent();
        intent1.setAction("com.futuremobile.facturaltoke");
        intent1.putExtra("isConnectedToInternet", connectedToNetwork);
        intent1.putExtra("changeNetworkState", changeNetworkState);
        intent1.putExtra("freeSpace", freeSpace);
        intent1.putExtra("totalSpace", totalSpace);
        intent1.putExtra("connectionType", connectionType);
        sendBroadcast(intent1);
    }

    @Override
    public void syncSuccess(WsSync wsSync) {

    }

    @Override
    public void requestSyncSuccess(boolean sync) {


    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public Context getContext() {
        return getApplicationContext();
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
