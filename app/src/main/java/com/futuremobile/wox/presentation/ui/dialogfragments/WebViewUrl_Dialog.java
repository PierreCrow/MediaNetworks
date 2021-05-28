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
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.DialogFragment;

import com.futuremobile.wox.R;
import com.futuremobile.wox.presentation.ui.activities.mt_WorkOrder_Activity;
import com.futuremobile.wox.presentation.ui.fragments.HomeFragment;


public class WebViewUrl_Dialog extends DialogFragment {




    WebView wvFinal;


    void initUI(View x) {
        wvFinal = (WebView) x.findViewById(R.id.wvFinal);

        wvFinal.getSettings().setJavaScriptEnabled(true);

        Integer iddWorkOrder=HomeFragment.ID_WORK_ORDER;
        String urll= mt_WorkOrder_Activity.url+ iddWorkOrder;

        wvFinal.loadUrl(urll);

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

        View view = getActivity().getLayoutInflater().inflate(R.layout.webview_dialog, new LinearLayout(getActivity()), false);

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

    public interface onCloseCancelTicket {
        public void closeCancelTicket(boolean cancelado, String justificacion);
    }

    void sendCallback(boolean cancelado, String justificacion) {
        Activity ahhh = getActivity();
        if (ahhh instanceof onCloseCancelTicket) {
            ((onCloseCancelTicket) ahhh).closeCancelTicket(cancelado,justificacion);
        }
    }


}

