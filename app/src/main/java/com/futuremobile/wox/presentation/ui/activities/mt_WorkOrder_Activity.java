package com.futuremobile.wox.presentation.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.futuremobile.wox.R;
import com.futuremobile.wox.presentation.ui.dialogfragments.AceptarTicket_Dialog;
import com.futuremobile.wox.presentation.ui.dialogfragments.ActionDetail_Dialog;
import com.futuremobile.wox.presentation.ui.dialogfragments.Cancel_Dialog;
import com.futuremobile.wox.presentation.ui.dialogfragments.WebViewUrl_Dialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class mt_WorkOrder_Activity extends BaseActivity implements AceptarTicket_Dialog.onCloseActivarTicket, Cancel_Dialog.onCloseCancelTicket, ActionDetail_Dialog.onCloseAction {


    @BindView(R.id.llActions)
    LinearLayout llActions;

    @BindView(R.id.llRollback)
    LinearLayout llRollback;

    @BindView(R.id.llAmpliacion)
    LinearLayout llAmpliacion;
    Toolbar mitoolbar;

    @BindView(R.id.btnCancel)
    Button btnCancel;

    @BindView(R.id.btnActivarTicket)
    Button btnActivarTicket;


    @BindView(R.id.spiDesactivarTicket)
    Spinner spiDesactivarTicket;

    @BindView(R.id.btnDesactivarTicket)
    Button btnDesactivarTicket;

    @BindView(R.id.llNoActivar)
    LinearLayout llNoActivar;

    @BindView(R.id.tvEstado)
    TextView tvEstado;

    @BindView(R.id.btnDatosGenerales)
    Button btnDatosGenerales;

    @BindView(R.id.btnParametros)
    Button btnParametros;


    boolean ticketActivado, ticketCancelado;

    public static String url = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mt_work_order_activity);

        injectView();
        initUI();
        //    loadTabs();

    }


    private void initUI() {
        mitoolbar = (Toolbar) findViewById(R.id.toolbarWO);
        setSupportActionBar(mitoolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        llActions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), mt_WorkOrder_Actions_Activity.class);
                startActivity(intent);
            }
        });

        llRollback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), mt_WorkOrder_Rollback_Activity.class);
                startActivity(intent);
            }
        });

        llAmpliacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), mt_WorkOrder_Ampliacion_Activity.class);
                startActivity(intent);

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Cancel_Dialog df = new Cancel_Dialog();
                // df.setArguments(args);
                df.show(getSupportFragmentManager(), "PickVoucherDialog");

            }
        });


        btnActivarTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AceptarTicket_Dialog df = new AceptarTicket_Dialog();
                // df.setArguments(args);
                df.show(getSupportFragmentManager(), "PickVoucherDialog");

            }
        });


        btnParametros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                url = "dd";

                WebViewUrl_Dialog df = new WebViewUrl_Dialog();
                // df.setArguments(args);
                df.show(getSupportFragmentManager(), "PickVoucherDialog");
            }
        });


        btnDatosGenerales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                url = "dd";

                WebViewUrl_Dialog df = new WebViewUrl_Dialog();
                // df.setArguments(args);
                df.show(getSupportFragmentManager(), "PickVoucherDialog");
            }
        });

    }

    @Override
    public void onBackPressed() {

        finish();

        //   Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //   startActivity(intent);
    }


    @Override
    public void closeActivarTicket(boolean activar, String descripcion, String alarmas) {

        ticketActivado = true;

        tvEstado.setText("ACTIVADO");

        btnActivarTicket.setText("Finalizar Ticket");

        btnActivarTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  Cancel_Dialog df = new Cancel_Dialog();
                // df.setArguments(args);
                // df.show(getSupportFragmentManager(), "PickVoucherDialog");

            }
        });


    }

    @Override
    public void closeCancelTicket(boolean cancelado, String justificacion) {

        ticketCancelado = true;
        tvEstado.setText("CANCELADO");

        btnActivarTicket.setEnabled(false);

    }

    @Override
    public void closeAction(String iniOFin, String estado) {


        if (iniOFin.equals("FIN")) {
            tvEstado.setText(estado);
        }


    }
}
