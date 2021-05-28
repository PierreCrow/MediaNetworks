package com.futuremobile.wox.presentation.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.facebook.stetho.Stetho;
import com.futuremobile.wox.R;
import com.futuremobile.wox.data.datasource.db.WoxDb;
import com.futuremobile.wox.data.datasource.db.model.Rol;
import com.futuremobile.wox.presentation.utiles.Helperr;

import java.util.ArrayList;

public class SplashActivity extends Activity {

    /**
     * Duration of wait
     **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;


    ArrayList<Rol> DATOS_ROLES;

    WoxDb BBDD;
    Boolean hasData;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splashscreen);


        BBDD = Helperr.Inicia_BBDD_LOCAL(getApplicationContext());


        Stetho.initializeWithDefaults(this);

        verifyDbHasBasicData();

       // sync();

        timerSplash();


    }




    void timerSplash() {
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }


    void verifyDbHasBasicData() {

        hasData = false;
    }







}
