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
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.DialogFragment;

import com.futuremobile.wox.R;


public class AceptarTicket_Dialog extends DialogFragment {


    String voucherType;

    LinearLayout lnBoleta, lnFactura, lnNotaVenta;


    Button btnAply,btnCancelar;
    EditText etAlarmas,etDescripcion;


    void initUI(View x) {
        btnAply = (Button) x.findViewById(R.id.btnAcpetar);
        btnCancelar = (Button) x.findViewById(R.id.btnCancelar);

        etAlarmas = (EditText) x.findViewById(R.id.etAlarmas);
        etDescripcion = (EditText) x.findViewById(R.id.etDescripcion);

        btnAply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendCallback(true,etDescripcion.getText().toString(),etAlarmas.getText().toString());
                dismiss();

            }
        });


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();

            }
        });
    }



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

        View view = getActivity().getLayoutInflater().inflate(R.layout.activar_ticket_dialog, new LinearLayout(getActivity()), false);

        initUI(view);
     //   clickEvents();

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

    public interface onCloseActivarTicket {
        public void closeActivarTicket(boolean activar, String descripcion, String alarmas);
    }

    void sendCallback(boolean activar, String descripcion, String alarma) {
        Activity ahhh = getActivity();
        if (ahhh instanceof onCloseActivarTicket) {
            ((onCloseActivarTicket) ahhh).closeActivarTicket(activar,descripcion,alarma);
        }
    }


}

