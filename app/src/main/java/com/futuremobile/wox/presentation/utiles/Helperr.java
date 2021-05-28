package com.futuremobile.wox.presentation.utiles;


import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;

import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.URLSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.futuremobile.wox.R;
import com.futuremobile.wox.data.datasource.db.WoxDb;
import com.futuremobile.wox.domain.model.Item;
import com.futuremobile.wox.domain.model.UserPreference;
import com.futuremobile.wox.presentation.utiles.scanqr.BarcodeCaptureActivity;
import com.futuremobile.wox.presentation.ui.activities.LoginActivity;
import com.futuremobile.wox.presentation.ui.activities.MainActivity;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.content.Context.NOTIFICATION_SERVICE;

public class Helperr {


    private Context ctx;

    public Helperr(Context ctx) {
        this.ctx = ctx;
    }

    public static String APPNAME = "Wox";
    public static String PATH_EXTERNAL_MEWMORY = "/sdcard/wox/" + APPNAME + "/";

    public static final String DATABASE_NAME = "wox_db";



    public static void saveUserAppPreference(Context context, UserPreference userPreference) {

        SharedPreferences preferenciasssee = context.getSharedPreferences(Constantes.PREFERENCES.PREFERENCE_CURRENT_USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editoriieei = preferenciasssee.edit();
        editoriieei.putInt(Constantes.PREFERENCES_KEYS.CURRENT_USER_ID_USUARIO, userPreference.getIdUser());
        editoriieei.putString(Constantes.PREFERENCES_KEYS.CURRENT_USER_TOKEN, userPreference.getToken());
        editoriieei.putString(Constantes.PREFERENCES_KEYS.CURRENT_USER_EMAIL, userPreference.getEmail());
        editoriieei.putString(Constantes.PREFERENCES_KEYS.CURRENT_USER_NAME, userPreference.getName());
        editoriieei.putInt(Constantes.PREFERENCES_KEYS.CURRENT_USER_ROL, userPreference.getRol());
        editoriieei.putBoolean(Constantes.PREFERENCES_KEYS.CURRENT_USER_LOGUEADO, userPreference.isLogged());
        editoriieei.apply();
    }



    public static UserPreference getUserAppPreference(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Constantes.PREFERENCES.PREFERENCE_CURRENT_USER, Context.MODE_PRIVATE);
        UserPreference userPreference =
                new UserPreference(preferences.getInt(Constantes.PREFERENCES_KEYS.CURRENT_USER_ID_USUARIO, 0),
                        preferences.getString(Constantes.PREFERENCES_KEYS.CURRENT_USER_TOKEN, ""),
                        preferences.getString(Constantes.PREFERENCES_KEYS.CURRENT_USER_EMAIL, ""),
                        preferences.getString(Constantes.PREFERENCES_KEYS.CURRENT_USER_NAME, ""),
                        preferences.getInt(Constantes.PREFERENCES_KEYS.CURRENT_USER_ROL, 0),
                        preferences.getBoolean(Constantes.PREFERENCES_KEYS.CURRENT_USER_LOGUEADO, false));

        return userPreference;
    }



    public static WoxDb Inicia_BBDD_LOCAL(Context ctx) {
        WoxDb APPDATABASE;
        APPDATABASE = Room.databaseBuilder(ctx,
                WoxDb.class, Helperr.DATABASE_NAME).fallbackToDestructiveMigration().build();
        return APPDATABASE;
    }




    public static Boolean Permisos_APP(Context mContext, Activity mActivity) {
        String[] appPermisions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        List<String> listpermisionNeeded = new ArrayList<>();
        for (String perm : appPermisions) {
            if (ContextCompat.checkSelfPermission(mContext, perm) != PackageManager.PERMISSION_GRANTED) {
                listpermisionNeeded.add(perm);
            }
        }
        if (!listpermisionNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(mActivity,
                    listpermisionNeeded.toArray(new String[listpermisionNeeded.size()]),
                    Constantes.RESULT_CODE.PERMISIONS_REQUEST_CODE);
            return false;
        }
        return true;
    }





}
