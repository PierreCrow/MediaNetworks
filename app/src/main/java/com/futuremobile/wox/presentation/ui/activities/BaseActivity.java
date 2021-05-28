package com.futuremobile.wox.presentation.ui.activities;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.stetho.Stetho;
import com.futuremobile.wox.presentation.ui.services.NetworkValidationIntentService;
import com.futuremobile.wox.presentation.utiles.Constantes;
import com.futuremobile.wox.presentation.utiles.dialog.ConfirmationDialogCallback;
import com.futuremobile.wox.presentation.utiles.dialog.DialogUI;
import com.futuremobile.wox.presentation.utiles.scanqr.BarcodeCaptureActivity;

import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

    boolean internetConectionSuccesWatched, internetConectionNoSuccesWatched, changeNetworkStateNoSuccesMessageShowed, changeNetworkStateSuccesMessageShowed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  Fabric.with(this, new Crashlytics());
        //  Crashlytics.getInstance().crash();
        // FacturAltokeDb db = Metodos.Inicia_BBDD_LOCAL(getApplicationContext());
        Stetho.initializeWithDefaults(this);
        // Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler(this, MainActivity.class));
        startNetworkService();
    }

    protected void injectView() {
        ButterKnife.bind(this);
    }

    private void startNetworkService() {
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }
        if (!isMyServiceRunning(NetworkValidationIntentService.class, getApplicationContext())) {
            Intent serviceIntento = new Intent(getApplicationContext(), NetworkValidationIntentService.class);
            startService(serviceIntento);
        }
    }



    public void updateNetworkIndicator(Context ctx, boolean isConnectedToInternet, boolean changeNetworkState, ImageView imageLedNetworkIndicator, boolean showFirstTimeNetworkDialog, boolean backFromOtherActivity) {

        if (showFirstTimeNetworkDialog) {
            internetConectionSuccesWatched = true;
            internetConectionNoSuccesWatched = false;
        }
        if (changeNetworkState) {
            changeNetworkStateNoSuccesMessageShowed = false;
            changeNetworkStateSuccesMessageShowed = false;
            internetConectionSuccesWatched = false;
            internetConectionNoSuccesWatched = false;
        }

        if (backFromOtherActivity) {
            internetConectionSuccesWatched = true;
            internetConectionNoSuccesWatched = true;
        }

        if (!isConnectedToInternet) {
            //  imageLedNetworkIndicator.setVisibility(View.VISIBLE);
            if (!internetConectionNoSuccesWatched) {
                if (!changeNetworkStateNoSuccesMessageShowed) {
                    DialogUI dialogUI = new DialogUI(ctx);
                    dialogUI.showDialogConfirmation("Conexion a Internet", "No cuenta con conexion a Internet", false, new ConfirmationDialogCallback() {
                        @Override
                        public void onConfirmDialog() {
                            internetConectionNoSuccesWatched = true;
                        }
                    });
                    changeNetworkStateNoSuccesMessageShowed = true;
                }
            }
        } else {
            //  imageLedNetworkIndicator.setVisibility(View.GONE);
            if (!internetConectionSuccesWatched) {
                if (!changeNetworkStateSuccesMessageShowed) {
                    DialogUI dialogUI = new DialogUI(ctx);
                    dialogUI.showDialogConfirmation("Conexion a Internet", "Ya cuenta con conexion a Internet", false, new ConfirmationDialogCallback() {
                        @Override
                        public void onConfirmDialog() {
                            internetConectionSuccesWatched = true;
                        }
                    });
                    changeNetworkStateSuccesMessageShowed = true;
                }
            }
        }
    }


    public static boolean getNetworkDialogFirstTimeShowed(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("NetworkPreference", Context.MODE_PRIVATE);
        return preferences.getBoolean("firstTimeNetwork", false);
    }

    public static void saveNetworkDialogFirstTimeShowed(Context context, boolean b) {
        SharedPreferences preferences = context.getSharedPreferences("NetworkPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("firstTimeNetwork", b);
        editor.apply();
    }

    public static boolean getNetworkIsConnectedToInternet(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("NetworkPreference", Context.MODE_PRIVATE);
        return preferences.getBoolean("IsConnectedToInternet", false);
    }


    public static void saveIsConnectedToInternet(Context context, boolean b) {
        SharedPreferences preferences = context.getSharedPreferences("NetworkPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("IsConnectedToInternet", b);
        editor.apply();
    }

    public static boolean getUserLogged(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Constantes.PREFERENCES.PREFERENCE_CURRENT_USER, Context.MODE_PRIVATE);
        return preferences.getBoolean(Constantes.PREFERENCES_KEYS.CURRENT_USER_LOGUEADO, false);
    }

    public static void saveUserLogged(Context context, boolean b) {
        SharedPreferences preferences = context.getSharedPreferences(Constantes.PREFERENCES.PREFERENCE_CURRENT_USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(Constantes.PREFERENCES_KEYS.CURRENT_USER_LOGUEADO, b);
        editor.apply();
    }


    protected void next(Bundle bundle, Class<?> activity, String fragment) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }

        startActivity(intent);
        finish();
    }


    protected void goToMainActivity(Bundle bundle, String fragment) {
        Intent intent = new Intent(this, MainActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (fragment != null) {
            intent.putExtra("fragment", fragment);
        }
        startActivity(intent);
        finish();
    }



    protected Intent goToViewReadQR(Context context) {
        Intent intents = new Intent(context, BarcodeCaptureActivity.class);
        intents.putExtra("AutoFocus", true);
        return intents;
    }

    protected void pickerDateEvent(int mYear, int mMonth, int mDay, final EditText et_date, final DatePicker datePicker) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        et_date.setText((dayOfMonth < 10 ? "0" + dayOfMonth : dayOfMonth) + "/" + ((monthOfYear + 1) < 10 ? "0" + (monthOfYear + 1) : (monthOfYear + 1)) + "/" + year);
                        datePicker.init(year, monthOfYear + 1, dayOfMonth, null);
                    }
                }, mYear, mMonth, mDay);

        if (datePicker != null) {
            datePickerDialog.updateDate(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        }
        datePickerDialog.show();
    }

    protected void countLetters(int countMax, EditText etObservation, final TextView txtCountLetters) {
        final int initCountletters = Constantes.OBSERVATIONS_QUANTITY_LETTERS.MIN_LETTERS;
        final int maxCountLetters = countMax;
        txtCountLetters.setText(String.format("%s / %s", initCountletters, maxCountLetters));
        etObservation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                txtCountLetters.setText(String.format("%s / %s", initCountletters + s.toString().length(), String.valueOf(maxCountLetters)));
            }
        });
    }

    public static boolean isMyServiceRunning(Class<?> serviceClass, Context ctx) {
        ActivityManager manager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public String getAppVersion() {
        String appVersion = "";
        try {
            PackageInfo pInfo = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
            appVersion = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appVersion;
    }

    private int compareVersions(String appVersion, String minimumVersion) {
        int response = Integer.parseInt(Constantes.APP_VERSION.EQUAL);

        String[] oldNumbers = appVersion.split("\\.");
        String[] newNumbers = minimumVersion.split("\\.");

        int maxIndex = Math.min(oldNumbers.length, newNumbers.length);

        for (int i = 0; i < maxIndex; i++) {
            int oldVersionPart = Integer.valueOf(oldNumbers[i]);
            int newVersionPart = Integer.valueOf(newNumbers[i]);

            if (oldVersionPart < newVersionPart) {
                response = Integer.parseInt(Constantes.APP_VERSION.MINOR);
                break;
            } else if (oldVersionPart > newVersionPart) {
                response = Integer.parseInt(Constantes.APP_VERSION.MAJOR);
                break;
            }
        }

        if (response == Integer.parseInt(Constantes.APP_VERSION.EQUAL) && oldNumbers.length != newNumbers.length) {
            response = (oldNumbers.length > newNumbers.length) ? 1 : -1;
        }

        return response;
    }

    protected void goVerifyVersion(final Context context, String minimumVersion, final String url) {

        String myVersion = "";
        try {
            PackageInfo pInfo = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
            String appVersion = "";
            appVersion = pInfo.versionName;
            myVersion = appVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if (minimumVersion != null) {
            if (!myVersion.equals("") && minimumVersion.equals("")) {
                int response = compareVersions(myVersion, minimumVersion);
                if (response == Integer.parseInt(Constantes.APP_VERSION.MINOR)) {

                    DialogUI dialogUI = new DialogUI(getApplicationContext());
                    dialogUI.showDialogConfirmation("Version incorrecta", "Actualice de version", false, new ConfirmationDialogCallback() {
                        @Override
                        public void onConfirmDialog() {
                            if (url != null) {
                                goToLink(url);
                            }
                        }
                    });
                }
            }
        }
    }

    private void goToLink(String url) {
        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browse);
    }


}
