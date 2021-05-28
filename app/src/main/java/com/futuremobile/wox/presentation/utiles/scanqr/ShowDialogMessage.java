package com.futuremobile.wox.presentation.utiles.scanqr;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.futuremobile.wox.R;

public class ShowDialogMessage {
    public Context context;

    public ShowDialogMessage(Context context) {
        this.context = context;
    }

    public ShowDialogMessage() {
    }

    public void showAlertDefault(String title, String message, String textButton) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.context);
        alertDialog.setCancelable(false);
        LayoutInflater inflater = ((Activity)this.context).getLayoutInflater();
        View alertView =  inflater.inflate(R.layout.show_dialog_message,null);
       // View alertView = inflater.inflate(layout.show_dialog_message, (ViewGroup)null);
        ((TextView)alertView.findViewById(R.id.sdm_title)).setText(title);
        ((TextView)alertView.findViewById(R.id.sdm_messagge)).setText(message);
        AppCompatButton alertButton = (AppCompatButton)alertView.findViewById(R.id.btn_test);
        alertButton.setText(textButton);
        alertDialog.setView(alertView);
        final AlertDialog show = alertDialog.show();
        alertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                show.cancel();
            }
        });
    }

    public void showAlertBack(String title, String message, String textButton, final Activity activity) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.context);
        alertDialog.setCancelable(false);
        LayoutInflater inflater = ((Activity)this.context).getLayoutInflater();
        View alertView =  inflater.inflate(R.layout.show_dialog_message,null);
      //  View alertView = inflater.inflate(layout.show_dialog_message, (ViewGroup)null);
        ((TextView)alertView.findViewById(R.id.sdm_title)).setText(title);
        ((TextView)alertView.findViewById(R.id.sdm_messagge)).setText(message);
        AppCompatButton alertButton = (AppCompatButton)alertView.findViewById(R.id.btn_test);
        alertButton.setText(textButton);
        alertDialog.setView(alertView);
        final AlertDialog show = alertDialog.show();
        alertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                activity.startActivity((new Intent(activity, BarcodeCaptureActivity.class)).setFlags(67108864));
                activity.finish();
                show.cancel();
            }
        });
    }

    public void showOpenSettings(String message) {
        this.showOpenSettings(message, 168);
    }

    public void showOpenSettings(String message, final int requestCode) {
        final Dialog dialog = new Dialog(this.context);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.show_dialog_message);
        TextView tvTitle = (TextView)dialog.findViewById(R.id.sdm_title);
        TextView tvQuestion = (TextView)dialog.findViewById(R.id.sdm_messagge);
        tvTitle.setText(  "ajajaja");
        tvQuestion.setText(message);
        Button btnConfirm = (Button)dialog.findViewById(R.id.btn_test);
        btnConfirm.setText("confirmamelo");
        final String appPackageName = this.context.getPackageName();
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + appPackageName));
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setFlags(268435456);
                ((Activity)ShowDialogMessage.this.context).startActivityForResult(intent, requestCode);
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }
}
