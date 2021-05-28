package com.futuremobile.wox.presentation.ui.dialogfragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.futuremobile.wox.R;
import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.presentation.presenter.LineaTiempoPresenter;
import com.futuremobile.wox.presentation.ui.fragments.HomeFragment;
import com.futuremobile.wox.presentation.utiles.Constantes;
import com.futuremobile.wox.presentation.view.LineaTiempoView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ActionDetail_Dialog extends DialogFragment implements LineaTiempoView,FinAction_Dialog.onCloseFinAction {


    Button btnFin,btnInicio;

    LineaTiempo lineaTiempo;

    TextView tvAccion, tvTareas, tvCodTipo, tvTipo, tvAreaResponsable, tvHora, tvDuracion;

    LineaTiempoPresenter lineaTiempoPresenter;




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.action_detail_dialog, new LinearLayout(getActivity()), false);

        initUI(view);
        loadPresenter();
        clickEvents();
        setFields();

        Dialog builder = new Dialog(getActivity());
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.setContentView(view);
        return builder;


    }


    void initUI(View x) {

        tvAccion = (TextView) x.findViewById(R.id.tvAccion);
        tvTareas = (TextView) x.findViewById(R.id.tvTareas);
        tvCodTipo = (TextView) x.findViewById(R.id.tvCodTipo);
        tvTipo = (TextView) x.findViewById(R.id.tvTipo);
        tvAreaResponsable = (TextView) x.findViewById(R.id.tvAreaResponsable);
        tvHora = (TextView) x.findViewById(R.id.tvHora);
        tvDuracion = (TextView) x.findViewById(R.id.tvDuracion);


        btnFin = (Button) x.findViewById(R.id.btnFin);
        btnInicio = (Button) x.findViewById(R.id.btnInicio);

    }

    void loadPresenter()
    {
        lineaTiempoPresenter= new LineaTiempoPresenter();
        lineaTiempoPresenter.addView(this);
    }

    void clickEvents()
    {

        btnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FinAction_Dialog df = new FinAction_Dialog();
                // df.setArguments(args);
                df.show(getFragmentManager(), "PickVoucherDialog");
            }
        });

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                lineaTiempoPresenter.iniAccion(Constantes.STORE.DB,lineaTiempo,getTimestamp());

            }
        });
    }

    void setFields()
    {
        Bundle bundle = getArguments();
        lineaTiempo = (LineaTiempo) bundle.getSerializable("lineaTiempo");


        tvAccion.setText(lineaTiempo.getAccion());
        tvHora.setText(lineaTiempo.getHora());

        Integer duracion = lineaTiempo.getDuracion();
        tvDuracion.setText(duracion.toString() + " min");

        tvCodTipo.setText(lineaTiempo.getCod_tipo());
        tvTipo.setText(lineaTiempo.getTipo());

           tvAreaResponsable.setText(lineaTiempo.getDesc_area());
           tvTareas.setText(lineaTiempo.getCod_condicion());
    }

    public String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return sdf.format(new Date());
    }


    @Override
    public void onDismiss(DialogInterface dialog) {

    }


    @Override
    public void onCancel(DialogInterface dialog) {
        dismiss();
    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
            dialog.getWindow().getAttributes().alpha = 1f;
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    @Override
    public void lineaTiempoListSuccess(ArrayList<LineaTiempo> lineaTiempos) {

    }

    @Override
    public void lineaTiemposCreateSuccess(boolean success) {

    }

    @Override
    public void lineaTiemposIniAccionSuccess(boolean success) {

        sendCallback("INI","INICIADO");
        dismiss();
        Toast.makeText(getContext(), "Acción iniciada", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void lineaTiemposFinAccionSuccess(boolean success) {
        sendCallback("FIN","FINALIZADO");
        dismiss();
        Toast.makeText(getContext(), "Acción finalizada", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void lineaTiempoUpdateSuccess(LineaTiempo lineaTiempo) {

    }

    @Override
    public void showErrorMessage(String message) {
        String errorrr=message;

    }

    @Override
    public void closeinAction(boolean fin, String comentario) {

        lineaTiempoPresenter.finAccion(Constantes.STORE.DB,lineaTiempo,getTimestamp(),comentario);
    }

    public interface onCloseAction {
        public void closeAction(String iniOFin, String estado);//or whatever args you want
    }

    void sendCallback(String iniOFin, String estado) {
        Activity ahhh = getActivity();
        if (ahhh instanceof onCloseAction) {
            ((onCloseAction) ahhh).closeAction(iniOFin,estado);
        }
    }

}

