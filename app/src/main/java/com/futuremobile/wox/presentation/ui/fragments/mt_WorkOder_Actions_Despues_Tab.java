package com.futuremobile.wox.presentation.ui.fragments;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.futuremobile.wox.R;
import com.futuremobile.wox.domain.model.Action;
import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.presentation.ui.adapterlist.mt_WorkOrder_Action_AdapterList;
import com.futuremobile.wox.presentation.ui.dialogfragments.ActionDetail_Dialog;
import com.futuremobile.wox.presentation.utiles.Constantes;

import java.util.ArrayList;


public class mt_WorkOder_Actions_Despues_Tab extends Fragment
        implements mt_WorkOrder_Action_AdapterList.OnItemClickListener {

    Context context;

    mt_WorkOrder_Action_AdapterList adapter;
    mt_WorkOrder_Action_AdapterList.OnItemClickListener listener;
    RecyclerView rvActions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.mt_workorder_actions_before_tab, container, false);
        context = rootView.getContext();

        initAll(rootView);

        return rootView;

    }

    void initAll(View x)
    {
        rvActions=(RecyclerView)x.findViewById(R.id.rvActions);

        listener=this;

        ArrayList<LineaTiempo> lineaTiemposDespues=new ArrayList<>();

        for(LineaTiempo lineaTiempo:mt_WorkOrder_Actions_Tabs.lineaTiempos)
        {

            if(lineaTiempo.getCondicion()== Constantes.CONDICION_LINEA_TIEMPO.DESPUES)
            {
                lineaTiemposDespues.add(lineaTiempo);
            }
        }

        adapter = new mt_WorkOrder_Action_AdapterList(listener, getContext(), lineaTiemposDespues);
        rvActions.setHasFixedSize(true);
        rvActions.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvActions.setAdapter(adapter);

        int[] ATTRS = new int[]{android.R.attr.listDivider};

        TypedArray a = getContext().obtainStyledAttributes(ATTRS);
        Drawable divider = a.getDrawable(0);
        int inset = getResources().getDimensionPixelSize(R.dimen.marginrecyclwe);
        InsetDrawable insetDivider = new InsetDrawable(divider, inset, 0, inset, 0);
        a.recycle();

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(insetDivider);

        rvActions.addItemDecoration(itemDecoration);
    }


    @Override
    public void onItemWOClicked(View v, LineaTiempo workOrder) {


        Bundle args= new Bundle();
        args.putSerializable("lineaTiempo",workOrder);

        ActionDetail_Dialog df = new ActionDetail_Dialog();
        df.setArguments(args);
        df.show(getFragmentManager(), "ActionDetail_Dialog");
    }
}
