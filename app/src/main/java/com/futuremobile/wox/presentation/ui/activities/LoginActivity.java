package com.futuremobile.wox.presentation.ui.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.futuremobile.wox.R;
import com.futuremobile.wox.domain.model.UserPreference;
import com.futuremobile.wox.presentation.presenter.UserPresenter;
import com.futuremobile.wox.presentation.ui.services.SyncData;
import com.futuremobile.wox.presentation.utiles.Helperr;
import com.futuremobile.wox.presentation.utiles.TransparentProgressDialog;
import com.futuremobile.wox.presentation.view.UserView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements UserView {


    @BindView(R.id.etUser)
    EditText etUser;
    @BindView(R.id.etPass)
    EditText etPass;
    @BindView(R.id.btn_ingresar_Login)
    Button entrar;

    Date currentTime;
    public ProgressDialog dialog;
    UserPresenter userPresenter;
    TransparentProgressDialog loading;


    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserPreference userPreference= Helperr.getUserAppPreference(getContext());
        if(userPreference.isLogged())
        {
            next(null, MainActivity.class, "");
        }
        else
        {
            setContentView(R.layout.activity_login);
            injectView();
            initUI();
            clickEvents();
        }


    }



    void initUI() {
        currentTime = Calendar.getInstance().getTime();
        userPresenter= new UserPresenter();
        userPresenter.addView(this);
        loading = new TransparentProgressDialog(getContext());

        etUser.setText("christian.espinoza@telefonica.com");
        etPass.setText("abcd1234");
    }

    void clickEvents() {
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userrr=etUser.getText().toString().trim();
                String pass=etPass.getText().toString().trim();
                if (!loading.isShowing()) {
                    loading.show();
                }
                userPresenter.login(userrr,pass);

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

    @Override
    public void userLogged(String token) {

        UserPreference userPreference= Helperr.getUserAppPreference(getContext());
        userPreference.setToken(token);
        userPreference.setLogged(true);
        Helperr.saveUserAppPreference(getContext(),userPreference);

        SyncData syncData= new SyncData(getContext(),null,token);
        syncData.syncNewAll();

        next(null, MainActivity.class, "");

        if (loading.isShowing()) {
            loading.dismiss();
        }

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorMessage(String message) {
        if (loading.isShowing()) {
            loading.dismiss();
        }
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return this;
    }
}





