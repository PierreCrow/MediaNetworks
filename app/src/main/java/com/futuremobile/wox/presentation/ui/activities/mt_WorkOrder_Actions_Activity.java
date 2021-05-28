package com.futuremobile.wox.presentation.ui.activities;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.futuremobile.wox.R;
import com.futuremobile.wox.presentation.ui.fragments.mt_WorkOrder_Actions_Tabs;

public class mt_WorkOrder_Actions_Activity extends BaseActivity {



    Toolbar mitoolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mt_work_order_actions_activity);

     //   injectView();
        initUI();
        loadTabs();

    }

    void loadTabs() {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        mt_WorkOrder_Actions_Tabs descar = new mt_WorkOrder_Actions_Tabs();
        fragmentTransaction.replace(R.id.containerworkorderactions, descar, "");
        fragmentTransaction.commit();
    }


    private void initUI() {


        mitoolbar = (Toolbar) findViewById(R.id.toolbarActions);
        setSupportActionBar(mitoolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onBackPressed() {

        finish();

    }


}
