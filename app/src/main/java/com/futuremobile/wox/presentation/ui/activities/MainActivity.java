package com.futuremobile.wox.presentation.ui.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.futuremobile.wox.presentation.ui.dialogfragments.mt_Filter_Dialog;
import com.google.android.material.navigation.NavigationView;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.futuremobile.wox.presentation.utiles.Constantes;
import com.futuremobile.wox.presentation.utiles.Helperr;
import com.futuremobile.wox.R;
import com.futuremobile.wox.presentation.ui.fragments.HomeFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    Toolbar mitoolbar;
    private MenuItem itemConfig, itemScan;
    public static String Ir_A_Este_fragment;
    ImageView imagenDrawer;
    LinearLayout groupLogOut, grupoOrdenesTrabajo;
    ImageView ivFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        loadFragment();
    }


    private void initUI() {

        //Drawer y NavigationView
        mitoolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);
        setSupportActionBar(mitoolbar);

        //inicializo el toolbar y coloco el titulo
        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mitoolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        setDrawerHeader(mNavigationView);

        ivFilter = (ImageView) findViewById(R.id.ivFilter);
        groupLogOut = (LinearLayout) findViewById(R.id.grupoCerrarSesion);
        grupoOrdenesTrabajo = (LinearLayout) findViewById(R.id.grupoOrdenesTrabajo);

        clickListener();

    }

    void clickListener() {
        ivFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mt_Filter_Dialog df = new mt_Filter_Dialog();
                // df.setArguments(args);
                df.show(getSupportFragmentManager(), "PickVoucherDialog");
            }
        });

        groupLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(null, LoginActivity.class, "");
            }
        });

        grupoOrdenesTrabajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(null, MainActivity.class, "");
            }
        });
    }

    void loadFragment() {

        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        HomeFragment homi = new HomeFragment();
        fragmentTransaction.replace(R.id.containerView, homi, Constantes.FRAGMENTS_TAGS.HOME);
        fragmentTransaction.commit();
        mitoolbar.setTitle("Órdenes de trabajo");

    }

    void setDrawerHeader(NavigationView miNavigationView) {
        View vi = miNavigationView.getHeaderView(0);
        imagenDrawer = (ImageView) vi.findViewById(R.id.iv_FotoEmpresa_Drawer);
        // nombreDrawer = (TextView) vi.findViewById(R.id.tv_nombreEmpresa_Drawer);

        String userName = Helperr.getUserAppPreference(getApplicationContext()).getName();
        if (userName.equals("")) {
            //  nombreDrawer.setText("Usuario Sin nombre");
        } else {
            //  nombreDrawer.setText(Metodos.getUserAppPreference(getApplicationContext()).getName());
        }
    }


    //muestra el menu en la parte superior derecha
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // infla el menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        itemConfig = menu.findItem(R.id.menuItem_configuracion);

        return true;
    }


    //eventos click de los items del menu superior derecho
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuItem_configuracion) {

            //   ConfiguracionDialog df = new ConfiguracionDialog();
            //   df.show(getSupportFragmentManager(), "Dialog");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @RequiresApi(api = 23)
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == Constantes.RESULT_CODE.PERMISIONS_REQUEST_CODE) {
            HashMap<String, Integer> permisionResults = new HashMap<>();
            int deniedCount = 0;


            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    permisionResults.put(permissions[i], grantResults[i]);
                    deniedCount++;
                }
            }

            //verifica si se han denegado algun permiso
            if (deniedCount == 0) {
                //iniciar app
            }
            //se denego al menos 1 permiso
            else {

                for (Map.Entry<String, Integer> entry : permisionResults.entrySet()) {
                    String permName = entry.getKey();
                    int permResult = entry.getValue();

                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, permName)) {
                        //show dialog : this apps need location and storage permisions para funcionar sin problemas
                        // Mandar dialog yes no
                        // "Yes", Grant Permisions and dismiss dialog
                        Helperr.Permisos_APP(getApplicationContext(), this);
                        //"No", Exit App and dismiss dialog
                    } else {
                        //You have denied some permisions. Allow all permisions at Settings > Permisions
                        //Mandar dialog yes no
                        //Yes  Go to settings and dismiss dialog
                        Intent inttento = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.fromParts("package", getPackageName(), null));
                        inttento.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(inttento);
                        finish();
                    }

                }
            }
        }
    }


    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        //aplicacion en background
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("key", "value");
    }

}