package com.futuremobile.wox.presentation.ui.dialogfragments;

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


public class FinAction_Dialog extends DialogFragment {


    String voucherType;

    LinearLayout lnBoleta, lnFactura, lnNotaVenta;


    Button btnCancelar,btnAceptar;
    EditText etComent;


    void initUI(View x) {
        btnAceptar = (Button) x.findViewById(R.id.btnAceptar);
        btnCancelar = (Button) x.findViewById(R.id.btnCancelar);

        etComent = (EditText) x.findViewById(R.id.etComent);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendCallback(true,etComent.getText().toString());
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

        View view = getActivity().getLayoutInflater().inflate(R.layout.fin_action_dialog, new LinearLayout(getActivity()), false);

        initUI(view);


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

    public interface onCloseFinAction {
        public void closeinAction(boolean fin, String comentario);
    }

    void sendCallback(boolean fin, String comentario)
    {
        ActionDetail_Dialog dda = new ActionDetail_Dialog();

        if (dda instanceof onCloseFinAction) {
            ((onCloseFinAction) dda).closeinAction(fin, comentario);
        }
    }


}

