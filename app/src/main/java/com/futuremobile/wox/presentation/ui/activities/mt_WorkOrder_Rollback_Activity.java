package com.futuremobile.wox.presentation.ui.activities;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.futuremobile.wox.R;
import com.futuremobile.wox.domain.model.Action;
import com.futuremobile.wox.presentation.ui.adapterlist.mt_WorkOrder_Action_AdapterList;
import com.futuremobile.wox.presentation.ui.adapterlist.mt_WorkOrder_Rollback_AdapterList;
import com.futuremobile.wox.presentation.ui.dialogfragments.RollbackDetail_Dialog;
import com.futuremobile.wox.presentation.ui.fragments.mt_WorkOrder_Actions_Tabs;

import java.util.ArrayList;

public class mt_WorkOrder_Rollback_Activity extends BaseActivity
implements mt_WorkOrder_Rollback_AdapterList.OnItemClickListener{



    Toolbar mitoolbar;

    mt_WorkOrder_Rollback_AdapterList adapter;
    mt_WorkOrder_Rollback_AdapterList.OnItemClickListener listener;
    ArrayList<Action> actions;

    RecyclerView rvActions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mt_work_order_rollback_activity);

     //   injectView();
        initUI();

        initAll();


    }

    void initAll()
    {
        rvActions=(RecyclerView)findViewById(R.id.rvActions);
        actions= new ArrayList<>();
        actions.add(new Action(1));
        actions.add(new Action(1));
        actions.add(new Action(1));
        actions.add(new Action(1));
        actions.add(new Action(1));
        actions.add(new Action(1));
        actions.add(new Action(1));
        actions.add(new Action(1));
        actions.add(new Action(1));
        actions.add(new Action(1));


        listener=this;

        adapter = new mt_WorkOrder_Rollback_AdapterList(listener, getApplicationContext(), actions);
        rvActions.setHasFixedSize(true);
        rvActions.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvActions.setAdapter(adapter);

        int[] ATTRS = new int[]{android.R.attr.listDivider};

        TypedArray a = getApplicationContext().obtainStyledAttributes(ATTRS);
        Drawable divider = a.getDrawable(0);
        int inset = getResources().getDimensionPixelSize(R.dimen.marginrecyclwe);
        InsetDrawable insetDivider = new InsetDrawable(divider, inset, 0, inset, 0);
        a.recycle();

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(insetDivider);

        rvActions.addItemDecoration(itemDecoration);
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

        RollbackDetail_Dialog df = new RollbackDetail_Dialog();
        // df.setArguments(args);
        df.show(getSupportFragmentManager(), "PickVoucherDialog");
    }
}
