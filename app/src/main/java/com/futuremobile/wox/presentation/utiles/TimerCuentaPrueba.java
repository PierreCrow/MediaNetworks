package com.futuremobile.wox.presentation.utiles;

import android.app.ActivityManager;
import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import com.futuremobile.wox.data.datasource.db.WoxDb;

import java.util.List;

public class TimerCuentaPrueba extends IntentService {
    private final LocalBinder mBinder = new LocalBinder();
    protected Handler handler;
    protected Toast mToast;

    WoxDb BBDD;



    public class LocalBinder extends Binder {
        public TimerCuentaPrueba getService() {
            return TimerCuentaPrueba.this;
        }
    }

    public TimerCuentaPrueba() {
        super("TimerCuentaPrueba");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        BBDD= Helperr.Inicia_BBDD_LOCAL(getApplicationContext());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    //detecta si el app esta en foreground
    private boolean isAppOnForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        final String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }


    @Override
    protected void onHandleIntent(Intent workIntent) {


        Timer_Corta_Servicio();

    //    startTime = System.currentTimeMillis();
    //    timerHandler.postDelayed(timerRunnable, 0);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        onHandleIntent(intent);


        return Service.START_STICKY;
    }


    void Timer_Corta_Servicio()
    {

      //  Integer minutos=1;
       // Integer minutos=10080; //<- Una semana
        Integer minutos=20160; //<- 2 semanas
        Integer CADA_CUANTO_TIEMPO=60000*minutos;

        CountDownTimer newtimer = new CountDownTimer(1000000000, CADA_CUANTO_TIEMPO) {

            Boolean primeravez=true;

            public void onTick(long millisUntilFinished) {

                if(primeravez==true)
                {
                    primeravez=false;
                }
                else
                {
                    primeravez=false;

                      Actualiza_CuentaPrueba_Empresa_BBDD task= new Actualiza_CuentaPrueba_Empresa_BBDD();
                      task.execute();
                }

            }
            public void onFinish() {

              //  Actualiza_CuentaPrueba_Empresa_BBDD task= new Actualiza_CuentaPrueba_Empresa_BBDD();
              //  task.execute();

            }
        };
        newtimer.start();



    }


    private class Actualiza_CuentaPrueba_Empresa_BBDD extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Void doInBackground(Void... params) {



            try {

              //  BBDD.empresasDAO().Update_Cuenta_Prueba_Vencida(true);

            }
            catch (Exception e) {
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);



          //  Toast.makeText(getApplicationContext(), "SU CUENTA DE PRUEBA VENCIO", Toast.LENGTH_LONG).show();


          //  Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
          //  startActivity(intent);


        }
    }





}