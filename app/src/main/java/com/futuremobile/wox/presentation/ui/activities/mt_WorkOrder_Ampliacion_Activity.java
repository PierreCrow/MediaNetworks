package com.futuremobile.wox.presentation.ui.activities;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.futuremobile.wox.R;
import com.futuremobile.wox.domain.model.Action;
import com.futuremobile.wox.presentation.ui.adapterlist.mt_WorkOrder_Rollback_AdapterList;

import java.util.ArrayList;

public class mt_WorkOrder_Ampliacion_Activity extends BaseActivity
implements mt_WorkOrder_Rollback_AdapterList.OnItemClickListener{



    Toolbar mitoolbar;

    mt_WorkOrder_Rollback_AdapterList adapter;
    mt_WorkOrder_Rollback_AdapterList.OnItemClickListener listener;
    ArrayList<Action> actions;

    RecyclerView rvActions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mt_work_order_ampliacion_activity);

     //   injectView();
        initUI();

      //  initAll();


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


    @Override
    public void onItemWOClicked(View v, Action workOrder) {

    }
}
