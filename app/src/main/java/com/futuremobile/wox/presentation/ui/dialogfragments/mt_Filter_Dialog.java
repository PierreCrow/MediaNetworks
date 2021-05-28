package com.futuremobile.wox.presentation.ui.dialogfragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.futuremobile.wox.R;
import com.futuremobile.wox.domain.model.AreaGrupo;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.presentation.presenter.AreaGrupoPresenter;
import com.futuremobile.wox.presentation.ui.fragments.HomeFragment;
import com.futuremobile.wox.presentation.view.AreaGrupoView;

import java.util.ArrayList;
import java.util.List;


public class mt_Filter_Dialog extends DialogFragment implements AreaGrupoView {


    Button btnAply;
    Spinner spiGrupo,spiEstado,spiTipoTrabajo;

    AreaGrupoPresenter areaGrupoPresenter;
    ArrayList<AreaGrupo> areaGrupos;



    @Override
    public void onDismiss(DialogInterface dialog) {


    }


    @Override
    public void onCancel(DialogInterface dialog) {
        dismiss();
    }


    //evento cuando se crea el dialog
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.mt_filter_dialog, new LinearLayout(getActivity()), false);

        initUI(view);
        clickEvents();

        /*
        assert getArguments() != null;
        voucherTypes = (ArrayList<VoucherType>) getArguments().getSerializable("warehouses");
        voucherType="";
*/

        Dialog builder = new Dialog(getActivity());
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.setContentView(view);
        return builder;


    }

    void initUI(View x) {
        btnAply = (Button) x.findViewById(R.id.btnAply);
        spiEstado = (Spinner) x.findViewById(R.id.spiEstado);
        spiGrupo = (Spinner) x.findViewById(R.id.spiGrupo);
        spiTipoTrabajo = (Spinner) x.findViewById(R.id.spiTipoTrabajo);

        areaGrupoPresenter=new AreaGrupoPresenter();
        areaGrupoPresenter.addView(this);
        areaGrupoPresenter.getAreaGrupos();


        setSpinnerEstado(null,spiEstado,getContext());
        setSpinnerTipoTrabajo(null,spiTipoTrabajo,getContext());

    }


    void clickEvents() {
        btnAply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();

                HomeFragment dda = (HomeFragment) getFragmentManager().findFragmentById(R.id.containerView);

                if (dda instanceof onCloseFilters) {
                    ((onCloseFilters) dda).closeFilters( spiEstado.getSelectedItem().toString(), spiGrupo.getSelectedItem().toString(), spiTipoTrabajo.getSelectedItem().toString());
                }


            }
        });

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
    public void areaGrupoListSuccess(ArrayList<AreaGrupo> areaGrupos) {

        setSpinnerArea(areaGrupos,spiGrupo,getContext());

    }

    @Override
    public void areaGruposCreateSuccess(boolean success) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    public interface onCloseFilters {
        public void closeFilters(String estado, String grupo, String tipoTrabajo);//or whatever args you want
    }


    public void setSpinnerTipoTrabajo(ArrayList<WorkOrder> countries, Spinner spiner, Context ctx) {
        final List<String> paises = new ArrayList<String>();
        paises.add("Todos");

        paises.add("Comercial");
        paises.add("Correctivo");
        paises.add("Dispositivos");
        paises.add("Herramientas");
        paises.add("Hosting");
        paises.add("Infraestructura TI");
        paises.add("Nuevos despliuegues HW");
        paises.add("Preventivo");
        paises.add("Programador");
        paises.add("Provision");
        paises.add("Release SW");
        paises.add("Seguridad");


        final ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                ctx, R.layout.spinneritem, paises) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return true;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
           //     tv.setTextColor(Color.BLACK);
                return view;
            }
        };
        spinnerArrayAdapter1.setDropDownViewResource(R.layout.spinneritem);
        spiner.setAdapter(spinnerArrayAdapter1);
    }

    public void setSpinnerArea(ArrayList<AreaGrupo> areaGrupos, Spinner spiner, Context ctx) {
        final List<String> paises = new ArrayList<String>();
        paises.add("Todos");
        for (Integer i = 0; i < areaGrupos.size(); i++) {
               paises.add(areaGrupos.get(i).getNombre());
        }

        final ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                ctx, R.layout.spinneritem, paises) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return true;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
            //    tv.setTextColor(Color.BLACK);
                return view;
            }
        };
        spinnerArrayAdapter1.setDropDownViewResource(R.layout.spinneritem);
        spiner.setAdapter(spinnerArrayAdapter1);
    }


    public void setSpinnerEstado(ArrayList<WorkOrder> countries, Spinner spiner, Context ctx) {
        final List<String> paises = new ArrayList<String>();
        paises.add("Todos");

        paises.add("Registro parcial");
        paises.add("Registrado");
        paises.add("Planeado");
        paises.add("Activado");
        paises.add("Finalizado");
        paises.add("Cancelado");

        final ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                ctx, R.layout.spinneritem, paises) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return true;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
             //   tv.setTextColor(Color.BLACK);
                return view;
            }
        };
        spinnerArrayAdapter1.setDropDownViewResource(R.layout.spinneritem);
        spiner.setAdapter(spinnerArrayAdapter1);
    }



}

